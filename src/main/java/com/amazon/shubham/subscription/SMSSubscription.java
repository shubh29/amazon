package com.amazon.shubham.subscription;


public class SMSSubscription extends Subscription {

	@Override
	public boolean validate(String value) {
		// TODO Auto-generated method stub
//if(value.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"))
			return true;
//else
//	System.err.println("Please enter value in the format:123-456-7890");
//	return false;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "sms";
	}
	

}
