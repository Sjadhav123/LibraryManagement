package com.silicus.librarymanagement.ServiceImplementation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import com.silicus.librarymanagement.Service.BookService;
import com.silicus.librarymanagement.daoImplementation.BookDaoImpl;
import com.silicus.librarymanagment.entity.Book;

public class BookServiceImpl<T> implements BookService<T> {

	private BookDaoImpl<Book>bookDaoImpl;
	
	
	
	
	public BookServiceImpl() {
		this.bookDaoImpl=new BookDaoImpl<>();
	}

	
	@Override
	public void insert(Collection<T>t) throws IOException, FileNotFoundException {
	   try {
		bookDaoImpl.insert((Collection<Book>) t);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	@SuppressWarnings("unchecked")
	public LinkedHashSet<T> findAll() throws IllegalStateException, IllegalArgumentException {

		BookDaoImpl<Book> bookDaoImpl = new BookDaoImpl<Book>();
		Set<Book> bookset = null;
		try {
			bookset = bookDaoImpl.findAll();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (LinkedHashSet<T>) bookset;

	}

	public T update(int id) {
		BookDaoImpl<Book> bookDaoImpl = new BookDaoImpl<Book>();
		try {
			bookDaoImpl.update(id);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public boolean delete(Long id) {
		try {
			bookDaoImpl.delete(id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object findById(int id) {
		BookDaoImpl<Book> bookDaoImpl = new BookDaoImpl<Book>();
		bookDaoImpl.findById(1);
		return null;
	}

	@Override
	public T findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}


}
