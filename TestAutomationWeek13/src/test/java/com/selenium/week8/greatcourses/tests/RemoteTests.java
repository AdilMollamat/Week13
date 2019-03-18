package com.selenium.week8.greatcourses.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class RemoteTests {

	WebDriver driver;
	String hubURL = "http://192.168.1.14:8789/wd/hub/";
	
	@Test
	public void testing_selenium_remote() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		cap.setBrowserName("internet explorer");
		driver = new RemoteWebDriver(new URL(hubURL), cap);		
		driver.get("http://www.google.com/");
		Thread.sleep(20 * 1000);
	}
}
