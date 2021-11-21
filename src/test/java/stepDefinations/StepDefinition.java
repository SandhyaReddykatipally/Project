//install tidy gherkin plugin in chrome

package stepDefinations;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Activity;
import pageObjects.SigninPage;

public class StepDefinition  {

	public WebDriver driver;

	//Invoking the chrome browser

	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome()  {

		System.setProperty("webdriver.chrome.driver","C:\\Users\\KASANDHY\\Documents\\SELENIUM\\chromedriver_win32\\chromedriver.exe" );
		driver=new ChromeDriver();
	}

	//Navigating to Url

	@And("^Navigate to  \"([^\"]*)\" site$")
	public void navigate_to_something_site(String url) {
		driver.get(url);  

		driver.manage().window().maximize();//Maximizing the window

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");//Scroll down

	}

	//Login Home Page

	@And("^Click on Login link in home page to land on Secure sign in Page$")
	public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page() throws Throwable {

		SigninPage l= new SigninPage(driver);
		l.getLoginbtn().click();

	}

	//Entering Usename and Password

	@When("^I entered valid (.+) and valid (.+) logs in$")
	public void i_entered_valid_and_valid_logs_in(String username, String password) throws Throwable {

		SigninPage lp=new SigninPage(driver);
		lp.getUsername().sendKeys(username);//Entering username
		lp.getPassword().sendKeys(password);//Entering password
		lp.getSignin().click();//click On Sigin
	}

	@Then("^Click on signin button$")
	public void click_on_signin_button()  {

		System.out.println("Login Sucessfull");
	}


	//Dashboard----------

	@Given("User get the dashboard")
	public void user_get_the_dashboard() {

		System.out.println("User get the dashboard");
	}

	@And("tap on Activity")
	public void tap_on_activity() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");//Scroll down the page


		System.out.println("user Get the Activity option");


	}

	@And("user obtain Some options")
	public void user_obtain_some_options() {

		System.out.println("User obtain Different type of comments");

	}

	@When("person tap on option")
	public void person_tap_on_option() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);//wait

		Activity a =new Activity(driver);//Creating object
		a.getAll().click();//All Comments
		driver.navigate().back();

		a.getPending().click();//Pending Comments
		driver.navigate().back();//Get back to the previous page

		a.getApproved().click();//Approved Comments
		driver.navigate().back();

		a.getSpam().click();//Spam Comments
		driver.navigate().back();

		a.getTrash().click();//Trash Comments
		driver.navigate().back();//Get back to the previous page
	}

	@Then("Each option should be easily  reachable")
	public void each_option_should_be_easily_reachable() {
		System.out.println("Each option is easily  reachable by the User");
		driver.close();//close
	}




	//At a Glance

	@Given("User clicks on At a glance drapdown")
	public void user_clicks_on_at_a_glance_drapdown() throws InterruptedException {

		System.out.println("User clicks on At a glance drapdown ");
	}

	@And("User gets few options")
	public void user_gets_few_options() throws InterruptedException {


		System.out.println("User gets Posts,Pages,Comments,Moderations options");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");//Scroll down the page


	}

	@When("User clicks on each option")
	public void user_clicks_on_each_option() throws InterruptedException  {


		for(int i=1;i<=3;i++) {
			driver.findElement(By.xpath("//*[@id='dashboard_right_now']//ul//li["+ i +"]//a")).click(); //iteration using loops

			driver.manage().timeouts().implicitlyWait(2,TimeUnit.MINUTES);//wait
			driver.navigate().back();	//Get back to the previous page
		}
	}

	@Then("Each options available should be accessible")
	public void each_options_available_should_be_accessible() {

		System.out.println("Each options accessed by User");
	}


	//Quick Draft--------------------------------

	@Given("Entering text in Title box")
	public void entering_text_in_title_box() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");//Scroll down the page

		driver.findElement(By.id("title")).sendKeys("Real Estate");
	}

	@Given("Adding text to the content box")
	public void adding_text_to_the_content_box() {

		driver.findElement(By.xpath("//*[@id='content']")).sendKeys("Land For Sale sq2000 near by Kphb");
	}

	@Then("hit on Save Draft button")
	public void hit_on_save_draft_button() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id='save-post'][@name='save']")).click();
		System.out.println("Message saved in draft");
		driver.close();
	}

	//WordPress Event and News----------------------------------

	@Given("user go to  WordPress Events and News")
	public void user_go_to_word_press_events_and_news() {

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,700)", "");//Scroll down the page
	}

	@When("Options are available to the user")
	public void options_are_available_to_the_user() throws InterruptedException {

		//Get meetups
		driver.findElement(By.xpath("//*[@id=\"dashboard_primary\"]//p//a[1]")).click();

		Set<String> windows = driver.getWindowHandles(); // multiple WindowHandling
		Iterator<String>it = windows.iterator();
		String ParentWindow = it.next();
		String ChildWindow = it.next();
		driver.switchTo().window(ChildWindow); //Switching to childwindow
		System.out.println("childwindow is opened");

		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);//wait
		driver.close();

		driver.switchTo().window(ParentWindow); //Switch to parentwindow
		System.out.println("Meetups is opened");

		//Get Wordcamp
		driver.findElement(By.xpath("//*[@id=\"dashboard_primary\"]//p//a[2]")).click();

		Set<String> window2 = driver.getWindowHandles(); // multiple WindowHandling
		Iterator<String>it2 = window2.iterator();
		String ParentWindow2 = it2.next();
		String ChildWindow2 = it2.next();
		driver.switchTo().window(ChildWindow2); //Switching to childwindow
		System.out.println("ChildWindow is opened");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//wait
		driver.close();

		driver.switchTo().window(ParentWindow2);//Switch to parentwindow
		System.out.println("Wordcamp is opened");


		//Get News
		driver.findElement(By.xpath("//*[@id=\"dashboard_primary\"]//p//a[3]")).click();

		Set<String> windows3 = driver.getWindowHandles();// multiple WindowHandling
		Iterator<String>it3 = windows3.iterator();
		String ParentWindow3 = it3.next();
		String ChildWindow3 = it3.next();
		driver.switchTo().window(ChildWindow3); //Switching to childwindow
		System.out.println("childwindow is opened");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//wait
		driver.close();

		driver.switchTo().window(ParentWindow3); //Switch to parentwindow
		System.out.println("Wordcamp is opened");

	}

	@Then("Every choice will display some content")
	public void every_choice_will_display_some_content() {

		System.out.println("Every Option is displaying some content");
		driver.close();
	}

	//Woocommerce Status

	@Given("user move to WooCommerce Status Options")
	public void user_move_to_woo_commerce_status_options() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1500)", "");

		System.out.println("Woocomerce Status option is available");
	}

	@And("^Order Status of Woocommerce Should be appered$")
	public void order_status_of_woocommerce_should_be_appered()  {

		System.out.println("Diiferent kind of status are displayed ");

	}

	@Then("click on Each option")
	public void click_on_each_option() {

		for(int k=1;k<=5;k++) {		
			driver.findElement(By.xpath("//*[@id='woocommerce_dashboard_status']//ul//li["+ k +"]//a")).click(); //iteration using loops

			driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);//wait
			driver.navigate().back();

		}

	}

	@And("It display the relavent content")
	public void it_display_the_relavent_content() {
		System.out.println("Status is Displaying");

		driver.close();
		
	}
	

}




