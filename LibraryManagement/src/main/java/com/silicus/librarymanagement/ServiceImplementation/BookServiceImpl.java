package com.silicus.librarymanagement.ServiceImplementation;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import com.silicus.librarymanagement.Service.BookService;
import com.silicus.librarymanagement.daoImplementation.BookDaoImpl;
import com.silicus.librarymanagment.entity.Book;

public class BookServiceImpl<T> implements BookService<T> {

	@SuppressWarnings("unchecked")
	public LinkedHashSet<T> findAll() throws IllegalStateException, IllegalArgumentException {
		
		BookDaoImpl<Book>bookDaoImpl=new BookDaoImpl<Book>();
		Set<Book> bookset = bookDaoImpl.findAll();
		return (LinkedHashSet<T>) bookset;
		
	}

	public T update(int id) {
		BookDaoImpl<Book>bookDaoImpl=new BookDaoImpl<Book>();
		bookDaoImpl.update(1);
		return null;
		
	}

	public T insert(T t) {
		
	BookDaoImpl<Book>bookDaoImpl=new BookDaoImpl<Book>();
	try {
		bookDaoImpl.insert((Book) t);
	} catch (IOException e) {
		e.printStackTrace();
	}
	return t;
	
		
	}


	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object findById(int id) {
		BookDaoImpl<Book>bookDaoImpl=new BookDaoImpl<Book>();
		bookDaoImpl.findById(1);
		return null;
	}

	@Override
	public T findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
