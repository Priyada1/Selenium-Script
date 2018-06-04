package com.crm.qa.pages;

import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase1;



//import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage1 extends TestBase1 {

	

	@FindBy(xpath ="//img[Contains(@class,'img-responsive')]")

	WebElement crmlogo;

	@FindBy(xpath ="//*[@id='navbar-collapse']/ul/li[3]/a")
	WebElement pricing;

	@FindBy(xpath="//input[contains(@name,'username')]")
	WebElement userName;

	@FindBy(xpath ="//input[contains(@type,'password')]")
	WebElement password;

	@FindBy(xpath ="//input[contains(@type,'submit')]")

	WebElement loginbtn;
	
	// Initializing the Page Objects:
		// by using this keyword, we can use all elements of LoginPage1 class via
		// driver(which is defined variable in TestBase class)
	/*Page Factory is an inbuilt Page Object Model concept for Selenium WebDriver but it is very 
	 * optimized.
	 * Here as well, we follow the concept of separation of Page Object Repository and Test Methods. 
	 * Additionally, with the help of PageFactory class, we use annotations @FindBy to find WebElement.
	 *  We use initElements method to initialize web elements
		
	 */

public LoginPage1() {
			PageFactory.initElements(driver, this);
		}

	public String validateCRMLogo() {
		System.out.println("Login page title is" + driver.getTitle());
		return driver.getTitle();
	}

	public String validateLoginPageTitle() 
	{
		System.out.println("Login page title is" +driver.getTitle());
		return driver.getTitle();
	}

	public boolean validatePricingLink() {
		return pricing.isDisplayed();
	}

	public HomePage loginTest(String username, String pass)  {
		userName.sendKeys(username);
		password.sendKeys(pass);
		loginbtn.submit();
		
		
		
		
		return new HomePage();

	}

}
