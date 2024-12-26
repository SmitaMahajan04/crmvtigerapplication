package practice.testng;

import org.testng.annotations.Test;

public class ContactTest {
	@Test
	
	public void createContact()
	{
		System.out.println("execute  createContact with-->HDFC");
	}
	
	
	@Test
	public void modifyContact()
	{
		
		System.out.println("execute query insert contact in db-->ICICI");
		System.out.println("execute  modifyContact");
	}
	
	
	@Test
	public void deleteContact()
	{
		
		System.out.println("execute query insert contact in db-->ICICI");
		System.out.println("execute  deleteContact");
	}

}
