package com.app.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.app.models.Author;
import com.jk.webstack.controllers.JKManagedBeanWithOrmSupport;

@ManagedBean(name = "mbAuthor")
@ViewScoped
public class MB_Author extends JKManagedBeanWithOrmSupport<Author> {
	
}
