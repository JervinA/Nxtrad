package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import Config.ConfigReader;

public class Create_Edit_Delete_Basket {
	
	private WebDriver driver;
	
	// Global wait method
    private void waitOneSecond() throws InterruptedException {
        Thread.sleep(2000);
    }
    
    
    private By Dashboard = By.xpath("//*[contains(text(),'Dashboard')]");
    private By BasketTab = By.xpath("//*[contains(text(),'Baskets')]");
    private By AllCheckbox = By.xpath("//input[@class='PrivateSwitchBase-input css-1m9pwf3']");
    private By DeleteBasket = By.xpath("//*[contains(text(),'Delete')]");
    private By DeleteConfirmation = By.xpath("(//button[contains(text(),'Yes')])[2]");
    
    
    String NseOrder = ConfigReader.getProperty("NseOrder");
    
    
    // Constructor
    public Create_Edit_Delete_Basket(WebDriver driver) {
        this.driver = driver;
        
    }
    
    
  //Actions
    public void Create_Edit_Delete_Basket(OrderModification om) {
    	
//    	driver.findElement(Dashboard).click();
    	
    	driver.findElement(om.getOrdersTab()).click();
    	
    	driver.findElement(BasketTab).click();
    	
    	//Checking basket screen is empty
    	
    	System.out.println("Checking basket screen is empty");
    	
    	if(driver.findElement(AllCheckbox).isDisplayed()) {
    		driver.findElement(AllCheckbox).click();
    		driver.findElement(DeleteBasket).click();
    		driver.findElement(DeleteConfirmation).click();
    	}
    	
    	
    	
    	
    }

}
