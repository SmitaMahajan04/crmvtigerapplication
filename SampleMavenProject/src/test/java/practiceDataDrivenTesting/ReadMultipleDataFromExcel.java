package practiceDataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcel {
	
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
	
	FileInputStream fis = new FileInputStream("C:\\Users\\Shree\\Desktop\\TekPyramid\\TestDataForSampleProject\\testScriptData.xls.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sheet = wb.getSheet("sheet1");
	int rowCount = sheet.getLastRowNum();
	for(int i=1;i<=rowCount;i++) {
	Row row = sheet.getRow(i);
	Cell cell1 = row.getCell(0);
	Cell cell2 = row.getCell(1);
	
	
	System.out.println(cell1.getStringCellValue()+"    \t    "+cell2.getStringCellValue());
	//System.out.println();

	}

}
}
