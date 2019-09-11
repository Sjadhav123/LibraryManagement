package com.silicus.librarymanagement.ServiceImplementation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

import com.silicus.librarymanagement.Service.BookIssueTrackerService;
import com.silicus.librarymanagement.daoImplementation.BookIssueTrackerDaoImpl;
import com.silicus.librarymanagment.entity.BookIssueTracker;

public class BookIssueTrackerServiceImpl<T> implements BookIssueTrackerService<T> {

	BookIssueTrackerDaoImpl<BookIssueTracker>bookIssueTrackerDaoImpl;
	
	
	
	public BookIssueTrackerServiceImpl() {
	
		this.bookIssueTrackerDaoImpl=new BookIssueTrackerDaoImpl<>();
	
	}


	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public T update(int id) {
	
		try {
			bookIssueTrackerDaoImpl.update(id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public Collection<T> findAll() {
		try {
			return (Collection<T>) bookIssueTrackerDaoImpl.findAll();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public boolean delete(Long id) {
		try {
			bookIssueTrackerDaoImpl.delete(id);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
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
	public void insert(Collection<T> t) throws IOException, FileNotFoundException {
			try {
				bookIssueTrackerDaoImpl.insert((Collection<BookIssueTracker>) t);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}



	

}
