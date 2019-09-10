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

import com.silicus.librarymanagement.ServiceImplementation.BookReturnTrackerServiceImpl;
import com.silicus.librarymanagement.ServiceImplementation.BookServiceImpl;
import com.silicus.librarymanagment.entity.Book;
import com.silicus.librarymanagment.entity.BookReturnTracker;
import com.silicus.librarymanagment.entity.User;

public class MainClass {

	private static final boolean Yes = false;

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		LinkedHashSet<Book> bookset = new LinkedHashSet<>();
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

						// Book addedBook = bookServiceImpl.insert(book);
						bookset.add(book);
						System.out.println("Size of bookset is:" + bookset.size());
						sc.nextLine();
						System.out.println("Do you want to add more books? Yes/No");
						sc.nextLine();
						readmoreinput = sc.nextBoolean();
					} while (readmoreinput);
					writeToFile(bookset);
					// System.out.println("size of bookset while passing it to
					// writeFile :" + bookset.size());
					// readFromFile();
					nextCheck = true;
					bookset = new LinkedHashSet<>();
					break;

				// Read Operation
				case 2:
					getExistingObjects();
					nextCheck = false;
					break;
				// UPdate Book Operation
				case 3:
					updateBook();
					nextCheck = false;
					break;

				case 4:
					deleteBook();
					nextCheck = false;
					break;

				case 5:
					nextCheck = true;
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

						// Book addedBook = bookServiceImpl.insert(book);
						bookset.add(book);
						System.out.println("Size of bookset is:" + bookset.size());
						sc.nextLine();
						System.out.println("Do you want to add more books? Yes/No");
						sc.nextLine();
						readmoreinput = sc.nextBoolean();
					} while (readmoreinput);
					writeToFile(bookset);
					// System.out.println("size of bookset while passing it to
					// writeFile :" + bookset.size());
					// readFromFile();
					nextCheck = true;
					bookset = new LinkedHashSet<>();
					break;

				// Read Operation
				case 2:
					getExistingObjects();
					nextCheck = true;
					break;
				// UPdate Book Operation
				case 3:
					updateBook();
					nextCheck = true;
					break;

				case 4:
					deleteBook();
					nextCheck = true;
					break;

				default:
					break;
				} // Child Switch closed

				break;

// *******Book return tracker Service starts here**********//			
				
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
							    int id= sc.nextInt();
							    User userDetails=TempUserDetails.getUser(id);
							    
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

	
	
	
	private static void writeToFile(LinkedHashSet<Book> bookset) throws IOException, ClassNotFoundException {
		File file = new File("D:\\FileOperationsPractice123.txt");
		LinkedHashSet<Book> existingHashset = getExistingObjects();
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

	private static LinkedHashSet<Book> getExistingObjects() throws IOException, ClassNotFoundException {
		LinkedHashSet<Book> bookset = null;
		ObjectInputStream input = null;
		File file = new File("D:\\FileOperationsPractice123.txt");
		try {

			if (file.exists()) {
				FileInputStream fis = new FileInputStream(file);

				input = new ObjectInputStream(fis);
				bookset = (LinkedHashSet<Book>) input.readObject();
			}
		} catch (EOFException e) {
			e.printStackTrace();
		} finally {
			if (file.exists()) {
				input.close();
			}
		}
		System.out.println("All books:" + bookset);
		return bookset;

	}

	private static void updateBook() throws ClassNotFoundException, IOException {

		System.out.println("Enter book id to update the book:");
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();
		LinkedHashSet<Book> bookSet = null;
		try {
			bookSet = getExistingObjects();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Book book : bookSet) {
			if (book.getId() == id) {
				book.setName("updatedBookName");
				book.setAuthor("updateBookAuthor");
				bookSet.add(book);
				break;
			}
		}

		writeToFile(bookSet);


	}
	
	

	private static void deleteBook() throws ClassNotFoundException, IOException {

		System.out.println("Enter book id to delete the book from bookset:");
		Scanner scanner = new Scanner(System.in);
		int id = scanner.nextInt();
		LinkedHashSet<Book> bookSet = null;
		try {
			bookSet = getExistingObjects();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (Book book : bookSet) {
			if (book.getId() == id) {
				bookSet.remove(book);
				System.out.println("Book successfully deleted");
				break;
			}
		}
		System.out.println("Bookset after deletion:" + bookSet.size());
		
		File file = new File("D:\\FileOperationsPractice123.txt");
		FileOutputStream outputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		objectOutputStream.writeObject(bookSet);

	}
}
