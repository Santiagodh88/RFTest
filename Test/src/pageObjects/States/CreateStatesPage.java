package pageObjects.States;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateStatesPage {
	public final WebDriver driver;
	
	@FindBy (id = "name")
	private WebElement name;
	@FindBy (id = "abbr")
	private WebElement abbr;
	@FindBy (id = "num_max_areas")
	private WebElement num_max_areas;
	@FindBy (css = "#areas-button")
	private WebElement areaButton;
	@FindBy (id = "areas-1-name")
	private WebElement area1;
	@FindBy (id = "areas-0-name")
	private WebElement area0;
	@FindBy (css = "[type='submit']")
	private WebElement submit;
	
		
	public CreateStatesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public StatesPage CompleteAllFields () {
		name.sendKeys("Mississippi");
		abbr.sendKeys("MS");
		num_max_areas.sendKeys("2");
		areaButton.click();
		area0.sendKeys("MS - Area 1");
		areaButton.click();
		area1.sendKeys("MS - Area 2");
		submit.click();
		return new StatesPage (driver);
		
	}
	public StatesPage addArea (){
		area1.sendKeys("MS - Area 3");
		num_max_areas.clear();
		num_max_areas.sendKeys("5");
		submit.click();
		return new StatesPage (driver);
	}
}
