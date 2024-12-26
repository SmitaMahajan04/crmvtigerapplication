package com.practice.baseclasswithconfigannotation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.practice.baseclass.BaseClass;

public class CreateOrgTest extends BaseClass {
	
	@Test
	public void createOrg() {
		
		
		System.out.println("Execute createOrg and vrify");
	}
	
	@Test
	public void createOrgWithIndustry() {
		
		
		System.out.println("Execute createOrgWithIndustry  and vrify");
	}
	

	

}
