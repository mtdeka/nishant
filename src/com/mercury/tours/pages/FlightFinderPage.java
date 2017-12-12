package com.mercury.tours.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class FlightFinderPage {
	
	public static By roundTripRdoBtn = By.xpath("//input[@value='roundtrip']");
	
	public static By oneWyRdoBtn = By.xpath("//input[@value='oneway']");
	
	//Select passngrs = new Select(element)
	
	public static By economyRdBtn = By.xpath("//input[@value='Coach']");
	
	public static By businessRdBtn = By.xpath("//input[@value='Business']");
	
	public static By firstRdBtn = By.xpath("//input[@value='First']");
	
	public static By continBtn = By.name("findFlights");
	
	public static By signOffLink = By.linkText("SIGN-OFF");

}
