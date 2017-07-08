package designPatterns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class EbayPOM2Style {
	

	
	private WebElement searchBox;
	private WebElement selectBox;
	private Select dropDown;
	private WebElement searchButton;
	private WebElement result;
	
	public EbayPOM2Style(WebDriver Driver){
		searchBox = Driver.findElement(By.id("gh-ac"));
		selectBox = Driver.findElement(By.id("gh-cat"));
		
		dropDown = new Select(selectBox);
		
		searchButton = Driver.findElement(By.id("gh-btn"));
	}
	
	public void searchProduct(String product, String category){
		
		searchBox.sendKeys(product);
		
		dropDown.selectByVisibleText(category);
		
		searchButton.click();
	}
	

}
