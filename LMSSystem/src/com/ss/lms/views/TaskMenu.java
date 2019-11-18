/**
 * 
 */
package com.ss.lms.views;

import java.util.Scanner;
import com.ss.lms.controllers.*;

/**
 * @author chiayang
 *
 */
public class TaskMenu {
	
	Scanner scanner = new Scanner(System.in);
	
	LMSAuthorController authController = new LMSAuthorController();
	
	public TaskMenu() {
		
	}
	
	public void getAuthorMenu() {		
		
		System.out.println("Author Menu\n");
		
		// TODO: Add in method to allow user to continue after an invalid selection!
		//int c = 0;
		//do {
		System.out.println("1. View Authors");
		System.out.println("2. Add an Author");
		System.out.println("3. Update an Author");
		System.out.println("4. Delete an Author");
		
		try {
		
			System.out.println("\nSelect a task to continue (1, 2, 3, 4):  ");			
			
			int taskNum = Integer.parseInt(scanner.nextLine());	
			
			System.out.println("You selected choice #:  " + taskNum + "\n");	
			
			// switch statement for menu selection 
			switch(taskNum)
			{
			   // case statements
			   // values must be of same type of expression
			   case 1:
	
				   System.out.println("you chose View Authors!");
	
				   
				   authController.seeListOfAuthor();
				   
				   break; // break is optional
			   
			   case 2:
	
				   System.out.println("you chose Add Authors!");
				   
				   System.out.println("Enter in new Author Name:  ");
				   
				   String authName = scanner.nextLine();
				   
				   System.out.println("Enter in new Author Phone:  ");
				   
				   String authPhoneNum = scanner.nextLine();
				   
				   System.out.println("Before Going to lmsauthController!:  ");
				   
				   authController.createAuthor(authName, authPhoneNum);
				   
				   System.out.println("After Going to lmsauthController!:  ");
				   
				   break; // break is optional
				   
			   case 3:
	
				   System.out.println("you chose Update Authors!");
				   // call LMSPublisherController method
				   
				   break; // break is optional   
				   
			   case 4:
	
				   System.out.println("you chose Delete Authors!");
				   // call LMSPublisherController method
				   
				   break; // break is optional  
			      
			   // We can have any number of case statements
			   // below is default statement, used when none of the cases is true. 
			   // No break is needed in the default case.
			   default : 
				   
				   System.out.println("Please enter in a valid selection!\n");
				   break; // break is optional   	
			}		
		} catch (Exception e) {
			
			System.out.println("You must enter in a valid selection!\n");		
		}			
	} // end of method getAuthorMenu	
	
	
	
	
}
