/*package com.selenium.customlibrary.report;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentTestNGReportBuilder {

	private static ExtentReports extent;
	private static ThreadLocal parentTest = new ThreadLocal();
	private static ThreadLocal test = new ThreadLocal();

	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.createInstance("extent.html");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		extent.attachReporter(htmlReporter);
	}

	@BeforeClass
	public synchronized void beforeClass() {
		ExtentTest parent = extent.createTest(getClass().getName());
		parentTest.set(parent);
	}

	@BeforeMethod
	public synchronized void beforeMethod(Method method) {
		ExtentTest child = parentTest.get().createNode(method.getName());
		test.set(child);
	}

	@AfterMethod
	public synchronized void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE)
			test.get().fail(result.getThrowable());
		else if (result.getStatus() == ITestResult.SKIP)
			test.get().skip(result.getThrowable());
		else
			test.get().pass("Test passed");

		extent.flush();
	}
}


 * public class ExtentManager {
 * 
 * private static ExtentReports extent;
 * 
 * public static ExtentReports getInstance() { if (extent == null)
 * createInstance("test-output/extent.html");
 * 
 * return extent; }
 * 
 * public static ExtentReports createInstance(String fileName) {
 * ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
 * htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
 * htmlReporter.config().setChartVisibilityOnOpen(true);
 * htmlReporter.config().setTheme(Theme.STANDARD);
 * htmlReporter.config().setDocumentTitle(fileName);
 * htmlReporter.config().setEncoding("utf-8");
 * htmlReporter.config().setReportName(fileName);
 * 
 * extent = new ExtentReports(); extent.attachReporter(htmlReporter);
 * 
 * return extent; } }
 */