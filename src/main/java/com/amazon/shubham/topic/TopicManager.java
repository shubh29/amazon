package com.amazon.shubham.topic;

import java.util.ArrayList;
import java.util.List;

import com.amazon.shubham.clientmanager.SNSClientManager;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.ListTopicsResult;
import com.amazonaws.services.sns.model.Topic;

public class TopicManager {

	AmazonSNSClient snsClient;

	public void listTopics() {
		 System.out.println("Listing Topics..");
		 
		 AmazonSNSClient snsClient = SNSClientManager.getInstance().getAmazonSNSClient();
		 List<Topic> topics = new ArrayList<>();
		 
		 ListTopicsResult listTopicsResult = snsClient.listTopics(); //gets list of topics - first 100 and nextToken if more than 100
		 
	     topics.addAll(listTopicsResult.getTopics());	//add first 100 topics to our local list
	     String nextToken = listTopicsResult.getNextToken(); //check if more than 100 then nextToken != null
	      //iterator patter. Also an example of pagination
	      while (nextToken != null) {
	          listTopicsResult = snsClient.listTopics(nextToken); //get me next 100 topics and nextToken if still more than 100

	         topics.addAll(listTopicsResult.getTopics());	//add next 100 topics to our local list
	 	     nextToken = listTopicsResult.getNextToken(); //check if more than 100 then nextToken != null
	      }
	      for (Topic topic : topics) {
	          System.out.println(topic);
	      }
	}
	
	public void delete(String value) {
		
		 List<Topic> list = new ArrayList<>();
		 for (Topic topic: list) {
			 if(topic.getTopicArn().equals(value)) {
				 
			 }
		 }
	}
}
