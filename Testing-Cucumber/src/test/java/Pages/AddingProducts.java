package Pages;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddingProducts {

	WebDriver driver;
	
	
	

	// By firstproduct=By.xpath("(//a[@data-product-id=\"1\"])[1]");
	// By SecondProduct=By.xpath("(//a[@data-product-id=\"2\"])[1]");
	
	@FindBy(xpath="//*[@id='cartModal']/div/div/div[3]/button")
    WebElement Continuebutton;
	
	
	By Cartbutton = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u");
	

	@FindBy(xpath = "(//div[@class=\"productinfo text-center\"])[1]")
	WebElement ImageFrame1;
	@FindBy(xpath = "(//div[@class=\"productinfo text-center\"])[3]")
	WebElement ImageFrame2;

	@FindBy(xpath = "(//a[@class=\"btn btn-default add-to-cart\"])[1]")
	WebElement ClickOnAddcart1;
	
	@FindBy(xpath = "(//a[@class=\"btn btn-default add-to-cart\"])[3]")
	WebElement ClickOnAddcart2;
	
	By CartProduct1 = By.xpath("//*[@id='product-1']/td[1]");
	By CartProduct2 = By.xpath("//*[@id='product-2']/td[1]/a/img");
	
	boolean Status = false;
	public WebDriverWait Wait;

	public AddingProducts(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	public void scrolldown() {
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
	//	js1.executeScript("arguments[0].scrollIntoView();",ImageFrame1);
		
		js1.executeScript("window.scrollBy(0,600)", "");
	}
	

	public void AddCart1() {
		Actions PA = new Actions(driver);
		PA.moveToElement(ImageFrame1);
		ClickOnAddcart1.click();
	}

	
	
	public void ClickContinuebtton() {
		
		//Wait.until(ExpectedConditions.visibilityOf(Continuebutton));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(Continuebutton)); 
		wait.until(ExpectedConditions.elementToBeClickable(Continuebutton));
		Continuebutton.click();
	}
	
	
	public void AddCart2() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ImageFrame2)); 
	   Actions PA = new Actions(driver);
		PA.moveToElement(ImageFrame2);
		ClickOnAddcart2.click();
	}


	public void ViewCartButton() {
		WebElement ele=new WebDriverWait(driver,Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(Cartbutton));
					ele.click();

	}

	public boolean VerifyCartproducts() {
		
		if (driver.findElement(CartProduct1).isEnabled() && driver.findElement(CartProduct2).isEnabled()) {
			Status = true;
		}
		return Status;
	}

	public boolean verifyprice_qty_totalPriceAreDisplayed() {

		for (int i = 1; i < 3; i++) {
			List<WebElement> elementsInTable = driver.findElements(By.xpath("//*[@id=\"product-" + i + "\"]/td"));
			for (WebElement element : elementsInTable) {
				if (element.isDisplayed()) {
					Status = true;
				}
			}
		}
		return Status;
	}

}
