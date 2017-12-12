package com.mercury.tours.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mercury.tours.pages.FlightFinderPage;
import com.mercury.tours.pages.HomePage;
import com.mercury.tours.pages.SignOnPage;
import com.mercury.tours.utils.BrowserDrivers;

public class TestCaseTwo {
	
	public BrowserDrivers bs = new BrowserDrivers();
	
	@BeforeTest
	public void openBrowser(){
		
		bs.launchBrowser("firefox");
	 System.out.println("Browser launched succesfully ");
	 
	 }

	@Test
	public void validateCred(){
		
		bs.driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		
		// validate the invalid user name and password
		
		bs.driver.findElement(HomePage.userName).sendKeys("asdad");
		
		bs.driver.findElement(HomePage.passWord).sendKeys("invafgdg");
		
		bs.driver.findElement(HomePage.signInLink).click();
		
		bs.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
		
		WebElement image = bs.driver.findElement(SignOnPage.signOnImg);
		
		System.out.println("It was invalid user name and password");
		
		if(image.isDisplayed()){
		
		// empty user name and password
			bs.driver.findElement(SignOnPage.userName).sendKeys("");
			
			bs.driver.findElement(SignOnPage.passWord).sendKeys("");
			
			bs.driver.findElement(SignOnPage.loginBtn).click();
			
			bs.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
			
			System.out.println("User name and password were empty");
			
			// valid username and invalid password
			
            bs.driver.findElement(SignOnPage.userName).sendKeys("nish_test");
			
			bs.driver.findElement(SignOnPage.passWord).sendKeys("ads234");
			
			bs.driver.findElement(SignOnPage.loginBtn).click();
			
			bs.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			System.out.println("valid User name and invalid password");
		
		// invalid username and valid password
		
		bs.driver.findElement(SignOnPage.userName).sendKeys("ads234");
		
		bs.driver.findElement(SignOnPage.passWord).sendKeys("tester");
		
		bs.driver.findElement(SignOnPage.loginBtn).click();
		
		bs.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		System.out.println("invalid User name and valid password");
		
		// valid username and valid password
		
        bs.driver.findElement(SignOnPage.userName).sendKeys("nish_test");
		
		bs.driver.findElement(SignOnPage.passWord).sendKeys("tester");
		
		bs.driver.findElement(SignOnPage.loginBtn).click();
		
		bs.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		System.out.println("User logged in sucessfully");
		
		bs.driver.findElement(FlightFinderPage.signOffLink).click();
			
		System.out.println("User logged out sucessfully");
			
		}
		else{
			System.out.println("Unable to find image");
		}
		
		bs.driver.quit();
	}
	
	@AfterTest
	public void closeBrowser(){
		
		   bs.driver.quit();
		   System.out.println("TestCaseTwo : Browser closed successfully");
	}
	
	@AfterSuite
	public void emailSend(){
		try {
			//SendEmailSSL SM = new SendEmailSSL();
			SendEmailSSL.execute("Execution status report");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

