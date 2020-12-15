package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        WebDriver driver = new FirefoxDriver();

        //Open the browser
        driver.get("https://www.training-support.net/selenium/dynamic-controls");
        
        //Find the page title and print it
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        
        //Find the text field
        WebElement textInput = driver.findElement(By.xpath("//input[@type='text']"));
  
        
      //Print status
        System.out.println("The text field is Enabled: " + textInput.isEnabled());
 
        driver.findElement(By.id("toggleInput")).click();
 
        //Print status
        System.out.println("The text field is Enabled: " + textInput.isEnabled());
 
        //Close the browser
        driver.close();
 
    }
 
}