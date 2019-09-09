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

	private Set<Book>bookset=new LinkedHashSet<>();
	
	
	public BookDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	


	@Override
	public Set<T> findAll() throws IllegalStateException, IllegalArgumentException {
		HashSet<Book> hsOutput=null;
		boolean cont=true;
		try {
			FileInputStream fileInputStream = new FileInputStream("D:\\FileOperationsPractice11111.txt");
			ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
			  hsOutput = new LinkedHashSet<Book>();
			  while(cont){
                  Object obj=null;
                try {
                    obj = inputStream.readObject();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                  if(obj != null)
                	  hsOutput.add((Book) obj);
                  else
                     cont = false;
               }
			//hsOutput = (LinkedHashSet<Book>) inputStream.readObject();
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
	public T insert(T t) throws IOException,FileNotFoundException {
		
		Book b=(Book)t;
		 bookset.add(b);
           System.out.println(bookset.toString());
			return (T) bookset;

	
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
