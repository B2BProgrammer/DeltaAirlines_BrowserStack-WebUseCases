package org.delta.web.ucase.util;

import java.util.LinkedList;
import java.util.Properties;

import org.delta.web.ucase.constants.BSConfigurationConstants;
import org.delta.web.ucase.custom.CustomBase;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CommonUtils extends CustomBase{
	
	/**
	 * Utility Use : To Construct the URL at BrowserStack to Hit
	 * 
	 * @return
	 */
	public static String BrowserStackURL(){
		Properties prop = loadConfigurationProperties();
		
		// User Configuration for Access for BrowserStack
		final String CONNECTION_TYPE = prop.getProperty(BSConfigurationConstants.BS_DELTA_CON_TYPE);
		final String USERNAME = prop.getProperty(BSConfigurationConstants.BS_DELTA_USERNAME);
		final String AUTOMATE_KEY = prop.getProperty(BSConfigurationConstants.BS_DELTA_AUTOMATE_KEY);
		final String END_POINT = prop.getProperty(BSConfigurationConstants.BS_DELTA_END_POINT);

		// Hitting URL at BrowserStack Infrastructure
		final String URL = CONNECTION_TYPE + USERNAME + ":" + AUTOMATE_KEY + END_POINT;		
		
		return URL;
		
		
	}

	/**
	 * Utility Use : To Construct the capabilities of Browser specifications
	 * 
	 * @return
	 */
	public static DesiredCapabilities BrowserStackCaps() {
		Properties prop = loadConfigurationProperties();
		
		final String BROWSER = prop.getProperty(BSConfigurationConstants.BS_DELTA_BROWSER);
		final String BROWSER_VERSION = prop.getProperty(BSConfigurationConstants.BS_DELTA_BROWSER_VERSION);
		final String OS = prop.getProperty(BSConfigurationConstants.BS_DELTA_OS);
		final String OS_VERSION = prop.getProperty(BSConfigurationConstants.BS_DELTA_OS_VERSION);
		final String RESOLUTION = prop.getProperty(BSConfigurationConstants.BS_DELTA_RESOLUTION);
		final String DEBUG = prop.getProperty(BSConfigurationConstants.BS_DELTA_DEBUG);
		final String BUILDNAME_SERIAL = prop.getProperty(BSConfigurationConstants.BS_DELTA_BUILDSERIAL);

		// Capabilities configuration for BrowserStack
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browser", BROWSER);
		caps.setCapability("browser_version", BROWSER_VERSION);
		caps.setCapability("os", OS);
		caps.setCapability("os_version", OS_VERSION);
		caps.setCapability("resolution", RESOLUTION);
		caps.setCapability("browserstack.debug", DEBUG);
		caps.setCapability("build", BUILDNAME_SERIAL);
		
		return caps;
	}
	
   	/**
	 * Utility Use : To Construct the env, filled with all the BrowserNames + BrowserVersions
	 * 
	 * @return
	 */
	public static LinkedList<String[]> getEnviroment(){
		
		// Load Configuration File to access the properties
		Properties prop = loadConfigurationProperties();  
		
		String BROWSER_NAME_1 = prop.getProperty(BSConfigurationConstants.BS_DELTA_BROWSER_NAME_1);
		String BROWSER_NAME_2 = prop.getProperty(BSConfigurationConstants.BS_DELTA_BROWSER_NAME_2);
		String BROWSER_NAME_3  = prop.getProperty(BSConfigurationConstants.BS_DELTA_BROWSER_NAME_3);
		String BS_DELTA_BROWSER_NAME_VERSION_1 = prop.getProperty(BSConfigurationConstants.BS_DELTA_BROWSER_NAME_VERSION_1);
		String BS_DELTA_BROWSER_NAME_VERSION_2 = prop.getProperty(BSConfigurationConstants.BS_DELTA_BROWSER_NAME_VERSION_2);
		String BS_DELTA_BROWSER_NAME_VERSION_3 = prop.getProperty(BSConfigurationConstants.BS_DELTA_BROWSER_NAME_VERSION_3);
		
	    LinkedList<String[]> env = new LinkedList<String[]>();
	    env.add(new String[]{Platform.WINDOWS.toString(), BROWSER_NAME_1, BS_DELTA_BROWSER_NAME_VERSION_1});
	    env.add(new String[]{Platform.WINDOWS.toString(),BROWSER_NAME_2,BS_DELTA_BROWSER_NAME_VERSION_2});
	    env.add(new String[]{Platform.WINDOWS.toString(),BROWSER_NAME_3,BS_DELTA_BROWSER_NAME_VERSION_3});
	   

	    //add more browsers here

	    return env;
	}

}
