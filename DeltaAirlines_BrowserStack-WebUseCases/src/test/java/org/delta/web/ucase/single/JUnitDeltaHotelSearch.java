
package org.delta.web.ucase.single;

import java.net.URL;
import java.util.Properties;

import org.delta.web.ucase.constants.BSConfigurationConstants;
import org.delta.web.ucase.custom.CustomBase;
import org.delta.web.ucase.util.CommonUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class JUnitDeltaHotelSearch extends CustomBase {
  private WebDriver driver;
    
  /**
	 * Constructor - Calling Abstract Base class for Common Tasks
	 */
	public JUnitDeltaHotelSearch() {
		super();
	}

  @Before
  public void setUp() throws Exception {
	    String URL = CommonUtils.BrowserStackURL();
		DesiredCapabilities caps = CommonUtils.BrowserStackCaps();

		// WebDriver Initialization in BrowserStack Infrastructure
		driver = new RemoteWebDriver(new URL(URL), caps);    
  }

  @Test
  public void testDeltaHotelSearch() throws Exception {
	  // Load Configuration File to access the properties
	  Properties prop = loadConfigurationProperties();
	  
	  // URL to access from BrowserStack Browser of selection + Navigate to actual location
	  driver.get(prop.getProperty(BSConfigurationConstants.BS_DELTA_TEST_URL3));
	  
	  driver.findElement(By.xpath(".//*[(@id = 'book-hotel-content-trigger')]")).click();


	  WebElement element1 = driver.findElement(By.name(prop.getProperty(BSConfigurationConstants.BS_DELTA_HOTEL_SEARCH_CODE_ELE)));   
	  element1.sendKeys(prop.getProperty(BSConfigurationConstants.BS_DELTA_HOTEL_SEARCH_CODE));


	  WebElement element2 = driver.findElement(By.name(prop.getProperty(BSConfigurationConstants.BS_DELTA_CHECKIN_DATE_ELEM)));   
	  element2.sendKeys(prop.getProperty(BSConfigurationConstants.BS_DELTA_CHECKIN_DATE)); 


	  WebElement element3 = driver.findElement(By.name(prop.getProperty(BSConfigurationConstants.BS_DELTA_CHECKOUT_DATE_ELEM)));   
	  element3.sendKeys(prop.getProperty(BSConfigurationConstants.BS_DELTA_CHECKOUT_DATE)); 

	  element1.submit();
	  element2.submit();
	  element3.submit();
  }

  @After
  public void tearDown() throws Exception {
      
  }
}