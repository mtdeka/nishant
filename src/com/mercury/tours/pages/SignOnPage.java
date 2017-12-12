package com.mercury.tours.pages;

import org.openqa.selenium.By;

public class SignOnPage {

	
    public static By userName = By.name("userName");
	
	public static By passWord = By.name("password");
	
	public static By signOnLink = By.linkText("SIGN-ON");
	
	public static By signOnImg= By.xpath("//img[contains(@src,'/images/masts/mast_signon.gif')]");
	
	public static By loginBtn = By.name("login");
	
	 // /images/forms/submit.gif
	
	
}
