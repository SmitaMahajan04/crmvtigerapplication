package practice.assertion_home_test;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HomePageSamplewithHardAssertTest
{
	
	@Test
	public void homePageTest(Method mtd)
	{
		System.out.println(mtd.getName()+" Test Start ");
		SoftAssert assertObj=new SoftAssert();
		System.out.println("step-1");
		System.out.println("step-2");
		assertObj.assertEquals("Home", "Home Page");
		System.out.println("step-3");
		assertObj.assertEquals("CRM", "CRM");
		System.out.println("step-4");
		
	System.out.println(mtd.getName()+" Test End ");	
		
	}

	@Test
	public void verifyLogoHomePageTest(Method mtd)
	{
		System.out.println(mtd.getName()+" Test Start ");
		SoftAssert assertObj=new SoftAssert();
		System.out.println("step-1");
		System.out.println("step-2");
		assertObj.assertTrue(true);
		System.out.println("step-3");
		System.out.println("step-4");
		
	System.out.println(mtd.getName()+" Test End ");	
	
	
		}


}

