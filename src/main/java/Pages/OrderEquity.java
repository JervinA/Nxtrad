package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Config.ConfigReader;

public class OrderEquity {
	
	private WebDriver driver;
	private Actions actions;
    
    String NseOrder = ConfigReader.getProperty("NseOrder");
    String ToastMessage = ConfigReader.getProperty("ToastMessage");
    String BseOrder = ConfigReader.getProperty("BseOrder");  
  
 // Constructor
    public OrderEquity(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        
    }
    
    
  //Actions
    public void OrderEquity(Xpath xp, String NseOrder, String BseOrder) throws InterruptedException {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSelectTab())).click();
    	
    	//Placing NSE Order
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSearchfield())).sendKeys(NseOrder);
    	
    	actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getHoverEquitySymbol()))).perform();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getBuyIcon())).click();
    	
    	WebElement checkLimit_1 = wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getCheckLimit()));
    	if (checkLimit_1.isSelected()) {
    	    System.out.println("CheckLimit is already selected");
    	} else {
    	    checkLimit_1.click();
    	    System.out.println("CheckLimit was not selected, now clicked");
    	}
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getBuyButton())).click();
    	
    	try {
    		wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getNseConfirmation())).click();
        } catch (Exception e) {
        	System.out.println("Confirmation not shown");
        }
    	
    	WebElement toastElement = wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getNseOrderToast()));        
    	String actualText_1 = toastElement.getText().trim();
    	String expectedText = ToastMessage.trim();
    	Assert.assertEquals(actualText_1,expectedText,"Toast message mismatch. Actual Toast: " + actualText_1);
    	System.out.println("Verified NSE Symbol Order placement");

    	
    	//Placing BSE Order
    	
//    	waitOneSecond();
//    	driver.findElement(ss.getSearchfield()).sendKeys(BseOrder);
//    	
//    	waitOneSecond();
//    	actions.moveToElement(driver.findElement(HoverEquitySymbol)).perform();
//    	
//    	driver.findElement(BuyIcon).click();
//    	
//    	WebElement checkLimit_2 = driver.findElement(CheckLimit);
//    	if (checkLimit_2.isSelected()) {
//    	    System.out.println("CheckLimit is already selected");
//    	} else {
//    	    checkLimit_2.click();
//    	    System.out.println("CheckLimit was not selected, now clicked");
//    	}
//    	
//    	driver.findElement(BuyButton).click();
//    	
//    	waitOneSecond();
//    	try {
//        	driver.findElement(NseConfirmation).click();
//        } catch (Exception e) {
//        	System.out.println("Confirmation not shown");
//        }
//    	
//    	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//    	//WebElement toastElement = wait.until(ExpectedConditions.presenceOfElementLocated(NseOrderToast));        
//    	String actualText_2 = toastElement.getText().trim();
//    	String expectedText_2 = ToastMessage.trim();
//    	Assert.assertEquals(actualText_2,expectedText,"Toast message mismatch. Actual Toast: " + actualText_2);
//    	System.out.println("Verified BSE Symbol Order placement");

    	
    	

    	
    }

}
