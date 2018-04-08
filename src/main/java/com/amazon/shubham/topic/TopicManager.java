package com.amazon.shubham.topic;

import com.amazon.shubham.clientmanager.SNSClientManager;
import java.util.ArrayList;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.DeleteTopicRequest;
import com.amazonaws.services.sns.model.GetTopicAttributesRequest;
import com.amazonaws.services.sns.model.GetTopicAttributesResult;
import com.amazonaws.services.sns.model.ListTopicsResult;
import com.amazonaws.services.sns.model.Topic;
import java.util.List;

public class TopicManager {

  AmazonSNSClient snsClient;
  String topicARN ="";
  
  GetTopicAttributesRequest getTopicAttributesRequest;

  public void listTopics() {
    System.out.println("Listing Topics..");
    snsClient = SNSClientManager.getInstance().getAmazonSNSClient();
    List<Topic> topics = new ArrayList<>();
    //Gets list of topics - first 100 and nextToken if more than 100
    ListTopicsResult listTopicsResult = snsClient.listTopics(); 
    //Add first 100 topics to our local list
    topics.addAll(listTopicsResult.getTopics());	
    //Check if more than 100 then nextToken != null
    String nextToken = listTopicsResult.getNextToken(); 
    //Iterator pattern. Also an example of pagination
    while (nextToken != null) {
    	//Gets the next 100 topics and nextToken if still more than 100
    	listTopicsResult = snsClient.listTopics(nextToken); 
    	//Adds the next 100 topics to our local list
    	topics.addAll(listTopicsResult.getTopics());	
    	//check if more than 100 then nextToken != null
    	nextToken = listTopicsResult.getNextToken(); 
    }
    for (Topic topic : topics) {
    	System.out.println(topic);
    }
  }

  //Method to delete a topic
  public void delete(String value) {
    System.out.println("Fetching the list of topics");
    snsClient = SNSClientManager.getInstance().getAmazonSNSClient();
    List<Topic> topics = new ArrayList<>();
    ListTopicsResult listTopicsResult = snsClient.listTopics(); 
    topics.addAll(listTopicsResult.getTopics());	
    for (Topic topic : topics) {
      getTopicAttributesRequest = new GetTopicAttributesRequest(topic.getTopicArn());
      GetTopicAttributesResult getTopicAttributesResult = snsClient.getTopicAttributes(getTopicAttributesRequest);
      String topicName = getTopicAttributesResult.getAttributes().get("DisplayName");
      if(topicName.equals(value)) {
    	  topicARN = topic.getTopicArn();
      }
    }
    if(topicARN=="") {
      System.out.println("The name of the topic you entered, doesnt exists!");
    } else {
      DeleteTopicRequest deleteTopicRequest = new DeleteTopicRequest(topicARN);
      snsClient.deleteTopic(deleteTopicRequest);
      System.out.println("The topic: "+value+" has been deleted!");
    }
  }

  //Method to get topic attributes
  public void getTopicAttributes(String value) {
    System.out.println("Fetching the list of topics");
    snsClient = SNSClientManager.getInstance().getAmazonSNSClient();
    List<Topic> topics = new ArrayList<>();
    ListTopicsResult listTopicsResult = snsClient.listTopics(); //gets list of topics - first 100 and nextToken if more than 100
    topics.addAll(listTopicsResult.getTopics());	//add first 100 topics to our local list
    System.out.println("Printing list of all the topic attributes:");
    for (Topic topic : topics) {
      GetTopicAttributesRequest getTopicAttributesRequest = new GetTopicAttributesRequest(topic.getTopicArn());
      GetTopicAttributesResult getTopicAttributesResult = snsClient.getTopicAttributes(getTopicAttributesRequest);
      String topicName = getTopicAttributesResult.getAttributes().get("DisplayName");
      if(topicName.equals(value)) {
        topicARN = topic.getTopicArn();
        System.out.println(topicARN);
	  }
    }
    if(topicARN=="") {
      System.out.println("The name of the topic you entered, doesnt exists!");
    } else {
      GetTopicAttributesRequest getTopicAttributesRequest = new GetTopicAttributesRequest(topicARN);
      System.out.println("Listing the attributes of the topic: "+value);
      System.out.println(snsClient.getTopicAttributes(getTopicAttributesRequest));
    }
  }

  //Method to set topic attributes
  public void setTopicAttributes() {

  }

}
