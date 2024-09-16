package com.wadiaa.lending.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Lending_Login_Page {
	
	@FindBy(xpath = "//input[@type='email']")private WebElement wadiaEmail;
	@FindBy(xpath = "//input[@type='password']")private WebElement wadiaPassword;
	@FindBy(xpath = "//span[@class='flex items-center justify-center']")private WebElement wadiaLogin;
	@FindBy(xpath = "//button[@class='w-full px-4 py-2 tracking-wide text-sm font-medium text-white transition-colors duration-200 transform bg-[#3F5C88] rounded  focus:outline-none disabled:opacity-60']")private WebElement adminLogin;
	
	

	public Lending_Login_Page(WebDriver driver) {
		PageFactory.initElements( driver , this);
	}
	
	public void testWadiaEmailInputField() {
		Assert.assertTrue(wadiaEmail.isDisplayed(), "Wadia Email is Display");
		wadiaEmail.sendKeys("batoxa4335@maxturns.com");

	}

	public void testWadiaPasswordField() {
		Assert.assertTrue(wadiaPassword.isDisplayed(), "Wadia Password is Display");
		wadiaPassword.sendKeys("Sample@123");
	}

	public void testWadiaLoginButton() {
		Assert.assertTrue(wadiaLogin.isDisplayed(), "Wadia Login Button is Display");
		wadiaLogin.click();
	}
	
	// Admin Credential
	
	public void adminEmailInputField() {
		Assert.assertTrue(wadiaEmail.isDisplayed(), "Wadia Email is Display");
		wadiaEmail.clear();
		wadiaEmail.sendKeys("admin@test.com");

	}

	public void adminPasswordField() {
		Assert.assertTrue(wadiaPassword.isDisplayed(), "Wadia Password is Display");
		wadiaPassword.clear();
		wadiaPassword.sendKeys("Sample@123");
	}

	public void adminLoginButton() {
		Assert.assertTrue(adminLogin.isDisplayed(), "Wadia Login Button is Display");
		adminLogin.click();
	}
	
}
