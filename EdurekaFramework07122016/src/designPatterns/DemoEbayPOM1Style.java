package designPatterns;

import commonLibs.CommonDriver;

public class DemoEbayPOM1Style {

	public static void main(String[] args) {
		
		CommonDriver Driver = new CommonDriver();
		
		Driver.setPageLoadTimeout(90l);
		Driver.setElementDetectionTimeout(30l);
		Driver.openBrowser("chrome", "http://ebay.in");
		
		EbayPOM1Style homePage = new EbayPOM1Style(Driver.getDriver());
		
		homePage.searchBox.sendKeys("Apple Watch");
		
		homePage.dropDown.selectByVisibleText("Watches");
		
		homePage.searchButton.click();
		
		Driver.closeBrowser();
	}

}
