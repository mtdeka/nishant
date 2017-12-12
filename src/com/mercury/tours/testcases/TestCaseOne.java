package com.mercury.tours.testcases;

import java.util.concurrent.TimeUnit;

import org.apache.http.util.Asserts;
import org.openqa.selenium.WebElement;





import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mercury.tours.pages.BookFlightPage;
import com.mercury.tours.pages.FlightConfirmationPage;
import com.mercury.tours.pages.FlightFinderPage;
import com.mercury.tours.pages.HomePage;
import com.mercury.tours.pages.SelectPage;
import com.mercury.tours.utils.BrowserDrivers;

public class TestCaseOne {
	
	
	public BrowserDrivers bs = new BrowserDrivers();
	
	
	@BeforeTest
	public void openBrowser(){
			
		bs.launchBrowser("firefox");
	 System.out.println("Browser launched succesfully : Before TEST");
	 
	 
	}

	@Test
	public void roundTripTicket(){
		
		
	bs.driver.get("http://newtours.demoaut.com/mercurywelcome.php");
     
     bs.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     
     WebElement usrName = bs.driver.findElement(HomePage.userName);
     
     WebElement pwd = bs.driver.findElement(HomePage.passWord);
     
     usrName.sendKeys("nish_test");
     
     pwd.sendKeys("tester");
     
     bs.driver.findElement(HomePage.signInLink).click();
     
     System.out.println("User logged in successfully");
     
     bs.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
     
     bs.driver.findElement(FlightFinderPage.roundTripRdoBtn).click();
     
     bs.driver.findElement(FlightFinderPage.economyRdBtn).click();
     
     bs.driver.findElement(FlightFinderPage.continBtn).click();
     
     bs.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);     
     
     bs.driver.findElement(SelectPage.bkAirlines360).click();
     
     bs.driver.findElement(SelectPage.bkAirlines631).click();
     
    bs.driver.findElement(SelectPage.continueBtn).click();
    
    bs.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
    
    bs.driver.findElement(BookFlightPage.firstNameTxtBox).sendKeys("Nishant");
    
    bs.driver.findElement(BookFlightPage.lastNameTxtBox).sendKeys("tester");
    
    bs.driver.findElement(BookFlightPage.creditNumber).sendKeys("1234567890");
    
    bs.driver.findElement(BookFlightPage.purchaseBtn).click();
    
    bs.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    
   WebElement image = bs.driver.findElement(FlightConfirmationPage.flightConfirmationImg);
   
   if((image).isDisplayed()){
	   
	   System.out.println("Round trip ticket booked successfully");
	   
   }
   
   else{
    System.out.println("Unable to book the ticket");
     
	}
	

	}
	
	@AfterTest
	public void closeBrowser(){
		
		   bs.driver.quit();
		   System.out.println("TestCaseOne : Browser closed successfully");
		   
	}
	
}
	
	

