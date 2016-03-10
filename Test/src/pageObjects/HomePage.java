package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageObjects.Carrier.CarrierPage;
import pageObjects.ManageAreas.ManageAreasPage;
import pageObjects.States.StatesPage;

public class HomePage {
	public final WebDriver driver;
	
	@FindBy (css = "[href='/admin/state/']")
	private WebElement statesLink;
	@FindBy (css = "[href='/admin/carrier/']")
	private WebElement carrierLink;
	@FindBy (css = "[href='/admin/manage_areas/']")
	private WebElement manageAreasLink;

	public HomePage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public StatesPage clickOnStates () {
		statesLink.click();
		return new StatesPage (driver);
	}
	
	public CarrierPage clickOnCarrier () {
		carrierLink.click();
		return new CarrierPage (driver);
		
	}

	public ManageAreasPage clickOnManageAreas() {
		manageAreasLink.click();
		return new ManageAreasPage (driver);		
	}

}
