package Appium_Activities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity3_1 {
    AppiumDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 4 Pie");
        caps.setCapability("platformName", "Android");
        caps.setCapability("noReset", true);
        // Use your own device's messaging app
        caps.setCapability("appPackage", "com.google.android.apps.messaging");//com.google.android.apps.messaging
        caps.setCapability("appActivity", ".ui.ConversationListActivity");//.ui.ConversationListActivity

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 5);
    }

    @Test
    public void smsTest() {
        // Locate the button to write a new message and click it
        driver.findElement(MobileBy.AndroidUIAutomator("description(\"Start new conversation\")")).click();

        // Enter the number to send message to
        //String contactBoxLocator = "resourceId(\"com.microsoft.android.smsorganizer:id/auto_complete_contact\")";
        String contactBoxLocator = "resourceId(\"com.google.android.apps.messaging:id/recipient_text_view\")";
        driver.findElement(MobileBy.AndroidUIAutomator(contactBoxLocator)).click();
        MobileElement contactBoxInput = driver.findElement(MobileBy.AndroidUIAutomator(contactBoxLocator));
        contactBoxInput.sendKeys("1234567890");
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("contact_picker_create_group")));
        
        // Enter your own phone number
        //driver.findElement(MobileBy.AndroidUIAutomator(contactBoxLocator)).sendKeys("1234567890");
        //com.google.android.apps.messaging:id/contact_picker_create_group
        String contactLocator = "resourceId(\"com.google.android.apps.messaging:id/contact_picker_create_group\")";
        driver.findElement(MobileBy.AndroidUIAutomator(contactLocator)).click();
       
        
        //Focus on the message text box
        
        String messageBoxLocator = "resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")";
        driver.findElement(MobileBy.AndroidUIAutomator(messageBoxLocator)).click();

        // Type in a message
        //messageBoxLocator = "resourceId(\"com.microsoft.android.smsorganizer:id/sms_edit_text\")";
        MobileElement composeMessageInput = driver.findElement(MobileBy.AndroidUIAutomator(messageBoxLocator));
        composeMessageInput.sendKeys("Hello from Appium");

        // Send the message
        driver.findElement(MobileBy.AndroidUIAutomator("description(\"Send SMS\")")).click();

        // Wait for message to show
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("message_text_view")));

        // Assertion
        String messageLocator = "resourceId(\"com.microsoft.android.smsorganizer:id/message_text_view\")";
        String sentMessageText = driver.findElement(MobileBy.AndroidUIAutomator(messageLocator)).getText();
        Assert.assertEquals(sentMessageText, "Hello from Appium");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
    
}
