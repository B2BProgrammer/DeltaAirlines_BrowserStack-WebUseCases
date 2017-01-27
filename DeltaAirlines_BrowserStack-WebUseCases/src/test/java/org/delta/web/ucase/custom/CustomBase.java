package org.delta.web.ucase.custom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author A.Ajjarani
 * 
 * Custom Base Class - Where the generic functions for all classes are implemented *
 */
public abstract class CustomBase {
	
	private static Properties prop = new Properties();
	
	/**
	 * Constructor Loads the Configuration file - 
	 * used in all next subsequent operations. 
	 * @param exitContext
	 */
	public CustomBase() {
		super();	
		loadConfigurationProperties();
	}
	
	
	/**
	 * Method for - Loading all the configuration properties file 
	 * @return
	 */
	public static Properties loadConfigurationProperties(){	 
		InputStream input;
		try {
			input = new FileInputStream("config.properties");
			prop.load(input);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return prop;
  }
}
