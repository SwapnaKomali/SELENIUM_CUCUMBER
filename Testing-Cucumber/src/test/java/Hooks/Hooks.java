package Hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
   public WebDriver driver;
	@Before
	public void Launchdriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SKOMALI\\eclipse-workspace\\Testing-Cucumber\\src\\main\\resources\\driver\\chromedriver.exe");
        driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");
	}
	@After
	public void Closethedriver() {
		driver.quit();
	}
	
}
