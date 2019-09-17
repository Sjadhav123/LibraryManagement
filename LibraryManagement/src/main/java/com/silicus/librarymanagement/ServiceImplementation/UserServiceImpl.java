package com.silicus.librarymanagement.ServiceImplementation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import com.silicus.librarymanagement.Service.UserService;
import com.silicus.librarymanagement.daoImplementation.BookDaoImpl;
import com.silicus.librarymanagement.daoImplementation.UserDaoImpl;
import com.silicus.librarymanagment.entity.Book;
import com.silicus.librarymanagment.entity.User;

public class UserServiceImpl<T> implements UserService<T> {

private UserDaoImpl<User>userDaoImpl;

	

public UserServiceImpl() {
	
	this.userDaoImpl= new UserDaoImpl<User>();
}


	public T update(int id) throws FileNotFoundException, ClassNotFoundException, IOException {
		userDaoImpl.update(id);
		
		return null;
	}


	public LinkedHashSet<T> findAll() {
		
	//	UserDaoImpl<User> userDaoImpl = new UserDaoImpl<User>();
		Set<User> userset = null;
		try {
			userset = userDaoImpl.findAll();
		} catch (ClassNotFoundException | IOException e) {
			
			e.printStackTrace();
		}
		
		return (LinkedHashSet<T>) userset;
		
	}

	public boolean delete(Long id) throws IOException {
		
		userDaoImpl.delete(id);
		
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


	@SuppressWarnings("unchecked")
	@Override
	public void insert(Collection<T> t) throws IOException, FileNotFoundException, ClassNotFoundException {
		 // System.out.println("In User Service IMPL :"+ t.toString());
		userDaoImpl.insert((Collection<User>) t);
		
	}

	
}
