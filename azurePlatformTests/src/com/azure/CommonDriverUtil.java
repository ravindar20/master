package com.azure;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonDriverUtil {
	private WebDriver driver;
	
	
	public void openBrowser(String browserType) {
		try {
			System.out.println();
			browserType = browserType.trim();
			if (browserType.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();

			} else if (browserType.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"D:\\edureka examples\\lib\\chromedriver.exe");
				driver = new ChromeDriver();

			} else if (browserType.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver",
						"D:\\edureka examples\\lib\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			} else {
				throw new Exception("Invalid BrowserType : " + browserType);
			}

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();

			driver.manage().timeouts().pageLoadTimeout(60l, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30l, TimeUnit.SECONDS);

			driver.get("https://scansightweb.azurewebsites.net");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public WebDriver getDriver(){
		try {
			if(driver==null){
				System.setProperty("webdriver.chrome.driver",
						"D:\\edureka examples\\lib\\chromedriver.exe");
				driver = new ChromeDriver();

			}
			return driver;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void closeAllBrowser(){
		try {
			driver.quit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void clickWhenReady(WebDriver driver, WebElement locator, int
			iTimeout) {
			WebDriverWait wait = new WebDriverWait(driver, iTimeout);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			
			}

public void waitForPageLoaded(WebDriver driver) {
    ExpectedCondition<Boolean> expectation = new
            ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                }
            };
    try {
        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(expectation);
    } catch (Throwable error) {
        Assert.fail("Timeout waiting for Page Load Request to complete.");
    }
}
	
	

}
