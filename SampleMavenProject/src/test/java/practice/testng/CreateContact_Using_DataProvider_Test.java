package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_Using_DataProvider_Test {
	
	@Test(dataProvider = "getData")
	public void  CreateContactTest(String firstName, String lastName, int n)
	{
		System.out.println("FirstNmae= "+firstName+"  LastName= " +lastName+" number= "+n );
		
		
	}
	@DataProvider
	public Object[][] getData()
	{
		Object[][] objArr=new Object[3][3];
		
		objArr[0][0]="deepak";
		objArr[0][1]="hr";
		objArr[0][1]=123;
		
		objArr[1][0]="sam";
		objArr[1][1]="hh";
		objArr[0][1]=1234;
		
		objArr[2][0]="john";
		objArr[2][1]="smith";
		objArr[0][1]=12345;
		
		return objArr;
		
	}
	

}
