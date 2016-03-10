package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class WebDriverTestBase {

	protected WebDriver driver;

	@BeforeClass
	public void setUp (){
	
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
