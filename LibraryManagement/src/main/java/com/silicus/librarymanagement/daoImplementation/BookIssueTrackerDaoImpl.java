package com.silicus.librarymanagement.daoImplementation;

import java.util.Collection;

import com.silicus.librarymanagement.dao.BookIssueTrackerDao;

public class BookIssueTrackerDaoImpl<T> implements BookIssueTrackerDao<T> {



	@Override
	public T update(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T insert(T t) {
		return t;
		// TODO Auto-generated method stub
		
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


}
