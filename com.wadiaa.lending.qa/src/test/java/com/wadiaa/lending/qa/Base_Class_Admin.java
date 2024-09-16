package com.wadiaa.lending.qa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Base_Class_Admin {

	 protected static WebDriver driver;
	 
		@BeforeSuite
	    public void setup() {
	        System.setProperty("webdriver.chrome.driver", "D:\\Automation eclips\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--start-maximized");
	        driver = new ChromeDriver(options);
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.get("https://lending.wadiaa.com/login");
	    }
		
	   @BeforeClass
	    public void login() throws InterruptedException {
	    	Lending_Login_Page lendingLoginPage = new Lending_Login_Page(driver);
	        String expectedUrl = "https://lending.wadiaa.com/login";
	        WebDriverWait wait = new WebDriverWait(driver, 50); // Adjust timeout as needed
	        wait.until(ExpectedConditions.urlToBe(expectedUrl));
	        lendingLoginPage.adminEmailInputField();
	        lendingLoginPage.adminPasswordField();
	        lendingLoginPage.adminLoginButton();
	    }
	    

//	    @AfterSuite
//	    public void tearDown() {
//	        if (driver != null) {
//	            driver.quit();
//	        }
//	    }
//	
}
