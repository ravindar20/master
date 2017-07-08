package designPatterns;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.server.browserlaunchers.DrivenSeleniumLauncher;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EbayPOM3Style {
	
	@FindBy(id="gh-ac")
	private WebElement searchBox;
	
	@FindBy(id="gh-cat")
	private WebElement selectBox;
	
	@FindBy(id="gh-btn")
	private WebElement searchButton;
	
	private Select dropdown;
	
	public EbayPOM3Style(WebDriver Driver){
		
		PageFactory.initElements(Driver, this);
		
		dropdown = new Select(selectBox);
	}
	
	public void searchProduct(String product, String category){
		
		searchBox.sendKeys(product);
		dropdown.selectByVisibleText(category);
		searchButton.click();
	}
	

}
