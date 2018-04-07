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

  //Method to list subscriptions
  public List<Subscription> listSubscriptions() {
    snsClient = SNSClientManager.getInstance().getAmazonSNSClient();
    System.out.println("Deriving list of Subscriptions..");
    List<Subscription> subscriptions = new ArrayList<>();
    //Gets list of topics - first 100 and nextToken if more than 100
    ListSubscriptionsResult listSubscriptionsResult = snsClient.listSubscriptions(); 
    //Add first 100 subscriptions to our local list
    subscriptions.addAll(listSubscriptionsResult.getSubscriptions());
    //check if more than 100 then nextToken != null
    String nextToken = listSubscriptionsResult.getNextToken(); 
    //Iterator pattern. Also an example of pagination
    while (nextToken != null) {
      //Get the next 100 subscriptions and nextToken if still more than 100
      listSubscriptionsResult = snsClient.listSubscriptions(nextToken); 
      //Add next 100 subscriptions to our local list
      subscriptions.addAll(listSubscriptionsResult.getSubscriptions());	 
      //Check if more than 100 then nextToken != null
      nextToken = listSubscriptionsResult.getNextToken(); 
    }
    for (Subscription subscription : subscriptions) {
      System.out.println(subscription);
    }
    return subscriptions;
  }

  //Method to unsubscribe a topic
  public void unSubscribe(String value) {
    List<Subscription> list = listSubscriptions();
    for (Subscription subscription: list) {
      if(subscription.getEndpoint().equals(value)) {
        UnsubscribeRequest unsubscribeRequest = new UnsubscribeRequest(subscription.getSubscriptionArn());
        snsClient.unsubscribe(unsubscribeRequest);
      } else {
        System.out.println("The name of the topic you entered doesn't exist!");
      }
    }
  }
  
}
