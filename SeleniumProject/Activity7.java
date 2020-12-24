package Selenium_Project;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;



public class Activity7 {
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
        WebElement CoursesLocator = driver.findElement(By.id("menu-item-1508"));
        System.out.println("Text in element: " + CoursesLocator.getText());
        CoursesLocator.click();
        
        //Get tiles
        List<WebElement> Tiles = driver.findElements(By.xpath("//div[contains(@class, 'ld_course_grid col-sm-8 col-md-4')]"));

        //Number of Courses
        System.out.println("Number of Courses are: " + Tiles.size());
        
    }
    
    @AfterClass
    public void afterClass() {
        //Close browser
        driver.close();
    }
   
}
