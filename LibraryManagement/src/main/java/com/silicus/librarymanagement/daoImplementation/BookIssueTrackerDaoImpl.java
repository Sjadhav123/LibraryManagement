package com.silicus.librarymanagement.daoImplementation;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import com.silicus.librarymanagement.dao.BookIssueTrackerDao;
import com.silicus.librarymanagement.util.Utilities;
import com.silicus.librarymanagment.entity.BookIssueTracker;

public class BookIssueTrackerDaoImpl<T> implements BookIssueTrackerDao<T> {


	
	private Set<BookIssueTracker> bookIssueTrackerset = new LinkedHashSet<>();
	Utilities utilities = new Utilities();

	
	@Override
	public T update(int id) throws FileNotFoundException, IOException {


		LinkedHashSet<BookIssueTracker> bookIssueTrackerSet = null;
		try {
			bookIssueTrackerSet = getExistingObjects();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for ( BookIssueTracker bookIssueObj : bookIssueTrackerSet) {
			if (bookIssueObj.getId() == id) {
				bookIssueObj.setIssuer("New Issuer");
				bookIssueObj.setExpDate("31-10-2019");
				bookIssueTrackerSet.add(bookIssueObj);
				break;
			}
		}
		

		String bookIssueRecordsFilePath = utilities.getFilePath("bookIssue");
		File file = new File(bookIssueRecordsFilePath);
		FileOutputStream outputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		objectOutputStream.writeObject(bookIssueTrackerset);
		System.out.println("BookSet after update and write Operation:" + bookIssueTrackerSet.toString());
		return (T) bookIssueTrackerSet;
	}

	
	@Override
	public Collection<T> findAll() throws ClassNotFoundException, IOException {
		LinkedHashSet<BookIssueTracker> issueTrackerSet = getExistingObjects();
		return (Collection<T>) issueTrackerSet;
	}

	
		@Override
		public boolean delete(Long id) throws IOException {

			LinkedHashSet<BookIssueTracker> bookIssueTrackerSet = null;
			try {
				bookIssueTrackerSet = getExistingObjects();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			for (BookIssueTracker book : bookIssueTrackerSet) {
				if (book.getId() == id) {
					bookIssueTrackerSet.remove(book);
					System.out.println("Book successfully deleted");
					break;
				}
			}
			System.out.println("Bookset after deletion:" + bookIssueTrackerSet.size());

			String bookIssueRecordsFilePath = utilities.getFilePath("bookIssue");
			File file = new File(bookIssueRecordsFilePath);
			FileOutputStream outputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(bookIssueTrackerSet);

			return false;
	

	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	
	/*****************************Write BookIssueTracker Objects**********************/
	@Override
	public void insert(Collection<T> t) throws IOException, FileNotFoundException, ClassNotFoundException {
			
		
		System.out.println("IN INSERT ::::::bookIssue Records AFTER UPDATE OPERATION" + t.toString());
		String bookIssueRecordsFilePath = utilities.getFilePath("bookIssue");
		File file = new File(bookIssueRecordsFilePath);
		LinkedHashSet<BookIssueTracker> existingHashset = getExistingObjects();
		FileOutputStream outputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		System.out.println("new bookIssue Records" + t.size());
		bookIssueTrackerset = (Set<BookIssueTracker>) t;
		System.out.println("BookIssue Records After update operation in insert:" + bookIssueTrackerset.toString());
		if (existingHashset != null) {
			System.out.println("existing bookIssue Records Size:" + existingHashset.size());
			System.out.println("existing bookIssue Records:" + existingHashset.toString());
			existingHashset.addAll(bookIssueTrackerset);
			System.out.println(
					"BookIssue Records After adding  bookIssue Records to existing hashset in insert:" + existingHashset.toString());

		} else {
			System.out.println("existing bookIssue Records:" + 0);
			existingHashset = (LinkedHashSet<BookIssueTracker>) t;
		}
		System.out.println("Updated bookIssue Records to write to file:");
		objectOutputStream.writeObject(existingHashset);
		objectOutputStream.close();
		System.out.println("Objects have been successfully written to file");
		System.out.println("TotalbookIssue Records:" + existingHashset.size());
		System.out.println("TotalbookIssue are:" + getExistingObjects());
	
	}

	
	
    // **************		Read All BookIssueTracker Records.
	public LinkedHashSet<BookIssueTracker> getExistingObjects() throws IOException, ClassNotFoundException {
		LinkedHashSet<BookIssueTracker> bookIssueTrackerset = null;
		ObjectInputStream input = null;
		String bookIssueRecordsFilePath = utilities.getFilePath("bookIssue");
		File file = new File(bookIssueRecordsFilePath);
		try {

			if (file.exists()) {
				FileInputStream fis = new FileInputStream(file);

				input = new ObjectInputStream(fis);
				bookIssueTrackerset = (LinkedHashSet<BookIssueTracker>) input.readObject();
			}
		} catch (EOFException e) {
			e.printStackTrace();
		} finally {
			if (file.exists()) {
				input.close();
			}
		}
		System.out.println("All bookIssueRecords:" + bookIssueTrackerset);
		return bookIssueTrackerset;

	}

}
