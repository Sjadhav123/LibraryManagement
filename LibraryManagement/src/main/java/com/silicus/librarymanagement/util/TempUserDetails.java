package com.silicus.librarymanagement.util;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

import com.silicus.librarymanagment.entity.Book;
import com.silicus.librarymanagment.entity.BookReturnTracker;
import com.silicus.librarymanagment.entity.User;

public class TempUserDetails {

	public static HashSet<User> getListOfUsers()
	{
		
		User as1=new User();
		as1.setEmail("user1@gmail.com");
		as1.setId(111);
		as1.setName("user1");
		as1.setPhoneNumber("1111111111");
		as1.setRoleId("01");

		
		User as2=new User();
		as2.setEmail("user2@gmail.com");
		as2.setId(222);
		as2.setName("user2");
		as2.setPhoneNumber("2222222222");
		as2.setRoleId("01");

		User as3=new User();
		as3.setEmail("user3@gmail.com");
		as3.setId(333);
		as3.setName("user3");
		as3.setPhoneNumber("3333333333");
		as3.setRoleId("02");

		User as4=new User();
		as3.setEmail("user4@gmail.com");
		as3.setId(444);
		as3.setName("user4");
		as3.setPhoneNumber("4444444444");
		as3.setRoleId("03");

		User as5=new User();
		as3.setEmail("user5@gmail.com");
		as3.setId(555);
		as3.setName("user5");
		as3.setPhoneNumber("5555555555");
		as3.setRoleId("04");

		
		 HashSet<User> as=new HashSet<User>();
         as.add(as1);
         as.add(as2);
         as.add(as3);
         as.add(as4);
         as.add(as5);

         
		return as;
		
	}
		
// to get all list of Available Users******************************************//

	public static User getUser(int id) {
		User defaultUSer=new User();
		
		HashSet<User> listOfUsers = TempUserDetails.getListOfUsers();
		     for (User user : listOfUsers) {    	
		        	  if(user.getId()==id) {
		        		 return user;
		        	  }
				}	         
		         defaultUSer.setId(id);
		         defaultUSer.setEmail("defaultUser@gmail.com");
		         defaultUSer.setName("default user");
		         defaultUSer.setPhoneNumber("7777777777");
		         defaultUSer.setRoleId("09");
		         System.out.println("default user returned");
		         return defaultUSer;
		         
	}
	// to get all list of Available Users******************************************//


	// To calculate the fine Amount 
		public static long fineCalculation(String dateOfReturn) {

			
			String dateBeforeString = "2019-09-01";
			String dateAfterString = dateOfReturn;
				
			//Parsing the date
			LocalDate dateBefore = LocalDate.parse(dateBeforeString);
			LocalDate dateAfter = LocalDate.parse(dateAfterString);
				
			//calculating number of days in between
			long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
			
			int LateCountDay = (int) noOfDaysBetween - 10;
			System.out.println("No Of Days Late"+LateCountDay);
			if(LateCountDay >= 10) {
			long FineAmount=(long)LateCountDay*100;
			return FineAmount;
			}
			
		return 0;	

		}




	

	
	public static void main(String[] args) {
		
	}
}










