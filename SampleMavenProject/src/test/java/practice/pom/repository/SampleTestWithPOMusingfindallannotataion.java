package practice.pom.repository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SampleTestWithPOMusingfindallannotataion {
	
	
	@FindBy(name="user_name") WebElement usn;
	@FindBy(name="user_password") WebElement pwd;
	
	
	
	@FindAll({@FindBy(xpath="//input[@type='text']"),@FindBy(id="submitButton")})WebElement lgnbtn;
	
	@Test
	public void sampleTest() {
	
	WebDriver driver=new ChromeDriver();
	driver.get("http://localhost:8888");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	SampleTestWithPOMusingfindallannotataion s=PageFactory.initElements(driver, SampleTestWithPOMusingfindallannotataion.class);
	
	s.usn.sendKeys("admin");
	s.pwd.sendKeys("admin");
	
	
	
	s.lgnbtn.click();
	
	driver.close();
	
	
	
	
	}
	
	
}
