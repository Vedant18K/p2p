package com.wadiaa.lending.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class waive_Off_Guarantor {
	

	private WebDriver driver;
	
	@FindBy(xpath = "//a[@href='#borrowerDetails']")private WebElement BorrowerDetails;
	@FindBy(xpath = "//button[@class='flex flex-row border text-sm py-2 px-3 rounded-3xl font-medium text-black bg-[#fff] truncate ml-2 items-center']") private WebElement waiveoff;
	@FindBy(xpath = "//textarea[@placeholder='Enter remark for Waive Off']") private WebElement Remark;
	@FindBy(xpath = "//button[@class='bg-[#3F5C88] text-white text-xs font-normal rounded py-2 w-full ml-3 disabled:opacity-60']") private WebElement Submit;
	
	
	
	
	public waive_Off_Guarantor(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void waiveOffGuarantor() throws InterruptedException {
		BorrowerDetails.click();
		Thread.sleep(1000);
		waiveoff.click();
		Thread.sleep(1000);
		Remark.sendKeys("Checked");
		Thread.sleep(1000);
		Submit.click();
	}
}
