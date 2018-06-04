package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase1;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage1;

import com.crm.qa.utility.TestUtil;
import com.crm.qa.pages.CasesPage;

public class HomeTestcase extends TestBase1{

	LoginPage1 login1;
	HomePage home;
	CasesPage case1;
	TestUtil util;
	
	public HomeTestcase()
	{
		super();
	}
	
	
	@BeforeMethod
	public void setUP()
	{
		initialization();
		login1=new LoginPage1();
		home=new HomePage();
		util=new TestUtil();
		home=login1.loginTest(prop.getProperty("username"), prop.getProperty("password"));
		
		
		
	}
	
	
	@Test(priority=4)
	public void homePageTitle()
	{
		String title=home.validateCRMPROLogo();
		Assert.assertEquals(title, "CRMPRO");
	}
	
	@Test(priority=2)
	public void casesLink()
	{
		home.validateCaseLink();
	}
	@Test(priority=3)
	public void validateCaseLink()
	{
		case1=home.validateClickOnCaseLink();
	}
	
	@Test(priority=1)
	
	public void fullSearchLink()
	{
		home.validateClickOnFullSearchLink();
	}
	
	@AfterMethod

	public void endUp() {
		driver.quit();
	}


	
	
	
}
