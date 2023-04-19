package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scroling {
	WebDriver driver;
	
	
		
	By Subscription=By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2");
	
	By TextField= By.xpath("(//h2[contains(text(),\"Full-Fledged \")])[1]");
     
	Boolean Status=false;
	public WebDriverWait wait;
	
	public Scroling(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void Scrolldown() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView()",Subscription );
		
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
	}
	
	public String subscriptionTextisDisplayed() {
		//wait.until(ExpectedConditions.visibilityOf());
		String Text=driver.findElement(Subscription).getText();
		return Text;
	
	}
	
	public void Scrollup() {
		
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",TextField);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
	    js1.executeScript("window.scrollBy(0,-10000)", "");
		
      }
	public String VerifyMaintext() {
		String VT=driver.findElement(TextField).getText();
		return VT;
	}}
