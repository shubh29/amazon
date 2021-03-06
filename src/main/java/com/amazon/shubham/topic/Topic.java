package com.amazon.shubham.topic;

import com.amazon.shubham.clientmanager.SNSClientManager;
import com.amazon.shubham.message.Message;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;

public class Topic {

  private String topicARN;
  private String topicName;
  boolean isDeleted = false;

  //
  public Topic(String topicARN, String topicName) {
    super();
    this.topicARN = topicARN;
    this.topicName = topicName;
  }

  //The method saves the reloading of SNSClient everytime it is called and the region can be changed here
    public void publish(String message, String subject) {
    AmazonSNSClient snsClient = SNSClientManager.getInstance().getAmazonSNSClient(); 
    PublishRequest publishRequest = new PublishRequest(topicARN, message, subject);
    snsClient.publish(publishRequest);
  }
  
  //The aim of creating this method: allows us to perform operation directly on message for ex: an uppercase for first letter of subject
  public void publish(Message message) {
    publish(message.getMessage(), message.getSubject());
  }

  //Get the Topic ARN
  public String getTopicARN() {
    return topicARN;
  }

  //Get the Topic Name
  public String getTopicName() {
    return topicName;
  }
}
	