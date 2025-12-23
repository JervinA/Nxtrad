package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Config.ConfigReader;

public class OrderModification {
	
	private WebDriver driver;
	
	// Global wait method
    private void waitOneSecond() throws InterruptedException {
        Thread.sleep(2000);
    }
    
    
    private By VerifyEmptyWatchlist = By.xpath("//*[contains(text(),'Your watchlist is empty')]");
    private By OrdersTab = By.xpath("//*[contains(text(),'Orders')]");
    private By SearchField = By.xpath("(//input[@placeholder='Search'])[1]");
    
    
    
    String NseOrder = ConfigReader.getProperty("NseOrder");
    String SearcOpenOrder = ConfigReader.getProperty("SearcOpenOrder");
    
    
 // Constructor
    public OrderModification(WebDriver driver) {
        this.driver = driver;
    }
    
    
  //Actions
    public void OrderModification(SearchStocks ss, String SearcOpenOrder ) {
    	
    	//Clearing Automation named watchlist
    	
    	driver.findElement(ss.getSelectTab()).click();
    	WebElement WatchlistEmpty = driver.findElement(VerifyEmptyWatchlist);
    	if (WatchlistEmpty.isDisplayed()) {
    	    System.out.println("Watchlist is Empty");
    	} else {
    		WatchlistEmpty.click();
    	    System.out.println("CheckLimit was not selected, now clicked");
    	}
    	
    	
    	driver.findElement(OrdersTab).click();
    	
    	driver.findElement(SearchField).sendKeys(SearcOpenOrder);
    	
    	
    	
    	
    	
    	
    	
    }

}
