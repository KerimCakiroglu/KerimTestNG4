package com.neotech.lesson03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;

public class DataProviderDemo extends CommonMethods {
//	@BeforeMethod
//	public void openAndNavigate() {setUp();}
//
//	@AfterMethod
//	public void quitBrowser() {
//		tearDown();
//	}
	@Test(dataProvider = "userData")
	public void LoginFunctionality(String username, String password) {

		WebElement usernameBox = driver.findElement(By.id("txtUsername"));
		sendText(usernameBox, username);

		WebElement passwordBox = driver.findElement(By.id("txtPassword"));
		sendText(passwordBox, password);
		wait(2);

		click(driver.findElement(By.xpath("//button[@type='submit']")));

	}

	@DataProvider(name = "userData")
	public String[][] getData() {

		// {"Admin

		String[][] credentials = { { "Admin", "Admin123" }, { "Burak", "Admin456" }, { "Oguzhan", "Admin789" } };
		return credentials;

	}

}
