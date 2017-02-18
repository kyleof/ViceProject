package vice.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class testPage {
	
	private WebDriver driver;
    private WebDriverWait wait;
    private String black = "rgba(0, 0, 0, 1)";
	private String grey = "rgba(170, 170, 170, 1)";
	
    
    public testPage()
    {
    	driver = new ChromeDriver(); 
	    driver.get("https://www.vice.com/en_us"); 
	    wait = new WebDriverWait(driver,120);
    }
    
    //Open Menu 
    public void openMenu()
    {
    	driver.findElement(By.cssSelector("img.icon.icon-menu.nav-toggle")).click();
    }
    
    //Open Follow DropDown
    public void openFollow()
    {
    	wait.until(ExpectedConditions.elementToBeClickable(By.className("nav__section__title")));
    	
    	driver.findElement(By.className("nav__section__title")).click();
    }
    
    public void checkColour()
    {	
    	Actions action = new Actions(driver);
    	
    	WebElement follow = driver.findElement(By.className("nav__section__items"));
    	List<WebElement> links = follow.findElements(By.tagName("li"));
    	
    	//Check the original color of the links.
    	for (int i = 0; i < links.size(); i++)
    	{
    	    
    	    System.out.println("Color of the link is: "	+ links.get(i).getCssValue("color"));
    	    
    	    Assert.assertEquals(black, links.get(i).getCssValue("color"));
	
    	}
    	
    	//Declaring elements 
    	WebElement Facebook = driver.findElement(By.linkText("Facebook"));
    	WebElement Twitter = driver.findElement(By.linkText("Twitter"));
    	WebElement Tumblr = driver.findElement(By.linkText("Tumblr"));
    	WebElement YouTube = driver.findElement(By.linkText("YouTube"));
    	WebElement Instagram = driver.findElement(By.linkText("Instagram"));
    	
    	//Hover & Assert 
    	helper(Facebook, action);
    	helper(Twitter, action);
    	helper(Tumblr, action);
    	helper(YouTube, action);
    	helper(Instagram, action);

  

    }
    //close menu
    public void closeMenu(){
    	
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
    	driver.findElement(By.cssSelector("img.icon.icon-close")).click();
    	
    	
    }
    
    //Helper function for hovering over elements.
    private void helper(WebElement element, Actions action)
    {
    	action.moveToElement(element).perform();
    	
		System.out.println("Color of the link after mouse hover is: "	+ element.getCssValue("color"));
    	
		Assert.assertEquals(grey, element.getCssValue("color"));
    }
    
}
    



