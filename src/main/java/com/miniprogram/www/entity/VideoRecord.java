package com.miniprogram.www.entity;


public class VideoRecord {

  private int id;
  private int studentId;
  private int videoId;
  private java.sql.Date watchTime;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public int getStudentId() {
    return studentId;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }


  public int getVideoId() {
    return videoId;
  }

  public void setVideoId(int videoId) {
    this.videoId = videoId;
  }


  public java.sql.Date getWatchTime() {
    return watchTime;
  }

  public void setWatchTime(java.sql.Date watchTime) {
    this.watchTime = watchTime;
  }

}
