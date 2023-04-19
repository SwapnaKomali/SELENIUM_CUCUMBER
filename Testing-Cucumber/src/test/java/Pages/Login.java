package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

	WebDriver driver;
	
	By loginButton = By.xpath("//a[@href='/login']");
	
	By emailTextField = By.xpath("(//input[@type=\"email\"])[1]");
	
	By passwordTextField =(By.xpath("//input[@type=\"password\"]"));
	
	By clickButton = By.xpath("(//button[@type=\"submit\"])[1]");
	
	By errorMessage = By.xpath("//p[contains(text(),\"Your email or password is incorrect!\")]");
	
	public Login(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	public void clickloginbutton() 
	{
		driver.findElement(loginButton).click();
	}
	

   
	
  public void enteremailandpassword(String mailId,String pwd) {
	  

    driver.findElement(emailTextField).sendKeys(mailId);
    driver.findElement(passwordTextField).sendKeys(pwd);
    driver.findElement(clickButton).click();
  
  }
  
  public String getErrorMessage() {
	 String message = driver.findElement(errorMessage).getText();
	 return message;
  }
  
  public void tearDownBrowser() {
	  	  
     driver.quit();
  }
 
}
