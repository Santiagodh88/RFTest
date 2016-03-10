package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public final WebDriver driver;

	private String url = "http://qa-rate-factory.elasticbeanstalk.com/admin/login/";
	
	@FindBy (id = "login") 
	private WebElement login;
	@FindBy (id = "password") 
	private WebElement password;
	@FindBy (css = "[type='submit']") 
	private WebElement submitButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public HomePage LoginAsAdmin(String user, String pass) {
		login.sendKeys(user);
		password.sendKeys(pass);
		submitButton.click();
		//PageFactory.initElements(driver, HomePage.class);
		return PageFactory.initElements(driver, HomePage.class);
	}

	public LoginPage open() {
		driver.navigate().to(url);
		return this;

	}
}
