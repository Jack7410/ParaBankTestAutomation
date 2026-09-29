package com.nopCommers.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProp {
	
	private FileInputStream input; 
	private Properties prop;
	
	public ReadProp() {
		try {
			input=new FileInputStream("resources.data.properties");
			prop=new Properties();
			prop.load(input);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public String getUrl() {
		return prop.getProperty("Url");
	}
}
