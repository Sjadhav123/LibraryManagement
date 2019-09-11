package com.silicus.librarymanagement.daoImplementation;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

import com.silicus.librarymanagement.dao.BookDao;
import com.silicus.librarymanagement.util.Utilities;
import com.silicus.librarymanagment.entity.Book;

public class BookDaoImpl<T> implements BookDao<T> {

	private Set<Book> bookset = new LinkedHashSet<>();
	Utilities utilities = new Utilities();

	public BookDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<T> findAll()
			throws IllegalStateException, IllegalArgumentException, ClassNotFoundException, IOException {
		LinkedHashSet<Book> allBooks = getExistingObjects();
		return (Set<T>) allBooks;

	}

	@Override
	public T update(int id) throws FileNotFoundException, ClassNotFoundException, IOException {

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

		String bookFilePath = utilities.getFilePath();
		File file = new File(bookFilePath);
		FileOutputStream outputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		objectOutputStream.writeObject(bookSet);
		System.out.println("BookSet after update and write Operation:" + bookSet.toString());
		return null;
	}

	@Override
	public boolean delete(Long id) throws IOException {

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
		String bookFilePath = utilities.getFilePath();
		File file = new File(bookFilePath);
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
	public Object findById(int id) {

		Book returnBook = null;
		HashSet<Book> hsOutput = new LinkedHashSet<Book>();
		try {
			String bookFilePath = utilities.getFilePath();
			File file = new File(bookFilePath);
			FileInputStream fileInputStream = new FileInputStream(file);
			ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
			hsOutput = (LinkedHashSet<Book>) inputStream.readObject();

			for (Book book : hsOutput) {
				if (book.getId() == id) {
					returnBook = book;
					break;
				}
			}

		} catch (Exception e) {

		}

		return returnBook;
	}

	@Override
	public T findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Collection<T> t) throws IOException, FileNotFoundException, ClassNotFoundException {
		System.out.println("IN INSERT :::::::::BOOKSET AFTER UPDATE OPERATION" + t.toString());
		String bookFilePath = utilities.getFilePath();
		File file = new File(bookFilePath);
		LinkedHashSet<Book> existingHashset = getExistingObjects();
		FileOutputStream outputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		System.out.println("new books" + t.size());
		bookset = (Set<Book>) t;
		System.out.println("Bookset After update operation in insert:" + bookset.toString());
		if (existingHashset != null) {
			System.out.println("existing books:" + existingHashset.size());
			System.out.println("existing books:" + existingHashset.toString());
			existingHashset.addAll(bookset);
			System.out.println(
					"Bookset After adding bookset to existing hashset in insert:" + existingHashset.toString());

		} else {
			System.out.println("existing books:" + 0);
			existingHashset = (LinkedHashSet<Book>) t;
		}
		System.out.println("Updated Bookset to write to file:");
		objectOutputStream.writeObject(existingHashset);
		objectOutputStream.close();
		System.out.println("Objects have been successfully written to file");
		System.out.println("Total books:" + existingHashset.size());
		System.out.println("Total books are:" + getExistingObjects());

	}

	public LinkedHashSet<Book> getExistingObjects() throws IOException, ClassNotFoundException {
		LinkedHashSet<Book> bookset = null;
		ObjectInputStream input = null;
		String bookFilePath = utilities.getFilePath();
		File file = new File(bookFilePath);
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

}
