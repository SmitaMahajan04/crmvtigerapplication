package practice.contactTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactWithSupportDateTest {
	
	public static void main(String[] args) throws IOException {
		FileInputStream fis =new FileInputStream("C:\\Users\\Shree\\Desktop\\TekPyramid\\TestDataForSampleProject\\Data.properties");
		
		//step2 : using Properties class,load all the keys
		
		Properties pObj=new Properties();
		pObj.load(fis);
		
		//step 3 : get the value based on key

	String BROWSER = pObj.getProperty("browser");
	String URL = pObj.getProperty("url");
	String USERNAME = pObj.getProperty("username");
	String PASSWORD = pObj.getProperty("password");


	//generate the random Number
	Random random=new Random();
	int randomInt=random.nextInt(1000);


	//read testScript data from excelFile

	FileInputStream fis1=new FileInputStream("C:\\Users\\Shree\\Desktop\\TekPyramid\\TestDataForSampleProject\\testScriptData2.xlsx");
	Workbook wb = WorkbookFactory.create(fis1);
	Sheet sh = wb.getSheet("contact");
	Row row = sh.getRow(1);
	String lastName=row.getCell(2).toString()+randomInt;
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
		
		//navigate to Contact module
		
		driver.findElement(By.linkText("Contacts")).click();
		
		//click on create Contact button
		
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//enter all the details and create new organization
		
		
		Date dateObj=new Date();//this displays the current date and time in standard format
		
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
		String startDate = sd.format(dateObj);
		
			
		Calendar cal=sd.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, 30);//this will generate 30 day before date
	String EndDate=	sd.format(cal.getTime());
	
	
	driver.findElement(By.id("jscal_field_support_start_date")).clear();
	driver.findElement(By.id("jscal_field_support_start_date")).sendKeys(startDate);
	
	driver.findElement(By.id("jscal_field_support_end_date")).clear();
	driver.findElement(By.id("jscal_field_support_end_date")).sendKeys(EndDate);
	
	

		
		
		
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		//verify startdate and enddate in  Expected Result
		
		
		
		String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if(actStartDate.contains(startDate))
		{
			System.out.println(startDate+" is created==PASS");
		}
		else
		{
			System.out.println(startDate+" is not created==FAIL");	
		}
		
		String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if(actEndDate.contains(EndDate))
		{
			System.out.println(EndDate+" is created==PASS");
		}
		else
		{
			System.out.println(EndDate+" is not created==FAIL");	
		}
		
			
		//logout
		
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		
		
	
}
}
