package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Activity {
	
	public WebDriver driver;
	
	By Dashboard=By.className("wp-menu-name");
	
	//By dismiss=By.className("notice-dismiss vc-notice-dismiss");
	/*Alert alert =driver.switchTo().alert();
	alert.dismiss();*/
	
	By activity= By.xpath("//*[@id='dashboard_activity']/button");
	
	By RecPub = By.xpath("//h3[text()='Recently Published']");
	By lscom  = By.xpath("//h3[text()='Recent Comments']");
	By all    = By.cssSelector(".all");

	By moderated = By.cssSelector(".moderated");
	By approved  = By.xpath(".//*[@class='approved']  ");
	By spam  = By.xpath("//li[@class='spam']  ");
	By trash = By.cssSelector("li.trash");

	
	

	
	public Activity(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}

	
	
	public WebElement getDashboard()
	{
		return driver.findElement(Dashboard);
	}
	

	public WebElement getActivity()
	{
		return driver.findElement(activity);
	}

    public WebElement getRecentlyPublished()
	{
		return driver.findElement(RecPub);
	}

	public WebElement getRecentlyCommented()
	{
		return driver.findElement(lscom);
	}

	public WebElement getAll()
	{
		return driver.findElement(all);
	}

	public WebElement getPending()
	{
		return driver.findElement(moderated);
	}

	public WebElement getApproved()
	{
		return driver.findElement(approved);
	}
	public WebElement getSpam()
	{
		return driver.findElement(spam);
	}

	public WebElement getTrash()
	{
		return driver.findElement(trash);
	}


	

	
	

}
