package com.miniprogram.www.entity;


public class AnswerRecord {

  private int id;
  private int recordId;
  private int number;
  private int score;
  private String content;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public int getRecordId() {
    return recordId;
  }

  public void setRecordId(int recordId) {
    this.recordId = recordId;
  }


  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }


  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

}
