package sns;

import java.util.Scanner;

public class UserChoiceKey {
	String ACCESSKEYID = "";
	String SECRETKEYID = "";
	Scanner scannerKeySelection = new Scanner(System.in);
	String userChoiceForKey = "";
	
	public String userSelectionForkeys() {
		System.out.println("Do you want to use default access key used for Shubham's account?");
	    System.out.println("Press Y/y to use default or Press N/n to overwrite with custom access key:");
	    userChoiceForKey = scannerKeySelection.next();
	    if (userChoiceForKey.equalsIgnoreCase("y")) {
	    	ACCESSKEYID = "AKIAJAP7SPJMW3B4SB7Q";
	    	SECRETKEYID = "2YqnukGtf/7kqNQkNQT26p4nYTXEHEDv2cZrf41j";
	      } else {
	        System.out.println("Enter Access Key Id");
	        ACCESSKEYID = scannerKeySelection.next();
	        System.out.println("Enter Secret Access Key");
	        SECRETKEYID = scannerKeySelection.next();
	      }
		return userChoiceForKey;
	}
	
}
