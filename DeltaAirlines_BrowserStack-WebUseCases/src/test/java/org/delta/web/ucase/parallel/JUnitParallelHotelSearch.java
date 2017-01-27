package org.delta.web.ucase.parallel;

import java.net.URL;
import java.util.LinkedList;
import java.util.Properties;

import org.delta.web.ucase.custom.CustomBase;
import org.delta.web.ucase.test.constants.BSConfigurationConstants;
import org.delta.web.ucase.test.util.CommonUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

@RunWith(Parallelized.class)
public class JUnitParallelHotelSearch extends CustomBase  {
  private String platform;
  private String browserName;
  private String browserVersion;

  @Parameterized.Parameters
  public static LinkedList<String[]> getEnvironments() throws Exception {
	  LinkedList<String[]> env = CommonUtils.getEnviroment();
	  return env;
  }


  public JUnitParallelHotelSearch(String platform, String browserName, String browserVersion) {
    this.platform = platform;
    this.browserName = browserName;
    this.browserVersion = browserVersion;
  }

  private WebDriver driver;

  @Before
  public void setUp() throws Exception {
		// Load Configuration File to access the properties
		Properties prop = loadConfigurationProperties();  
		  
	    DesiredCapabilities capability = new DesiredCapabilities();
	    capability.setCapability("platform", platform);
	    capability.setCapability("browser", browserName);
	    capability.setCapability("browserVersion", browserVersion);
	    capability.setCapability("build", prop.getProperty(BSConfigurationConstants.BS_DELTA_BUILDPARALLEL));
	    String URL = CommonUtils.BrowserStackURL();
	    
	    // WebDriver Initialization in BrowserStack Infrastructure
	 	driver = new RemoteWebDriver(new URL(URL), capability);    
	  }

  @Test
  public void testSimple() throws Exception {
	  
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



	  /*driver = new Augmenter().augment(driver);
	  File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	  try {
		  FileUtils.copyFile(srcFile, new File("Screenshot.png"));
	  } catch (IOException e) {
		  e.printStackTrace();
	  }*/
  }

  @After
  public void tearDown() throws Exception {
    //driver.quit();
  }
}