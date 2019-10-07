package com.smoothstack.SERVICE;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.smoothstack.dao.*;
import com.smoothstack.entities.*;

public class Service {
	
	static Scanner input = new Scanner(System.in);
	static String choice = "";
	

	//CREATE
	public static void CreateAuthor(String id, String name, List<Author> newAuthor) {
		for(Author i: newAuthor) 
		{
			if(i.getAuthorId().equals(id)) {
				System.out.print("The Author already exists");
				System.out.print("Press any key to continue");
				choice = input.nextLine();
				return;
			}
		}
		Author auth = new Author(id, name);
		newAuthor.add(auth);
		DaoAuthor.writeAuthor(newAuthor);
	}
	
	public static void CreatePublisher(String id, String name, String address, List<Publisher> newPublisher) {
		for(Publisher i: newPublisher) 
		{
			if(i.getPublisherId().equals(id)) {
				System.out.print("The Publisher already exists");
				System.out.print("Press any key to continue");
				choice = input.nextLine();
				return;
			}
		}
		Publisher pub = new Publisher(id, name, address);
		newPublisher.add(pub);
		DaoPublisher.writePublisher(newPublisher);
	}
	

	public static void CreateBook(String bookid, String name, String authid,
			String pubid, List<Book> newBook, List<Author> newAuthor, List<Publisher> newPublisher) {
		for(Book i: newBook) 
		{
			if(i.getBookId().equals(bookid)) {
				System.out.print("The Book already exists");
				System.out.print("Press any key to continue.....");
				choice = input.nextLine();
				return;
			}	
		}
		boolean check = false;
		for(Author i: newAuthor) 
		{	
				if(i.getAuthorId().equals(authid)) 
				{
					check = true;
					break;
				}	
		}
		if(check == true)
		{
			check = false;
			for(Publisher i: newPublisher) 
			{
				if(i.getPublisherId().equals(pubid)) {
					check = true;
					break;
				}	
			}
			if(check == false)
			{
				System.out.println("Publisher doesn't exist\n");
				System.out.println("Press any key to continue....");
				choice = input.nextLine();
				return;
			}
		}
		else 
		{
			System.out.println("Author doesn't exist\n");
			System.out.println("Press any key to continue....");
			choice = input.nextLine();
			return;
		}
		Book book = new Book(bookid, name, authid, pubid);
		newBook.add(book);
		DaoBook.writeBook(newBook);
	}
	
	//UPDATE
	public static void UpdateAuthor(String id, String name, List<Author> list) {
		int index = 0;
		for(Author i: list) 
		{
			if(i.getAuthorId().equals(id)) {
				index = list.indexOf(i);
				list.get(index).setAuthorName(name);
				DaoAuthor.writeAuthor(list);
			}
		}
	}
	
	public static void UpdatePublisher(String id, String name, String address, List<Publisher> list) {
		int index = 0;
		for(Publisher i: list) 
		{
			if(i.getPublisherId().equals(id)) {
				if(address == "n/a" | address == "N/A")
				{
				index = list.indexOf(i);
				list.get(index).setPublisherName(name);
				DaoPublisher.writePublisher(list);
				}
				else if(name == "n/a" | name == "N/A")
				{
				index = list.indexOf(i);
				list.get(index).setPublisherAddress(address);
				DaoPublisher.writePublisher(list);
				}
				else
				{
					index = list.indexOf(i);
					list.get(index).setPublisherName(name);
					list.get(index).setPublisherAddress(address);
					DaoPublisher.writePublisher(list);
				}
			}
		}
	}
	

	public static void UpdateBook(String id, String name, List<Book> list) {
		int index = 0;
		for(Book i: list) 
		{
			if(i.getBookId().equals(id)) {
				index = list.indexOf(i);
				list.get(index).setBookTitle(name);
				DaoBook.writeBook(list);
			}
		}
	}
	
	//DELETE
	public static void DeleteBook(String id, List<Book> booklist) {
		for(Iterator<Book> boo = booklist.iterator(); boo.hasNext();) 
		{
			Book b = boo.next();
			if(b.getBookId().equals(id))
			{
				boo.remove();
				DaoBook.writeBook(booklist);
				return;
			}
		}
	}
	
	public static void DeletePublisher(String id, List<Publisher> list, List<Book> booklist) {
		
		for(Iterator<Book> boo = booklist.iterator(); boo.hasNext();) 
		{
			Book b = boo.next();
			if(b.getPublisherId().equals(id))
			{
				boo.remove();
				DaoBook.writeBook(booklist);
			}
		}
		
		for(Iterator<Publisher> pub = list.iterator(); pub.hasNext();) 
		{
			Publisher p = pub.next();
			if(p.getPublisherId().equals(id))
			{
				pub.remove();
				DaoPublisher.writePublisher(list);
			}
		}
	}
	
public static void DeleteAuthor(String id, List<Author> list, List<Book> booklist)
{
		for(Iterator<Book> boo = booklist.iterator(); boo.hasNext();) 
		{
			Book b = boo.next();
			if(b.getAuthorId().equals(id))
			{
				boo.remove();
			}
		}
		DaoBook.writeBook(booklist);
		
		for(Iterator<Author> auth = list.iterator(); auth.hasNext();) 
		{
			Author a = auth.next();
			if(a.getAuthorId().equals(id))
			{
				auth.remove();
				DaoAuthor.writeAuthor(list);
				return;
			}
		}
	}
	
	
}
