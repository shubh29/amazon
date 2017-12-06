package com.amazon.shubham.profile;

public class Topic {

	String topicARN;
	
	public String transalateTopicNameToARN(String topicName)
	{
		//some logig to featch this from the DB
		return topicARN;
	}

	public String getTopicARN() {
		return topicARN;
	}

	public void setTopicARN(String topicARN) {
		this.topicARN = topicARN;
	}
}
