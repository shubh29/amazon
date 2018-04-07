package com.amazon.shubham.classmain;

import com.amazon.shubham.programactions.UserInteration;
import com.amazon.shubham.projectinfo.AboutProject;
import java.util.Scanner;

/*import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
*/

//import com.amazonaws.services.sns.model.transform.SubscribeRequestMarshaller;

//@Controller
//@EnableAutoConfiguration

// import com.amazonaws.services.sns.model.Topic;

public class Main {
/*
	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}
	
	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "1. Create 2. Sub";
	}

	@RequestMapping(value="/createTopic", method=RequestMethod.POST)
	    @ResponseBody
	    String createTopic(@RequestBody Topic request) {
		System.out.println("Topic Name:"+request.getTopicName());
		 Topic topic = TopicFactory.createTopic(request.getTopicName());
			 
	        return "Topic created successfully";
	    }

	@RequestMapping(value="/creatSub")
	*/
	//SpringApplication.run(Main.class, args);
	
  //Main method
  public static void main(String[] args) throws Exception {

		//illegal construct
	    //Compile Time Error: The constructor SingleObject() is not visible
	    //SNSClientManager snsClientManager = new SNSClientManager();
		
    AboutProject aboutProject = new AboutProject();
    aboutProject.infoAboutprogram();

    UserInteration userInteration = new UserInteration();
    userInteration.operationInfo();

    Scanner scanner = new Scanner(System.in);
    int value = scanner.nextInt();
    if (value <= 0 && value > 10) {
    	System.out.println("Invalid Input!");
    } else {
        System.out.println("");
        userInteration.choiceForOperation(value);
    }
		// TODO Auto-generated method stub
		//topic.publish("How are you", "hi1");
		//topic.publish(new Message("how are you", "hi"));
		//topic.deleteTopic();
		// Subscription subscription = new Subscription();
		// subscribe(topic, "email", "shubham.mahajan29@gmail.com");
		// subscription.subscribe(topic, "SMS", "1-484-716-4765");
		//TopicManager topicManager = new TopicManager();
		//topicManager.listTopics();
		//topicManager.delete("xyz");
		/*
		EmailSubscription emailSubscription = new EmailSubscription();
		emailSubscription.subscribe(topic, "shubham.mahajan29@gmail.com");
		
		SMSSubscription smsSubscription = new SMSSubscription();
		smsSubscription.subscribe(topic, "1-484-716-4765");
		
		SubscriptionManager subscriptionManager = new SubscriptionManager();
		subscriptionManager.unSubscribe("+14847164765"); */
    scanner.close();
  }

}
