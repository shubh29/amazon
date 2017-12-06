package com.amazon.shubham.sns.message;

import com.amazon.shubham.profile.Topic;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;

public class PublishMessage {

	AmazonSNSClient client = new AmazonSNSClient();
	PublishRequest request = new PublishRequest();
	Topic topic = new Topic();
	
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public void publish(String message, String topicName) {

		request.withMessage(message);
		String topicARN; 
		
		topicARN = topic.transalateTopicNameToARN(topicName);
		request.withTopicArn(topicARN);
		client.publish(request);
	}

	public PublishRequest getRequest() {
		return request;
	}

	public void setRequest(PublishRequest request) {
		this.request = request;
	}

	public AmazonSNSClient getClient() {
		return client;
	}

	public void setClient(AmazonSNSClient client) {
		this.client = client;
	}

}
