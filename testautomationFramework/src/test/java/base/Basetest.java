package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basetest {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc =new Properties();
	
	public static FileReader fr;
	public static FileReader fr1;
	
	@BeforeTest
	public void setUp() throws IOException {
		
		if (driver == null) {
			// Correcting the path to the properties file
			fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
			prop.load(fr);
			fr1 = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locators.properties");
			// Closing the FileReader after loading properties
			loc.load(fr1);
			fr.close();
			fr1.close();
			

			String browser = prop.getProperty("browser");
			String testUrl = prop.getProperty("testurl");

			// Initialize WebDriver based on the browser property
			if (browser != null && browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browser != null && browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else {
				throw new RuntimeException("Browser type not supported: " + browser);
			}
			
			// Maximize the browser window and navigate to the URL
			driver.manage().window().maximize();
			driver.get(testUrl);
		}
	}
	
	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
			System.out.println("Browser closed and test ended.");
		}
	}
}
