package sns;

import java.util.Scanner;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.DeleteTopicRequest;

public class BasicTopicOperations {
	AmazonSNS amazonSNSObject;
	private static AWSCredentials credentials;
	private static Region region;
	Region REGION = Region.getRegion(Regions.US_WEST_2);
	Scanner btoClassScanner = new Scanner(System.in);
	String userInputString = "";
	
	 public BasicTopicOperations(AWSCredentials p_credentials, Region p_region ) throws AmazonClientException {
		 credentials = p_credentials;
		 try {
			 System.out.println("Creating Amazon SNS Client..");
		     amazonSNSObject = new AmazonSNSClient(credentials);
		     System.out.println("Amazon SNS Client created successfully..");
		 } catch (Exception ex) {
		     System.out.println("Failed to create AWS Simple Notification Service Client");
		     ex.printStackTrace();
		 }
		 if (p_region == null) {
			 region = Region.getRegion(Regions.US_EAST_1);
		 } else {
		     region = p_region;
		 }
		    System.out.println("Setting Region to: " + region.getName());
		    amazonSNSObject.setRegion(region);
	 }

	public void createTopic() {
		System.out.println("Please enter the name of the topic you would like to create:");
		userInputString = btoClassScanner.next();
		CreateTopicRequest createTopicRequestObject = new CreateTopicRequest(userInputString);
		System.out.println("Creating Topic");
		amazonSNSObject.createTopic(createTopicRequestObject);
		System.out.println("Topic " + userInputString + "has been created!");
	}
	
	
	public void listTopic() {
		
	}
	
	public void deleteTopic() {
		System.out.println("Please enter the name of the topic you would like to create:");
		userInputString = btoClassScanner.next();
		DeleteTopicRequest deleteTopicRequestObject =  new DeleteTopicRequest(userInputString);
		amazonSNSObject.deleteTopic(deleteTopicRequestObject);
		System.out.println("Topic" + userInputString + "has been deleted!");
	}
}
