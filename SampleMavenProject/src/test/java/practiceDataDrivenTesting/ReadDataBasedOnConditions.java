package practiceDataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBasedOnConditions {

	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Shree\\Desktop\\TekPyramid\\TestDataForSampleProject\\testScriptData.xls.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data1="";
		String data2="";
		String expectedTCId="tc_01";
		Sheet sh = wb.getSheet("org");
		boolean flag =false;
		for(int i=1;i<=sh.getLastRowNum();i++)
		{
		String data="";
		
			try
			{
		
		 data = sh.getRow(i).getCell(0).getStringCellValue();
			}
			catch(Exception e)
			{}
		
		if(data.equals(expectedTCId))
		{
			flag=true;
			 data1=sh.getRow(i).getCell(1).getStringCellValue();
			 data2=sh.getRow(i).getCell(2).getStringCellValue();
		//	String data3=sh.getRow(i).getCell(3).getStringCellValue();
			
			//System.out.println(data2);
		}
		else
		{
		
		}
		
		
		
	}
		
		if (flag==true)
		{
			System.out.println(data1+"  \t  "+data2);
		}
		else{
			System.out.println(expectedTCId+" is not available");
		}
	}
}

