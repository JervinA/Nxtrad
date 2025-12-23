package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import Config.ConfigReader;

public class OrderModification {
	
	private WebDriver driver;
	
	// Global wait method
    private void waitOneSecond() throws InterruptedException {
        Thread.sleep(2000);
    }
    
    
    private By OrdersTab = By.xpath("//*[contains(text(),'Orders')]");
    
    
    
    String NseOrder = ConfigReader.getProperty("NseOrder");
    
 // Constructor
    public OrderModification(WebDriver driver) {
        this.driver = driver;
    }
    
    
  //Actions
    public void OrderModification() {
    	
    	driver.findElement(OrdersTab).click();
    	
    	
    	
    	
    	
    }

}
