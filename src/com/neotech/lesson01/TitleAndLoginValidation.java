package com.neotech.lesson01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class TitleAndLoginValidation extends CommonMethods {

	@BeforeMethod
	public void openAndNavigate() {
		setUp();
	}

	@AfterMethod
	public void quitBrowser() {
		tearDown();
	}

	@Test
	public void titleValidation() throws Exception {

		String expectedTitle = "OrangeHRM";
		String actualTitle = driver.getTitle();

		if (expectedTitle.equals(actualTitle)) {

			System.out.println("title validation passed");
		} else {

			System.out.println("Title validation failed");
			throw new Exception();
		}
		wait(3);

	}

	@Test
	public void logoValidation() {

		WebElement logo = driver.findElement(By.xpath("//div[@class='orangehrm-logo']/img"));

		if (logo.isDisplayed()) {
			System.out.println("Logo Validation Passed !");
		} else {
			System.out.println("Logo Validation Failed");
		}
		wait(3);
	}

	@Test
	public void loginValidation() throws Exception {
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));

		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));

		click(driver.findElement(By.xpath("//button[@type='submit']")));

		// we can validate if we are logged in successfully by finding
		// the user photo

		WebElement userImg = driver.findElement(By.xpath("//div[@id='menu-profile']/img"));

		if (userImg.isDisplayed()) {
			System.out.println("We have logged in successfuly!!");
		} else {
			System.out.println("Login failed!!");
			throw new Exception();
		}

	}

}
