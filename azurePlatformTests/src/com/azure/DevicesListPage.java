package com.azure;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DevicesListPage {
	
	@FindBy(css=".btn.btn-default.dropdown-toggle.style-scope.bootstrap-dropdown")
	private WebElement sortBy;

	@FindBy(css=".form-control.style-scope.kodak-device-search")
	private WebElement hintText;
	

	@FindBy(css="ul[role='menu']")
	private WebElement dropDownList;

	
	public DevicesListPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifySortByDefaultValue(){
		String sortByText=sortBy.getText();
		return sortByText;
}
	
	public String getSearchTextHintVals(){
		String searchHint=hintText.getAttribute("placeholder");
		return searchHint;
}
	
	public void getSortComboVals(WebDriver driver){
		List<WebElement> elements =driver.findElements(By.cssSelector("ul[role='menu']>li>a"));

		for(WebElement ele:elements){
			ele.getText();
		   }
}
	}

