package Selenium_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity5 {
	WebDriver driver;
	
	@BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        //Open browser
        driver.get("https://alchemy.hguy.co/lms");
    }
	
	@Test
    public void testCase1() {
		
        //Find the My account link with Absolute XPath
        String MyAccount = driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[5]/a")).getText();
        System.out.println("Link text is: " + MyAccount);
        Assert.assertEquals(MyAccount, "My Account");
        //click My account link with Absolute XPath
		driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[5]/a")).click();
		String title = driver.getTitle();
        System.out.println("Title is: " + title);
        Assert.assertEquals(title, "My Account – Alchemy LMS");
    }
	
	@AfterMethod
	 public void afterMethod() {
      //Close browser
      driver.close();
  }
	
	
}
