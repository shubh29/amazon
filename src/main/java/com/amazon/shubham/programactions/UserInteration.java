package com.amazon.shubham.programactions;

import java.util.Scanner;

public class UserInteration {
Scanner scanner = new Scanner(System.in);
	
	public void operationInfo() {
		System.out.println("Please select the operation (select choice by number):");
	    System.out.println("1: Create Topic");
	    System.out.println("2: List Topics");
	    System.out.println("3: Delete Topic");
	    System.out.println("4: Get Topic Attributes");
	    System.out.println("5: Set Topic Attributes");
	    System.out.println("6: Subscribe");
	    System.out.println("7: List Subscriptions");
	    System.out.println("8: Unsubscribe");
	    System.out.println("9: Publish");
	    System.out.println("10: EXIT Application");
	    System.out.println("!! Select a number between 1 to 10 only!!");
	    System.out.println("Enter an Action number");
	}
	
	public String choiceForOperation(int inputMain) {
		switch(inputMain){
		case 1: //Create Topic
			
        break;
        case 2:  //List Topics
            
        break;
        case 3:  //Delete Topic
           
        break;
        case 4: //Get Topic Attributes
          
        break;
        case 5:  //Set Topic Attributes
        	      
        break;
        case 6:  //Subscribe
        	
        break;
        case 7:  //List Subscriptions
        	
        break;
        case 8:  //Unsubscribe
           
        break;
        case 9://Publish
        	
        break;
        case 10: //Exit 
		
		}
	    
	    
		return null;
	}
	
	public void caseSelection() {
		
	}
	
	public void thankYouMessage() {
		System.out.println("\nThanks for using the application! Exiting the application now..");
	}
	
	public String exitApplication() {
		return "EXIT";
	}

}
