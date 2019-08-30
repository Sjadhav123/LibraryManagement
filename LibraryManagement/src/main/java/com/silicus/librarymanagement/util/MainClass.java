package com.silicus.librarymanagement.util;

import com.silicus.librarymanagement.ServiceImplementation.BookServiceImpl;
import com.silicus.librarymanagment.entity.Book;

public class MainClass {

	public static void main(String[] args) {
		
		BookServiceImpl<Book>bookServiceImpl=new BookServiceImpl<Book>();
		bookServiceImpl.insert();
		
		bookServiceImpl.findAll();
		bookServiceImpl.update(1);
		bookServiceImpl.findAll();
		
		
		
		
	}
}
