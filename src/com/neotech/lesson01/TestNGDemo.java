package com.neotech.lesson01;

import org.testng.annotations.Test;

public class TestNGDemo {

	@Test(groups = "regression")
	public void testOne() {
		System.out.println("Test one!");
	}

	@Test
	public void testTwo() {
		System.out.println("Test two!");
	}

	@Test
	public void testThree() {
		System.out.println("Test three!");
	}

}
