package com.amazon.shubham.classmain;

import com.amazon.shubham.programactions.UserInteration;
import com.amazon.shubham.projectinfo.AboutProject;
import java.util.Scanner;

public class Main {

	// Main method
	public static void main(String[] args) throws Exception {

		// illegal construct
		// Compile Time Error: The constructor SingleObject() is not visible
		// SNSClientManager snsClientManager = new SNSClientManager();

		AboutProject aboutProject = new AboutProject();
		aboutProject.infoAboutprogram();

		UserInteration userInteration = new UserInteration();
		Scanner scanner = new Scanner(System.in);
		int value = 0;
		do {
			try {
			userInteration.operationInfo();
			value = scanner.nextInt();
			if (value <= 0 && value > 10) {
				System.out.println("Invalid Input!");
			} else {
				userInteration.choiceForOperation(value);
			} } catch(Exception e) {
				System.err.print("Please enter a valid input!");
				scanner.nextLine();
			}
		} while (value != 10);
		scanner.close();
	}

}
