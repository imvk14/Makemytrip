package Newtest;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Report {

	
	ExtentReports extent;
	ExtentTest logger;
	WebDriver driver;
	
	@BeforeTest
	public void BT()
	{
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/vinesh.html",true);
		extent.loadConfig(new File(System.getProperty("user.dir")+"/src/test/java/extent-config.xml"));
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}
	@Test
	public void T() throws InterruptedException
	{
		logger = extent.startTest("Newtest");
		driver.get("https://www.makemytrip.com/");
		Thread.sleep(3000);
		logger.log(LogStatus.PASS, "webpage opened");
		String title = driver.getTitle();
		logger.log(LogStatus.PASS, title);
		driver.findElement(By.linkText("Holiday Packages")).click();
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, "Holiday Packages is opened");
		driver.findElement(By.xpath("//*[@id='fromCity']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='react-autowhatever-1-section-0-item-2']/div/p/span")).click();
		Thread.sleep(4000);
		logger.log(LogStatus.PASS, "Bangalore city is selected");
		driver.quit();
		extent.endTest(logger);
		extent.flush();
		
	}	
}
