package Selenium_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
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
        //This test case will pass
		String Header = driver.findElement(By.xpath("//h1")).getText();
        System.out.println("Header text is: " + Header);
        Assert.assertEquals(Header, "Learn from Industry Experts");
    }
	
	@AfterMethod
	 public void afterMethod() {
        //Close browser
        driver.close();
    }

}
