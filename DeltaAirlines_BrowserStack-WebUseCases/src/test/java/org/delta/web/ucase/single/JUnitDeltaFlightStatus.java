
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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class JUnitDeltaFlightStatus extends CustomBase  {
  private WebDriver driver;
  
  /**
	 * Constructor - Calling Abstract Base class for Common Tasks
	 */
	public JUnitDeltaFlightStatus() {
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
  public void testDeltaFlightStatus() throws Exception {    

	// Load Configuration File to access the properties
	  Properties prop = loadConfigurationProperties();
	  
	  driver.get(prop.getProperty(BSConfigurationConstants.BS_DELTA_TEST_URL2));         
	  driver.findElement(By.xpath(".//*[(@id = 'navFlightStatus')]")).click();

	  WebElement element1 = driver.findElement(By.name(prop.getProperty(BSConfigurationConstants.BS_DELTA_FLIGHT_NUM_ELEMENT)));	  
	  element1.sendKeys(prop.getProperty(BSConfigurationConstants.BS_DELTA_FLIGHT_NUM));
	  element1.submit();
  }

  @After
  public void tearDown() throws Exception {
      
  }
}