package commonLibs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonDriver {
	
	private WebDriver Driver;
	private long pageLoadTimeout;
	private long elementDetectionTimeout; //Implicit Wait
	
	public CommonDriver(){
		pageLoadTimeout = 60l;
		elementDetectionTimeout = 30l;
	}
	
	public void setPageLoadTimeout(long pageLoadTimeout){
		this.pageLoadTimeout = pageLoadTimeout;
	}
	
	public void setElementDetectionTimeout(long elementDetectionTimeout){
		this.elementDetectionTimeout = elementDetectionTimeout;
	}
	
	public void openBrowser(String browserType, String url){
		
		try {
			
			browserType = browserType.trim();
			
			url = url.trim();
			
			if(browserType.equalsIgnoreCase("ff") || 
					browserType.equalsIgnoreCase("firefox") 
					|| 
					browserType.equalsIgnoreCase("mozilla")
					|| 
					browserType.equalsIgnoreCase("mozilla firefox")) {
				Driver = new FirefoxDriver();
				
			} else if(browserType.equalsIgnoreCase("chrome") || 
					browserType.equalsIgnoreCase("google") 
					|| 
					browserType.equalsIgnoreCase("google chrome")
					) {
				System.setProperty("webdriver.chrome.driver", 
						"C:\\workspace_edureka\\libs\\chromedriver.exe");
				Driver = new ChromeDriver();
				
			} else if(browserType.equalsIgnoreCase("ie") || 
					browserType.equalsIgnoreCase("internet explorer") 
					|| 
					browserType.equalsIgnoreCase("explorer")
					) {
				System.setProperty("webdriver.ie.driver", 
						"C:\\workspace_edureka\\libs\\IEDriverServer.exe");
				Driver = new InternetExplorerDriver();
			} else {
				throw new Exception("Invalid BrowserType : "+browserType);
			}
			
			if(url.isEmpty()){
				url = "about:blank";
			}
			
			Driver.manage().window().maximize();
			Driver.manage().deleteAllCookies();
			
			Driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
			Driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);
			
			Driver.get(url);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
	}
	
	//-----------------------------------------------------------------------
	
	
	public void closeBrowser(){
		try {
			Driver.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//-----------------------------------------------------------------------
	
	
		public void closeAllBrowser(){
			try {
				Driver.quit();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	//-----------------------------------------------------------------------
		
		
		public void click(By oBy){
			try {
				Driver.findElement(oBy).click();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//-----------------------------------------------------------------------
		
		
				public void clear(By oBy){
					try {
						Driver.findElement(oBy).clear();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			//-----------------------------------------------------------------------
				
				
			public void setText(By oBy, String text){
					try {
						Driver.findElement(oBy).sendKeys(text);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			//-----------------------------------------------------------------------
			
			
			public WebDriver getDriver(){
					try {
						return Driver;
					} catch (Exception e) {
						e.printStackTrace();
						return null;
					}
				}
			
		//----------------------------------------------------------------------
			
			public String getText(By oBy){
				try {
				return	Driver.findElement(oBy).getText();
				} catch (Exception e) {
					e.printStackTrace();
					return "";
				}
			}
//----------------------------------------------------------------------
			
			public void selectViaVisibleText(By oBy, String item){
				try {
				
					Select dropdown = new Select(Driver.findElement(oBy));
					dropdown.selectByVisibleText(item);
					
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
//----------------------------------------------------------------------
			
			public void selectViaValue(By oBy, String item){
				try {
				
					Select dropdown = new Select(Driver.findElement(oBy));
					dropdown.selectByValue(item);
					
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
//----------------------------------------------------------------------
			
			public void deselectViaVisibleText(By oBy, String item){
				try {
				
					Select dropdown = new Select(Driver.findElement(oBy));
					dropdown.deselectByVisibleText(item);
					
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
//----------------------------------------------------------------------
			
			public void waitTillElementVisible(By oBy, long timeOutInSeconds){
				try {
				
					WebDriverWait wait = new WebDriverWait(Driver, timeOutInSeconds);
					
					wait.until(ExpectedConditions.visibilityOfElementLocated(oBy));
					
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
	//------------------------------------------------------------------
			
			public boolean isSelected(By oBy){
				try {
					
					return Driver.findElement(oBy).isSelected();
					
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}
			
//------------------------------------------------------------------
			
			public boolean isDisplayed(By oBy){
				try {
					
					return Driver.findElement(oBy).isDisplayed();
					
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}
//------------------------------------------------------------------
			
			public boolean isEnabled(By oBy){
				try {
					
					return Driver.findElement(oBy).isEnabled();
					
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}
}



