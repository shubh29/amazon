package com.amazon.shubham.topic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.amazon.shubham.clientmanager.SNSClientManager;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.CreateTopicResult;

@RunWith(PowerMockRunner.class)
@PrepareForTest({SNSClientManager.class})
public class TopicFactoryTest {

	@Test
	public void test() {
		
		SNSClientManager manager = Mockito.mock(SNSClientManager.class);
		
		AmazonSNSClient client = Mockito.mock(AmazonSNSClient.class);
		CreateTopicResult topicResult = Mockito.mock(CreateTopicResult.class);
		
		PowerMockito.mockStatic(SNSClientManager.class);
		
	
		Mockito.when(SNSClientManager.getInstance()).thenReturn(manager);
		Mockito.when(manager.getAmazonSNSClient()).thenReturn(client);
		Mockito.when(client.createTopic(Matchers.any(CreateTopicRequest.class))).thenReturn(topicResult);
		
		client.setTopicAttributes(topicResult.getTopicArn(), "DisplayName", "My Test");
	}

	/*
	public static Topic createTopicTest(String TopicName) {
		return ;
	}
	*/
}
