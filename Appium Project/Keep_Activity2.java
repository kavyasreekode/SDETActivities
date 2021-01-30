package Appium_Project;

import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Keep_Activity2 {
	
  AppiumDriver<MobileElement> driver = null;

  @BeforeTest
  public void beforeClass() throws MalformedURLException {
      // Set the Desired Capabilities
      DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceName", "Pixel 4 Pie");
      caps.setCapability("platformName", "Android");
      caps.setCapability("automationName", "UiAutomator2");
      caps.setCapability("appPackage", "com.google.android.keep");
      caps.setCapability("appActivity",".activities.BrowseActivity");
      caps.setCapability("noReset", true);

      // Instantiate Appium Driver
      URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
      driver = new AndroidDriver<MobileElement>(appServer, caps);
  }
      
  @Test 
 
  public void addNote() {
  	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  	driver.findElement(By.id("com.google.android.keep:id/new_note_button")).click();
  	driver.findElement(By.id("com.google.android.keep:id/editable_title")).sendKeys("Note");
  	driver.findElement(By.id("com.google.android.keep:id/edit_note_text")).sendKeys("Small description");
  	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")).click();;
  	
  	String savedNoteTitle = driver.findElement(By.id("com.google.android.keep:id/index_note_title")).getText();
  	Assert.assertEquals(savedNoteTitle, "Note");
  	System.out.println("NOte is added successfully");
  }	
  
 @AfterTest
  public void tearDown() {
  	driver.quit();
 }
}
