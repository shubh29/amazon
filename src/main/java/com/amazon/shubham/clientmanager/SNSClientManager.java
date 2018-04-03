package com.amazon.shubham.clientmanager;

import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
//singleton pattern
//create an object of SingleObject
public class SNSClientManager {
	
	//eager loading
	private static SNSClientManager snsClientManager = new SNSClientManager();
	
	private AmazonSNSClient snsClient;
	
	//make the constructor private so that this class cannot be instantiated
	private SNSClientManager() {
		System.out.println("New SNS Client Created");
	    snsClient = new AmazonSNSClient(new ClasspathPropertiesFileCredentialsProvider());		                           
		snsClient.setRegion(Region.getRegion(Regions.US_EAST_1));
	}

	//Get the only object available
	public static SNSClientManager getInstance() {
		
		return snsClientManager;
	}

	public AmazonSNSClient getAmazonSNSClient() {
		// TODO Auto-generated method stub
		return snsClient;
	}
}
