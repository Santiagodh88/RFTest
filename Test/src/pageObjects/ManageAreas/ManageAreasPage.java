package pageObjects.ManageAreas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageAreasPage {

	public final WebDriver driver;
	@FindBy (name = "flt1_0")
	private WebElement filter;
	@FindBy (css = ".btn.btn-primary")
	private WebElement applyButton;
	@FindBy (css = "[href='/admin/manage_areas/edit/?url=/admin/manage_areas/?flt1_0=NY&id=74374918-45c9-4017-acf0-1c49aec77f6b']")
	private WebElement addCountiesButton;
	@FindBy (css = ".alert.alert-info.alert-dismissable")
	private WebElement message;
	
	public ManageAreasPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public EditAreaPage SearchState () {
		filter.sendKeys("NY");
		applyButton.click();
		addCountiesButton.click();
		return new EditAreaPage (driver);		
	}

	public String getMessage() {
			return (message.getText());
	}
}
