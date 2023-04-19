package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.core.backend.Status;

public class AddressCheckout {
	

	WebDriver driver;
	
	//Locaters for signup
	By signupName=By.xpath("//input[@name=\"name\"]");
	
	By Mailid=By.xpath("(//input[@name=\"email\"])[2]");
	
	By signupButton=By.xpath("(//button[@type=\"submit\"])[2]");
	
	By password=By.xpath("//input[@id=\"password\"]");
	
	By firstName=By.xpath("//input[@id=\"first_name\"]");
	
	By lastName=By.xpath("//input[@id=\"last_name\"]");
	
	By Address1=By.xpath("//input[@id=\"address1\"]");
	
	By country=By.xpath("//*[@id=\"country\"]");
	
	By State=By.xpath("//input[@id=\"state\"]");
	
	By City=By.xpath("//input[@id=\"city\"]");
	
	By Zipcode=By.xpath("//input[@id=\"zipcode\"]");
	
   By mobileNumber=By.xpath("//input[@id=\"mobile_number\"]");
   
   By CreateAcnt=By.xpath("(//button[@class=\"btn btn-default\"])[1]");
   
   
   //VeriftAccount Created
   
   By AcuntTextField=By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");
   
   By Continuebutton=By.xpath("//a[@class=\"btn btn-primary\"]");
   
   By LoginnameText=By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[10]/a");
   
   //AfterviewCart
   By proceed =By.xpath("//a[@class=\"btn btn-default check_out\"]");
   
   By VerifyDeliveryAddress=By.xpath("//*[@id=\"address_delivery\"]/li[7]");
   
   By VerifyBllingAdrs=By.xpath("//*[@id=\"address_invoice\"]/li[7]");
   
   //Delete Account
   By deleteAcunt=By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[5]/a");
   By AcountDeletedText=By.xpath("//*[@id=\"form\"]/div/div/div/h2");
   By lastContinuebutton=By.xpath("//*[@id=\"form\"]/div/div/div/div/a");
   
   boolean Status=false;
   //methods
   public AddressCheckout(WebDriver driver)
	{
		this.driver = driver;
	}
   
   public void CreateAccount(String Name,String MailId,String pwd,String Fname,String Lname,String ads, String state,String city,String zipcode,String mobileNUM) {
	   driver.findElement(signupName).sendKeys(Name);
	   driver.findElement(Mailid).sendKeys(MailId);
	   driver.findElement(signupButton).click();
	   driver.findElement(password).sendKeys(pwd);
	   driver.findElement(firstName).sendKeys(Fname);
	   driver.findElement(lastName).sendKeys(Lname);
	   driver.findElement(Address1).sendKeys(ads);
	   
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,600)", "");
	    
	 
	    Select Country1=new Select(driver.findElement(country));
	    Country1.selectByVisibleText("India");
	   driver.findElement(State).sendKeys(state);
	   driver.findElement(City).sendKeys(city);
	   driver.findElement(Zipcode).sendKeys(zipcode);
	   driver.findElement(mobileNumber).sendKeys(mobileNUM);
	   driver.findElement(CreateAcnt).click();
   }
   
   public String VeriftAcuntTextField() {
//	   WebElement ele=new WebDriverWait(driver,Duration.ofSeconds(10))
//				.until(ExpectedConditions.alertIsPresent(ExpectedConditions.visibilityOfAllElements("AcuntTextField")));
//					ele.click();
	   //act=new Actions(driver);
	   //driver.getWindowHandles();
	  // driver.switchTo().alert().dismiss();;
//	   driver.switchTo().alert().sendKeys("No thanks");
	   String Acc=driver.findElement(AcuntTextField).getText();
	   return Acc;
   }
	   
   public void ClickContinuebutton() {
	   
	   driver.findElement(Continuebutton).click();
   }
   
   public  String VerifyLoginNameText() {
	   String name=driver.findElement(LoginnameText).getText();
	   return name;
   }
   
   public void ClickonProceedtoCheckout() {
	   driver.findElement(proceed).click();
   }
   
   public  String VerifyDeliveryAddress() {
	   String adrs=driver.findElement(VerifyDeliveryAddress).getText();
	   return adrs;
   }
   
   public String verifyBillingAddress() {
	   String Badrs=driver.findElement(VerifyBllingAdrs).getText();
	   return Badrs;
   }
   public void ClickdeleteAccount() {
	  // JavascriptExecutor js1 = (JavascriptExecutor) driver;
	    //js1.executeScript("window.scrollBy(0,-10000)", "");
	   driver.findElement(deleteAcunt).click();
   }
   
   public String  VerifydeletedText() {
	   String txt=driver.findElement(AcountDeletedText).getText();
	   return txt;
	   
   }
   public void ClickonfinalcontinueButton() {
	   driver.findElement(lastContinuebutton).click();
   }
   
	   
	   
	   
   
}