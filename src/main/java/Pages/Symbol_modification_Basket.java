package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Config.ConfigReader;

public class Symbol_modification_Basket {
	
	private WebDriver driver;
	private Actions actions;
	
	
	// Global wait method
    private void waitOneSecond() throws InterruptedException {
        Thread.sleep(2000);
    }
    
    private By EditIcon = By.xpath("(//button[contains(@class,'edit-icon')])[3]");
    private By GetPrice = By.xpath("//*[@data-cy='BASKET_SCRIPS-body']/tr[1]/td[7]");
    
    
    String SearchNSESymbol = ConfigReader.getProperty("SearchNSESymbol");
    
    
 // Constructor
    public Symbol_modification_Basket(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        
    }
    
    
    public void Symbol_modification_Basket(Add_Delete_Reaarange_Invert_symbols ad) throws InterruptedException {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	
    	Thread.sleep(2000);
    	
    	//getting price before modification
    	String actualText_1 = driver.findElement(GetPrice).getText();
    	System.out.println(actualText_1);
    	
    	actions.moveToElement(driver.findElement(ad.getHoverSymbol3())).perform();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(EditIcon)).click();
    }
    

}
