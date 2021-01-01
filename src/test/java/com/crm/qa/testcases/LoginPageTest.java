package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.Loginpage;

public class LoginPageTest extends Testbase{
	
	Loginpage loginPage;
	Homepage homepage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new Loginpage();
	
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginpagetitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority = 2)
	public void crmlogoImageTest() {
		Boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
			
	}
	
	@Test(priority = 3)
	public void loginTest() {
		homepage = loginPage.LogIn(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		
	}

}


