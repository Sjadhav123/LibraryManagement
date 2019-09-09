package com.silicus.librarymanagement.ServiceImplementation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

import com.silicus.librarymanagement.Service.UserService;

public class UserServiceImpl<T> implements UserService<T> {



	public T update(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	public Collection<T> findAll() {
		// TODO Auto-generated method stub
		return null;
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
	public T findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void insert(Collection<T> t) throws IOException, FileNotFoundException {
		// TODO Auto-generated method stub
		
	}

	
}
