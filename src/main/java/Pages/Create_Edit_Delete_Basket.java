package Pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    private By Createbasket = By.xpath("//*[contains(text(),'Add New Basket')]");
    
    
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
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	boolean isCheckboxPresent;

    	try {
    	    wait.until(ExpectedConditions.presenceOfElementLocated(AllCheckbox));
    	    isCheckboxPresent = true;
    	} catch (TimeoutException e) {
    	    isCheckboxPresent = false;
    	}

    	if (isCheckboxPresent) {
    	    wait.until(ExpectedConditions.elementToBeClickable(AllCheckbox)).click();
    	    wait.until(ExpectedConditions.elementToBeClickable(DeleteBasket)).click();
    	    wait.until(ExpectedConditions.elementToBeClickable(DeleteConfirmation)).click();
    	} else {
    	    wait.until(ExpectedConditions.elementToBeClickable(Createbasket)).click();
    	}
    	
    	
    	
    }

}
