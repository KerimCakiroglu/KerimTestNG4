package com.neotech.lesson03;

import org.testng.annotations.Test;

public class Homework1 {

	/*
	 * HW1: Executing tests using priority and enable attributes
	 * 
	 * Create a class TaskOne that has 5 test methods named: firstMethod
	 * firstMethod1 secondMethod thirdMethod fourthMethod
	 * 
	 * And each of them printing the method name Run and observe results
	 * 
	 * Then, add the needed attributes to print the following result: fourthMethod
	 * thirdMethod secondMethod firstMethod
	 */

	@Test(priority = 10)
	public void firstMethod() {
		System.out.println("first method");

	}

	@Test(enabled = false) // or we can just comment out the annotation
	public void firstMethod1() {
		System.out.println("first method1");
	}

	@Test(priority = 5)
	public void secondMethod() {
		System.out.println("second method");
	}

	@Test(priority = 3)
	public void thirdMethod() {
		System.out.println("third method");
	}

	// if no priority is set, then default 0
	@Test
	public void fourthMethod() {
		System.out.println("fourth method");
	}

}
