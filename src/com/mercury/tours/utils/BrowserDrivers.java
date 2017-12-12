package com.mercury.tours.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserDrivers {
	
	public WebDriver driver;
	
public void launchBrowser(String browser){
		
	
		
		if(browser.equalsIgnoreCase("firefox")){
			
		
			System.setProperty("webdriver.gecko.driver","F:\\Drivers\\geckodriver.exe");
	
			driver = new FirefoxDriver();
		//	TestCaseFlows.browserDriver = new FirefoxDriver();
			System.out.println("Launched Firefox browser");					
		}
		
		else if(browser.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "F:\\Selen\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
						
		}
		
		else if(browser.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			System.out.println("Launced IE browser");
						
		}
		
		else{
			System.out.println("Browser is incorrect");
		}
		
	}

}
