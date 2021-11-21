package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AtaGlance {
	
	public WebDriver driver;
	
	By AtaGlance = By.id("dashboard_right_now");
	By posts = By.cssSelector(".post-count");
	By pages = By.cssSelector(".page-count");
	By comments = By.cssSelector(".comment-count");
	By moderations = By.cssSelector(".comment-mod-count");
	
	
	public AtaGlance(WebDriver driver) {
		
		this.driver=driver;
		
	}	

	public WebElement getAtaGlance()
	{
		return driver.findElement(AtaGlance);
	}
	public WebElement getPosts()
	{
		return driver.findElement(posts);
	}
	public WebElement getPages()
	{
		return driver.findElement(pages);
	}
	public WebElement getComments()
	{
		return driver.findElement(comments);
	}
	public WebElement getModerations()
	{
		return driver.findElement(moderations);
	}




}
