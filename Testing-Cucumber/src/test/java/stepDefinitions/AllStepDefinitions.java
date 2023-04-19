package stepDefinitions;
	import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;


import Pages.AddingProducts;
import Pages.AddressCheckout;
import Pages.Contactus;
import Pages.Login;
import Pages.Placeorder;
import Pages.Scroling;
import Pages.SearchProduct;
import Pages.ViewCategory;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AllStepDefinitions {

	
	Login page ;
	Contactus contactpage;
	SearchProduct SearchPage;
	Scroling scroll;
	AddingProducts addcart;
	ViewCategory Category;
	AddressCheckout address;
	Placeorder order;
   static WebDriver  driver;

	
	
	

	//1>StepDefinations for Loginpage
	@Given("user is able to open the URL")
	public void user_is_able_to_open_the_url() throws InterruptedException {
		System.out.println("I am inside the browser ");
		
		 String projectpath =System.getProperty("user.dir");
		 System.out.println("project path:"+projectpath);

		 
//		  driver = new EdgeDriver();
		 ChromeOptions ops = new ChromeOptions();
		 System.setProperty("webdriver.chrome.driver",projectpath+"/src/main/resources/driver/chromedriver.exe"); 
		ops.addArguments("--remote-allow-origins=*");
		 driver= new ChromeDriver(ops);
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com");
		Thread.sleep(3000);
        contactpage=new Contactus(driver);
		System.out.println("user lauanced the URL");
	}
	

	@And("user is click on  sign up button")
	public void user_is_click_on_signup_login_button()
	{	        	 
		page = new Login(driver);	        
		page.clickloginbutton();	        	

	}

	@When("user enters incorrect {string} and {string}")
	public void user_enters_incorrect_email_and_password(String mailId,String pwd) 
	{
		page = new Login(driver);
		page.enteremailandpassword(mailId,pwd);
	}

	@Then("user should see an error message")
	public void user_should_see_an_error_message() {
		page = new Login(driver);
	    String ActaulErrormesg="Your email or password is incorrect!";
	    String ExpectedErrormesg=page.getErrorMessage();
	    assertEquals(ActaulErrormesg,ExpectedErrormesg);
		      	
		page.tearDownBrowser();	        	
	}







	//2>step definitions for contact us form page

	@And("Verify that home page is visible successfully")
	public void ValididateHomePage() {
		contactpage=new Contactus(driver);
		String ActualText="Home";
		String Expectedtext=contactpage.HomebuttonisPresent();
		assertEquals(ActualText,Expectedtext);

	}

	@When ("Click on Contact Us button and verify {string} is visible")
	public void ClickContactVerifyHeaderName(String HeaderName) 
	{
		contactpage=new Contactus(driver);

		contactpage.clickonContactbutton();
		String Actualtext="GET IN TOUCH";
		String ExpectedText=contactpage.VerifyGetinTouchText();
		assertEquals(Actualtext,ExpectedText);
	}





	@Then ("Enter {string}, {string}, {string} and {string}")
	public void EnterContactDetails(String Name,String Email,String Subject,String Message) {
		contactpage=new Contactus(driver);

		contactpage.enterContactDetails(Name, Email, Subject, Message);


	}

	@And ("Upload File in Contact Form")

	public void UploadFile() {
		contactpage=new Contactus(driver);
		contactpage.Uploadfile();
	}


	@Then ("Click on Submit Button")
	public void ClickSubmitonContact() {
		contactpage=new Contactus(driver);
		contactpage.ClickSubmit();
	}

	@And ("Verify Success Message")
	public void Validatesuccessmessage() {
		contactpage=new Contactus(driver);
		
		String Actalsuccessmesg="Success! Your details have been submitted successfully.";
		String Expectedsuccessmesg=contactpage.SuccessMesg();
		assertEquals(Actalsuccessmesg,Expectedsuccessmesg);

	}



	@Then ("Click on home button and verify home page")
	public void clickHomeButtonAndVerifyHomepage() {
		page = new Login(driver);
		contactpage=new Contactus(driver);
		contactpage.ClickHomebutton();
		ValididateHomePage();
		page.tearDownBrowser();	 
	}





	//3>Stepdefinitions for SearchProductpage

	@When("click on Products button and verify {string} page is visible")
	public void ClickproductbuttonandverifyHeader(String Header) throws InterruptedException {
		SearchPage=new SearchProduct(driver);
		Thread.sleep(3000);
		SearchPage.ClickProductButton();
		String actualtext="ALL PRODUCTS";
		String expectedtext=SearchPage.ProductsTextField();
		assertEquals(actualtext,expectedtext);


	}


	@Then("Enter product name in search input and click search button")
	public void enter_product_name_in_search_input_and_click_search_button() {
		SearchPage=new SearchProduct(driver);
		SearchPage.ClickSearchProduct();
		SearchPage.ClicksearchSymbol();

	}



	 @Then("verify {string} is visible")
	 public void verify_is_visible(String Value) {	        	
		SearchPage=new SearchProduct(driver);
		String actualText="SEARCHED PRODUCTS";
		String expctedtext=SearchPage.validateSearchedproductText();
		assertEquals(actualText,expctedtext);
				
	}

	@And("Verify all the products related to {string} are visible")	        	
	public void ValidateProductsonDisplay(String Value){
		SearchPage=new SearchProduct(driver);
		page = new Login(driver);	
		String actualproduct="Blue Top";
		String expectedproduct=SearchPage.validateSearchedProduct();
		assertEquals(actualproduct,expectedproduct);
		page.tearDownBrowser();
	}




	//4> stpesdefinations for scrollingpage


	@When("Scrolldown page to bottom and Verify SUBSCRIPTION is visible")
	public void scrolldown_page_to_bottom_and_verify_subscription_is_visible() {
		scroll= new Scroling(driver);
		scroll.Scrolldown();
		String actualText=scroll.subscriptionTextisDisplayed();
		String expectedtext="SUBSCRIPTION";
		assertEquals(actualText,expectedtext);
		 
		
	}

	@Then("Scrollup page to top")
	public void scrollup_page_to_top() {
		scroll= new Scroling(driver);
		scroll.Scrollup();
	} 

	@Then("Verify that page is scrolled up and Full-Fledged practice website for Automation Engineers text is visible on screen")
	public void verify_that_page_is_scrolled_up_and_full_fledged_practice_website_for_automation_engineers_text_is_visible_on_screen() {
		scroll= new Scroling(driver);
		page = new Login(driver);	
		String actualtext=scroll.VerifyMaintext();
		String expectedtext="Full-Fledged practice website for Automation Engineers";
		assertEquals(actualtext,expectedtext);
		page.tearDownBrowser();
	}




	//5>StepDefinations for Products Add to cart 


	@Then("Hover over first product and click Add to cart")
	public void hover_over_first_product_and_click() {
		addcart=new AddingProducts(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)", "");
		// addcart.scrolldown();
		addcart.AddCart1();



	}

	@Then("Click Continue Shopping button")
	public void click_button() {
		addcart=new AddingProducts(driver);
		addcart.ClickContinuebtton();


	}

	@Then("Hover over second product and click Add to cart")
	public void hover_over_second_product_and_click() {
		addcart=new AddingProducts(driver);
		addcart.AddCart2();

	}

	@And ("Click View Cart button")
	public void viewcartbutton() {
		addcart=new AddingProducts(driver);
		addcart.ViewCartButton();
	}

	@Then("Verify both products are added to Cart")
	public void verify_both_products_are_added_to_cart() {
		addcart=new AddingProducts(driver);
		addcart.VerifyCartproducts();
		System.out.println("Selected products are displayed : "+ addcart.VerifyCartproducts());


	}

	@Then("Verify their prices, quantity and total price")
	public void verify_their_prices_quantity_and_total_price() {
		addcart=new AddingProducts(driver);
		page = new Login(driver);
		if(addcart.verifyprice_qty_totalPriceAreDisplayed()) {
			System.out.println(" All values in Cart are displayed: "+addcart.verifyprice_qty_totalPriceAreDisplayed());
		}	        		
		page.tearDownBrowser();
	}


	//6>Stepdefinations for Viewcategorypage



	@Then("Verify that {string} are visible on left side bar")
	public void verify_that_are_visible_on_left_side_bar(String textname) {

		Category = new ViewCategory(driver);
		String Actaultext="CATEGORY";
		String Expectedtext=Category.verifyCategoryField();
		assertEquals(Actaultext,Expectedtext);

	}

	@Then("Click on Women category")
	public void click_on_women_category() {
		Category = new ViewCategory(driver);
		Category.clickonwomenButton();
	}

	@When("Click on any category link under Women category")
	public void click_on_any_category_link_under_women_category() {
		Category = new ViewCategory(driver);
		Category.ClickOnTopbutton();
		
	}

	@When("Verify that category page is displayed and confirm text WOMEN - TOPS PRODUCTS")
	public void verify_that_category_page_is_displayed_and_confirm_text_women_tops_products() {
		Category = new ViewCategory(driver);
		String actualtext="WOMEN - TOPS PRODUCTS";
		String Expectedtext=Category.verifyWomentextField();
		assertEquals(actualtext,Expectedtext);
	}

	@When("click on any sub-category link of Men category")
	public void click_on_any_sub_category_link_of_men_category() {
		Category = new ViewCategory(driver);
		Category.ClickOnmenButton();
		Category.clickonTshirt();
	}

	@When("Verify that user is navigated to that category page")
	public void verify_that_user_is_navigated_to_that_category_page() {
		Category = new ViewCategory(driver);
		page = new Login(driver);
		String ActualTextfield="MEN - TSHIRTS PRODUCTS";
		String Expectedttextfield=Category.VerifyMenTextfield();
		assertEquals(ActualTextfield,Expectedttextfield);
		page.tearDownBrowser();
	}


	//7>Step Definations for AddressCheckoutPage



	@Then("Enter {string} , {string},{string},{string} ,{string},{string},{string} , {string},{string} and {string}")
	public void enter_and(String Name, String MailId, String pwd, String Fname, String Lname, String ads, String state, String city, String zipcode, String mobileNUM) {
		address =new AddressCheckout(driver);
		address.CreateAccount(Name,MailId,pwd,Fname,Lname,ads,state,city,zipcode,mobileNUM);
	}



	@Then("Verify ACCOUNT CREATED! and click Continue button")
	public void verify_account_created_and_click_continue_button() {

		address =new AddressCheckout(driver);

		String actualtext=address.VeriftAcuntTextField();
		String expectedtext="ACCOUNT CREATED!";
		assertEquals(actualtext,expectedtext);
		address.ClickContinuebutton();
	}



	@Then("Verify Logged in as username at top")
	public void verify_logged_in_as_username_at_top() {
		address =new AddressCheckout(driver);
		String actualtext=address.VerifyLoginNameText();
		String expectedtext="Logged in as Swapna";
		assertEquals(actualtext,expectedtext);

	}




	@Then("and Click Proceed To Checkout")
	public void and_click_proceed_to_checkout() {
		address =new AddressCheckout(driver);

		address.ClickonProceedtoCheckout();
	}


	@Then("Verify that the delivery address is same address filled at the time registration of account")
	public void verify_that_the_delivery_address_is_same_address_filled_at_the_time_registration_of_account() {
		address =new AddressCheckout(driver);

		String Actualaddress=address.VerifyDeliveryAddress();
		String Expectedaddress="India";
		assertEquals(Actualaddress,Expectedaddress);
	}




	@Then("Verify that the billing address is same address filled at the time registration of account")
	public void verify_that_the_billing_address_is_same_address_filled_at_the_time_registration_of_account() {
		address =new AddressCheckout(driver);

		String ActualADD=address.verifyBillingAddress();
		String expectedADD="India";
		assertEquals(ActualADD,expectedADD);
	}


	@Then("Click Delete Account button")
	public void click_delete_account_button() {
		address =new AddressCheckout(driver);
		address.ClickdeleteAccount();
	}


	@Then("Verify ACCOUNT DELETED!and click Continue button")
	public void verify_account_deleted_and_click_continue_button() {
		address =new AddressCheckout(driver);
		page = new Login(driver);
		
		String Actualtxt=address.VerifydeletedText();
		String expectedtxt="ACCOUNT DELETED!";
		assertEquals(Actualtxt,expectedtxt);
		
		address.ClickonfinalcontinueButton();

		page.tearDownBrowser();

	}

	


	//8>StepDefinationsfor Placeorderpage    



	@Then("Enter description in comment text area and click Place Order")
	public void enter_description_in_comment_text_area_and_click_place_order() {

		order=new Placeorder(driver);
		order.EnterComment();
		order.ClickonPlaceOrderbutton();
	}



	@Then("Enter payment details")
	public void enter_payment_details() throws FileNotFoundException, IOException, ParseException {
		order=new Placeorder(driver);
		order.EnterPaymentDetails();


	}


	@Then("Click Pay and Confirm Order button")
	public void click_pay_and_confirm_order_button() {
		order=new Placeorder(driver);
		order.ClickonpayandPlaceOrder();
	}


	@Then("Verify success message Your order has been placed successfully!")
	public void verify_success_message_your_order_has_been_placed_successfully() {
		order=new Placeorder(driver);
		page = new Login(driver);
		String Actualmesg=order.VerifySuccessmesg();
		String expectedmesg="Congratulations! Your order has been confirmed!";
		assertEquals(Actualmesg,expectedmesg);
		page.tearDownBrowser();
	}
	
	
	//For Taking Screenshot
	@After(order = 1)
	public void takeScreenshot(Scenario scenario) {
		if(scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] src = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(src, "image/png", "screenshot");
			
		}
	}
			
	@After(order = 0)
	public void tearDown() {
		driver.quit();
	}
	
	
	

}
