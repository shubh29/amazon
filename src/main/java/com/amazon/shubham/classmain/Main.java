package com.amazon.shubham.classmain;

import com.amazon.shubham.programactions.UserInteration;
import com.amazon.shubham.projectinfo.AboutProject;
import java.util.Scanner;

public class Main {
	
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
    while(value!=11) {
      if(value <=0 && value > 11) {
        System.out.println("Invalid Input!");
      } else {
        userInteration.operationInfo();
        value = scanner.nextInt();
        userInteration.choiceForOperation(value);
      }
    }
    scanner.close();
  }

}
