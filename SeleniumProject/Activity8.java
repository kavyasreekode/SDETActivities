package Selenium_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Activity8 {
	WebDriver driver;

	
    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/lms");
    }
    
    @Test
    public void testCase1() {
		
        //Find the Contact link and click
        WebElement MALocator = driver.findElement(By.id("menu-item-1506"));
        System.out.println("Text in element: " + MALocator.getText());
        MALocator.click();
        
        //Find the input fields
        WebElement firstName = driver.findElement(By.xpath("//input[@id = 'wpforms-8-field_0']"));
        WebElement Email = driver.findElement(By.xpath("//input[@id = 'wpforms-8-field_1']"));
        WebElement Subject = driver.findElement(By.xpath("//input[@id = 'wpforms-8-field_3']"));
        WebElement Comment = driver.findElement(By.cssSelector("#wpforms-8-field_2"));
        //Enter text
        firstName.sendKeys("Kavya");
        Email.sendKeys("abc.def@gmail.com");
        Subject.sendKeys("Access");
        Comment.sendKeys("Request for LMS Access");
      //Click Submit
        driver.findElement(By.xpath("//button[contains(text(), 'Send Message')]")).click();
        
      //Print login message
        String SuccessMessage = driver.findElement(By.id("wpforms-confirmation-8")).getText();
        System.out.println(" message: " + SuccessMessage);
        
        Assert.assertEquals(SuccessMessage, "Thanks for contacting us! We will be in touch with you shortly.");
    } 
    
    @AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }
}
    
