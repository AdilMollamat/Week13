package com.selenium.week13;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.customlibrary.ExcelReadWrite;

public class ExcelDataProfiderTests {

	WebDriver driver;
	
	@DataProvider(name = "Login")
	public static Object[][] credentials()
	{
		ExcelReadWrite reader = new ExcelReadWrite("src/test/resources/testData.xls");
		return reader.getExcelData("Sheet1");
		//return new Object[][]{
		//{"testUser1", "testUserPass1"}, {"testUser2", "testUserPass2"},{"test0014524@gmail.com", "0123456789+-a"}};
	}
	
	@Test(dataProvider = "Login")
	public void loginTest(String userName, String userPassword) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.gmail.com/");
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys(userName);
		driver.findElement(By.id("next")).click();
		Thread.sleep(3*1000);
		
		driver.findElement(By.id("Passwd")).clear();
		driver.findElement(By.id("Passwd")).sendKeys(userPassword);
		Thread.sleep(3*1000);
		//driver.findElement(By.id("signIn")).click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
