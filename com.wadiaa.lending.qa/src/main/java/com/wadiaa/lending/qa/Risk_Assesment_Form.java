package com.wadiaa.lending.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Risk_Assesment_Form {
    
	@FindBy(xpath = "//a[@href='#riskAssessment']")private WebElement RiskAssement;
    @FindBy(xpath = "//select[@name='beneficialOwnersScore']") private WebElement beneficialOwnersScore;
    @FindBy(xpath = "//select[@name='marketedCheckings']") private WebElement marketedCheckings;
    @FindBy(xpath = "//select[@name='siteVisit']") private WebElement siteVisit;
    @FindBy(xpath = "//input[@name='minYearsInBusiness']") private WebElement minYearsInBusiness;
    @FindBy(xpath = "//input[@name='mgmtExperience']") private WebElement mgmtExperience;
    @FindBy(xpath = "//select[@name='tangibleNetWorth']") private WebElement tangibleNetWorth;
    @FindBy(xpath = "//select[@name='positiveNetProfit']") private WebElement positiveNetProfit;
    @FindBy(xpath = "//input[@name='ebitda']") private WebElement ebitda;
    @FindBy(xpath = "//input[@name='currentRatio']") private WebElement currentRatio;
    @FindBy(xpath = "//input[@name='levarage']") private WebElement levarage;
    @FindBy(xpath = "//input[@name='operatingMargin']") private WebElement operatingMargin;
    @FindBy(xpath = "//input[@name='netMargin']") private WebElement netMargin;
    @FindBy(xpath = "//input[@name='buyerShare']") private WebElement buyerShare;
    @FindBy(xpath = "//input[@name='salesGrowth']") private WebElement salesGrowth;
    @FindBy(xpath = "//select[@name='yoyGrowth']") private WebElement yoyGrowth;
    @FindBy(xpath = "//select[@name='deviation']") private WebElement deviation;

    @FindBy(xpath = "//button[@class='btn bg-[rgb(63,92,136)] text-white w-4/6 rounded opacity-100 ']") private WebElement SubmitButton;
    @FindBy(xpath = "//span[@class='bg-transparent text-[#111827] h-6 w-6 text-2xl block outline-none focus:outline-none']") private WebElement CloseResult;
    
    
    // Case Login Form 
    @FindBy(xpath = "//input[@name='isAmountsAreSame']") private WebElement isAmountsAreSame;
    @FindBy(xpath = "(//input[@autocapitalize='none'])[2]") private WebElement selectValidator;
    @FindBy(xpath = "//select[@name='assignedApprovalAuthorityId']") private WebElement assignedApprovalAuthorityId;
    @FindBy(xpath = "//button[@class='btn bg-[rgb(63,92,136)] text-white w-4/6 rounded opacity-100 ']") private WebElement nextButton;
    @FindBy(xpath = "//input[@name='isTenuresAreSame']") private WebElement isTenuresAreSame;
    @FindBy(xpath = "//input[@placeholder='Enter No. of Advance Monthly Installments']")private WebElement noofadvemi;
    @FindBy(xpath = "//select[@name='modeOfDisburement']")private WebElement modeOfDisburement;
    @FindBy(xpath = "//input[@placeholder='Enter File Charges']")private WebElement fileCharges;    
    @FindBy(xpath = "//input[@placeholder='Enter Processing Charges']")private WebElement processingCharges; 
    @FindBy(xpath = "//input[@placeholder='Enter Late Payment Charges']")private WebElement latePaymentCharges; 
    @FindBy(xpath = "//input[@placeholder='Enter Foreclosure Charges']")private WebElement foreClosureCharges; 
    @FindBy(xpath = "//input[@placeholder='Enter Stamping Charges']")private WebElement stampingCharges; 
    
    
    private WebDriver driver;

    public Risk_Assesment_Form(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillRiskAssesmentForm() throws InterruptedException {
    	RiskAssement.click();
    	Thread.sleep(1000);
        new Select(beneficialOwnersScore).selectByVisibleText("Clean report obtained");
        new Select(marketedCheckings).selectByVisibleText("Positive");
        new Select(siteVisit).selectByVisibleText("Yes");
        
        minYearsInBusiness.sendKeys("12");
        mgmtExperience.sendKeys("12");

        new Select(tangibleNetWorth).selectByVisibleText("Yes");
        new Select(positiveNetProfit).selectByValue("2");

        ebitda.sendKeys("12");
        currentRatio.sendKeys("12");
        levarage.sendKeys("12");
        operatingMargin.sendKeys("12");
        netMargin.sendKeys("12");
        buyerShare.sendKeys("12");
        salesGrowth.sendKeys("12");

        new Select(yoyGrowth).selectByVisibleText("Last 3 years is positive");
        new Select(deviation).selectByVisibleText("Yes");

        SubmitButton.click();
        Thread.sleep(1000);
        CloseResult.click();
    }
    
    
    public void caseLogin() throws InterruptedException {
    	Thread.sleep(1000);
    	
    	isAmountsAreSame.click();
    	selectValidator.sendKeys("Hamza Al Lawati");
    	selectValidator.sendKeys("Approval Authority");
    	Select s = new Select(assignedApprovalAuthorityId);
    	s.selectByIndex(1);
    		
    	
    	nextButton.click();
   
    	isTenuresAreSame.click();
    	noofadvemi.sendKeys("0");
    	Select s1 = new Select(modeOfDisburement);
    	s1.selectByVisibleText("Bank Transfer");
    
    	nextButton.click();
    	
    	fileCharges.sendKeys("0");
    	processingCharges.sendKeys("0");
    	latePaymentCharges.sendKeys("12");
    	foreClosureCharges.sendKeys("224");
    	stampingCharges.sendKeys("0");
    	
    	nextButton.click();
    
    }
    
}
