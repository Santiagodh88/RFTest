package pageObjects.Carrier;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarrierPage {
	public final WebDriver driver;

	@FindBy(css = "[title='Create new record']")
	private WebElement createButton;

	public CarrierPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public CreateCarrierPage createCarrier() {
		createButton.click();
		return new CreateCarrierPage(driver);

	}

	public CreateCarrierPage EditCarrier(String carrier) {
		String carrierTable = null;
		int row = 0;

		// Search for the carrier
		do {
			row++;
			carrierTable = driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr[" + row + "]/td[3]")).getText();
		} while (!carrier.equals(carrierTable));

		driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr[" + row + "]/td[2]/a/span")).click();
		return new CreateCarrierPage(driver);
	}

	public String getMessage() {
		String message = driver
				.findElement(By.cssSelector("html body div.container div.alert.alert-info.alert-dismissable"))
				.getText();
		return (message);
	}

	public void deleteCarrier(String carrier) {
		String carrierTable = null;
		int row = 0;

		// Search for the carrier
		do {
			row++;
			carrierTable = driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr[" + row + "]/td[3]")).getText();
		} while (!carrier.equals(carrierTable));

		driver.findElement(By.xpath("html/body/div[1]/table/tbody/tr[" + row + "]/td[2]/form/button")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

}
