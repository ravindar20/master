package com.azure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class loginTest {
 public static void main(String  a[]){
	 System.setProperty("webdriver.chrome.driver", 
				"C:\\workspace_edureka\\libs\\chromedriver.exe");
		
  WebDriver driver= new ChromeDriver();
  driver.get("https://scansightweb.azurewebsites.net");
  WebElement   unameText=driver.findElement(By.cssSelector("#cred_userid_inputtext"));
  WebElement   passwordText=driver.findElement(By.cssSelector("#cred_password_inputtext"));
  WebElement   login=driver.findElement(By.cssSelector("#cred_sign_in_button"));
  unameText.clear();
  unameText.click();
  unameText.sendKeys("90000190@kodakalaris.com");
  passwordText.clear();
  passwordText.click();
  passwordText.sendKeys("Agasthya$2012");
  Actions action = new Actions(driver);
  action.moveToElement(login).build().perform();
  login.click();
 }
}