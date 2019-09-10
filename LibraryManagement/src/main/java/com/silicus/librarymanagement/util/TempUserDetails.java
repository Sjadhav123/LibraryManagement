package com.silicus.librarymanagement.util;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

import com.silicus.librarymanagment.entity.Book;
import com.silicus.librarymanagment.entity.BookReturnTracker;
import com.silicus.librarymanagment.entity.User;

public class TempUserDetails {

	
	public static void main(String[] args) {

	}
	
	
	public static HashSet<User> getListOfUsers()
	{
		
		User as1=new User();
		as1.setEmail("user1@gmail.com");
		as1.setId(111);
		as1.setName("user1");
		as1.setPhoneNumber("1111111111");
		as1.setRoleId("01");

		
		User as2=new User();
		as2.setEmail("user2@gmail.com");
		as2.setId(222);
		as2.setName("user2");
		as2.setPhoneNumber("2222222222");
		as2.setRoleId("01");

		User as3=new User();
		as3.setEmail("user3@gmail.com");
		as3.setId(333);
		as3.setName("user3");
		as3.setPhoneNumber("3333333333");
		as3.setRoleId("02");

		User as4=new User();
		as3.setEmail("user4@gmail.com");
		as3.setId(444);
		as3.setName("user4");
		as3.setPhoneNumber("4444444444");
		as3.setRoleId("03");

		User as5=new User();
		as3.setEmail("user5@gmail.com");
		as3.setId(555);
		as3.setName("user5");
		as3.setPhoneNumber("5555555555");
		as3.setRoleId("04");

		
		 HashSet<User> as=new HashSet<User>();
         as.add(as1);
         as.add(as2);
         as.add(as3);
         as.add(as4);
         as.add(as5);

         
		return as;
		
	}
	
	
	
	
	
// to write the Bookreturn tracker objects to file

	public static void writeToFile(LinkedHashSet<BookReturnTracker> bookset) throws IOException, ClassNotFoundException {
		File file = new File("D:\\FileOperationsReturnTracker.txt");
		LinkedHashSet<BookReturnTracker> existingHashset = getExistingObjects();
		FileOutputStream outputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		System.out.println("new books" + bookset.size());
		if (existingHashset != null) {
			System.out.println("existing books:" + existingHashset.size());
			existingHashset.addAll(bookset);

		} else {
			System.out.println("existing books:" + 0);
			existingHashset = bookset;
		}
		System.out.println("Updated Bookset to write to file:");
		objectOutputStream.writeObject(existingHashset);
		objectOutputStream.close();
		System.out.println("Objects have been successfully written to file");
		System.out.println("Total books:" + existingHashset.size());
		System.out.println("Total books are:" + getExistingObjects());
		// return existingHashset;
	}



// get existing objects i.e. updated objects from list
	
	public  static LinkedHashSet<BookReturnTracker> getExistingObjects() throws IOException, ClassNotFoundException {
		LinkedHashSet<BookReturnTracker> bookReturnTracker = null;
		ObjectInputStream input = null;
		File file = new File("D:\\FileOperationsReturnTracker.txt");
		try {

			if (file.exists()) {
				FileInputStream fis = new FileInputStream(file);
				
				input = new ObjectInputStream(fis);
				bookReturnTracker = (LinkedHashSet<BookReturnTracker>) input.readObject();
			}
		} catch (EOFException e) {
			e.printStackTrace();
		} finally {
			if (file.exists()) {
				input.close();
			}
		}
		System.out.println("Book size"+bookReturnTracker.size());
		System.out.println("All books:" + bookReturnTracker);
		return bookReturnTracker;

	}

	
	
	
	
	

	
	
	// update the book return tracker for time being
	public  static void updateBook() throws ClassNotFoundException, IOException {

		System.out.println("Enter book return id to update the bookreturn status:");
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();
		LinkedHashSet<BookReturnTracker> bookReturnTracker = null;
		try {
			bookReturnTracker = getExistingObjects();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (BookReturnTracker book : bookReturnTracker) {
			if (book.getId() == id) {
				book.setFineAmount(90000);
				bookReturnTracker.add(book);
				break;
			}
		}
        
		System.out.println("After updation of BookReturn Tracker"+bookReturnTracker.toString());
		writeToFile(bookReturnTracker);

	}



	// delete the record from bookreturn tracker
	public  static void deleteBook() throws ClassNotFoundException, IOException {

		System.out.println("Enter book return id to delete the book from Bookreturn tracker:");
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();
		LinkedHashSet<BookReturnTracker> bookReturnTracker = null;
		try {
			bookReturnTracker = getExistingObjects();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (BookReturnTracker book : bookReturnTracker) {
			if (book.getId() == id) {
				bookReturnTracker.remove(book);
				System.out.println("Book successfully deleted");
				break;
			}
		}
		
		System.out.println("Bookset after deletion:" + bookReturnTracker.size());
     	System.out.println("Record in bookset after deletion="+bookReturnTracker.toString());
	
		File file = new File("D:\\FileOperationsReturnTracker.txt");
		FileOutputStream outputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		objectOutputStream.writeObject(bookReturnTracker);

	}

	
// to get all list of Available Users******************************************//

	public static User getUser(int id) {
		User defaultUSer=new User();
		
		HashSet<User> listOfUsers = TempUserDetails.getListOfUsers();
		     for (User user : listOfUsers) {    	
		        	  if(user.getId()==id) {
		        		 return user;
		        	  }
				}	         
		         defaultUSer.setId(id);
		         defaultUSer.setEmail("defaultUser@gmail.com");
		         defaultUSer.setName("default user");
		         defaultUSer.setPhoneNumber("7777777777");
		         defaultUSer.setRoleId("09");
		         System.out.println("default user returned");
		         return defaultUSer;
		         
	}
	// to get all list of Available Users******************************************//










}
