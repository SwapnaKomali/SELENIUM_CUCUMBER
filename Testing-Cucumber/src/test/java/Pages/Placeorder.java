package Pages;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Placeorder {
	WebDriver driver;
	
	//forDescription and place order
	By descriptionText=By.xpath("//*[@id=\"ordermsg\"]/textarea");
	By placeOrderbutton=By.xpath("//*[@id=\"cart_items\"]/div/div[7]/a");
	
	//Payment Details
	By Cardname=By.xpath("//*[@id=\"payment-form\"]/div[1]/div/input");
	By cardNumner=By.xpath("//*[@id=\"payment-form\"]/div[2]/div/input");
	By cvCnumber=By.xpath("//*[@id=\"payment-form\"]/div[3]/div[1]/input");
	By Expirationmonth=By.xpath("//*[@id=\"payment-form\"]/div[3]/div[2]/input");
	By ExpirationYear=By.xpath("//*[@id=\"payment-form\"]/div[3]/div[3]/input");
	
	
	By Paybutton=By.xpath("//*[@id=\"submit\"]");
	
	By SuccessMesg=By.xpath("//*[@id=\"form\"]/div/div/div/p");
	
	
	private static final readpayment rp = new readpayment();
	String cn=rp.getcardname();
	String cnum=rp.getcardnumebr();
	String cvNUM=rp.getcvcnum();
	String exprmonth=rp.getexpmonth();
	String expyear=rp.getexpyear();
	 boolean Status=false;
	//Methods
	 
	 public Placeorder(WebDriver driver)
		{
			this.driver = driver;
		}
	
	public void EnterComment() {
		
		driver.findElement(descriptionText).sendKeys("ThankYou");
	}
	
	public void ClickonPlaceOrderbutton() {
		
		driver.findElement(placeOrderbutton).click();
	}
	
	public void EnterPaymentDetails() throws FileNotFoundException, IOException, ParseException {
		
		driver.findElement(Cardname).sendKeys(cn);
		driver.findElement(cardNumner).sendKeys(cnum);
		driver.findElement(cvCnumber).sendKeys(cvNUM);
		driver.findElement(Expirationmonth).sendKeys(exprmonth);
		driver.findElement(ExpirationYear).sendKeys(expyear);
		
	}
	
	public void ClickonpayandPlaceOrder() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	 	    js.executeScript("window.scrollBy(0,400)", "");
		driver.findElement(Paybutton).click();
	}
	
	
	public String  VerifySuccessmesg() {
		String mesg=driver.findElement(SuccessMesg).getText();
		return mesg;
	}
	
	
	
	
	
}


