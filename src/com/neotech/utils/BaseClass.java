package com.neotech.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	public static WebDriver driver;

	/**
	 * This method will initialize driver
	 */
	@BeforeMethod(alwaysRun = true)
	public static void setUp() {

		// this line will read the configuratiom.properties file
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

		// if the value of the browser is chrome ...
		switch (ConfigsReader.getProperty("browser").toLowerCase()) {
		case "chrome":
			// open chrome
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
			break;

		case "firefox":
			// open firefox
			System.setProperty("wedriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
			driver = new FirefoxDriver();
			break;

		default:
			throw new RuntimeException("Browser is not supported!!!");
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT_TIME));
		driver.manage().window().maximize();
		driver.get(ConfigsReader.getProperty("url"));
	}

	/**
	 * This method will quit browser
	 */
	@AfterMethod(alwaysRun = true)
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}

	}

}
