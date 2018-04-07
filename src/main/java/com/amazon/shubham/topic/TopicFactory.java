package com.amazon.shubham.topic;

import com.amazon.shubham.clientmanager.SNSClientManager;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.CreateTopicResult;

public class TopicFactory {
 
  //Method to create topic
  public static Topic createTopic(String TopicName) {
    //create a new SNS client and set endpoint
    AmazonSNSClient snsClient = SNSClientManager.getInstance().getAmazonSNSClient();
    //create a new SNS topic
    CreateTopicRequest createTopicRequest = new CreateTopicRequest(TopicName);
    CreateTopicResult createTopicResult = snsClient.createTopic(createTopicRequest);
    Topic topic = new Topic(createTopicResult.getTopicArn(), TopicName);
    snsClient.setTopicAttributes(createTopicResult.getTopicArn(), "DisplayName", TopicName);
    return topic;
  }
  
}
