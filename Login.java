package peble;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {


	ChromeDriver c1;

	@BeforeTest
	public void setup1() {
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver_win32 (1)\\chromedriver.exe" );
		c1 = new ChromeDriver();
		c1.manage().window().maximize();
	}
	@Test
	public void test1() throws Exception {
		c1.get("http://pepble.com/#/signIn");
		Thread.sleep(2000);
		c1.findElement(By.xpath("//div[2]/div/a[1]")).click();
		Thread.sleep(2000);
		c1.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Thomas");
		c1.findElement(By.xpath("//input[@placeholder='Mobile']")).sendKeys("124864893");
		c1.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("thomas@gmail.com");
		c1.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Asdfgh@123");
		c1.findElement(By.xpath("//div[4]//input")).sendKeys("Asdfgh@123");
		Thread.sleep(2000);
		Actions action = new Actions(c1);
		WebElement element = c1.findElement(By.xpath("//button[contains(text(),'Sign Up')]"));
		action.moveToElement(element).click().perform();
		Thread.sleep(3000);
		c1.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("thomas@gmail,com");
		c1.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Asdfgh@123");
		Thread.sleep(2000);
		Actions action1 = new Actions(c1);
		WebElement element1 = c1.findElement(By.xpath("//button[contains(text(),'Sign In')]"));
		action1.moveToElement(element1).click().perform();
		Thread.sleep(2000);
	}	
	
	@AfterTest
	public void teardown1() {
		c1.close();
		c1.quit();
	}

}

