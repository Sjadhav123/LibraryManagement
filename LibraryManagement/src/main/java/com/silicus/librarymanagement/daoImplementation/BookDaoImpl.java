package com.silicus.librarymanagement.daoImplementation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import com.silicus.librarymanagement.dao.BookDao;
import com.silicus.librarymanagment.entity.Book;

public class BookDaoImpl<T> implements BookDao<T> {

	@Override
	public Set<T> findAll() throws IllegalStateException, IllegalArgumentException {
		HashSet<Book> hsOutput = new LinkedHashSet<Book>();
		try {
			FileInputStream fileInputStream = new FileInputStream("D:\\\\FileOperationsPractice.txt");
			ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
			hsOutput = (LinkedHashSet<Book>) inputStream.readObject();
			System.out.println(hsOutput.toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return (Set<T>) hsOutput;

	}

	@Override
	public T update(int id) {
		HashSet<Book> bookset = (HashSet<Book>)findAll();
        Book bookObject = null;
		
		for(Book book:bookset) {
			if(book.getId()==id) {
				bookObject=book;
				break;
			}
		}
		
        bookObject.setId(1);
		bookObject.setAuthor("newAuthorname");
		bookObject.setAvailable(Boolean.FALSE);
		bookObject.setName("Durga Book");
		bookObject.setISBN("qqqq222");
		bookObject.setName("UpdatedBookName");
		bookObject.setRackName("aa22");
		bookset.add(bookObject);
		try {
			FileOutputStream outputStream = new FileOutputStream("D:\\FileOperationsPractice.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(bookset);
			objectOutputStream.close();
			System.out.println("Object have been successfully updated to file");
		} catch (FileNotFoundException fne) {
			System.out.println(fne);
		} catch (IOException ioe) {
			System.out.println(ioe);
		}

		return null;

	}

	@Override
	public void insert() {
		Book book1 = new Book();
		book1.setAuthor("Sachin Jadhav");
		book1.setAvailable(Boolean.TRUE);
		book1.setISBN("abcd1234");
		book1.setName("Basic Java Concepts");
		book1.setRackName("A1");
		book1.setId(1);

		Book book2 = new Book();
		book2.setAuthor("Sagar Sarawade");
		book2.setAvailable(Boolean.TRUE);
		book2.setISBN("abcd12345");
		book2.setName("Head First Java");
		book2.setRackName("A2");
		book2.setId(2);

		HashSet<Book> hs = new LinkedHashSet<Book>();
		hs.add(book1);
		hs.add(book2);

		try {
			FileOutputStream outputStream = new FileOutputStream("D:\\FileOperationsPractice.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(hs);
			objectOutputStream.close();
			System.out.println("Objects have been successfully written to file");
		} catch (FileNotFoundException fne) {
			System.out.println(fne);
		} catch (IOException ioe) {
			System.out.println(ioe);
		}

	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object findById(int id) {
		
		Book returnBook=null;
		HashSet<Book> hsOutput = new LinkedHashSet<Book>();
		try {
			FileInputStream fileInputStream = new FileInputStream("D:\\\\FileOperationsPractice.txt");
			ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
			hsOutput = (LinkedHashSet<Book>) inputStream.readObject();
			
			for(Book book:hsOutput) {
				if(book.getId()==id) {
					returnBook=book;
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

}
