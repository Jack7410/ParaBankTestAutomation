package com.parabank.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProp {
	
	private FileInputStream input; 
	private Properties prop;
	
	public ReadProp() {
		try {
			input=new FileInputStream("src/test/resources/data.properties");
			prop=new Properties();
			prop.load(input);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public String getUrl() {
		return prop.getProperty("Url");
	}
	

	public String getFirstName() {
		return prop.getProperty("FirstName");
	}

	public String getLastName() {
		return prop.getProperty("LastName");
	}

	public String getAddress() {
		return prop.getProperty("Address");
	}

	public String getCity() {
		return prop.getProperty("City");
	}

	public String getState() {
		return prop.getProperty("State");
	}

	public String getZipCode() {
		return prop.getProperty("ZipCode");
	}

	public String getPhoneNo() {
		return prop.getProperty("PhoneNo");
	}

	public String getSnn() {
		return prop.getProperty("snn");
	}

	public String getUserName() {
		return prop.getProperty("UserName"); 
			 	
	}

	public String getUserPass() {
		return prop.getProperty("UserPass");
	}
	
	

	

}
