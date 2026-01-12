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

public class OrderCancellation {
	
	private WebDriver driver;
	private Actions actions;
	
	// Global wait method
    private void waitOneSecond() throws InterruptedException {
        Thread.sleep(1000);
    }
    
    
    private By OrderCheckBox = By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[2]");
    private By Cancelbutton = By.xpath("//*[contains(text(),'Cancel')]");
    private By CancelConfirmation = By.cssSelector("button[data-cy='orderbook-cancel']");
    private By CancelToast = By.xpath("//div[contains(text(),'Cancellation request submitted')]");
    
    
    String SearcOpenNseOrder = ConfigReader.getProperty("SearcOpenNseOrder");
    String CancelToastMessage = ConfigReader.getProperty("CancelToastMessage");
    String SearcOpenBseOrder = ConfigReader.getProperty("SearcOpenBseOrder");
    
    
    
    // Constructor
    public OrderCancellation(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }
    
    
  //Actions
    public void OrderCancellation(OrderModification om, String SearcOpenNseOrder, String SearcOpenBseOrder) throws InterruptedException {
    	
    	driver.navigate().refresh();
    	Thread.sleep(3000);
    	
    	driver.findElement(om.getSearchField()).sendKeys(SearcOpenNseOrder);
    	
    	driver.findElement(OrderCheckBox).click();
    	
    	driver.findElement(Cancelbutton).click();
    	
    	driver.findElement(CancelConfirmation).click();
    	
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	WebElement toastElement_1 = wait.until(ExpectedConditions.presenceOfElementLocated(CancelToast));        
    	String actualText_1 = toastElement_1.getText().trim();
    	String expectedText_1 = CancelToastMessage.trim();
    	Assert.assertEquals(actualText_1,expectedText_1,"Cancel Toast message mismatch for NSE Symbol. Actual Toast: " + actualText_1);
    	System.out.println("Verified NSE Symbol Cancel Order");
    	
    	
    	
    	driver.navigate().refresh();
    	Thread.sleep(3000);
    	
//    	driver.findElement(om.getSearchField()).sendKeys(SearcOpenBseOrder);
//    	
//    	driver.findElement(OrderCheckBox).click();
//    	
//    	driver.findElement(Cancelbutton).click();
//    	
//    	driver.findElement(CancelConfirmation).click();
//    	
//    	
//    	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//    	WebElement toastElement_2 = wait.until(ExpectedConditions.presenceOfElementLocated(CancelToast));        
//    	String actualText_2 = toastElement_2.getText().trim();
//    	String expectedText_2 = CancelToastMessage.trim();
//    	Assert.assertEquals(actualText_1,expectedText_2,"Cancel Toast message mismatch for BSE Symbol. Actual Toast: " + actualText_2);
//    	System.out.println("Verified BSE Symbol Cancel Order");
    	
    	
    	
    	
    }

}
