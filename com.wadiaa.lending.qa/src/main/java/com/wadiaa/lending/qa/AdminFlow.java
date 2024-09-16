package com.wadiaa.lending.qa;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminFlow {

	private WebDriver driver;
	private Admin_Validate_Document adminValidateDocument;
	private Admin_Verify_Document adminVerifyButton;
	private Risk_Assesment_Form riskAssesementForm;
	private waive_Off_Guarantor waiveoffguarantor;

	// Web elements
	@FindBy(xpath = "//a[@href='/loan-management']")
	private WebElement LoanManagement;
	@FindBy(xpath = "(//a[@href='/loan-details/67/loan-details'])[1]")
	private WebElement SpecificLoan;
	@FindBy(xpath = "//a[@href='#documentDetails']")
	private WebElement LoanDocument;
	@FindBy(xpath = "(//div[@class='flex justify-between cursor-pointer transition-all duration-200 ease-in-out'])[1]")
	private WebElement Dropdown1;
	@FindBy(xpath = "(//div[@class='flex justify-between cursor-pointer transition-all duration-200 ease-in-out'])[2]")
	private WebElement Dropdown2;
	@FindBy(xpath = "(//div[@class='flex justify-between cursor-pointer transition-all duration-200 ease-in-out'])[3]")
	private WebElement Dropdown3;
	@FindBy(xpath = "(//div[@class='flex justify-between cursor-pointer transition-all duration-200 ease-in-out'])[4]")
	private WebElement Dropdown4;
	@FindBy(xpath = "(//div[@class='flex justify-between cursor-pointer transition-all duration-200 ease-in-out'])[5]")
	private WebElement Dropdown5;
	@FindBy(xpath = "(//div[@class='flex justify-between cursor-pointer transition-all duration-200 ease-in-out'])[6]")
	private WebElement Dropdown6;
	@FindBy(xpath = "(//div[@class='flex justify-between cursor-pointer transition-all duration-200 ease-in-out'])[7]")
	private WebElement Dropdown7;
	@FindBy(xpath = "(//div[@class='flex justify-between cursor-pointer transition-all duration-200 ease-in-out'])[8]")
	private WebElement Dropdown8;
	@FindBy(xpath = "(//div[@class='flex justify-between cursor-pointer transition-all duration-200 ease-in-out'])[9]")
	private WebElement Dropdown9;
	@FindBy(xpath = "(//div[@class='flex justify-between cursor-pointer transition-all duration-200 ease-in-out'])[10]")
	private WebElement Dropdown10;
	@FindBy(xpath = "(//div[@class='flex justify-between cursor-pointer transition-all duration-200 ease-in-out'])[11]")
	private WebElement Dropdown11;
	@FindBy(xpath = "//div[@class='ribbon bg-[#FFA600]']")
	private WebElement EnquiryStage;
	@FindBy(xpath = "//div[@class='ribbon bg-[#FFD700]']")
	private WebElement Docsverificationinprocess;
	@FindBy(xpath = "//div[@class='ribbon bg-[#ADD8E6]']")
	private WebElement Docsverified;
	@FindBy(xpath = "//a[@href='#riskAssessment']")
	private WebElement RiskAssement;


	public AdminFlow(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		adminValidateDocument = new Admin_Validate_Document(driver);
		adminVerifyButton = new Admin_Verify_Document(driver);
		riskAssesementForm = new Risk_Assesment_Form(driver);
		waiveoffguarantor = new waive_Off_Guarantor(driver);

	}

	public void specificLoan() throws InterruptedException {
	    LoanManagement.click();
	    SpecificLoan.click();
	    Thread.sleep(2000); // Wait for the page to load (adjust as needed)

	    List<WebElement> dropdowns = Arrays.asList(Dropdown1, Dropdown2, Dropdown3, Dropdown4, Dropdown5, Dropdown6,
	            Dropdown7, Dropdown8, Dropdown9, Dropdown10, Dropdown11);

	    boolean actionTaken = false;

	    if (isElementVisible(EnquiryStage)) {
	        // Validate documents
	        adminValidateDocument.validateDocument(dropdowns);
	        actionTaken = true;
	    }

	    if (isElementVisible(Docsverificationinprocess)) {
	        // Verify documents
	        adminVerifyButton.verifyDocument(dropdowns);
	        
	        actionTaken = true;
	    }

	    if (isElementVisible(Docsverified) && !isElementVisible(RiskAssement)) {
	        // Waive off guarantor
	        waiveoffguarantor.waiveOffGuarantor();
	        actionTaken = true;
	        driver.navigate().refresh();
	        Thread.sleep(2000);
	    }
	    
	    if (isElementVisible(Docsverified) && isElementVisible(RiskAssement)) {
	        // Fill the risk assessment form
	        
	        Thread.sleep(2000);
	        riskAssesementForm.fillRiskAssesmentForm();
	        Thread.sleep(1000);
	        riskAssesementForm.caseLogin(); 
	        actionTaken = true;
	    }

	   

	    if (!actionTaken) {
	        System.out.println("No relevant stage element found or action needed.");
	    }
	}


	private boolean isElementVisible(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}
