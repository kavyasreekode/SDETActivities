package Selenium_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity4 {
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
		
        //Find the 2nd course with Absolute XPath
        String SecPopular = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/section[4]/div[2]/div/div[2]/div/div/div/div[2]/article/div[2]/h3")).getText();
        System.out.println("The 2nd Popular course is: " + SecPopular);
        Assert.assertEquals(SecPopular, "Email Marketing Strategies");
    }
	
	@AfterMethod
	 public void afterMethod() {
        //Close browser
        driver.close();
    }

}
