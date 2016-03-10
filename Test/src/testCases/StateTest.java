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
import pageObjects.States.CreateStatesPage;
import pageObjects.States.StatesPage;

public class StateTest extends WebDriverTestBase {

	public static final String user = "admin@mailinator.com";
	public static final String pass = "admin";
	LoginPage onLoginPage;
	HomePage onHomePage;
	StatesPage onStatesPage;
	CreateStatesPage onCreateStatesPage;
	String message;

	@Test ( priority = 1 )
	public void CreateStateTest() {
		onLoginPage = PageFactory.initElements(driver, LoginPage.class);
		onLoginPage.open();
		onHomePage = onLoginPage.LoginAsAdmin(user, pass);
		onStatesPage = onHomePage.clickOnStates();
		onCreateStatesPage = onStatesPage.createState();
		onStatesPage = onCreateStatesPage.CompleteAllFields();
		Assert.assertTrue(onStatesPage.getMessage().contains("created"), "State was successfully created.");

	}

	@Test ( priority = 2 )
	public void AddAreaTest() {
		onLoginPage = PageFactory.initElements(driver, LoginPage.class);
		onLoginPage.open();
		onHomePage = onLoginPage.LoginAsAdmin(user, pass);
		onStatesPage = onHomePage.clickOnStates();
		CreateStatesPage onEditStatePage = onStatesPage.editState(onStatesPage.findStateToEdit("Mississippi"));
		onStatesPage = onEditStatePage.addArea();
		Assert.assertTrue(onStatesPage.getMessage().contains("saved"), "State was successfully created.");

	}

	@Test ( priority = 3 )
	public void DeleteStateTest() {
		onLoginPage = PageFactory.initElements(driver, LoginPage.class);
		onLoginPage.open();
		onHomePage = onLoginPage.LoginAsAdmin(user, pass);
		onStatesPage = onHomePage.clickOnStates();
		onStatesPage.deleteState("Mississippi");
		message = onStatesPage.getMessage();
		Assert.assertTrue(message.contains("deleted"), "State was successfully deleted.");

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
