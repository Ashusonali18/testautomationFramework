package base;


import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;



public class Pages extends Basetest {
	
	@Test(dataProvider = "logindata", dataProviderClass = Readexceldata.class)
	
	public static void LoginTest(String username ,String password) throws InterruptedException
	{
//	 driver.findElement(By.xpath("//a[@class='zlogin-apps']")).click();
//	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//	 driver.findElement(By.xpath("//input[@id='login_id']")).clear();
//	 driver.findElement(By.xpath("//input[@id='login_id']")).sendKeys("sonaliqa952@gmail.com");
//	 driver.findElement(By.id("nextbtn")).click();
//	 
//	 driver.findElement(By.id("password")).sendKeys("yuki@18jan");
//	 driver.findElement(By.id("nextbtn")).click();
	 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath(loc.getProperty("Signin_link"))).click();
	//	driver.findElement(By.xpath(loc.getProperty("email_field"))).clear();
		driver.findElement(By.xpath(loc.getProperty("email_field"))).sendKeys(username);
		driver.findElement(By.xpath(loc.getProperty("next_button"))).click();
		driver.findElement(By.xpath(loc.getProperty("pwd_field"))).sendKeys(password);
		driver.findElement(By.xpath(loc.getProperty("login_next_button"))).click();
		Thread.sleep(3000);
	 

	}
	

}
