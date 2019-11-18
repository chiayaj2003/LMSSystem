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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ss.lms.models.Author;
import com.ss.lms.models.Book;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author chiayang
 *
 */
public class AuthorDao {

	// Removed - Chris's method
/*  
	public List<Author> readAuthors() throws IOException {
		FileInputStream record = new FileInputStream("./data/authorlist");
		BufferedReader buffReader = new BufferedReader(new InputStreamReader(record));
		
		Map<String, List<Book>> authorBookMap = new HashMap<String, List<Book>>();
		List<Author> authors = new ArrayList<Author>();
		String authorLine;
		
		while((authorLine = buffReader.readLine()) != null) {
			String[] splitArray = authorLine.split(",");
			
			Book b = new Book();
			b.setBookTitle(splitArray[1]);
			b.setBookIsbn(splitArray[2]);
			
			if(authorBookMap.containsKey(splitArray[0])){
				authorBookMap.get(splitArray[0]).add(b);
			}
			else {
				List<Book> books = new ArrayList<>();
				books.add(b);
				authorBookMap.put(splitArray[0], books);
			}
			
		}
		
		for( Entry<String, List<Book>> entry : authorBookMap.entrySet() ) {
			Author author = new Author();
//			author.setAuthorId(entry.getValue());
			author.setAuthorName(entry.getKey());
//			author.setBooks(entry.getValue());
//			authors.add(author);
		}
		
		
		buffReader.close();
		return authors;
	}
	*/
	
	// Removed - method to read authorlist from pao.
	/*
	 public List<Author> readAuthors() throws IOException {
		 RandomAccessFile file = new RandomAccessFile("./data/authorlist", "r");

		 FileChannel channel = file.getChannel();

		 System.out.println("File size is: " + channel.size());

		 ByteBuffer buffer = ByteBuffer.allocate((int) channel.size());

		 channel.read(buffer);

		 buffer.flip();//Restore buffer to position 0 to read it

		 System.out.println("Reading content and printing ... ");

		 for (int i = 0; i < channel.size(); i++) {
		     System.out.print((char) buffer.get());
		 }

		 channel.close();
		 file.close();

	 }		 
	 */
	
	// Working method.
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

	
	

