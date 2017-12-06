package sns;

import java.util.Scanner;

import com.amazonaws.services.sns.AmazonSNS;

public class PublishSubscribeOperations {
	Scanner pSOClassScanner = new Scanner(System.in);
	String pSOClassString = "";
	AmazonSNS amazonSNS;
	
	public void publishTopic() {
		System.out.println("Enter the subject to publish the topic: ");
		pSOClassString = pSOClassScanner.next();
		System.out.println("Enter the message to publish the topic: ");
	}
	
	public void subscribeTopic() {
		System.out.println("Does the topic you want to publish already exists?");
		System.out.println("");
		System.out.println("Enter the name of the Topic:");
		System.out.println("Enter the mobile number in the format country code followed by ten digit mobile number e.g. 14847164765:");
		pSOClassString = pSOClassScanner.next();
	}
	
	public void unsubcribeTopic() {
		System.out.println("Enter the 11 digit mobile number you want to unsubscribe in the format country code followed by mobile number e.g. 14847164765:");
		pSOClassString = pSOClassScanner.next();
	}

}
