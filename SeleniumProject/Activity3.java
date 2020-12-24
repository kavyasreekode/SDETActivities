package Selenium_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {
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
		String SubHeader = driver.findElement(By.xpath("//h3")).getText();
        System.out.println("Header text is: " + SubHeader);
        Assert.assertEquals(SubHeader, "Actionable Training");
    }
	
	@AfterMethod
	 public void afterMethod() {
        //Close browser
        driver.close();
    }

}
