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
	
    String SearchNSESymbol = ConfigReader.getProperty("SearchNSESymbol");
    
    
 // Constructor
    public Symbol_modification_Basket(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        
    }
    
    
    public void Symbol_modification_Basket(Xpath xp) throws InterruptedException {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	
    	Thread.sleep(2000);
    	
    	//getting price before modification
    	String actualText_1 = wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getGetPrice())).getText();
    	System.out.println(actualText_1);
    	
    	actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getHoverSymbol3()))).perform();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getEditIcon2())).click();
    }
    

}
