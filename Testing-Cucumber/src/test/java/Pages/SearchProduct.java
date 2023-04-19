package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchProduct {

	WebDriver driver;
	
	By Productbutton=By.xpath("//a[@href=\"/products\"]");
	
	By AllproductsText=By.xpath("//h2[@class=\"title text-center\"]");
	
	By Searchproduct=By.xpath("//input[@id=\"search_product\"]");
	
	By SearchSymbol=By.xpath("//i[@class=\"fa fa-search\"]");
	
	By SearchedproductsText=By.xpath("//h2[@class='title text-center']");
	
	By MatchwithSearchedProduct=By.xpath("(//p[text()='Blue Top'])[1]");
	
	boolean Status=false;
	
	public SearchProduct(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void ClickProductButton() {
		driver.findElement(Productbutton).click();
		
	}
	
	public String ProductsTextField() {
		String  text=driver.findElement(AllproductsText).getText();
		return text;
	}
	
	public void ClickSearchProduct() {
		
		driver.findElement(Searchproduct).sendKeys("blue top");
	}
	
	public void ClicksearchSymbol() {
		driver.findElement(SearchSymbol).click();
	}
	
	public String validateSearchedproductText() {
		String product =driver.findElement(SearchedproductsText).getText();
		return product;
	}
	
	public String validateSearchedProduct() {
		String Value =driver.findElement(MatchwithSearchedProduct).getText();
		return Value;
	}
	
	
	
	
	
}

