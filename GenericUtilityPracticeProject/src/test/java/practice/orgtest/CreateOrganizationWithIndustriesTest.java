package practice.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationWithIndustriesTest {
	
	
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
	Sheet sh = wb.getSheet("org");
	Row row = sh.getRow(4);
	String orgName=row.getCell(2).toString()+randomInt;
	
	String industries=row.getCell(3).toString();
	
	String type=row.getCell(4).toString();
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
		
		
		WebElement industryDropdown = driver.findElement(By.name("industry"));
		Select sel=new Select(industryDropdown);
		sel.selectByVisibleText(industries);
		
		WebElement typeDropdown = driver.findElement(By.name("accounttype"));
		Select sel1=new Select(typeDropdown);
		sel1.selectByVisibleText(type);

		
		
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//verify the industry and type info
		
		String actualIndustryDd = driver.findElement(By.id("mouseArea_Industry")).getText();
		String actualTypeDd = driver.findElement(By.id("mouseArea_Type")).getText();
		if(actualIndustryDd.equals(industries))
		{
			
			System.out.println(actualIndustryDd+" is verified==>PASS");
		}
		else
{
			
			System.out.println(actualIndustryDd+" is not  verified==>FAIL");
		}
			
		
		//verify type dd
		if(actualTypeDd.equals(type))
		{
			
			System.out.println(actualTypeDd+" is verified==>PASS");
		}
		else
{
			
			System.out.println(actualTypeDd+" is not  verified==>FAIL");
		}

		//logout
		
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		
		

	}

}
