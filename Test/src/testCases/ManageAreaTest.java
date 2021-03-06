package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ManageAreas.EditAreaPage;
import pageObjects.ManageAreas.ManageAreasPage;

public class ManageAreaTest extends WebDriverTestBase {
	public static final String user = "admin@mailinator.com";
	public static final String pass = "admin";
	public static final String county = "Orange";
	LoginPage onLoginPage;
	HomePage onHomePage;
	ManageAreasPage onManageAreas;
	EditAreaPage onEditArea;
	
	@Test
	public void addCounty () {
		onLoginPage = PageFactory.initElements(driver, LoginPage.class);
		onLoginPage.open();
		onHomePage = onLoginPage.LoginAsAdmin(user, pass);
		onManageAreas = onHomePage.clickOnManageAreas();
		onEditArea = onManageAreas.SearchState();
		onManageAreas = onEditArea.AddCounty(county);
		Assert.assertTrue(onManageAreas.getMessage().contains("created"), "Carrier was successfully created.");
	}
	
	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void tearDown() {
		// logout
		driver.findElement(By.xpath("/html/body/div/nav/div[2]/div/a/span")).click();
		driver.findElement(By.xpath("/html/body/div/nav/div[2]/div/ul/li/a")).click();
		driver.quit();
	}
}

