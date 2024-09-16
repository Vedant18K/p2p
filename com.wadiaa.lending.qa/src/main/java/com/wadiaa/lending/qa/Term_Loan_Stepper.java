package com.wadiaa.lending.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Term_Loan_Stepper {
	
	//Loan Stepper 
	@FindBy(xpath ="//a[@href='/loan-application/term-loan/loan-process']") private WebElement WadiaFlexiLoanButton;
	@FindBy(xpath = "//input[@placeholder='Enter Amount']")private WebElement wadiaLoanAmount;
	@FindBy(xpath = "//input[@placeholder='Enter Tenure']")private WebElement wadiaLoanTenure;
	@FindBy(xpath = "//span[@class='flex items-center justify-center']")private WebElement NextButton;
	@FindBy(xpath = "//div[@class='flex justify-between w-full sm:w-2/5 md:w-3/5 lg:w-2/5 mt-12 mb-6 gap-3']//button[2]")private WebElement LoanTypeNextButton;
	@FindBy(xpath = "//select[@id='Business']") private WebElement ConstitutionofOrganization;
	@FindBy(xpath = "//select[@id='']") private WebElement PurposeofLoan;
	@FindBy(xpath = "//span[@class='flex items-center justify-center']") private WebElement LoanStepCompleted;
	
	//Personal Loan Details
	@FindBy(xpath = "//button[@class='w-full px-4 py-2 tracking-wide text-sm font-medium text-white transition-colors duration-200 transform bg-[#3F5C88] rounded  focus:outline-none disabled:opacity-60']")private WebElement personalNextButton;
	@FindBy(xpath = "//button[@class='w-1/2 px-4 py-2 tracking-wide text-sm font-medium text-white transition-colors duration-200 transform bg-[#3F5C88] rounded  focus:outline-none disabled:opacity-60']")private WebElement personalAddressNextButton;
	@FindBy(xpath = "//button[@class='w-1/2 px-4 py-2 tracking-wide text-sm font-medium text-white transition-colors duration-200 transform bg-[#3F5C88] rounded  focus:outline-none disabled:opacity-60']")private WebElement currentAddressNextButton;
		
	//If Business is already added 
	@FindBy(xpath = "//input[@type='checkbox']")private WebElement BusinessCheckBox;
	@FindBy(xpath = "//*[text()='Proceed']") private WebElement BusinessProceedButton;
	@FindBy(xpath = "//*[text()='Next']") private WebElement SelectedBusinessAddressNextButton;
	
	//KYC Next Button
	@FindBy(xpath = "//*[text()='Next']")private WebElement KYCNextButton;
	
	//Go to Loan Details 
	@FindBy(xpath = "//*[text()='Go to Loan Details']") private WebElement goToLoanDetailsButton;
	
	
	public Term_Loan_Stepper(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	// Loan Stepper 
	public void LoanStepper() {
		WadiaFlexiLoanButton.click();
		wadiaLoanAmount.sendKeys("50000");
		wadiaLoanTenure.sendKeys("13");
		NextButton.click();
		LoanTypeNextButton.click();
		Select s = new Select(ConstitutionofOrganization);
		s.selectByVisibleText("Sole Proprietorship (SPC)");
		Select s1 = new Select(PurposeofLoan);
		s1.selectByVisibleText("Trade finance");
		LoanStepCompleted.click();
		
		System.out.println("Loan Step Completed");
		
	}
	
	public void PersonalDetails() throws InterruptedException {
		personalNextButton.click();
		Thread.sleep(2000);
		personalAddressNextButton.click();
		Thread.sleep(2000);
		Assert.assertTrue(currentAddressNextButton.isDisplayed(),"Is Display");
		currentAddressNextButton.click();
		System.out.println("Personal Details Completed");
	}
	
	public void BusinessDetails() throws InterruptedException {
		Thread.sleep(3000);
		BusinessCheckBox.click();
		Thread.sleep(1000);
		BusinessProceedButton.click();
		SelectedBusinessAddressNextButton.click();
		
		System.out.println("Business Details Submited");
	}
	
	public void KYCDetails() {
		KYCNextButton.click();
		
		System.out.println("KYC Completed");
	}
	
	public void LoanDetails() {
		goToLoanDetailsButton.click();
		
		System.out.println("Loan Completed");
	}
}
