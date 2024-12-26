package practice.contactTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
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

public class CreateContactTest {
	
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
	Row row = sh.getRow(4);
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
		
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		//verify header lastname Expected Result
		
		
		
		String actLastName = driver.findElement(By.id("mouseArea_Last Name")).getText();
		if(actLastName.contains(lastName))
		{
			System.out.println(lastName+" is created==PASS");
		}
		else
		{
			System.out.println(lastName+" is not created==FAIL");	
		}
		
		
		
			
		//logout
		
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		
		
	
}
}
