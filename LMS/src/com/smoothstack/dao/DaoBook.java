package com.smoothstack.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.smoothstack.entities.Author;
import com.smoothstack.entities.Book;

public class DaoBook {

	static List<Book> Book = new ArrayList<Book>();    
	
	public static List<Book> readBook() throws IOException {
		   BufferedReader br = null;
		   List<Book> list = new ArrayList<Book>() ;
		   try 
		   {
			   br = new BufferedReader(new FileReader("C:\\Users\\jobys\\Music\\books.csv"));

			   String line = "";
		
			   br.readLine();
		
			   while((line = br.readLine()) != null)
			   {
				   String[] bookDetails = line.split(",");
			
				   if(bookDetails.length > 0)
				   {
						Book b = new Book(bookDetails[0],bookDetails[1],bookDetails[2],bookDetails[3]);
						list.add(b);
				   }
			   }
			   
		   } 
		   catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			   e.printStackTrace();
		   }
		   finally
		   {
			   	try 
			   	{
			   		br.close();
			   	}
			   	catch(IOException ie)
			   	{
			   		System.out.println("Error occured while closing the BufferedReader");
			   		ie.printStackTrace();
			   	}
		   }
		   return list;
	   }
	
	public static void writeBook(List<com.smoothstack.entities.Book> list) {
		BufferedWriter writer = null;  
		  StringBuilder sb = new StringBuilder();
		   try {
			   writer = new BufferedWriter(new FileWriter("C:\\Users\\jobys\\Music\\books.csv"));
			   {
				   sb.append("BookID,Title,AuthorID,PublisherID\n");
				   for (Book line: list) {
					   sb.append(line.CSV()+"\n");
				   }
				   writer.write(sb.toString());
			   }
		   } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   finally {
	           try {
	               writer.close();
	           		}
	           catch (IOException e) {
	             // TODO Auto-generated catch block
	             e.printStackTrace();
	         }
		 }
	   }
}
