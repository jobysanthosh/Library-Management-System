package com.smoothstack.UI;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import com.smoothstack.dao.*;
import com.smoothstack.entities.*;
import com.smoothstack.service.*;

	class Main {
	static Scanner input = new Scanner(System.in);
	static String choice = "";
	
	public static void clrscr(){
	    //Clears Screen in java
	    try {
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	    } catch (IOException | InterruptedException ex) {}
	}
	
	public class ThreadSleep {
	
	    public void threadsleep() throws InterruptedException {
	        long start = System.currentTimeMillis();
	        Thread.sleep(2000);
	        System.out.println("Sleep time in ms = "+(System.currentTimeMillis()-start));
	    }
	}

	public static boolean isInteger(String number) {
		try {
			int num = Integer.parseInt(number);
		}
		catch(NumberFormatException | NullPointerException e){
			return false;
		}
		return true;
	}

	public static void AuthorMenu() throws IOException, InterruptedException {
		String authname, authid;
		List<Author> list = null;
		while(choice!="5") {
			list = null;
			list = DaoAuthor.readAuthor();
			clrscr();
			System.out.println("\nWelcome to the Author Menu?\n");
			System.out.println("-------------------------------------------\n");
			System.out.println("1- View all records");
			System.out.println("2- Create a record");
			System.out.println("3- Update a record");
			System.out.println("4- Delete a record");
			System.out.println("5- Exit to previous menu");
			System.out.println("Enter your selection(1-4):- \n");
			
			choice = input.nextLine();
			switch(choice)
			{
			case "1":
				System.out.println("Author ID\t"+"Author Name");
				for(Author a : list)
		           {
		               System.out.println(a.getAuthorId()+"\t\t"+a.getAuthorName());
		           }
				choice = input.nextLine();
				break;
			case "2":
				System.out.println("What is the ID for the new Author?");
				authid = input.nextLine();
				System.out.println("What is the name for the new Author?");
				authname = input.nextLine();
				if(isInteger(authid)) {
					Service.CreateAuthor(authid, authname, list);
				}
				else {
					System.out.println("Please input an Integer");
					Thread.sleep(1000);
					return;
				}
				break;
			case "3":
				System.out.println("Author ID\t"+"Author Name");
				for(Author a : list)
		           {
		               System.out.println(a.getAuthorId()+"\t\t"+a.getAuthorName());
		           }
				System.out.println("What is the ID of the Author to edit?\n");
				authid = input.nextLine();
				System.out.println("What is the updated name for the Author?\n");
				authname = input.nextLine();
				if(isInteger(authid)) {
					Service.UpdateAuthor(authid, authname, list);
				}
				else {
					System.out.println("Please input an Integer");
					Thread.sleep(1000);
					return;
				}
				break;
			case "4":
				   System.out.println("Author ID\t"+"Author Name");
				for(Author a : list)
		           {
		               System.out.println(a.getAuthorId()+"\t\t"+a.getAuthorName()+"\t");
		           }
				System.out.println("What is the ID of the Author that you want to edit?");
				authid = input.nextLine();
				if(isInteger(authid)) {
					Service.DeleteAuthor(authid, list, DaoBook.readBook());
				}
				else {
					System.out.println("Please input an Integer");
					Thread.sleep(1000);
					return;
				}
				break;
			case "5":
				return;
			default:
				clrscr();
				System.out.println("Invalid choice, please try again\n");
				Thread.sleep(1000);
				break;

			}
		}
	}
		
		public static void PublisherMenu() throws IOException, InterruptedException {
			String pubName, pubId, pubAddress;
			List<Publisher> list = null;
			while(choice!="5") {
				list = null;
				list = DaoPublisher.readPublisher();
				clrscr();
				System.out.println("\nWelcome to the Publisher Menu\n");
				System.out.println("-------------------------------------------\n");
				System.out.println("1- View all records");
				System.out.println("2- Create a record");
				System.out.println("3- Update a record");
				System.out.println("4- Delete a record");
				System.out.println("5- Exit to previous menu\n");
				System.out.println("Enter your selection(1-4):- \n");
				
				choice = input.nextLine();
				switch(choice)
				{
				case "1":
					System.out.println("Publisher ID\t"+"Publisher Name\t"+"Publisher Address");
					for(Publisher p : list)
			           {
			               System.out.println(p.getPublisherId()+"\t\t"+p.getPublisherName()+"\t\t"+
			           p.getPublisherAddress());
			           }
					choice = input.nextLine();
					break;
				case "2":
					System.out.println("What is the ID for the Publisher?\n");
					pubId = input.nextLine();
					System.out.println("What is the name for the Publisher?\n");
					pubName = input.nextLine();
					System.out.println("What is the Address for the Publisher?\n");
					pubAddress = input.nextLine();
					if(isInteger(pubId)) {
						Service.CreatePublisher(pubId, pubName, pubAddress, list);
					}
					else {
						System.out.println("Please input an Integer");
						Thread.sleep(1000);
						return;
					}
					break;
				case "3":
					 System.out.println("Publisher ID\t"+"Publisher Name\t"+"Publisher Address");
					for(Publisher p : list)
			           {
			               System.out.println(p.getPublisherId()+"\t\t"+p.getPublisherName()+"\t\t"
			            		   +p.getPublisherAddress());
			           }
					System.out.println("What is the ID of the Publisher that you want to edit?\n");
					pubId = input.nextLine();
					System.out.println("What is the updated name for the Publisher? Enter N/A for no changes\n");
					pubName = input.nextLine();
					System.out.println("What is the updated address for the Publisher? Enter N/A for no changes\n");
					pubAddress = input.nextLine();
					Service.UpdatePublisher(pubId, pubName, pubAddress, list);
					break;
				case "4":
					System.out.println("Publisher ID\t"+"Publisher Name\t"+"Publisher Address");
					for(Publisher p : list)
			           {
			               System.out.println(p.getPublisherId()+"\t\t"+p.getPublisherName()+"\t\t"
			            		   +p.getPublisherAddress());
			           }
					System.out.println("What is the ID of the Publisher to delete?\n");
					pubId = input.nextLine();
					if(isInteger(pubId)) {
						Service.DeletePublisher(pubId, list, DaoBook.readBook());
					}
					else {
						System.out.println("Please input an Integer");
						Thread.sleep(1000);
						return;
					}
					break;
				case "5":
					return;
				default:
					clrscr();
					System.out.println("Invalid choice, please try again\n");
					Thread.sleep(1000);
					break;
				}
			}
		}
		
			public static void BookMenu() throws IOException, InterruptedException {
				String bookName, bookId, authId, pubId;
				List<Book> list = null;
				while(choice!="5") {
					list = null;
					list = DaoBook.readBook();
					clrscr();
					System.out.println("\nWelcome to the Book Menu\n");
					System.out.println("-------------------------------------------\n");
					System.out.println("1- View all records");
					System.out.println("2- Create a record");
					System.out.println("3- Update a record");
					System.out.println("4- Delete a record");
					System.out.println("5- Exit to previous menu");
					System.out.println("Enter your selection(1-4):- \n");
					
					choice = input.nextLine();
					switch(choice)
					{
					case "1":
						System.out.println("Book ID"+"Book Name\t"+"Author ID\t"+"Publisher ID");
						for(Book b : list)
				           {
				               System.out.println(b.getBookId()+"\t\t"+b.getBookTitle()+"\t\t"
				           +b.getAuthorId()+"\t\t"+b.getPublisherId());
				           }
						choice = input.nextLine();
						break;
					case "2":
						System.out.println("What is the ID for the Book?\n");
						bookId = input.nextLine();
						System.out.println("What is the name for the Book?\n");
						bookName = input.nextLine();
						System.out.println("What is the Author ID for the Book?\n");
						authId = input.nextLine();
						System.out.println("What is the Publisher ID for the Book?\n");
						pubId = input.nextLine();
						//if(isInteger(pubId)) {
							Service.CreateBook(bookName, bookId, authId, pubId,list,
									DaoAuthor.readAuthor(),DaoPublisher.readPublisher());
//						}
//						else {
//							System.out.println("Please input an Integer");
//							Thread.sleep(1000);
//							return;
//						}
						break;
					case "3":
						System.out.println("Book ID\t"+"Book Name\t"+"Author ID\t"+"Publisher ID");
						for(Book b : list)
				           {
				               System.out.println(b.getBookId()+"\t\t"+b.getBookTitle()+"\t\t"+b.getAuthorId()+"\t\t"+b.getPublisherId());
				           }
						System.out.println("What is the ID of the Book to edit?");
						bookId = input.nextLine();
						System.out.println("What is the updated title for the Book?");
						bookName = input.nextLine();
						if(isInteger(bookId)) {
							Service.UpdateBook(bookId, bookName, list);
						}
						else {
							System.out.println("Please input an Integer");
							Thread.sleep(1000);
							return;
						}
						break;
					case "4":
						System.out.println("Book ID\t"+"Book Name\t"+"Author ID\t"+"Publisher ID");
						for(Book b : list)
				           {
				               System.out.println(b.getBookId()+"\t\t"+b.getBookTitle()+"\t\t");
				           }
						System.out.println("What is the ID of the Book to delete?");
						bookId = input.nextLine();
						if(isInteger(bookId)) { //isInteger
							Service.DeleteBook(bookId, list);
						}
						else {
							System.out.println("Please input an Integer");
							Thread.sleep(1000);
							return;
						}
						break;
					case "5":
						return;
					default:
						System.out.println("Invalid choice, please try again\n");
						Thread.sleep(1000);
						break;
					}
				}
			}
	
	public static void main(String[] args) throws IOException, InterruptedException {

		do
		{
			clrscr();
		//-------------------------INTERFACE------------------------------------------------
		System.out.println("--------------------------------------------------------------");
		System.out.println("\tWelcome to the Library Management System");
		System.out.println("--------------------------------------------------------------\n");
		System.out.println("What would you like to access?\n");
		System.out.println("1-Author");
		System.out.println("2-Publisher");
		System.out.println("3-Book");
		System.out.println("4-Exit\n");
		System.out.println("Enter your selection(1-4):- \n");
		
		choice = input.nextLine();
			//switch statement
			switch(choice)
			{
				case "1":
					AuthorMenu();
					break;
				case "2":
					PublisherMenu();
					break;
				case "3":
					BookMenu();
					break;
				case "4":
					return;
				default:
					System.out.println("Invalid choice, please try again.....\n");
					Thread.sleep(1250);
					break;
			}
		
		}while(choice!="4");
	}
	
}

