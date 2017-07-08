package designPatterns;

import commonLibs.CommonDriver;

public class DemoEbayPOM2Style {

	public static void main(String[] args) {
		CommonDriver Driver = new CommonDriver();
		
		Driver.setPageLoadTimeout(90l);
		Driver.setElementDetectionTimeout(30l);
		Driver.openBrowser("chrome", "http://ebay.in");
		
		EbayPOM2Style homePage = new EbayPOM2Style(Driver.getDriver());
		
		homePage.searchProduct("Apple Watch", "Watches");
	}

}
