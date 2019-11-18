/**
 * 
 */
package com.ss.lms.controllers;

import java.util.ArrayList;

import com.ss.lms.models.*;

/**
 * @author chiayang
 *
 */
public class LMSAuthorController {
	
	AuthorDao authorDao = new AuthorDao(); //creating dao of author
	
	public void seeListOfAuthor() {
		
		//System.out.println("LMSFrontController::readAuthor");				
		ArrayList<Author> authorList = authorDao.readFromAuthor();
		//authorList.forEach(x -> System.out.println("Id: "+x.getAuthorId()+" Name: "+x.getAuthorName()+" Phone Number: "+x.getAuthorPhoneNumber()));
		authorList.forEach(x -> System.out.println(x.getAuthorId()+" Name: "+x.getAuthorName()+" Phone Number: "+x.getAuthorPhoneNumber()));
	}	
	
	public void createAuthor(String authName, String authPhone){
		 
		  	System.out.println("Coming into lmsauthController - CreateAuthor  ");
		   //List<String> newAuthorInfo = authorOperationMenuObj.createAuthorMenu();
		   Author authorObj = new Author();
		   
		   authorObj.setAuthorName(authName);
			
		   authorObj.setAuthorPhoneNumber(authPhone);
			
		   ArrayList<Author> authorList = authorDao.readFromAuthor(); 
		   
		   authorObj.setAuthorId(authorDao.getLastIndex() + 1); //getLastIndex() method returns the last value of id 
		                                                        //so that we can increment it and assign to the new created author.
		   authorList.add(authorObj);
		   //authorList.forEach(x -> System.out.println("Id: "+x.getAuthorId()+" Name: "+x.getAuthorName()+" Phone Number: "+x.getAuthorPhoneNumber()));
		   authorList.forEach(x -> System.out.println(x.getAuthorId()+" Name: "+x.getAuthorName()+" Phone Number: "+x.getAuthorPhoneNumber()));
		   
		System.out.println("Before going to writeToAuthor");
		   authorDao.writeToAuthor(authorList); //write back to the file after adding the new author object.
	}
	
	public void updateAuthor() {
		
		
		System.out.println("LMSFrontController::updateAuthor");
		
	}
	
	public void deleteAuthor() {
		
		
		System.out.println("LMSFrontController::deleteAuthor");
	}
}
