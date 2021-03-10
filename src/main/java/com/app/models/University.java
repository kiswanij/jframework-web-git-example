package com.app.models;

import javax.persistence.*;
@Entity
@Table(name="university")
public class University{

  @Id
  @Column(name="id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  @Column(name="name" , nullable=false)
  String name;


  public void setId(Integer id){
    this.id=id;
  }

  public Integer getId(){
   return this.id;
  }

  public void setName(String name){
    this.name=name;
  }

  public String getName(){
   return this.name;
  }
  @Override
  public String toString(){
    StringBuffer buf=new StringBuffer();
    buf.append(this.name).append(" ");
    return buf.toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
	  return false;
    }
    return this.getId() == ((University) obj).getId();
  }

}
