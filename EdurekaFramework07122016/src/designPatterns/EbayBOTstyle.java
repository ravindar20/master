package designPatterns;

import org.openqa.selenium.By;

import commonLibs.CommonDriver;

public class EbayBOTstyle {

	public static void main(String[] args) {
		
		CommonDriver Driver = new CommonDriver();
		String url = "http://www.ebay.in";
		Driver.setPageLoadTimeout(90l);
		Driver.setElementDetectionTimeout(30l);
		Driver.openBrowser("chrome", url);
		
		Driver.setText(By.id("gh-ac"), "Apple Watches");
		
		Driver.selectViaVisibleText(By.id("gh-cat"), "Watches");
		
		Driver.click(By.id("gh-btn"));
		
		String result = Driver.getText(By.className("listingscnt"));
		
		System.out.println("Result is : "+ result);
		Driver.closeAllBrowser();
	}

}
