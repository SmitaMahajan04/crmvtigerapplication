package practice.pom.repository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTestWithoutPOM {
	public static void main(String[] args) {
		
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement usn = driver.findElement(By.name("user_name"));
		WebElement pwd = driver.findElement(By.name("user_password"));
		WebElement lgnbn = driver.findElement(By.id("submitButton"));
		
		
		usn.sendKeys("admin");
		pwd.sendKeys("admin");
		
		driver.navigate().refresh();
		
		usn.sendKeys("admin");
		pwd.sendKeys("admin");
		
		
		lgnbn.click();
		
		driver.close();
		
	}

}
