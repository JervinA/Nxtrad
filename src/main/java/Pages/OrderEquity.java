package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import Config.ConfigReader;

public class OrderEquity {
	
	private WebDriver driver;
	private Actions actions;
	
	// Global wait method
    private void waitOneSecond() throws InterruptedException {
        Thread.sleep(2000);
    }
    
    
    private By HoverNSE = By.xpath("//div[@class='search-row search-row-selected']");
    private By BuyIcon = By.cssSelector("button[data-cy='search-buy-icon']");
    private By CheckLimit = By.cssSelector("input[data-cy='orderpad-limit']");
    private By BuyButton = By.id("place-order");
    private By NseConfirmation = By.xpath("(//button[contains(text(),'Yes')])[2]");
    private By NseOrderToast = By.cssSelector("span[data-cy='header-content-title']");
    
    
    
    String NseOrder = ConfigReader.getProperty("NseOrder");
    String ToastMessage = ConfigReader.getProperty("ToastMessage");
    
    
 // Constructor
    public OrderEquity(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        
    }
    
    
  //Actions
    public void OrderEquity(SearchStocks ss, String NseOrder) throws InterruptedException {
    	
    	driver.findElement(ss.getSelectTab()).click();
    	
    	//Placing NSE Order
    	
    	waitOneSecond();
    	driver.findElement(ss.getSearchfield()).sendKeys(NseOrder);
    	
    	waitOneSecond();
    	actions.moveToElement(driver.findElement(HoverNSE)).perform();
    	
    	driver.findElement(BuyIcon).click();
    	
    	WebElement checkLimit = driver.findElement(CheckLimit);
    	if (checkLimit.isSelected()) {
    	    System.out.println("CheckLimit is already selected");
    	} else {
    	    checkLimit.click();
    	    System.out.println("CheckLimit was not selected, now clicked");
    	}
    	
    	driver.findElement(BuyButton).click();
    	
    	waitOneSecond();
    	try {
        	driver.findElement(NseConfirmation).click();
        } catch (Exception e) {
        	System.out.println("Confirmation not shown");
        }
    	
    	String actualText_1 = driver.findElement(NseOrderToast).getText();
    	Assert.assertEquals(actualText_1, ToastMessage, "BSE Symbol Name Mismatch");
    	System.out.println("Verified BSE Symbol Name");
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }

}
