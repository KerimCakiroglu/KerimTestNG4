package com.neotech.HW;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class HWTNG02 extends CommonMethods {

//	Open chrome browser
//    Go to "https://hrm.neotechacademy.com/"
//    Login into the application
//    Click on Add Employee
//    Verify labels: Employee Full Name*, Employee Id, Location* are displayed
//    Provide Employee First and Last Name
//    Select a Location
//    Verify Employee has been added successfully
//    Close the browser

	@Test
	public void verify() {
//	    Login into the application
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
		click(driver.findElement(By.xpath("//button[@type='submit']")));
		wait(2);
		// Click on PIM menu
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		// Click on Add Employee
		driver.findElement(By.linkText("Add Employee")).click();

		wait(9);

		// Verify labels: Employee Full Name*, Employee Id, Location* are displayed
		boolean isDispFullName = driver.findElement(By.xpath("//label[text()='Employee Full Name']")).isDisplayed();
		boolean isDispEmpId = driver.findElement(By.xpath("//label[text()='Employee Id']")).isDisplayed();
		boolean isDispLocation = driver.findElement(By.xpath("//label[text()='Location']")).isDisplayed();

		SoftAssert soft = new SoftAssert();
		soft.assertTrue(isDispFullName, "Full name label is not displayed!");
		soft.assertTrue(isDispEmpId, "Employee ID label is not displayed!");
		soft.assertTrue(isDispLocation, "Location label is not displayed!");

		soft.assertAll();

		sendText(driver.findElement(By.id("first-name-box")), "Kerim");

		sendText(driver.findElement(By.id("last-name-box")), "Cakiroglu");

		selectDropdown(driver.findElement(By.id("location")), "New York Sales Office");
		String empId = driver.findElement(By.id("employeeId")).getAttribute("value");

		driver.findElement(By.id("modal-save-button")).click();

		soft.assertNotNull(empId, "Employee didnt add");
		soft.assertAll();

	}

}
