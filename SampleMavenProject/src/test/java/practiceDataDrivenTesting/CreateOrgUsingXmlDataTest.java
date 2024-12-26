package practiceDataDrivenTesting;

import java.awt.Desktop.Action;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class CreateOrgUsingXmlDataTest {
	
@Test
public void creatOrgTest (XmlTest test)throws IOException, InterruptedException, ParseException {
	
	
	FileInputStream fis =new FileInputStream("src\\test\\resources\\Data.properties");
	
	//step2 : using Properties class,load all the keys
	
	Properties pObj=new Properties();
	pObj.load(fis);
	
	//read the common data from xml file
	/*JSONParser parser=new JSONParser();
	FileReader fr=new FileReader("C:\\Users\\Shree\\Desktop\\TekPyramid\\TestDataForSampleProject\\appCommonData.json");
	Object obj = parser.parse(fr);
	JSONObject map = (JSONObject)obj;*/

String BROWSER =test.getParameter("browser");
String URL =test.getParameter("url") ;
String USERNAME =test.getParameter("username") ;
String PASSWORD =test.getParameter("password") ;


//generate the random Number
Random random=new Random();
int randomInt=random.nextInt(1000);


//read testScript data from excelFile

FileInputStream fis1=new FileInputStream("C:\\Users\\Shree\\Desktop\\TekPyramid\\TestDataForSampleProject\\testScriptData2.xlsx");
Workbook wb = WorkbookFactory.create(fis1);
Sheet sh = wb.getSheet("org");
Row row = sh.getRow(1);
String orgName=row.getCell(2).toString()+randomInt;
wb.close();



	
	WebDriver driver =null;
	
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver= new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		driver= new FirefoxDriver();
	}
	else if(BROWSER.equalsIgnoreCase("edge"))
	{
		driver= new EdgeDriver();
	}

	//login to app
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	//navigate to organization module
	
	driver.findElement(By.linkText("Organizations")).click();
	
	//click on create organisation button
	
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
	//enter all the details and create new organization
	
	driver.findElement(By.name("accountname")).sendKeys(orgName);//
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	
	Thread.sleep(2000);
	
	//logout
	
	Actions act=new Actions(driver);
	act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
	
	driver.findElement(By.linkText("Sign Out")).click();
	driver.quit();
	
	
}

}
