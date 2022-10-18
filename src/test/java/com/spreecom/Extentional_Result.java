package com.spreecom;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Extentional_Result {
	
	
	static String filePath = System.getProperty("user.dir");

	static String Relativepath_failure = filePath + "\\Screenshot_Failure";
	static String Relativepath_success = filePath + "\\Screenshot_Success";

	public static String getScreenshotfailure(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
	            //after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = Relativepath_failure + "//"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}


}

