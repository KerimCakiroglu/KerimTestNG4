package com.neotech.lesson03;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class AddEmployeeWithDataProvider extends CommonMethods {

	// because we have said @BeforeMethod and @AfterMethod on BaseClass,
	// we do not need any @BeforeMethod or @AfterMethod here

	@Test(dataProvider = "addEmployee")
	public void addEmployee(String firstName, String lastName) {

		// This line can simply test if we are getting the data from the dataProvider
		// System.out.println(firstName + " " + lastName);

		// login
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
		click(driver.findElement(By.xpath("//button[@type='submit']")));
		wait(6);
		// click on add Employee
		click(driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']/a/span[2]")));
		// navigate to PIM
		click(driver.findElement(By.xpath("//*[@id=\"menu_pim_addEmployee\"]/span[2]")));
		wait(10);

		// send employee data :fname , lname, location

		sendText(driver.findElement(By.id("first-name-box")), firstName);
		sendText(driver.findElement(By.id("last-name-box")), lastName);

		selectDropdown(driver.findElement(By.id("location")), "Australian Regional HQ");

		wait(3);
		click(driver.findElement(By.id("modal-save-button")));
		wait(5);
	}

	@DataProvider(name = "addEmployee")
	public Object[][] create2DArray() {

		Object[][] data = { { "A4Murad", "Bayramov" }, { "A4Emine", "Karakaya" }, { "A4Vugar", "Alisultanov" } };
		return data;
	}

}
