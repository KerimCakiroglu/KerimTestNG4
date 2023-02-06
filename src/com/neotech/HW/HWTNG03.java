package com.neotech.HW;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class HWTNG03 extends CommonMethods {
//	Open chrome browser
//	Go to "https://hrm.neotechacademy.com/"

	@Test(dataProvider = "loginData")
	public void addEmp(String fName, String lName, String uName, String pword) {

		// Login
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
		click(driver.findElement(By.xpath("//button[@type='submit']")));

		// Click on PIM menu
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		// Click on Add Employee
		driver.findElement(By.linkText("Add Employee")).click();

		wait(9);

		sendText(driver.findElement(By.id("first-name-box")), fName);
		sendText(driver.findElement(By.id("last-name-box")), lName);

		wait(3);

		selectDropdown(driver.findElement(By.id("location")), "France Regional HQ");
		jsClick(driver.findElement(By.id("hasLoginDetails")));

		wait(3);

		sendText(driver.findElement(By.id("username")), uName);
		sendText(driver.findElement(By.id("password")), pword);
		sendText(driver.findElement(By.id("confirmPassword")), pword);
		wait(1);

		// Clicking on Save Button
		click(driver.findElement(By.id("modal-save-button")));

		waitForVisibility(driver.findElement(By.id("pimPersonalDetailsForm")));

		takeScreenshot(fName + "_" + lName);

	}

	@DataProvider(name = "loginData")
	public Object[][] loginDetails() {
		Object[][] data = { { "1SSKerim", "Cakir1", "1SSkerim1kerim", "kerim@345" },
				{ "2Kerim", "Cakir2", "2SSSkerim2kerim", "kerim@222" },
				{ "3Kerim", "Cakir3", "3SSSkerim3kerim", "kerim@333" } };
		return data;
	}

}

//	Login to the application
//	Add 3 different Employees and Create Login Details by providing:
//	First Name
//	Last Name
//	Username
//	Password

//	Verify Employee has been added successfully 
//and take screenshot (you must have 3 different screenshots)

//	Specify a group for this test case, 
//add it into specific suite and execute from the xml file.
