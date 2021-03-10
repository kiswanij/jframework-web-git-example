package com.app.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.app.models.University;
import com.jk.webstack.controllers.JKManagedBeanWithOrmSupport;

@ManagedBean(name = "mbUniversity")
@ViewScoped
public class MB_University extends JKManagedBeanWithOrmSupport<University> {

}
