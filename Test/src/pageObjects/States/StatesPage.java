package pageObjects.States;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StatesPage {
	public final WebDriver driver;

	
	@FindBy(css = ".nav-tabs > li:nth-child(2) > a:nth-child(1)")
	private WebElement createStateButton;
	@FindBy(xpath = "/html/body/div/table/tbody/tr[10]/td[2]/form/button")
	private WebElement deleteStateButton;
	@FindBy(xpath = "/html/body/div/table/tbody/tr[10]/td[2]/a/span")
	private WebElement editStateButton;

	public StatesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public CreateStatesPage createState() {
		createStateButton.click();
		return new CreateStatesPage(driver);
	}

	public void deleteState(String state) {
		String stateTable = null;
		int row = 0;
		do {
			row++;
			stateTable = driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr[" + row + "]/td[3]")).getText();
			} while (!state.equals(stateTable));
		
		driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr["+ row + "]/td[2]/form/button")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public CreateStatesPage editState(int row) {
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr[" + row + "]/td[2]/a/span")).click();
		return new CreateStatesPage(driver);
	}

	public String getMessage() {
		String message = driver
				.findElement(By.cssSelector("html body div.container div.alert.alert-info.alert-dismissable"))
				.getText();
		return (message);
	}

	public int findStateToEdit(String stateWanted) {
		String stateTable = null;
		int row = 0;
		do {
			row++;
			stateTable = driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr[" + row + "]/td[3]")).getText();
			} while (!stateWanted.equals(stateTable));
		
		System.out.println(row);
		return (row);
	}
}
