
package org.delta.web.ucase.single;

import java.net.URL;
import java.util.Properties;

import org.delta.web.ucase.custom.CustomBase;
import org.delta.web.ucase.test.constants.BSConfigurationConstants;
import org.delta.web.ucase.test.util.CommonUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author A.Ajjarani
 *
 */
public class JUnitDeltaFlightSearch extends CustomBase {
	private WebDriver driver;

	/**
	 * Constructor - Calling Abstract Base class for Common Tasks
	 */
	public JUnitDeltaFlightSearch() {
		super();
	}

	@Before
	public void setUp() throws Exception {		
		String URL = CommonUtils.BrowserStackURL();
		DesiredCapabilities caps = CommonUtils.BrowserStackCaps();

		// WebDriver Initialization in BrowserStack Infrastructure
		driver = new RemoteWebDriver(new URL(URL), caps);
	}

	/**
	 * @throws Exception
	 */
	@Test
	public void testDeltaFlightSearch() throws Exception {
		// Load Configuration File to access the properties
		Properties prop = loadConfigurationProperties();

		// URL to access from BrowserStack Browser of selection
		driver.get(prop.getProperty(BSConfigurationConstants.BS_DELTA_TEST_URL));

		// Selection of RadioButton for 1 Way Travel
		WebElement radioBtn = driver
				.findElement(By.id(prop.getProperty(BSConfigurationConstants.BS_DELTA_TEST_DIRECTION)));
		radioBtn.click();

		// Selection + Insertion + Submission of values to text fields
		WebElement element1 = driver
				.findElement(By.name(prop.getProperty(BSConfigurationConstants.BS_DELTA_TEST_START_ELEMENT)));
		element1.sendKeys(prop.getProperty(BSConfigurationConstants.BS_DELTA_TEST_START));

		WebElement element2 = driver
				.findElement(By.name(prop.getProperty(BSConfigurationConstants.BS_DELTA_TEST_END_ELEMENT)));
		element2.sendKeys(prop.getProperty(BSConfigurationConstants.BS_DELTA_TEST_END));

		WebElement element3 = driver
				.findElement(By.name(prop.getProperty(BSConfigurationConstants.BS_DELTA_TEST_DATE_ELEMENT)));
		element3.sendKeys(prop.getProperty(BSConfigurationConstants.BS_DELTA_TEST_DATE));

		element1.submit();
		element2.submit();
		element3.submit();
	}

	@After
	public void tearDown() throws Exception {

	}
}