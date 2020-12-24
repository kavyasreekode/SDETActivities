package Selenium_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6 {
	WebDriver driver;
	
    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/lms");
    }
    
    
    @Test
    public void testCase1() throws InterruptedException {
		
        //Find the My account link with Absolute XPath
        String MyAccount = driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[5]/a")).getText();
        System.out.println("Link text is: " + MyAccount);
        Assert.assertEquals(MyAccount, "My Account");
        //click My account link with Absolute XPath
		driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[5]/a")).click();
		String title = driver.getTitle();
        System.out.println("Title is: " + title);
        Assert.assertEquals(title, "My Account – Alchemy LMS");
        
        //Find the login link using className()
        WebElement LoginLocator = driver.findElement(By.linkText("Login"));
        LoginLocator.click();
        
        //Find the input fields
        WebElement firstName = driver.findElement(By.id("user_login"));
        WebElement lastName = driver.findElement(By.id("user_pass"));
        //Enter text
        firstName.sendKeys("root");
        lastName.sendKeys("pa$$w0rd");

        //Click Submit
        driver.findElement(By.id("wp-submit")).click();
        
        Thread.sleep(5000);
        
        //Find logout to say that user is logged in
        
      //Find the login link using className()
        WebElement LogoutLocator = driver.findElement(By.linkText("Logout"));
 
        if(LogoutLocator.isDisplayed())
        {
        	System.out.println("success login");
        }

    }
    
    @AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }
    
    
}
