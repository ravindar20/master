package com.azure;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DeviceTest {
	LoginPage loginPage;
	CommonDriverUtil driverUtil=new CommonDriverUtil();
	DevicesListPage deviceList;
	WebDriver driver;
	@BeforeTest 
	@Parameters("browserType")
	public void openBrowser(String browserType){
		driverUtil.openBrowser(browserType);
		deviceList=new DevicesListPage(driverUtil.getDriver());
	}
	
	@Test(priority=1)
		private void loginTest(){
			String userName="90000190@kodakalaris.com";
			String pwd="Agasthya$2012";
			loginPage=new LoginPage(driverUtil.getDriver());
			loginPage.login(userName, pwd,driverUtil.getDriver());	
		}
	@Test(priority=2)
		private void verifySortDefalutVal(){	
		String expectedVal="Device ID";
		Assert.assertEquals(expectedVal, deviceList.verifySortByDefaultValue());
		
	}
	@Test(priority=3)
	private void verifySearchHint(){	
	String expectedVal="Device ID, company, model, etc.";
	Assert.assertEquals(expectedVal, deviceList.getSearchTextHintVals());
	
	}
	@Test(priority=4)
	private void verifydropdwonval(){
		deviceList.getSortComboVals(driverUtil.getDriver());
	}
	
	@AfterTest
	private void close(){
		driverUtil.closeAllBrowser();
	}
	


}
