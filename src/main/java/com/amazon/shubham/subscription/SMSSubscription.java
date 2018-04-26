package com.amazon.shubham.subscription;

import org.apache.log4j.Logger;

public class SMSSubscription extends Subscription {
	
  private static Logger sLogger = Logger.getLogger("com.amazon.shubham.validation");

  @Override
  //validate if the contact number is in valid format
  public boolean validate(String value) {
    // TODO Auto-generated method stub
    if (value.matches("[1][-]\\d{3}[-]\\d{3}[-]\\d{4}")) {
      sLogger.info("SMS number validated. Number is : " + value);
      return true;
    } else {
      System.err.println("Please enter value in the format:1-123-456-7890");
      sLogger.error("SMS number invalid. Number is : " + value);
	}
	return false;
  }

  @Override
  public String getType() {
    // TODO Auto-generated method stub
    return "sms";
  }

}
