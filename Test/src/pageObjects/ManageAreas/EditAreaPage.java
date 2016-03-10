package pageObjects.ManageAreas;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditAreaPage {
	public final WebDriver driver;
	@FindBy (css = "#s2id_counties .select2-choices")
	private WebElement countiesDrop;
	@FindBy (css = "[type='submit']")
	private WebElement save;
	
	
	public EditAreaPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ManageAreasPage AddCounty (String county) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		save.click();
		return new ManageAreasPage (driver);
		}
}
