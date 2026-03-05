package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Config.ConfigReader;

public class Add_Delete_Reaarange_Invert_symbols {

	
	private WebDriver driver;
	private Actions actions;
	
	
	// Global wait method
    private void waitOneSecond() throws InterruptedException {
        Thread.sleep(2000);
    }
    
    private By SearchSymbol = By.xpath("(//input[@placeholder='Search by Stock Name'])[2]");
    
    
    
    String SearchNSESymbol = ConfigReader.getProperty("SearchNSESymbol");
    
    
 // Constructor
    public Add_Delete_Reaarange_Invert_symbols(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        
    }
    
    
    //Actions 
    public void Add_Delete_Reaarange_Invert_symbols(Create_Edit_Delete_Basket cb, String basketname, String SearchNSESymbol) {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(cb.getCreatebasket())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(cb.getBasketNameField())).sendKeys(basketname);
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(cb.getCreateButton())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(cb.getOpenBasket())).click();
    	
    	//Adding NSE symbols
    	wait.until(ExpectedConditions.visibilityOfElementLocated(SearchSymbol)).sendKeys(SearchNSESymbol);
    	
    	
    	
    	
    	
    }
    
	
	
}
