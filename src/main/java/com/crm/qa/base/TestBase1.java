package com.crm.qa.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.utility.WebEventListeners;

public class TestBase1 {

	// why driver is static????????????????
	public static  WebDriver driver;
	public  static Properties prop;
	EventFiringWebDriver e_driver;

	public TestBase1() {
		try {
			prop = new Properties();

			FileInputStream fis = new FileInputStream(
					"G:/eclipse-workspace/GenerateReport/src/main/java/configuration/config.properties");

			prop.load(fis);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialization() {

		System.setProperty("webdriver.firefox.marionette", "G:/geckoDriver/geckodriver-v0.19.1-win64/geckodriver.exe");
		driver = new FirefoxDriver();

		
		e_driver= new EventFiringWebDriver(driver);
		
		WebEventListeners eventListener=new WebEventListeners();
		e_driver.register(eventListener);
		
		driver=e_driver;
		
	
		
		if (driver != null) {
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();

			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.get(prop.getProperty("url"));
		}

	}

}
