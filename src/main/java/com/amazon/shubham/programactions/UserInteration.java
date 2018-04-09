package com.amazon.shubham.programactions;

import java.util.Scanner;

import com.amazon.shubham.subscription.EmailSubscription;
import com.amazon.shubham.subscription.SubscriptionManager;
import com.amazon.shubham.topic.Topic;
import com.amazon.shubham.topic.TopicFactory;
import com.amazon.shubham.topic.TopicManager;

public class UserInteration {
Scanner scanner = new Scanner(System.in);

  //Information about program actions
  public void operationInfo() {
    System.out.println("Please select the operation (select choice by number):");
    System.out.println("1: Create Topic");
    System.out.println("2: List Topics");
    System.out.println("3: Delete Topic");
    System.out.println("4: Get Topic Attributes");
    System.out.println("5: Set Topic Attributes");
    System.out.println("6: Subscribe to a topic via email");
    System.out.println("7: Subscribe to a topic via sms");
    System.out.println("8: List Subscriptions");
    System.out.println("9: Unsubscribe");
    System.out.println("10: Publish");
    System.out.println("11: Exit application");
    System.out.println("!! Select a number between 1 to 11 only!!");
    System.out.println("Enter an Action number");
  }

  //Method to select operations
  public void choiceForOperation(int inputMain) {
    Scanner scanner = new Scanner(System.in);
    String userInput;
    Topic topic = null;
    SubscriptionManager subscriptionManager = new SubscriptionManager();
    TopicManager topicManager = new TopicManager();
    boolean condition = true;
    while(condition == true) {
    if(inputMain <= 0 && inputMain >11) {
      System.out.println("Invalid Input! Please enter a number between 1 to 11 only.");
    }
    else {
    	
      switch(inputMain){
        case 1: //Create Topic
          System.out.println("Enter the ame of the topic you would like to create : ");
          userInput = scanner.next();
          topic = TopicFactory.createTopic(userInput);
          System.out.println("Topic created");
          break;
        case 2:  //List Topics
          topicManager.listTopics();
          break;
        case 3:  //Delete Topic
         System.out.println("Enter the name of the topic you would like to delete:");
         userInput = scanner.next();
         topicManager.delete(userInput);
          break;
        case 4: //Get Topic Attributes
          //printing all the topics at this time, do it for single topic
          System.out.println("Enter the name of the topic, you would like to get attributes of:");
          userInput = scanner.next();
          topicManager.getTopicAttributes(userInput);
          break;
        case 5:  //Set Topic Attributes
        
          break;
        case 6:  //Subscribe via email
          System.out.println("Enter the name of the topic you would like to subscribe to: ");
          userInput = scanner.next();
          topic = TopicFactory.createTopic(userInput);
          System.out.println("Enter the email address you would like to subscribe to: ");
          userInput = scanner.next();
          EmailSubscription emailSubscription = new EmailSubscription();
          emailSubscription.subscribe(topic, userInput);
          break;
        case 7:  //Subscribe via sms
          System.out.println("Enter the name of the topic you would like to subscribe to: ");
          userInput = scanner.next();
          topic = TopicFactory.createTopic(userInput);
          System.out.println("Enter the email address you would like to subscribe to: ");
          userInput = scanner.next();
          break;
        case 8:  //List Subscriptions
          subscriptionManager.listSubscriptions();
          break;
        case 9: //Unsubscribe
          System.out.println("Enter the name of the topic, you would like to unsubscribe: ");
          userInput = scanner.next();
          subscriptionManager.unSubscribe(userInput);
          break;
        case 10: //Publish
          System.out.println("Enter the name of the topic");
    	  userInput = scanner.next();
    	  topic = TopicFactory.createTopic(userInput);
    	  System.out.println("Enter the subject: ");
    	  userInput = scanner.next();
    	  System.out.println("Enter the message: ");
    	  String message = scanner.next();
    	  topic.publish(message, userInput);
        case 11: //Exit
    	  System.out.println("\nThanks for using the application! Exiting the application now..");
    	  scanner.close();
    	  condition = false;
    	  break;
		} }
    }
    System.out.println("Press any between 1 to 11 to enter the main menu, press 10 for exit :");
  }
    
  public String exitApplication() {
    return "EXIT";
  }
}
