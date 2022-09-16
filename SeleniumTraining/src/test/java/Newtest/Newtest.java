package Newtest;

import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Newtest {

	WebDriver driver;
	
	@BeforeTest(enabled = true)
	public void BF()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test(enabled = true)
	public void T() throws InterruptedException
	{
		Thread.sleep(3000);
		
		//Selecting Holiday Packages
		driver.findElement(By.linkText("Holiday Packages")).click();
		Thread.sleep(3000);
		
		//Selecting From city to Bangalore
		driver.findElement(By.xpath("//*[@id='fromCity']")).click();
		Thread.sleep(5000);
		
		//Selecting the country to Singapore
		driver.findElement(By.xpath("//*[@id='react-autowhatever-1-section-0-item-2']/div/p/span")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[1]/div/div/div/input")).sendKeys("Singapore");
		Thread.sleep(2000);
		WebElement sg = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div[1]/div[2]/div[1]/div[2]/div[1]/div/div/div/input"));
		Thread.sleep(2000);
		sg.sendKeys(Keys.ARROW_DOWN, Keys.RETURN);
		
		//Selecting search Button
		driver.findElement(By.xpath("//*[@id='search_button']")).click();
		Thread.sleep(5000);
		
		//Skip the ad
		driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div[2]/div[2]/div[2]/div/button[1]")).click();
		Thread.sleep(10000);
		
        //Selecting the Strating Date
		driver.findElement(By.xpath("//*[@id='modifySearchDetails']/div/div[2]/div/label")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id='modifySearchDetails']/div/div[2]/div[2]/div/div/div[2]/div[1]/div[3]/div[5]/div[1]")).click();
		Thread.sleep(5000);
		
		//Selecting search Button 
		driver.findElement(By.xpath("//*[@id='modifySearchDetails']/div/button")).click();
		Thread.sleep(10000);
		
		//Selecting 2N/3D
		driver.findElement(By.xpath("//*[@id='root']/div/main/div[1]/div/div[1]/div/div[2]/div/div/button")).click();
		driver.findElement(By.xpath("//*[@id='root']/div/main/div[1]/div/div[1]/div/div[2]/div/div/div/div/div[2]/div/div/div/div[3]/div/div[1]/div/div/img")).click();
		Thread.sleep(10000);
		
		ArrayList<String> newtab = new ArrayList<String>(driver.getWindowHandles());
	      //switch to new tab
	      driver.switchTo().window(newtab.get(1));
	      System.out.println("Page title of new tab: " + driver.getTitle());
	      Thread.sleep(5000);
		
		//Skip the ad
		driver.findElement(By.xpath("//*[@id='root']/div/div[1]/div[4]/div[2]/div[2]/div[2]/div/button[1]")).click();
		Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("(//*[@id='changeRemoveBtn'])[3]")).click();
	    Thread.sleep(8000);
	    
	    js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(5000);
	    
	    driver.findElement(By.xpath("(//*[@class='primaryBtn fill selectBtn'])[4]")).click();
	    Thread.sleep(10000);
	    
	    driver.findElement(By.xpath("//*[@id='modalpopup']/div/div/div/div/div[3]/div[2]/div/p")).click();
	    Thread.sleep(8000);
	    
		
		driver.findElement(By.xpath("(//*[@id='chooseAndAddBtn'])[1]")).click();
		Thread.sleep(8000);
		
		driver.findElement(By.xpath("//*[@id='modalpopup']/div/div/div/div/div[2]/div/div[2]/div[2]/div[3]/span")).click();
		Thread.sleep(8000);
		
		driver.findElement(By.xpath("//*[@id='modalpopup']/div/div/div/div/div[4]/div[2]/div/p")).click();
		Thread.sleep(8000);
		
		driver.findElement(By.xpath("//*[@id='initeraryNav']/li[2]")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id='initeraryNav']/li[3]")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id='initeraryNav']/li[4]")).click();
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//*[@id='initeraryNav']/li[5]")).click();
		Thread.sleep(5000);
		
	}
	@AfterTest (enabled = true)
	public void AT() 
	{
		driver.quit();
	}
	
}
