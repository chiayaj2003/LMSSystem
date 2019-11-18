/**
 * 
 */
package com.ss.lms.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author chiayang
 */
public class BookDao{

	// absolute path
	private String filepath = ("C:\\MYWORKSPACE\\Week1Assignments\\LMSSystem\\Data\\authorlist.txt");
	
	// relative path
	//private String filepath = (*./Data/authorlist.txt);	
	
	//method to read from file and save the data in an arraylist.
	private int lastIndex;
   
    public int getLastIndex() {
    	return this.lastIndex;
    }

	public ArrayList<Author> readFromAuthor(){
		ArrayList<Author> authorList= new ArrayList<Author>();
		try {
		FileInputStream fileIn = new FileInputStream(filepath);
		BufferedReader br = new BufferedReader(new InputStreamReader(fileIn));
		String lineRead;
		
		while((lineRead = br.readLine() )!= null) {
			String[] splitFile = lineRead.split(",");
			Author authObj = new Author();
			authObj.setAuthorId(Integer.parseInt(splitFile[0]) );
			authObj.setAuthorName(splitFile[1]);
			authObj.setAuthorPhoneNumber(splitFile[2]);
			authorList.add(authObj);
		}
		br.close();
		fileIn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		lastIndex = authorList.get(authorList.size()-1).getAuthorId();
		return authorList;
	}
	
	
	//method to write ArrayList back to file after the update is done.
	public void writeToAuthor(ArrayList<Author> newAuthorList) {

		String tempFile = "temp.txt"; //temporary file where we will write the info and the replace it with the original file.

		File oldFile = new File(filepath);

		File newFile = new File(tempFile);

		FileWriter fw;
		
		try {
			fw = new FileWriter(newFile,true); //creating a filewriter to write to temp file.
			for(int i=0;i<newAuthorList.size();i++) {
				fw.write(newAuthorList.get(i).getAuthorId()+","+newAuthorList.get(i).getAuthorName()+","
						+ newAuthorList.get(i).getAuthorPhoneNumber()+"\n");
			}
			oldFile.delete();
			File dump = new File("c:\\MYWORKSPACE\\Week1Assignments\\LMSSystem\\Data\\authorlist.txt"); //creating a new file with the same file location and file name

			newFile.renameTo(dump);
		
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		lastIndex = newAuthorList.get(newAuthorList.size()-1).getAuthorId();
	}	
}

	
	

