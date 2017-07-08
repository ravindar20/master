package commonLibs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class KeywordUtility {	
	CommonDriver Driver;
	
	public KeywordUtility(){
		Driver  = new CommonDriver();
	}
	
	public String performAction(String sActionName, By oBy, String sValue){
		sActionName = sActionName.trim();
		
		if(sActionName.isEmpty()){
			return ""; 
		}
		
		if(sActionName.equalsIgnoreCase("click")){
			Driver.click(oBy);
			
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("openbrowser")){
			
			Driver.openBrowser(sValue, "about:blank");
		
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("setPageLoadTimeOut")){
			
			Driver.setPageLoadTimeout(Long.valueOf(sValue));
			
			
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("setElementDetectionTimeout")){
			
			Driver.setElementDetectionTimeout(Long.valueOf(sValue));
			
			
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("navigateToUrl")){
			
			Driver.navigateToUrl(sValue);
			
			
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("navigateBack")){
				
			Driver.getDriver().navigate().back();
				
				
				return "";
			}
			
		if(sActionName.equalsIgnoreCase("navigateForward")){
			
			Driver.getDriver().navigate().forward();
			
			
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("closeAllBrowser")){
			
			Driver.closeAllBrowser();
			
			
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("closeCurrentBrowser")){
			
			Driver.closeBrowser();
			
			
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("waitTillElementIsVisible")){
			
			
			Driver.waitTillElementVisible(oBy, Long.valueOf(sValue));
			
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("savepagesnapshot")){
			
			Driver.saveSnapShot(sValue);
			
			
			return "";
		}
		
		
		if(sActionName.equalsIgnoreCase("clear")){
			
			Driver.getDriver().findElement(oBy).clear();
			return "";
		}
		
		
		
		if(sActionName.equalsIgnoreCase("acceptAlert")){
			
			Driver.getDriver().switchTo().alert().accept();
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("rejectAlert")){
			
			Driver.getDriver().switchTo().alert().dismiss();
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("selectDefaultframe")){
			Driver.getDriver().switchTo().frame(sValue);
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("gettext")){
			return Driver.getText(oBy);
			 
		}
		
		if(sActionName.equalsIgnoreCase("getTitle")){
			return Driver.getTitle();
			 
		}
		
		if(sActionName.equalsIgnoreCase("getUrl")){
			return Driver.getCurrentUrl();
			 
		}
		
		if(sActionName.equalsIgnoreCase("setText")){
			 Driver.setText(oBy, sValue);
			 return "";
		}
		
		if(sActionName.equalsIgnoreCase("getstatus")){
			return String.valueOf(Driver.isSelected(oBy));
			 
		}
		
		
		
		if(sActionName.equalsIgnoreCase("selectitem")){
			Driver.selectItemFromDropdown(oBy, sValue);
			return "";
		}
		
		if(sActionName.equalsIgnoreCase("getItemsCount")){
			Select olist;
			WebElement oElement;
			
			oElement = Driver.getDriver().findElement(oBy);
			olist = new Select(oElement);
			
			return String.valueOf(olist.getOptions().size());
			
		}
		
		if(sActionName.equalsIgnoreCase("isvisible")){
			
			return String.valueOf(Driver.isDisplayed(oBy));
		}
		
				
		
		return "Error: Unknown keyword..";

	}

}
