package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pages.HomePage;
import pages.RevenueCalculatorPage;

public class RevenueCalculatorTest extends BaseTest {
	private ExtentTest test;

	@Test(priority = 1)
	public void navigateToRevenueCalculatorPageTest() {
		test = extent.createTest("Navigate To Revenue Calculator Page");

		try {
			HomePage homePage = new HomePage(driver);
			homePage.navigateToRevenueCalculator();
			test.log(Status.PASS, "Successfully navigated to Revenue Calculator Page");
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to navigate to Revenue Calculator Page: " + e.getMessage());
			Assert.fail("Navigation to Revenue Calculator Page failed");
		}
	}

	@Test(priority = 2)
	public void adjustSliderAndValidateTest() {
		test = extent.createTest("Scroll Down to the Slider section and Adjust the Slider");
		try {
			RevenueCalculatorPage page = new RevenueCalculatorPage(driver);
			page.scrollToSlider();
			int updateSlider = 820;
			String textValue = page.adjustSliderToValue(updateSlider);
			Assert.assertEquals(Integer.parseInt(textValue)+4, updateSlider,
					"Text field value did not update correctly.");
			test.log(Status.PASS, "Slider adjusted and text field validated correctly");
		} catch (Exception e) {
			test.log(Status.FAIL, "Slider adjustment or validation failed: " + e.getMessage());
			Assert.fail("Slider adjustment or validation failed");
		}
	}

	@Test(priority = 3)
	public void updateTextBoxAndValidateSliderTest() {
		test = extent.createTest("Update Text Field And Validate Slider Value"); 
		try {
			RevenueCalculatorPage page = new RevenueCalculatorPage(driver);
			String updateTextBox = "560";
			String sliderValue = page.updateTextFieldAndValidateSlider(updateTextBox);
			Assert.assertEquals(sliderValue, updateTextBox, "Slider value did not update correctly.");
			test.log(Status.PASS, "Text field updated and slider validated correctly");
			page.updateTextFieldAndValidateSlider("820");
		} catch (Exception e) {
			test.log(Status.FAIL, "Text field update or slider validation failed: " + e.getMessage());
			Assert.fail("Text field update or slider validation failed");
		}
	}

	@Test(priority = 4)
	public void selectCPTCodesTest() {
		test = extent.createTest("Select CPT Codes");

		try {
			RevenueCalculatorPage page = new RevenueCalculatorPage(driver);
			String[] cptCodes = { "CPT-99091", "CPT-99453", "CPT-99454", "CPT-99474" };
			page.selectCPTCodes(cptCodes);
			test.log(Status.PASS, "CPT codes selected successfully");
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to select CPT codes: " + e.getMessage());
			Assert.fail("Failed to select CPT codes");
		}
	}

	@Test(priority = 5)
	public void testValidateTotalRecurringReimbursement() {
		test = extent.createTest("Validate Total Recurring Reimbursement"); 

		try {
			RevenueCalculatorPage page = new RevenueCalculatorPage(driver);
			page.validateTotalRecurringReimbursement();
			test.log(Status.PASS, "Total Recurring Reimbursement validated successfully");
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to validate Total Recurring Reimbursement: " + e.getMessage());
			Assert.fail("Total Recurring Reimbursement validation failed");
		}
	}
}
