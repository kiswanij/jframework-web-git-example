package com.app.person;

import java.util.List;
import java.util.UUID;
import java.util.Vector;

import com.jk.web.faces.controllers.JKWebController;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named("controller")
@ViewScoped
public class Controller extends JKWebController {
	DataAccess da = new DataAccess();
	Model model;
	List<Model> modelList;
	List<Model> filterList;

	public boolean isAllowAdd() {
		return getModel().getId() == null;
	}

	public String add() {
		model.setId(UUID.randomUUID().toString());
		da.insert(model);
		refresh();
		success("Added Successfully");
		return null;
	}

	public boolean isAllowUpdate() {
		return getModel().getId() != null;
	}

	public String update() {
		da.update(model);
		String id = getModel().getId();
		success("Updated Successfully");
		refresh();
		// to ensure getting updated version from DB
		this.model = da.find(Model.class, id);
		return null;
	}

	public boolean isAllowDelete() {
		return getModel().getId() != null;
	}

	public String delete() {
		da.delete(getModel());
		success("Deleted Successfully");
		refresh();
		return null;
	}

	public String reset() {
		setModel(null);
		return null;
	}

	public Model getModel() {
		if (model == null) {
			model = new Model();
		}
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public List<Model> getModelList() {
		if (modelList == null) {
			modelList = da.getList(Model.class);
		}
		return modelList;
	}

	public List<Model> getFilterList() {
		return filterList;
	}

	public void setFilterList(Vector<Model> filterList) {
		this.filterList = filterList;
	}

	protected void refresh() {
		this.modelList = null;
		setModel(null);
	}
}
