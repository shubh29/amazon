package com.amazon.shubham.message;

import org.apache.commons.lang3.StringUtils;

public class Message {


  private String message;
  private String subject;

  //
  public Message(String message, String subject) {
    super();
    this.message = message;
    //this.subject = subject;
    this.subject = StringUtils.capitalize(subject);
  }

  //Method to get message
  public String getMessage() {
    return message;
  }

  //Method to get subject
  public String getSubject() {
    return subject;
  }

}
