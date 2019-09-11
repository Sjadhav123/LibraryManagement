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

import com.silicus.librarymanagement.dao.BookReturnDao;
import com.silicus.librarymanagment.entity.BookReturnTracker;

public class BookReturnDaoImpl<T> implements BookReturnDao<T> {
	
	private Set<BookReturnTracker> bookset = new LinkedHashSet<BookReturnTracker>();

	
	
	@Override
	public T update(int id) throws FileNotFoundException, ClassNotFoundException, IOException {

		LinkedHashSet<BookReturnTracker> bookSet = null;
		try {
			bookSet = getExistingObjects();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (BookReturnTracker book : bookSet) {
			if (book.getId() == id) {
				book.setFineAmount(90000);
				break;
			}
		}
		System.out.println("BookReturnSet  after update Operation:" + bookSet.toString());
		//insert((Collection<T>) bookSet);
		
		
		File file = new File("D:\\FileOperationsReturnTracker.txt");
		FileOutputStream outputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		objectOutputStream.writeObject(bookSet);
     
        return null;
	}


	@Override
	public Set<T> findAll()
			throws IllegalStateException, IllegalArgumentException, ClassNotFoundException, IOException {
		LinkedHashSet<BookReturnTracker> allBooks = getExistingObjects();
		return (Set<T>) allBooks;

	}

	@Override
	public boolean delete(Long id) throws IOException {

		LinkedHashSet<BookReturnTracker> bookSet = null;
		try {
			bookSet = getExistingObjects();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (BookReturnTracker book : bookSet) {
			if (book.getId() == id) {
				bookSet.remove(book);
				System.out.println("BookReturn Record  successfully deleted");
				break;
			}
		}
		System.out.println("BookReturnSet  after deletion:" + bookSet.size());
		File file = new File("D:\\FileOperationsReturnTracker.txt");
		FileOutputStream outputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		objectOutputStream.writeObject(bookSet);

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

	
	
	
	@Override
	public void insert(Collection<T> t) throws IOException, FileNotFoundException, ClassNotFoundException {
		
		File file = new File("D:\\FileOperationsReturnTracker.txt");
		LinkedHashSet<BookReturnTracker> existingHashset = getExistingObjects();
		FileOutputStream outputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		System.out.println("new BookReturnTracker Record" + t.size());
		bookset = (Set<BookReturnTracker>) t;
//		System.out.println("BookReturnSet  After update operation in insert:" + bookset.toString());
		
		if (existingHashset != null) {
			System.out.println("existing BookReturnSet :" + existingHashset.size());
			System.out.println("existing BookReturnSet :" + existingHashset.toString());
			existingHashset.addAll(bookset);
			System.out.println("Bookset After adding BookReturnSet  to existing hashset in insert:" + existingHashset.toString());

		} else {
			System.out.println("existing Records:" + 0);
			existingHashset = (LinkedHashSet<BookReturnTracker>) t;
		}
		System.out.println("Updated BookReturnSet  to write to file:");
		objectOutputStream.writeObject(existingHashset);
		objectOutputStream.close();
        System.out.println("Objects have been successfully written to file");
		System.out.println("Total books:" +     existingHashset.size());
		System.out.println("After insert operation Total books are:" + getExistingObjects());

	}

	
	
	public LinkedHashSet<BookReturnTracker> getExistingObjects() throws IOException, ClassNotFoundException {
		LinkedHashSet<BookReturnTracker> bookset = null;
		ObjectInputStream input = null;
		File file = new File("D:\\FileOperationsReturnTracker.txt");
		try {

			if (file.exists()) {
				FileInputStream fis = new FileInputStream(file);
				
				input = new ObjectInputStream(fis);
				bookset = (LinkedHashSet<BookReturnTracker>) input.readObject();
			}
		} catch (EOFException e) {
			e.printStackTrace();
		} finally {
			if (file.exists()) {
				input.close();
			}
		}
		System.out.println(" All books:" + bookset);
		return bookset;
		
	}

}