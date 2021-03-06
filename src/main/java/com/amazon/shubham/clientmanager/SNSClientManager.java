package com.amazon.shubham.clientmanager;

import org.apache.log4j.Logger;

import com.amazonaws.auth.ClasspathPropertiesFileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;

//Singleton pattern
//Create only object of SNSClientManager
public class SNSClientManager {

	private static Logger sLogger = Logger.getLogger(SNSClientManager.class);

	// Eager loading
	private static SNSClientManager snsClientManager = new SNSClientManager();

	private AmazonSNSClient snsClient;

	// Make the constructor private so that this class cannot be instantiated
	protected SNSClientManager() {
		sLogger.debug("Calling SNS Client");
		snsClient = new AmazonSNSClient(new ClasspathPropertiesFileCredentialsProvider());
		snsClient.setRegion(Region.getRegion(Regions.US_EAST_1));
    }

	// Get the only object available
	public static SNSClientManager getInstance() {
		return snsClientManager;
	}

	// Get SNSClient
	public AmazonSNSClient getAmazonSNSClient() {
		// TODO Auto-generated method stub
		return snsClient;
	}
}
