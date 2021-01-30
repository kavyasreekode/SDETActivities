package Appium_Project;

import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Task_Activity1 {
	
  AppiumDriver<MobileElement> driver = null;

  @BeforeTest
  public void beforeClass() throws MalformedURLException {
      // Set the Desired Capabilities
      DesiredCapabilities caps = new DesiredCapabilities();
      caps.setCapability("deviceName", "Pixel 4 Pie");
      caps.setCapability("platformName", "Android");
      caps.setCapability("automationName", "UiAutomator2");
      caps.setCapability("appPackage", "com.google.android.apps.tasks");
      caps.setCapability("appActivity", ".ui.TaskListsActivity");
      caps.setCapability("noReset", true);

      // Instantiate Appium Driver
      URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
      driver = new AndroidDriver<MobileElement>(appServer, caps);
  }


@Test
public void addTask() {
	String[] tasks = {"Complete Activity with Google Tasks", "Complete Activity with Google Keep", "Complete the second Activity Google Keep"};
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	for (String s : tasks) {
		driver.findElement(By.id("com.google.android.apps.tasks:id/tasks_fab")).click();
		driver.findElement(By.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys(s);
		driver.findElement(By.id("com.google.android.apps.tasks:id/add_task_done")).click();
	}
	List<MobileElement> created_Tasks = driver.findElements(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.tasks:id/task_name\")"));
	int count = (created_Tasks.size());
	Assert.assertEquals(count, 3);
	System.out.println("No of tasks created:" +count);
}	

@AfterTest
public void tearDown() {
	driver.quit();
}
}






