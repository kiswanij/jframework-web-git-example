package com.app.models;

import javax.persistence.*;
@Entity
@Table(name="author")
public class Author{

  @Id
  @Column(name="id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  @Column(name="first_name" , nullable=false)
  String firstName;

  @Column(name="last_name" , nullable=false)
  String lastName;

  @Column(name="email" , nullable=false)
  String email;

  @OneToOne
  @JoinColumn(name="university" , nullable=false)
  University university;

  @OneToOne
  @JoinColumn(name="department" , nullable=false)
  Department department;

  @Column(name="phone" )
  String phone;

  @Column(name="mobile" )
  String mobile;

  @Column(name="profile" )
  String profile;


  public void setId(Integer id){
    this.id=id;
  }

  public Integer getId(){
   return this.id;
  }

  public void setFirstName(String firstName){
    this.firstName=firstName;
  }

  public String getFirstName(){
   return this.firstName;
  }

  public void setLastName(String lastName){
    this.lastName=lastName;
  }

  public String getLastName(){
   return this.lastName;
  }

  public void setEmail(String email){
    this.email=email;
  }

  public String getEmail(){
   return this.email;
  }

  public void setUniversity(University university){
    this.university=university;
  }

  public University getUniversity(){
   return this.university;
  }

  public void setDepartment(Department department){
    this.department=department;
  }

  public Department getDepartment(){
   return this.department;
  }

  public void setPhone(String phone){
    this.phone=phone;
  }

  public String getPhone(){
   return this.phone;
  }

  public void setMobile(String mobile){
    this.mobile=mobile;
  }

  public String getMobile(){
   return this.mobile;
  }

  public void setProfile(String profile){
    this.profile=profile;
  }

  public String getProfile(){
   return this.profile;
  }
  @Override
  public String toString(){
    StringBuffer buf=new StringBuffer();
    buf.append(this.firstName).append(" ");
    buf.append(this.lastName).append(" ");
    return buf.toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
	  return false;
    }
    return this.getId() == ((Author) obj).getId();
  }

}
