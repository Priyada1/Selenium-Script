package com.crm.qa.utility;
/****************************************purpose**********************************
 * Taking Screenshots whenever any Error occurs,it takes screenshots and save it in "Screenshots" Folder
 */
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.TestBase1;

public class TestUtil extends TestBase1
{

	
	public static void takeScreenshotAtEndOfTest() throws IOException
	{
		File scrFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String currentDir=System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir+"/Screenshots/"+System.currentTimeMillis()+".png"));
	}
	
}
