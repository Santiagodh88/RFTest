package pageObjects.Carrier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCarrierPage {
	public final WebDriver driver;
	
	@FindBy (css = "[id='name']")
	private WebElement name;
	@FindBy (css = "input.btn.btn-primary")
	private WebElement save;

	public CreateCarrierPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public CarrierPage completeAllFields (String carrierName) {
		name.sendKeys(carrierName);
		save.click();
		return new CarrierPage (driver);
	}
	
	public CarrierPage editCarrier () {
		save.click();
		return new CarrierPage (driver);
		}
}
