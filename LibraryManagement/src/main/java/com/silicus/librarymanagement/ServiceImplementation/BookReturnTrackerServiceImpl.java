package com.silicus.librarymanagement.ServiceImplementation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.silicus.librarymanagement.Service.BookReturnTrackerService;
import com.silicus.librarymanagement.daoImplementation.BookReturnDaoImpl;
import com.silicus.librarymanagment.entity.BookReturnTracker;

public class BookReturnTrackerServiceImpl<T> implements BookReturnTrackerService<T> {
	
private BookReturnDaoImpl<BookReturnTracker> BookreturnDaoImpl =new BookReturnDaoImpl<BookReturnTracker>();

public T update(int id) throws ClassNotFoundException, IOException {
    BookReturnDaoImpl<BookReturnTracker> BookreturnDaoImpl1 =new BookReturnDaoImpl<BookReturnTracker>();

	BookreturnDaoImpl1.update(id);
	return null;

}


	@SuppressWarnings("unchecked")
	public LinkedHashSet<T> findAll() throws IllegalStateException, IllegalArgumentException, ClassNotFoundException, IOException {

		BookReturnDaoImpl<BookReturnTracker> bookReturnDaoImpl = new BookReturnDaoImpl<BookReturnTracker>();
		Set<BookReturnTracker> bookReturnset = null;
		bookReturnset = (Set<BookReturnTracker>) bookReturnDaoImpl.findAll();
		return (LinkedHashSet<T>) bookReturnset;

	}

	public boolean delete(Long id) throws IOException {
	    BookReturnDaoImpl<BookReturnTracker> BookreturnDaoImpl2 =new BookReturnDaoImpl<BookReturnTracker>();

		BookreturnDaoImpl2.delete(id);
		return false;
	}

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


	public void insert(Collection<T>t) throws IOException, FileNotFoundException, ClassNotFoundException {
		   BookreturnDaoImpl.insert((Collection<BookReturnTracker>) t);
			
		}
	
}
