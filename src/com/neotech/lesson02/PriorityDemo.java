package com.neotech.lesson02;

import org.testng.annotations.Test;

public class PriorityDemo {

	@Test(priority = 0)
	public void firstTest() {
		System.out.println("First Test Method");
	}

	@Test(priority = 1, groups = "regression")
	public void secondTest() {
		System.out.println("Second Test Method");
	}

	@Test(priority = 2, groups = "regression")
	public void thirdTest() {
		System.out.println("Third Test Method");
	}

	@Test(priority = 10, groups = "smoke")
	public void fourthTest() {
		System.out.println("Fourth Test Method l02 pd");
	}

}
