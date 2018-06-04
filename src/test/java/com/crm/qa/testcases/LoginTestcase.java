package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.Test;

import com.crm.qa.base.TestBase1;
import com.crm.qa.pages.HomePage;

import com.crm.qa.pages.LoginPage1;



public class LoginTestcase extends TestBase1 {
	LoginPage1 login;
	HomePage homepage;

	public LoginTestcase() {
		super();
		
		
	}

	
	@BeforeMethod
	public void setUp() {
		initialization();
		login = new LoginPage1();



	}

	
	 @Test(priority = 1) 
	 public void LoginPageTitle()
	 { 
		 String title = login.validateLoginPageTitle();
	 
	  Assert.assertEquals(title,"#1 Free CRM for Any Business: Online Customer Relationship Software");
	 
	  }
	 
	 @Test(priority=3)
	 public void pricingLink()
	 {
		boolean flag= login.validatePricingLink();
		Assert.assertTrue(flag);
	 }
	 
	@Test(priority = 2)

	public void validateLogin() throws InterruptedException {
		String t1 = prop.getProperty("username");
		String t2 = prop.getProperty("password");
		if (login != null)
			homepage = login.loginTest(t1,t2);
			
		

	}
	
@AfterMethod

	public void endUp() {
		driver.quit();
	}


}
