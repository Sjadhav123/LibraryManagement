package com.silicus.librarymanagement.util;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedHashSet;
import java.util.Scanner;

import com.silicus.librarymanagement.ServiceImplementation.BookIssueTrackerServiceImpl;
import com.silicus.librarymanagement.ServiceImplementation.BookReturnTrackerServiceImpl;
import com.silicus.librarymanagement.ServiceImplementation.BookServiceImpl;
import com.silicus.librarymanagement.ServiceImplementation.UserServiceImpl;
import com.silicus.librarymanagment.entity.Book;
import com.silicus.librarymanagment.entity.BookIssueTracker;
import com.silicus.librarymanagment.entity.BookReturnTracker;
import com.silicus.librarymanagment.entity.User;

public class MainClass {

	private static final boolean Yes = false;

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		LinkedHashSet<Book> bookset = new LinkedHashSet<>();

		LinkedHashSet<BookIssueTracker>issueTrackerSet=new LinkedHashSet<>();

		LinkedHashSet<BookReturnTracker> bookReturnset = new LinkedHashSet<BookReturnTracker>();
		

		boolean nextCheck = false;
		do {
			System.out.println("Library management details");
			System.out.println("please select entity to be manipulated");
			System.out.println("1 BOOK 2 BookIssueTracker 3 BookReturnTracker 4 Role 5 User");
			Scanner sc = new Scanner(System.in);
			int mainMenu = sc.nextInt();

			boolean readmoreinput = MainClass.Yes;
			BookServiceImpl<Book> bookServiceImpl = new BookServiceImpl<Book>();

	        BookReturnTrackerServiceImpl<BookReturnTracker> bkReturn=new BookReturnTrackerServiceImpl<BookReturnTracker>();
	        BookIssueTrackerServiceImpl<BookIssueTracker> issueTrackerServiceImpl=new BookIssueTrackerServiceImpl<BookIssueTracker>();


			switch (mainMenu) {
			case 1:
				System.out.println("1 Insert 2 Read 3 Update 4 Delete 5 Exit");
				int nextOperation = sc.nextInt();
				switch (nextOperation) {
				// Insert Operation
				case 1:
					do {
						Book book = new Book();
						System.out.println("Enter the id of book:");
						int id = sc.nextInt();
						sc.nextLine();
						System.out.println("Enter the name of book:");
						String name = sc.next();
						sc.nextLine();

						System.out.println("Enter the author of book:");
						String author = sc.next();
						sc.nextLine();
						System.out.println("Enter the ISBN  of book:");
						String isbn = sc.next();

						System.out.println("Enter the rackname of book:");
						String rackName = sc.next();

						System.out.println("Enter the availability flag:");
						boolean isAvailable = sc.hasNext();

						book.setAuthor(author);
						book.setAvailable(isAvailable);
						book.setId(id);
						book.setISBN(isbn);
						book.setName(name);
						book.setRackName(rackName);

						 
						bookset.add(book);
						bookServiceImpl.insert(bookset);
						System.out.println("Size of bookset is:" + bookset.size());
						sc.nextLine();
						System.out.println("Do you want to add more books? Yes/No");
						sc.nextLine();
						readmoreinput = sc.nextBoolean();
					} while (readmoreinput);
					
					// System.out.println("size of bookset while passing it to
					// writeFile :" + bookset.size());
					// readFromFile();
					nextCheck = true;
					bookset = new LinkedHashSet<>();
					break;

				// Read Operation
				case 2:
					bookServiceImpl.findAll();
					nextCheck = true;
					break;
				// UPdate Book Operation
				case 3:
					System.out.println("Enter the book id to update the book:");
					int id=sc.nextInt();
					bookServiceImpl.update(id);
					nextCheck = true;
					break;

				case 4:
					System.out.println("Enter the book id to update the book:");
					int bookId=sc.nextInt();
					bookServiceImpl.delete((long) bookId);
					nextCheck = true;
					break;

				case 5:
					nextCheck = false;
					break;

				default:
					break;
				} // Child Switch closed

				break; // Breaking Book Case
				

			/* Book Issue Tracker Operations */
			case 2:
				System.out.println("1 Insert 2 Read 3 Update 4 Delete 5 Exit");
				int bookIssueOperation = sc.nextInt();
				switch (bookIssueOperation) {
				// Insert Operation
				case 1:
					do {
						BookIssueTracker bookIssueTracker = new BookIssueTracker();
						System.out.println("Enter the id for IssueTracker Object:");
						int id = sc.nextInt();
						sc.nextLine();
						System.out.println("Enter the bid of book:");
						int bookId = sc.nextInt();
						sc.nextLine();

						Book book = (Book) bookServiceImpl.findById(bookId);
						System.out.println("Enter the User id to enter in IssueTracker:");
						int userId = sc.nextInt();
						sc.nextLine();
						UserServiceImpl<User>userServiceImpl=new UserServiceImpl<>();
					     User user = (User) userServiceImpl.findById(userId);
						
						System.out.println("Enter the dateOfIssue  of book:");
						String dateOfIssue = sc.next();

						System.out.println("Enter the expDate of book:");
						String expDate = sc.next();

						 System.out.println("Enter the issuer name:");
						  String issuer = sc.next();

						  bookIssueTracker.setId(id);;
						  bookIssueTracker.setBook(book);
						  bookIssueTracker.setDateOfIssue(dateOfIssue);
						  bookIssueTracker.setExpDate(expDate);
						  bookIssueTracker.setUser(user);
						  bookIssueTracker.setIssuer(issuer);
						  
						  issueTrackerSet.add(bookIssueTracker);
						  
					      issueTrackerServiceImpl.insert(issueTrackerSet);
						
						System.out.println("Size of bookIssueRecords is:" + issueTrackerSet.size());
						sc.nextLine();
						System.out.println("Do you want to add more bookIusse Records? Yes/No");
						readmoreinput = sc.nextBoolean();
					} while (readmoreinput);
					
					nextCheck = true;
					bookset = new LinkedHashSet<>();
					break;

					// Read Operation
					case 2:
					    issueTrackerServiceImpl.findAll();
						nextCheck = true;
						break;
					// UPdate Book Operation
					case 3:
						System.out.println("Enter the book id to update the book:");
						int id=sc.nextInt();
						issueTrackerServiceImpl.update(id);
						nextCheck = true;
						break;

					case 4:
						System.out.println("Enter the book id to update the book:");
						int bookId=sc.nextInt();
						issueTrackerServiceImpl.delete((long) bookId);
						nextCheck = true;
						break;

					case 5:
						nextCheck = false;
						break;

					default:
						break;
					} // Child Switch closed

					break; // Breaking Book Case
					

				

/******** Book Issue Tracker service ends here********/

/*******Book return tracker Service starts here**********/			
				
					case 3:
						
						BookReturnTracker bkreturn=new BookReturnTracker();
						System.out.println("1 Insert 2 Read 3 Update 4 Delete 5 Exit");
						int bookReturnOperation = sc.nextInt();
						switch (bookReturnOperation ) {
						// Insert Operation
						case 1:
							do {
								
								System.out.println("Enter the Return id :");
								int returnId = sc.nextInt();
								sc.nextLine();
								
								System.out.println("Enter the book issue ID:");
								int bookIssueId= sc.nextInt();
								sc.nextLine();
		                             
								System.out.println("Enter the book return Date in (YYYY-MM-DD): Format");
								String dateOfReturn= sc.next();
								sc.nextLine();
				
							    //Calculate the fine using date differance between DOI and DOR  
							    long fineCalculation = TempUserDetails.fineCalculation(dateOfReturn);
								
								System.out.println("Enter the User id:");
							    int Userid= sc.nextInt();
							    User userDetails=TempUserDetails.getUser(Userid);
							    //UserServiceImpl<User>userServiceImpl=new UserServiceImpl<>();
							    //User user = (User) userServiceImpl.findById(userId);
								
							    
							    bkreturn.setId(returnId);
							    bkreturn.setIssueId(bookIssueId);
							    bkreturn.setReturnDate(dateOfReturn);
							    bkreturn.setFineAmount(fineCalculation);
							    bkreturn.setReceiver(userDetails);
							    
							    bookReturnset.add(bkreturn);

							    bkReturn.insert(bookReturnset);
							    System.out.println("insert commited");
							    
								System.out.println("Size of bookset is:" + bookReturnset.size());
								sc.nextLine();
								System.out.println("Do you want to add more books? Yes/No");
								readmoreinput = sc.nextBoolean();
							} while (readmoreinput);
						    // writing Bookreturn tracker object to file named
						
							nextCheck = true;
							bookReturnset = new LinkedHashSet<>();
							break;

						// Read Operation
						case 2:
					    //find all records in BookReturnTracker
							bkReturn.findAll();
							nextCheck = true;
							break;
						// Update BookReturnTracker Record
						case 3:
							System.out.println("Enter the book Return id to be updated:");
							int id = sc.nextInt();
							bkReturn.update(id);
							nextCheck = true;
							break;
		                //Delete The BookReturn tracker Record 
						case 4:
							System.out.println("Enter the book Return id to be deleted:");
						    id = sc.nextInt();
						    bkReturn.delete((long) id);
							nextCheck = true;
							break;


						default:
							break;
						} // Child Switch closed

						break;

//**************Book return tracker operation ends here
				
			}// parent Switch Menu

		} while (nextCheck);// Parent do while loop

		}
	}
