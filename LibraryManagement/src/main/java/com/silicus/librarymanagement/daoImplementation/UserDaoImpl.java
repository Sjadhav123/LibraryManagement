package com.silicus.librarymanagement.daoImplementation;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.silicus.librarymanagement.dao.UserDao;
import com.silicus.librarymanagement.util.Utilities;
import com.silicus.librarymanagment.entity.Book;
import com.silicus.librarymanagment.entity.User;

public class UserDaoImpl<T> implements UserDao<T> {

	private Set<User> userset= new LinkedHashSet<>();;
	Utilities utilities=new Utilities();
	
	
	
	public UserDaoImpl() {
		//this.userset=new LinkedHashSet<>();
	}

	

	@Override
	public Set<T> findAll() throws IllegalStateException, IllegalArgumentException, ClassNotFoundException, IOException 
	{
			LinkedHashSet<User> allUSers = getExistingObjects();
			
			return (Set<T>) allUSers;
	}

	@Override
	public boolean delete(Long id) throws FileNotFoundException, IOException {
		
		LinkedHashSet<User> userSet = null;
		try {
			userSet = getExistingObjects();
		} catch (ClassNotFoundException | IOException e) {
			
			e.printStackTrace();
		}

		for (User user : userSet) {
			if (user.getId() == id) {
				userSet.remove(user);
				System.out.println("User successfully deleted..!");
				break;
			}
		}
		//System.out.println("UserSet after deletion:" + userSet.size());
		String userFilePath = utilities.getFilePath("user");
		File file = new File(userFilePath);
		
		
		//File file = new File(filepath);
		FileOutputStream outputStream=null;
		try {
			outputStream = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		ObjectOutputStream objectOutputStream=null;
		try {
			objectOutputStream = new ObjectOutputStream(outputStream);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		try {
			objectOutputStream.writeObject(userSet);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

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

	@Override
	public void insert(Collection<T> t) throws IOException, FileNotFoundException, ClassNotFoundException {
		String userFilePath = utilities.getFilePath("user");
		File file = new File(userFilePath);
		
		//File file = new File(filepath);
		LinkedHashSet<User> existingHashset = getExistingObjects();
		FileOutputStream outputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		//System.out.println("new Users" + t.size());
		userset = (Set<User>) t;
	
		if (existingHashset != null) {
		
			System.out.println("existing Users:" + existingHashset.toString());
			existingHashset.addAll(userset);
			

		} else {
			System.out.println("existing books:" + 0);
			existingHashset = (LinkedHashSet<User>) t;
		}
	
		objectOutputStream.writeObject(existingHashset);
		
		objectOutputStream.close();
		System.out.println("Objects have been successfully written to file");
		//System.out.println("Total Users:" + existingHashset);
		System.out.println("Total Updated Users are:" + getExistingObjects());
		
		
	}
	
	public LinkedHashSet<User> getExistingObjects() throws IOException, ClassNotFoundException {
		LinkedHashSet<User> userset =null;// new LinkedHashSet<>();
		ObjectInputStream input = null;
		
		String userFilePath = utilities.getFilePath("user");
		File file = new File(userFilePath);
		
		//File file = new File(filepath);
		try {

			if (file.exists()) {
				FileInputStream fis = new FileInputStream(file);

				input = new ObjectInputStream(fis);
				userset = (LinkedHashSet<User>) input.readObject();
				
			}
		} catch (EOFException e) {
			e.printStackTrace();
		} finally {
			if (file.exists()) {
				input.close();
			}
		}
		System.out.println("All users:" + userset.toString());
		return userset;

	}
	
	@Override
	public T update(int id) throws FileNotFoundException, ClassNotFoundException, IOException {
		
		LinkedHashSet<User> userSet = null;
		Scanner sc= new Scanner(System.in);
		try {
			userSet = getExistingObjects();
		} catch (ClassNotFoundException | IOException e) {
			
			e.printStackTrace();
		}
		
		for (User user : userSet) {
			if (user.getId() == id) {
				System.out.println("SELECTED USER TO UPDATE:"+ user.toString()+"\r\n");
				
				System.out.println("Please enter User Name:");
				String userName= sc.next();
				user.setName(userName);
				System.out.println("Please enter RoleId:");
				String roleId= sc.next();
				user.setRoleId(roleId);
				System.out.println("Please enter Email:");
				String email= sc.next();
				user.setEmail(email);
				System.out.println("Please enter Phone Number:");
				String phoneNumber= sc.next();
				user.setPhoneNumber(phoneNumber);
			//	boolean nextCheck=true;
				//System.out.println("Please Enter Numerics as per Attribute to: \r\n  1: Update Name \r\n 2:Update Role ID \r\n 3: Update Email \r\n 4:Update Phone Number \r\n 5:Update All Fields \r\n 6: Exit");
			//	int n= sc.nextInt();
				userSet.add(user);
				//insert((Collection<T>) userSet);
			}
			
		}

		String userFilePath = utilities.getFilePath("user");
		File file = new File(userFilePath);
		FileOutputStream outputStream = new FileOutputStream(file);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
		objectOutputStream.writeObject(userSet);
		System.out.println("userSet after update and write Operation:" + userSet.toString());
	
		
		
		/*LinkedHashSet<User> userSet = null;
		Scanner sc= new Scanner(System.in);
		String continuee="N";
		
		try {
			userSet = getExistingObjects();
		} catch (ClassNotFoundException | IOException e) {
			
			e.printStackTrace();
		}

		for (User user : userSet) {
			if (user.getId() == id) {
				boolean nextCheck = false;
				System.out.println("SELECTED USER TO UPDATE:"+ user.toString()+"\r\n");
				System.out.println("Please Enter Numerics as per Attribute to: \r\n  1: Update Name \r\n 2:Update Role ID \r\n 3: Update Email \r\n 4:Update Phone Number \r\n 5:Update All Fields \r\n 6: Exit");
				int n= sc.nextInt();
				
				
			do
			{	
				switch(n)
				{
				
				case 1: //update Name
				System.out.println("Please enter User Name:");
				String userName= sc.next();
				user.setName(userName);
				//nextCheck=true;
				//System.out.println("Please Enter Numerics as per Attribute to: \r\n  1: Update Name \r\n 2:Update Role ID \r\n 3: Update Email \r\n 4:Update Phone Number \r\n 5:Update All Fields \r\n 6: Exit");
				//n= sc.nextInt();
				userSet.add(user);
				insert((Collection<T>) userSet);
				
				//sc.nextLine();
				System.out.println("Do you want to update more fields of user? Y/N");
				sc.nextLine();
				continuee= sc.next();
				
				if(continuee=="Y"){update(id); }
				else
				nextCheck=false;
				break;
				
				case 2://Update RoleID
				System.out.println("Please enter RoleId:");
				String roleId= sc.next();
				user.setRoleId(roleId);
				nextCheck=true;
				System.out.println("Please Enter Numerics as per Attribute to: \r\n  1: Update Name \r\n 2:Update Role ID \r\n 3: Update Email \r\n 4:Update Phone Number \r\n 5:Update All Fields \r\n 6: Exit");
				n= sc.nextInt();
				userSet.add(user);
				insert((Collection<T>) userSet);
				//update(id);
				
				
				break;
				
				case 3: //Update Email
				System.out.println("Please enter Email:");
				String email= sc.next();
				user.setEmail(email);
				nextCheck=true;
				System.out.println("Please Enter Numerics as per Attribute to: \r\n  1: Update Name \r\n 2:Update Role ID \r\n 3: Update Email \r\n 4:Update Phone Number \r\n 5:Update All Fields \r\n 6: Exit");
				n= sc.nextInt();
				userSet.add(user);
				insert((Collection<T>) userSet);
				break;
				
				case 4: //Update Phone Number
				System.out.println("Please enter Phone Number:");
				String phoneNumber= sc.next();
				user.setPhoneNumber(phoneNumber);
				nextCheck=true;
				System.out.println("Please Enter Numerics as per Attribute to: \r\n  1: Update Name \r\n 2:Update Role ID \r\n 3: Update Email \r\n 4:Update Phone Number \r\n 5:Update All Fields \r\n 6: Exit");
				n= sc.nextInt();
				userSet.add(user);
				insert((Collection<T>) userSet);
			
				break;
				//System.out.println(userName +" ,"+roleId +" ,"+email +" ,"+ phoneNumber );
				
				case 5: //Update all Field
					
					System.out.println("Please enter User Name:");
					 userName= sc.next();
					user.setName(userName);
					System.out.println("Please enter RoleId:");
					roleId= sc.next();
					user.setRoleId(roleId);
					System.out.println("Please enter Email:");
					email= sc.next();
					user.setEmail(email);
					System.out.println("Please enter Phone Number:");
					phoneNumber= sc.next();
					user.setPhoneNumber(phoneNumber);
					nextCheck=true;
					System.out.println("Please Enter Numerics as per Attribute to: \r\n  1: Update Name \r\n 2:Update Role ID \r\n 3: Update Email \r\n 4:Update Phone Number \r\n 5:Update All Fields \r\n 6: Exit");
					n= sc.nextInt();
					userSet.add(user);
					insert((Collection<T>) userSet);
					
					break;
				
				case 6:// Exit 
					nextCheck=false;
					System.exit(0);
					break;
				default:
					System.out.println("You are Entered in default state of Update User.!");
					break;
				}
			}while(nextCheck);
				
				
			}
		}
		//System.out.println("UserSet after update Operation:" + userSet.toString());
		*/
		return null;
	}
	

}
