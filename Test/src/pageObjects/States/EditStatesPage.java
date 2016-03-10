package pageObjects.States;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditStatesPage {
	public final WebDriver driver;
	
	@FindBy (css = "#areas-button")
	private WebElement areaButton;
	@FindBy (id= "areas-2-name")
	private WebElement areaName2;
	
	public EditStatesPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addArea (){
		areaName2.sendKeys("MS - Area 3");
		
	}
	

}
