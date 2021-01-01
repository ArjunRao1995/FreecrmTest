package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class Loginpage extends Testbase {
	
	//PageFactory : OR
	@FindBy(name = "username")
		WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type = 'submit']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[contains(text(), 'Sign Up')]")
	WebElement signupBtn;
	
	@FindBy(xpath = "//img[contains(@class, 'img-responsive')]")
	WebElement crmLogo;
	
	//Initializing Page Objects
	public Loginpage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginpagetitle() {
		return driver.getTitle();
	}
	
	public Boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public Homepage LogIn(String un, String pwd) {
		
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();

		return new Homepage();
	}

}
