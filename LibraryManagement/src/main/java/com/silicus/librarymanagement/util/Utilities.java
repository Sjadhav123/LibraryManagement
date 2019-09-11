package com.silicus.librarymanagement.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

public class Utilities {

	public int getRandomnumber() {
		// TODO Auto-generated method stub
		UUID idOne = UUID.randomUUID();
		String str = "" + idOne;
		int uid = str.hashCode();
		String filterStr = "" + uid;
		str = filterStr.replaceAll("-", "");
		return Integer.parseInt(str);
	}

	public String getFilePath(String inputPath) throws FileNotFoundException, IOException {

		String filePath = "";

		try (InputStream input = new FileInputStream("FileProperties.properties")) {

			Properties prop = new Properties();

			// load a properties file
			prop.load(input);

			// get the property value and print it out

			if (inputPath.equals("book")) {
				System.out.println(prop.getProperty("bookFilePath"));
				return prop.getProperty("bookFilePath");
			} else if (inputPath.equals("bookReturn")) {
				System.out.println(prop.getProperty("bookFilePath"));
				return prop.getProperty("bookReturnFilePath");
			}

			return null;
		}

	}
}
