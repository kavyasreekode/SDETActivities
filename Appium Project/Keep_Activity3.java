package Appium_Project;

import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.BeforeTest;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

@Test
public class Keep_Activity3 {

	WebDriverWait wait;
	String title ="New Note";
	String desc = "Small description";
    AppiumDriver<MobileElement> driver = null;
    @BeforeTest
    public void setup() throws MalformedURLException {

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
        
    public void addNoteAndReminder() {
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.findElement(By.id("com.google.android.keep:id/new_note_button")).click();
    	driver.findElement(By.id("com.google.android.keep:id/editable_title")).sendKeys(title);
    	driver.findElement(By.id("com.google.android.keep:id/edit_note_text")).sendKeys(desc);
    	//Reminder
    	driver.findElement(By.id("com.google.android.keep:id/menu_switch_to_list_view")).click();
    	//Select today's date
    	driver.findElement(By.id("com.google.android.keep:id/spinner_inside_error_state")).click();
    	driver.findElement(By.id("com.google.android.keep:id/reminder_date_today")).click();
    	

    	//Select afternoon time
    	driver.findElement(By.id("com.google.android.keep:id/time_spinner")).click();
    	driver.findElement(By.id("com.google.android.keep:id/reminder_time_afternoon")).click();
    	
    	//Save the changes
    	driver.findElement(By.id("com.google.android.keep:id/save")).click();
    	
    	//Press the back button and switch to the Reminders page
    	driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")).click();;
        
    	//Verify notes and description
    	String savedNoteTitle = driver.findElement(By.id("com.google.android.keep:id/index_note_title")).getText();
    	Assert.assertEquals(savedNoteTitle, title);
    	String savedNoteDes = driver.findElement(By.id("com.google.android.keep:id/index_note_text_description")).getText();
    	Assert.assertEquals(savedNoteDes, desc);
        
    	//Verify reminder is added along with note	
    	driver.findElement(By.id("com.google.android.keep:id/reminder_chip_icon")).isDisplayed();
    	String reminderText = driver.findElement(By.id("com.google.android.keep:id/reminder_chip_text")).getText();
    	System.out.println(reminderText);
    	Assert.assertEquals(reminderText, "Today, 2:00 pm");

    	}	
    
   @AfterTest
    public void tearDown() {
    	driver.quit();
   }
}
