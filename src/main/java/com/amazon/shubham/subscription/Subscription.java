package com.amazon.shubham.subscription;


import com.amazon.shubham.manager.SNSClientManager;
import com.amazon.shubham.topic.Topic;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.SubscribeRequest;

abstract public class Subscription {
	
	public void subscribe(Topic topic, String value) {
		//subscribe to an SNS topic
		if(validate(value)) {
		SubscribeRequest subRequest = new SubscribeRequest(topic.getTopicARN(), getType(), value);
				
		//create a new SNS client and set endpoint
		AmazonSNSClient snsClient = SNSClientManager.getInstance().getAmazonSNSClient();
		snsClient.subscribe(subRequest);
		//get request id for SubscribeRequest from SNS metadata
		System.out.println("SubscribeRequest - " + snsClient.getCachedResponseMetadata(subRequest));
		//System.out.println("Check your email and confirm subscription.");
		} else {
			System.err.println("Validation failed for" +getType()+ "with value"+value);
		}
	}
	
	abstract public boolean validate(String value);
	
	abstract public String getType();
	
	
	//here we have just two types email and sms and if we use more types then it gets tougher. tHATS WHY WE ARE USING THE TEMPLATE pattern

}
