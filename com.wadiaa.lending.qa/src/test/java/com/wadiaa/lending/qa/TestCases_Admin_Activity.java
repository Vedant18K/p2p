package com.wadiaa.lending.qa;

import org.testng.annotations.Test;

public class TestCases_Admin_Activity extends Base_Class_Admin {

	@Test(priority = 1)
	public void verifyTestCases() throws InterruptedException {

		AdminFlow adminflow = new AdminFlow(driver);
		adminflow.specificLoan();

	}
}
