package com.miniprogram.www.entity;


public class Question {

  private int id;
  private int number;
  private String content;
  private int testId;
  private int value;
  private int type;
  private String options;
  private String answer;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public int getTestId() {
    return testId;
  }

  public void setTestId(int testId) {
    this.testId = testId;
  }


  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }


  public int getType() {
    return type;
  }

  public void setType(int type) {
    this.type = type;
  }


  public String getOptions() {
    return options;
  }

  public void setOptions(String options) {
    this.options = options;
  }


  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }

}
