package com.wadiaa.lending.qa;

import org.testng.annotations.Test;

public class TestCases_Term_Loan_Stepper extends Base_Class_Customer {

    @Test(priority = 1)
    public void verifyTermLoanTestCases() throws InterruptedException {
        Term_Loan_Stepper termloanstepper = new Term_Loan_Stepper(driver);
        termloanstepper.LoanStepper();
        termloanstepper.PersonalDetails();
        termloanstepper.BusinessDetails();
        termloanstepper.KYCDetails();
        termloanstepper.LoanDetails();
    }
}
