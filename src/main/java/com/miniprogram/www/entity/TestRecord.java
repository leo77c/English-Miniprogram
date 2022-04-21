package com.miniprogram.www.entity;

public class TestRecord {

  private int id;
  private int studentId;
  private int testId;
  private int totalScore;
  private int submitCount;
  private java.sql.Timestamp submitTime;


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


  public int getTestId() {
    return testId;
  }

  public void setTestId(int testId) {
    this.testId = testId;
  }


  public int getTotalScore() {
    return totalScore;
  }

  public void setTotalScore(int totalScore) {
    this.totalScore = totalScore;
  }


  public int getSubmitCount() {
    return submitCount;
  }

  public void setSubmitCount(int submitCount) {
    this.submitCount = submitCount;
  }


  public java.sql.Timestamp getSubmitTime() {
    return submitTime;
  }

  public void setSubmitTime(java.sql.Timestamp submitTime) {
    this.submitTime = submitTime;
  }

}
