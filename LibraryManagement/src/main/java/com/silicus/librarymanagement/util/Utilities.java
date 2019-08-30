package com.silicus.librarymanagement.util;

import java.util.UUID;

public class Utilities {

	
	
	public int getRandomnumber() {
		// TODO Auto-generated method stub
	    UUID idOne = UUID.randomUUID();
        String str=""+idOne;        
        int uid=str.hashCode();
        String filterStr=""+uid;
        str=filterStr.replaceAll("-", "");
        return Integer.parseInt(str);
	}
	
}
