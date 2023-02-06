package com.neotech.lesson02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;

public class AssertDemo extends CommonMethods {

	@BeforeMethod
	public void openAndNavigate() {

		setUp();
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

	@Test(enabled = false)
	public void titleValidation() {

		String expectedTitle = "OrangeHRM.....";
		String actualTitle = driver.getTitle();

		// 1st way
		// Assert.assertEquals(actualTitle, expectedTitle);

		// 2 second way print message if not
		Assert.assertEquals(actualTitle, expectedTitle, "Title does NOT match!");

		// if hard assertion fails
		// the statements after the assertion will not be executed
		System.out.println("continue after assertion..");

	}

	@Test
	public void validationLogo() {
		WebElement logo = driver.findElement(By.xpath("//div[@class='orangehrm-logo']/img"));
		boolean logoDisplayed = logo.isDisplayed();

		// I am manually setting this variable to false, to fail the test
		logoDisplayed = false;

		// 1st way
		Assert.assertEquals(logoDisplayed, true);

	}

}
