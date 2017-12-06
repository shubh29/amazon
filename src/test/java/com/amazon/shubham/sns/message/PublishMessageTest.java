package com.amazon.shubham.sns.message;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import com.amazon.shubham.profile.Topic;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;

public class PublishMessageTest {

	@Test
	public void publishTopic1Test(){
		
		String topicARN = "1234-XYZ-ABC";
		String message = "Test Message";
		String topicName = "Test Topic";
		AmazonSNSClient mockClient = mock(AmazonSNSClient.class);
		
		PublishRequest mockRequest = mock(PublishRequest.class);
		Topic topic = mock(Topic.class);
		when(topic.transalateTopicNameToARN(topicName)).thenReturn(topicARN);
		
		when(mockRequest.withTopicArn(topicARN)).thenReturn(mockRequest);
		when(mockRequest.withMessage(message)).thenReturn(mockRequest);
		
		//when(mockClient.publish(mockRequest)).thenReturn(any());
		
		PublishMessage publishMessage = new PublishMessage();
		publishMessage.setClient(mockClient);
		publishMessage.setRequest(mockRequest);
		publishMessage.setTopic(topic);
		publishMessage.publish(message, topicName);
		
//		verify(mockClient).publish(mockRequest);
		verify(mockRequest).withTopicArn(topicARN);
	}

	
	@Test
	public void publishTopic2Test(){

		String topicARN = "1234-XYZ-SMO";
		String message = "Test Message";
		String topicName = "Test Topic";
		AmazonSNSClient mockClient = mock(AmazonSNSClient.class);
		
		PublishRequest mockRequest = mock(PublishRequest.class);
		Topic topic = mock(Topic.class);
		when(topic.transalateTopicNameToARN(topicName)).thenReturn(topicARN);
		
		when(mockRequest.withTopicArn(topicARN)).thenReturn(mockRequest);
		when(mockRequest.withMessage(message)).thenReturn(mockRequest);
		
		//when(mockClient.publish(mockRequest)).thenReturn(any());
		
		PublishMessage publishMessage = new PublishMessage();
		publishMessage.setClient(mockClient);
		publishMessage.setRequest(mockRequest);
		publishMessage.setTopic(topic);
		publishMessage.publish(message, topicName);
		
//		verify(mockClient).publish(mockRequest);
		verify(mockRequest).withTopicArn(topicARN);
	}
}
