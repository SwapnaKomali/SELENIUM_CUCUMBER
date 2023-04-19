package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewCategory {
	WebDriver driver;
	By categoryText=By.xpath("//div[@class=\"left-sidebar\"]/h2");
	
	By Womenbutton=By.xpath("//a[@href=\"#Women\"]");
	
	By Topbutton=By.xpath("//*[@id='Women']/div/ul/li[2]/a");
	
	By WomenTextField=By.xpath("//div[@class=\"features_items\"]/h2");
	
	By mentext=By.xpath("//a[@href=\"#Men\"]");
	
	By tshirtbutton=By.xpath("//a[@href=\"/category_products/3\"]");
	
	By menTextField=By.xpath("//h2[@class=\"title text-center\"]");
	
    Boolean Status=false;

	
	public ViewCategory(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public String verifyCategoryField() {
	String value=driver.findElement(categoryText).getText();
		return value;
	}
	
	public void clickonwomenButton() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	 	    js.executeScript("window.scrollBy(0,400)", "");
		driver.findElement(Womenbutton).click();
	}
	
	public void ClickOnTopbutton() {
//		 JavascriptExecutor js = (JavascriptExecutor) driver;
// 	    js.executeScript("window.scrollBy(0,400)", "");
		WebElement ele=new WebDriverWait(driver,Duration.ofSeconds(10))
	.until(ExpectedConditions.elementToBeClickable(Topbutton));
		ele.click();
	}
	
	
	public String verifyWomentextField() {
		String text=driver.findElement(WomenTextField).getText();
		return text;
	}
	
	public void ClickOnmenButton() {
		driver.findElement(mentext).click();
	}
	
	public void clickonTshirt() {
		WebElement ele1=new WebDriverWait(driver,Duration.ofSeconds(10))
	.until(ExpectedConditions.elementToBeClickable(tshirtbutton));
         ele1.click();
	}
	
	public String VerifyMenTextfield() {
		String menText=driver.findElement(menTextField).getText();
		return menText;
				
	}
	
	
	
}
