package Selenium_Project;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class Activity9 {
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
        driver.findElement(By.xpath("/html/body/div/header/div/div/div/div/div[3]/div/nav/div/ul/li[5]/a")).click();   
        
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
    }
    
    @Test
    public void testCase2() {
		
        //Find the Contact link and click
        WebElement CoursesLocator = driver.findElement(By.id("menu-item-1508"));
        System.out.println("Text in element: " + CoursesLocator.getText());
        CoursesLocator.click();
        
        WebElement Firstcourse = driver.findElement(By.cssSelector("#post-69 > div:nth-child(3) > p:nth-child(3) > a:nth-child(1)"));
        Firstcourse.click();
        
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/div/div/div/div[3]/div[2]/div[2]/div[1]/div/div/span[1]")).click();
        
       
        WebElement course2 = driver.findElement(By.cssSelector("#ld-table-list-item-24182 > a:nth-child(1) > span:nth-child(2)"));
        course2.click();
        
        String SubHeading = driver.findElement(By.xpath("//div[contains(@class, 'ld-focus-content')]/h1")).getText();
        System.out.println("Title of page: " + SubHeading);
        
             
        WebElement markcomplete = driver.findElement(By.xpath("//input[contains(@class, 'mark_complete')]"));
        markcomplete.click();
       
    }
        
   
    
    @AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }

}