package com.wadiaa.lending.qa;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Admin_Verify_Document {

	private WebDriver driver;
	
	@FindBy(xpath = "//a[@href='#documentDetails']")
	private WebElement LoanDocument;

	@FindBy(xpath = "//button[@class='btn bg-[#3F5C88] text-white border border-[#E5E5E5]']")
	private WebElement MarkAsVerify;

	@FindBy(xpath = "//button[@class='btn bg-[#3F5C88] text-white w-full rounded disabled:opacity-60']")
	private WebElement MarkAsVerifiedYes;

	public Admin_Verify_Document(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifyDocument(List<WebElement> dropdowns) throws InterruptedException {
		
		LoanDocument.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);

		for (WebElement dropdown : dropdowns) {
			dropdown.click(); // Expand the dropdown
			Thread.sleep(1000); // Adjust the sleep time if necessary

			boolean verifyButtonFound = true;
			System.out.println("Verify Button Found");
			while (verifyButtonFound) {
				System.out.println("Enter in While Loop");
				try {
					// Attempt to locate the first visible ValidateButton within the current
					// dropdown
					WebElement verifyButton = dropdown.findElement(By.xpath(
							"(//button[@class='btn bg-[#3F5C88] text-white text-xs font-medium w-full disabled:opacity-60'])[1]"));

					// Wait for the button to be clickable and then click it
					wait.until(ExpectedConditions.elementToBeClickable(verifyButton));
					System.out.println("Button is Displayed");
					verifyButton.click();
					System.out.println("Button is Clicked");
					Thread.sleep(1000); // Wait for the action to complete
				} catch (NoSuchElementException e) {
					// If no ValidateButton is found, exit the loop for this dropdown
					verifyButtonFound = false;
					System.out.println("No more Validate buttons found in this dropdown.");
				} catch (Exception e) {
					// Handle any unexpected exceptions, such as ElementNotInteractableException
					verifyButtonFound = false;
					System.out.println("Error clicking the Validate button: " + e.getMessage());
				}
			}

			dropdown.click(); // Close the dropdown after processing all verify buttons
			Thread.sleep(1000); // Adjust the sleep time if necessary
		}

		if (MarkAsVerify.isDisplayed()) {
			MarkAsVerify.click();
			Thread.sleep(1000);
			MarkAsVerifiedYes.click();
		}
	}
}
