package com.silicus.librarymanagement.ServiceImplementation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

import com.silicus.librarymanagement.Service.BookIssueTrackerService;

public class BookIssueTrackerServiceImpl<T> implements BookIssueTrackerService<T> {


	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public T update(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public Collection<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		
	}



	

}
