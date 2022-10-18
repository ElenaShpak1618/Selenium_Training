package com.spreecom;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Base_Class_Nes {
	static ExtentSparkReporter htmlReporter;
	static ExtentReports extent;
	//helps to generate the logs in test report.
	static ExtentTest test;
	
	public static ExtentTest startReport() {
	
		// initialize the HtmlReporter
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") +"/test-output/Base_Class_Nes.html");
		//initialize ExtentReports and attach the HtmlReporter
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		//To add system or environment info by using the setSystemInfo method.
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Browser", "Chrome Latest");
		extent.setSystemInfo("QA Name", "Elena");

		//configuration items to change the look and feel
		//add content, manage tests etc
		//htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("WebOrder - Extent Report");
		htmlReporter.config().setReportName("Smoke Test Report");
		//htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		return test;
	}
	

}
