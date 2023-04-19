package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Contactus {
        WebDriver driver;
        
	By HomepageText=By.xpath("//a[text()=\" Home\"]");
	
	By ContactButton=By.xpath("//a[@href=\"/contact_us\"]");
	
	By VerifyText=By.xpath("//*[@id='contact-page']/div[2]/div[1]/div/h2");
	
	By nameTextField=By.xpath("(//input[@type=\"text\"])[1]");
	
	By mailIdTextField=By.xpath("(//input[@type=\"email\"])[1]");
	
	By SubjectTextField=By.xpath("//input[@data-qa=\"subject\"]");
	
	By messageField=By.xpath("//textarea[@name=\"message\"]");
	
	By UploadFile=By.xpath("//input[@name=\"upload_file\"]");
	
	By Submitbutton=By.xpath("//input[@type=\"submit\"]");
	
	By SuccessMessage=By.xpath("//div[@class=\"status alert alert-success\"]");
	
	By HomeButton=By.xpath("//*[@id=\"form-section\"]/a/span");
	
	Boolean status= false;
	
	public Contactus(WebDriver driver1)
	{
		this.driver = driver1;
	}
	
	public String HomebuttonisPresent() {
		String button= driver.findElement(HomepageText).getText();
		
		return button;
	}
	
	public void clickonContactbutton() {
		driver.findElement(ContactButton).click();
		
	}
	
	public String  VerifyGetinTouchText() {
		String text=driver.findElement(VerifyText).getText();
		return text;
	}
	
	
	public void enterContactDetails(String Name,String Email,String Subject,String Message) {
		driver.findElement(nameTextField).sendKeys(Name);
		driver.findElement(mailIdTextField).sendKeys(Email);
		
		driver.findElement(SubjectTextField).sendKeys(Subject);
		driver.findElement(messageField).sendKeys(Message);
	}
	
	public void Uploadfile() {
		driver.findElement(UploadFile).sendKeys("C:\\Users\\SKOMALI\\Downloads\\Internetbill April.pdf");
	}
	public void ClickSubmit() {
		driver.findElement(Submitbutton).click();
		driver.switchTo().alert().accept();
	}
	
	public String SuccessMesg() {
		String message=driver.findElement(SuccessMessage).getText();
	return message;
	}
	public void ClickHomebutton() {
		driver.findElement(HomeButton).click();
	}
	
}
