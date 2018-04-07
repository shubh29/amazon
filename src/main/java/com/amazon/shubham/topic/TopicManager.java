package com.amazon.shubham.topic;

import com.amazon.shubham.clientmanager.SNSClientManager;
import java.util.ArrayList;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.GetTopicAttributesRequest;
import com.amazonaws.services.sns.model.ListTopicsResult;
import com.amazonaws.services.sns.model.Topic;
import java.util.List;

public class TopicManager {

  AmazonSNSClient snsClient;

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
		  System.out.println(topic.getTopicArn());
		  GetTopicAttributesRequest getTopicAttributesRequest = new GetTopicAttributesRequest(topic.getTopicArn());
		  System.out.println(snsClient.getTopicAttributes(getTopicAttributesRequest));
		  //get attributes and display name
	  }
  }

  //Method to get topic attributes
  public void getTopicAttributes() {
	  System.out.println("Fetching the list of topics");
	  snsClient = SNSClientManager.getInstance().getAmazonSNSClient();
	  List<Topic> topics = new ArrayList<>();
	  ListTopicsResult listTopicsResult = snsClient.listTopics(); //gets list of topics - first 100 and nextToken if more than 100
	  topics.addAll(listTopicsResult.getTopics());	//add first 100 topics to our local list
	  System.out.println("Printing list of all the topic attributes:");
	  for (Topic topic : topics) {
		  System.out.println(topic.getTopicArn());
		  GetTopicAttributesRequest getTopicAttributesRequest = new GetTopicAttributesRequest(topic.getTopicArn());
		  System.out.println(snsClient.getTopicAttributes(getTopicAttributesRequest));
		  //get attributes and display name
	  }
  }

  //Method to set topic attributes
  public void setTopicAttributes() {

  }

  //sns clinet method tests will require mockito
  //message,
  //
}
