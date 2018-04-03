package com.amazon.shubham.subscription;

import java.util.regex.Pattern;

public class EmailSubscription extends Subscription {

	@Override
	public boolean validate(String value) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
		Pattern pattern=Pattern.compile(emailRegex);
		if (value.equals(null)) {
			System.err.println("Enter a valid email address!");
			return false;
		} else 
			return pattern.matcher(value).matches();
		//validation code (check if the email is correct)	
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "email";
	}
}
