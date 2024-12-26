package com.practice.baseclasswithconfigannotation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.practice.baseclass.BaseClass;

public class CreateContactTest extends BaseClass {
	
	@Test
	public void createContact() {
		
		
		System.out.println("Execute createContact and vrify");
	}
	
	@Test
	public void createContactWithDate() {
		
		
		System.out.println("Execute createContactWithDate  and vrify");
	}
	

	

}
