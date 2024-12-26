package practice.testngannotatons;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CreateContactTest {
	
	@Test
	public void methodTest() {
		
		
		System.out.println("TC1");
	}
	
	@Test
	public void methodTest1() {
		
		
		System.out.println("TC2");
	}
	
	@BeforeMethod
	public void m1()
	{
		System.out.println("BM");
	}
	@AfterMethod
	public void m2()
	{
		System.out.println("AM");
	}
	
	@BeforeClass
	public void m3()
	{
		System.out.println("BC");
	}
	
	@AfterClass
	public void m4()
	{
		System.out.println("AC");
	}
	@BeforeSuite
	public void m5()
	{
		System.out.println("BS");
	}
	
	
	@AfterSuite
	public void m6()
	{
		System.out.println("AS");
	}
	
	

}
