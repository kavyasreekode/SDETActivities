package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	
	static WebDriver driver = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver, 10);

}
