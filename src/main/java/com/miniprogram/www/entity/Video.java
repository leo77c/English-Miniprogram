package com.miniprogram.www.entity;


public class Video {

  private int id;
  private String title;
  private String url;
  private int courseId;
  private java.sql.Timestamp createTime;
  private int chapter;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  public int getCourseId() {
    return courseId;
  }

  public void setCourseId(int courseId) {
    this.courseId = courseId;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public int getChapter() {
    return chapter;
  }

  public void setChapter(int chapter) {
    this.chapter = chapter;
  }

}
