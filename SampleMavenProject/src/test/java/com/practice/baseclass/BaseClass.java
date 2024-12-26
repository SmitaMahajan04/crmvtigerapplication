
package com.practice.baseclass;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	@BeforeMethod
	public void configBM()
	{
		System.out.println("Login");
	}
	@AfterMethod
	public void configAM()
	{
		System.out.println("Logout");
	}
	
	@BeforeClass
	public void configBC()
	{
		System.out.println("Launch Browser");
	}
	
	@AfterClass
	public void configAC()
	{
		System.out.println("Close Browser");
	}
	@BeforeSuite
	public void configBS()
	{
		System.out.println("connect to db and report config");
	}
	
	
	@AfterSuite
	public void configAS()
	{
		System.out.println("close db and report backup");
	}
	

}
