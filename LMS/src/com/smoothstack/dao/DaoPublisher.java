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
import com.smoothstack.entities.Publisher;

public class DaoPublisher {

	static List<Publisher> Publisher = new ArrayList<Publisher>(); 
	
	public static List<Publisher> readPublisher() throws IOException {
		   BufferedReader br = null;
		   List<Publisher> list = new ArrayList<Publisher>() ;
		   try 
		   {
			   br = new BufferedReader(new FileReader("C:\\Users\\jobys\\Music\\publisher.csv"));
		
			   String line = "";
		
			   br.readLine();
		
			   while((line = br.readLine()) != null)
			   {
				   String[] publisherDetails = line.split(",");
			
				   if(publisherDetails.length > 0)
				   {
						Publisher pub = new Publisher(publisherDetails[0],publisherDetails[1],publisherDetails[2]);
						list.add(pub);
				   }
			   }
			   for(Publisher p : Publisher)
	           {
	               System.out.println(p.getPublisherId()+"   "+p.getPublisherName()+"   "+p.getPublisherAddress());
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
	
	public static void writePublisher(List<com.smoothstack.entities.Publisher> list) {
		BufferedWriter writer = null;   
		StringBuilder sb = new StringBuilder();
		   try {
				   writer = new BufferedWriter(new FileWriter("C:\\Users\\jobys\\Music\\publisher.csv"));
			   {
				   sb.append("ID,Name,Address\n");
				   for (Publisher line: list) {
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
