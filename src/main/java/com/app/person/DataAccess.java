package com.app.person;

import java.util.List;
import java.util.Vector;

import org.eclipse.jgit.api.Git;

import com.jk.core.config.JKConfig;
import com.jk.core.scm.JKGitWrapper;
import com.jk.core.util.JKIOUtil;
import com.jk.core.util.JKObjectUtil;

public class DataAccess {
	private static final String ID_FIELD_NAME = "id";
	private static JKGitWrapper gw = new JKGitWrapper();
	
	private static Git git= gw.password(JKConfig.getDefaultInstance().getProperty("git-password-plain")).cloneRepo();

	/////////////////////////////////////////
	public <T> void insert(T record) {
		List<T> list = getList((Class<T>) record.getClass());
		list.add(record);
		save((Class<T>)record.getClass(), list);
	}

	/////////////////////////////////////////
	public <T> T find(Class<T> clas, Object id) {
		List<T> list = getList(clas);
		for (T t : list) {
			if (JKObjectUtil.getFieldValue(t, ID_FIELD_NAME).equals(id)) {
				return t;
			}
		}
		return null;
	}

	/////////////////////////////////////////
	public <T> void update(T record) {
		List<T> list = (List<T>) getList(record.getClass());
		for (int i=0;i<list.size();i++) {
			T t = list.get(i);
			Object sourceId = JKObjectUtil.getFieldValue(record, ID_FIELD_NAME);
			Object currentId = JKObjectUtil.getFieldValue(t, ID_FIELD_NAME);
			if (currentId.equals(sourceId)) {
				list.set(i, record);
				save((Class<T>)record.getClass(), list);
				return;
			}
		}
	}
	
	/////////////////////////////////////////
	public <T> void delete(T record) {
		List<T> list = (List<T>) getList(record.getClass());
		for (int i=0;i<list.size();i++) {
			T t = list.get(i);
			Object sourceId = JKObjectUtil.getFieldValue(record, ID_FIELD_NAME);
			Object currentId = JKObjectUtil.getFieldValue(t, ID_FIELD_NAME);
			if (currentId.equals(sourceId)) {
				list.remove(i);
				save((Class<T>)record.getClass(), list);
				return;
			}
		}
	}

	/////////////////////////////////////////
	public <T> List<T> getList(Class<T> clas) {
		String filePath = getFilePath(clas);
		String fileContents = JKIOUtil.readFile(filePath);
		if(fileContents==null) {
			return new Vector<>();
		}
		List<T> all = (List<T>) JKObjectUtil.jsonToObjectList(fileContents, clas);
		return all;
	}

	/////////////////////////////////////////
	protected <T> void save(Class<T> clas, List<T> list) {
		String contents = JKObjectUtil.toJson(list);
		JKIOUtil.writeDataToFile(contents, getFilePath(clas));
		gw.addCommitPush();
	}

	/////////////////////////////////////////
	protected <T> String getFilePath(Class<T> clas) {
		String fileName = clas.getName() + ".json";
		String filePath = gw.getLocalPath() + "/" + fileName;
		return filePath;
	}

}