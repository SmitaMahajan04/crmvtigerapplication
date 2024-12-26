package practiceDataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//step 1 : get the Excel path Location and java object of he Physical ExcelFile
		
		FileInputStream fis = new FileInputStream("C:\\Users\\Shree\\Desktop\\TekPyramid\\TestDataForSampleProject\\testScriptData.xls.xlsx");
		//step 2 : open workbook in the read mode
		Workbook wb =WorkbookFactory.create(fis);
		
		//step 3 : get the control of the "org" sheet
		
		Sheet sheet = wb.getSheet("org");
		
		
		
		//step 4 : get the control of the "first" row
		
		Row row = sheet.getRow(1);
		
		//step 5 : get the control of the "2st" cell and read the string data
		
Cell cell = row.getCell(2);
String data = cell.getStringCellValue();
		System.out.println(data);
		//step 6 : close the workbokk
		wb.close();

	}
	
}
