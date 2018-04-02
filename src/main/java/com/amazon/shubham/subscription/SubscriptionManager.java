package com.amazon.shubham.subscription;

import java.util.ArrayList;
import java.util.List;

import com.amazon.shubham.clientmanager.SNSClientManager;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.ListSubscriptionsResult;
import com.amazonaws.services.sns.model.UnsubscribeRequest;
import com.amazonaws.services.sns.model.Subscription;

public class SubscriptionManager {
	AmazonSNSClient snsClient;
	
	public List<Subscription> listSubscriptions() {
		snsClient = SNSClientManager.getInstance().getAmazonSNSClient();
		System.out.println("Deriving list of Subscriptions..");
		
		List<Subscription> subscriptions = new ArrayList<>();
		 
		 ListSubscriptionsResult listSubscriptionsResult = snsClient.listSubscriptions(); //gets list of topics - first 100 and nextToken if more than 100
		 
	     subscriptions.addAll(listSubscriptionsResult.getSubscriptions());	//add first 100 topics to our local list
	     String nextToken = listSubscriptionsResult.getNextToken(); //check if more than 100 then nextToken != null
	      //iterator patter. Also an example of pagination
	      while (nextToken != null) {
	          listSubscriptionsResult = snsClient.listSubscriptions(nextToken); //get me next 100 topics and nextToken if still more than 100

	         subscriptions.addAll(listSubscriptionsResult.getSubscriptions());	//add next 100 topics to our local list
	 	     nextToken = listSubscriptionsResult.getNextToken(); //check if more than 100 then nextToken != null
	 	     
	          
	      }
	      for (Subscription subscription : subscriptions) {
	          System.out.println(subscription);
	      }
	      return subscriptions;
	}
	
	public void unSubscribe(String value) {
		List<Subscription> list = listSubscriptions();
		for (Subscription subscription: list) {
			if(subscription.getEndpoint().equals(value)) {
				 UnsubscribeRequest unsubscribeRequest = new UnsubscribeRequest(subscription.getSubscriptionArn());
			      snsClient.unsubscribe(unsubscribeRequest);
			}
		}		
	}
}
