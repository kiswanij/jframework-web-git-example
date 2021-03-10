package com.app.models;

import javax.persistence.*;
@Entity
@Table(name="publications")
public class Publications{

  @Id
  @Column(name="id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  @Column(name="title" , nullable=false)
  String title;

  @Column(name="category" , nullable=false)
  String category;

  @Column(name="year" )
  Integer year;

  @Column(name="publisher" )
  String publisher;

  @Column(name="volume" )
  Integer volume;

  @Column(name="issue" )
  Integer issue;

  @Column(name="pages" )
  String pages;

  @Column(name="location" )
  String location;

  @Column(name="note" )
  String note;

  @Column(name="full_citation" )
  byte[] fullCitation;

  @Column(name="full_source" )
  byte[] fullSource;

  @Column(name="final_version" )
  byte[] finalVersion;

  @OneToOne
  @JoinColumn(name="first_author" )
  Author firstAuthor;

  @OneToOne
  @JoinColumn(name="second_author" )
  Author secondAuthor;

  @OneToOne
  @JoinColumn(name="third_author" )
  Author thirdAuthor;

  @OneToOne
  @JoinColumn(name="fourth_author" )
  Author fourthAuthor;

  @OneToOne
  @JoinColumn(name="fifth_author" )
  Author fifthAuthor;

  @OneToOne
  @JoinColumn(name="sixth_author" )
  Author sixthAuthor;


  public void setId(Integer id){
    this.id=id;
  }

  public Integer getId(){
   return this.id;
  }

  public void setTitle(String title){
    this.title=title;
  }

  public String getTitle(){
   return this.title;
  }

  public void setCategory(String category){
    this.category=category;
  }

  public String getCategory(){
   return this.category;
  }

  public void setYear(Integer year){
    this.year=year;
  }

  public Integer getYear(){
   return this.year;
  }

  public void setPublisher(String publisher){
    this.publisher=publisher;
  }

  public String getPublisher(){
   return this.publisher;
  }

  public void setVolume(Integer volume){
    this.volume=volume;
  }

  public Integer getVolume(){
   return this.volume;
  }

  public void setIssue(Integer issue){
    this.issue=issue;
  }

  public Integer getIssue(){
   return this.issue;
  }

  public void setPages(String pages){
    this.pages=pages;
  }

  public String getPages(){
   return this.pages;
  }

  public void setLocation(String location){
    this.location=location;
  }

  public String getLocation(){
   return this.location;
  }

  public void setNote(String note){
    this.note=note;
  }

  public String getNote(){
   return this.note;
  }

  public void setFullCitation(byte[] fullCitation){
    this.fullCitation=fullCitation;
  }

  public byte[] getFullCitation(){
   return this.fullCitation;
  }

  public void setFullSource(byte[] fullSource){
    this.fullSource=fullSource;
  }

  public byte[] getFullSource(){
   return this.fullSource;
  }

  public void setFinalVersion(byte[] finalVersion){
    this.finalVersion=finalVersion;
  }

  public byte[] getFinalVersion(){
   return this.finalVersion;
  }

  public void setFirstAuthor(Author firstAuthor){
    this.firstAuthor=firstAuthor;
  }

  public Author getFirstAuthor(){
   return this.firstAuthor;
  }

  public void setSecondAuthor(Author secondAuthor){
    this.secondAuthor=secondAuthor;
  }

  public Author getSecondAuthor(){
   return this.secondAuthor;
  }

  public void setThirdAuthor(Author thirdAuthor){
    this.thirdAuthor=thirdAuthor;
  }

  public Author getThirdAuthor(){
   return this.thirdAuthor;
  }

  public void setFourthAuthor(Author fourthAuthor){
    this.fourthAuthor=fourthAuthor;
  }

  public Author getFourthAuthor(){
   return this.fourthAuthor;
  }

  public void setFifthAuthor(Author fifthAuthor){
    this.fifthAuthor=fifthAuthor;
  }

  public Author getFifthAuthor(){
   return this.fifthAuthor;
  }

  public void setSixthAuthor(Author sixthAuthor){
    this.sixthAuthor=sixthAuthor;
  }

  public Author getSixthAuthor(){
   return this.sixthAuthor;
  }
  @Override
  public String toString(){
    StringBuffer buf=new StringBuffer();
    buf.append(this.title).append(" ");
    return buf.toString();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
	  return false;
    }
    return this.getId() == ((Publications) obj).getId();
  }

}
