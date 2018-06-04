package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase1;

public class HomePage extends TestBase1 {
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(@title,'Cases')]")
	WebElement cases;
	
	@FindBy(xpath="//a[contains(@title,'Full Search Form')]")
	WebElement fullSearch;
	
	@FindBy(xpath="//td[contains(text(),'CRMPRO')]")
	WebElement logo;
	
	@FindBy(xpath="//a[contains(@title,'Campaigns')]")
	WebElement campaign;
	
	
	public String validateCRMPROLogo() {
		System.out.println("Home page title is" + driver.getTitle());
		return driver.getTitle();
	}
	
	public boolean validateCaseLink()
	{
		driver.switchTo().frame("mainpanel");
		return cases.isDisplayed();
	}
	
	public CasesPage validateClickOnCaseLink()
	{
		driver.switchTo().frame("mainpanel");
		 cases.click();
		 return new CasesPage();
	}
	
	public void validateClickOnFullSearchLink()
	{
		Actions act=new Actions(driver);

		driver.switchTo().frame("mainpanel");
		act.moveToElement(cases).click(fullSearch).build().perform();
		
		
		 
	}
	
	
	
	

}
