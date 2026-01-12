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
	
	// Global wait method
    private void waitOneSecond() throws InterruptedException {
        Thread.sleep(2000);
    }
    
    
    private By HoverEquitySymbol = By.xpath("//div[@class='search-row search-row-selected']");
    private By BuyIcon = By.cssSelector("button[data-cy='search-buy-icon']");
    private By CheckLimit = By.cssSelector("input[data-cy='orderpad-limit']");
    private By BuyButton = By.id("place-order");
    private By NseConfirmation = By.xpath("(//button[contains(text(),'Yes')])[2]");
    private By NseOrderToast = By.xpath("//*[contains(text(),'Submitted')]");
    private By OrdersTab = By.xpath("//*[contains(text(),'Orders')]");
    
    
    
    
    String NseOrder = ConfigReader.getProperty("NseOrder");
    String ToastMessage = ConfigReader.getProperty("ToastMessage");
    String BseOrder = ConfigReader.getProperty("BseOrder");
    
    
  //Reuse xpath
    public By getBuyButton() {
    	return BuyButton;
    }
    
    
 // Constructor
    public OrderEquity(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        
    }
    
    
  //Actions
    public void OrderEquity(SearchStocks ss, String NseOrder, String BseOrder) throws InterruptedException {
    	
    	driver.findElement(ss.getSelectTab()).click();
    	
    	//Placing NSE Order
    	
    	waitOneSecond();
    	driver.findElement(ss.getSearchfield()).sendKeys(NseOrder);
    	
    	waitOneSecond();
    	actions.moveToElement(driver.findElement(HoverEquitySymbol)).perform();
    	
    	driver.findElement(BuyIcon).click();
    	
    	WebElement checkLimit_1 = driver.findElement(CheckLimit);
    	if (checkLimit_1.isSelected()) {
    	    System.out.println("CheckLimit is already selected");
    	} else {
    	    checkLimit_1.click();
    	    System.out.println("CheckLimit was not selected, now clicked");
    	}
    	
    	driver.findElement(BuyButton).click();
    	
    	waitOneSecond();
    	try {
        	driver.findElement(NseConfirmation).click();
        } catch (Exception e) {
        	System.out.println("Confirmation not shown");
        }
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	WebElement toastElement = wait.until(ExpectedConditions.presenceOfElementLocated(NseOrderToast));        
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
