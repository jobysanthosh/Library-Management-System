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
import com.smoothstack.entities.*;

public class DaoAuthor {

     //Generate the list of publishers
    //List<Book> Book = new ArrayList<Book>();
	static List<Author> Author = new ArrayList<Author>();  
    
	
    
   public static List<Author> readAuthor() {
	   BufferedReader br = null;
	   List<Author> list = new ArrayList<Author>() ;
	   try 
	   {
		   br = new BufferedReader(new FileReader("C:\\Users\\jobys\\Music\\authors.csv"));
	
		   String line = "";
	
		   br.readLine();
		   while((line = br.readLine()) != null)
		   {
			   String[] authorDetails = line.split(",");
		
			   if(authorDetails.length > 0)
			   {
					Author auth = new Author(authorDetails[0],authorDetails[1]);
					list.add(auth);
			   }
		   }
//		   for(Author a : Author)
//           {
//               System.out.println(a.getAuthorId()+"   "+a.getAuthorName()+"   ");
//           }

	   } 
	   catch (FileNotFoundException f) {
		// TODO Auto-generated catch block
		   System.out.println("Error");
	   }
	   catch (IOException i) {
			// TODO Auto-generated catch block
			   System.out.println("Error");
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
		   	}
	   }
	   return list;
   }
   
   
   
   

   public static void writeAuthor(List<com.smoothstack.entities.Author> list) {
	   BufferedWriter writer = null;
	   StringBuilder sb = new StringBuilder();
	   try {
		   	    writer = new BufferedWriter(new FileWriter("C:\\Users\\jobys\\Music\\authors.csv"));
			   sb.append("ID,Name\n");
			   for (Author line: list) {
				   sb.append(line.CSV()+"\n");
			   }
			   writer.write(sb.toString());
			  
		   }
		   
	    catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   finally {
           try {
               writer.close();
           		}
           catch (IOException e) {
             // TODO Auto-generated catch block
        	   System.out.println("Error");
         }
	   }
   }
}
