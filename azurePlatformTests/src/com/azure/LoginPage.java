package com.azure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends CommonDriverUtil {
	@FindBy(css="#cred_userid_inputtext")
	private WebElement   unameText;

	@FindBy(css="#cred_password_inputtext")
	private WebElement   passwordText;
	
	@FindBy(css="#cred_sign_in_button")
	@CacheLookup
	private WebElement   login;


	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
		
	}
	public void login(String uname,String pass,WebDriver driver){
		unameText.clear();
		unameText.click();
		unameText.sendKeys(uname);
		passwordText.clear();
		passwordText.click();
		passwordText.sendKeys(pass);
		WebDriverWait wait = new WebDriverWait(driver, 5000);
		WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cred_sign_in_button")));
		ele.click();
		
		/*Actions action = new Actions(driver);
		  action.moveToElement(login).build().perform();
		  login.click();
		*/ 
		/*WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cred_sign_in_button")));
		ele.click();
		waitForPageLoaded(driver);
		*/
		

		
	}	
	//WebElement unameText=driver.findElement(By.cssSelector("#cred_userid_inputtext"));
	//WebElement passwordText=driver.findElement(By.cssSelector("#cred_password_inputtext")); 
	//WebElement login=driver.findElement(By.cssSelector("#cred_sign_in_button"));
	
}
