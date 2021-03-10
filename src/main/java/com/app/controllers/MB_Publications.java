package com.app.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.app.models.Publications;
import com.jk.webstack.controllers.JKManagedBeanWithOrmSupport;

@ManagedBean(name = "mbPublications")
@ViewScoped
public class MB_Publications extends JKManagedBeanWithOrmSupport<Publications> {

}
