package com.neotech.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.neotech.pages.DashboardPageElements;
import com.neotech.pages.LoginPageElements;
import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class LoginTest extends CommonMethods {

	@Test
	public void validLogin() {
		LoginPageElements login = new LoginPageElements();
		DashboardPageElements dashboard = new DashboardPageElements();

		// send username
		sendText(login.username, ConfigsReader.getProperty("username"));
		wait(1);
		// send password
		sendText(login.password, ConfigsReader.getProperty("password"));
		wait(1);
		// click on login

		jsClick(login.logInButton);
		wait(2);

		// verify username
		String expected = "Jacqueline White";
		String actual = dashboard.accountName.getText();

		// assertion
		Assert.assertEquals(actual, expected, "The account name does NOT match!!!");

	}

	@Test
	public void emptyPasswordLogin() {
		LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		wait(1);
		// send password
		sendText(login.password, "");
		wait(1);
		// click on login
		jsClick(login.logInButton);
		wait(2);

		SoftAssert soft = new SoftAssert();
		String expected = "Password cannot be empty";
		String actual = driver.findElement(By.id("txtPassword-error")).getText();

		soft.assertEquals(expected, actual, "Error message is unexpected");

	}

	@Test
	public void invalidPasswordLogin() {
		LoginPageElements login = new LoginPageElements();
		sendText(login.username, ConfigsReader.getProperty("username"));
		wait(1);
		// send password
		sendText(login.password, "WrongPass");
		wait(1);
		// click on login
		jsClick(login.logInButton);
		wait(2);

		SoftAssert soft = new SoftAssert();
		// String expected = "Password cannot be empty";
		// String actual = driver.findElement(By.id("txtPassword-error")).getText();

		// soft.assertEquals(expected, actual, "Error message is unexpected");
	}

}
