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

public class OrderModification {
	
	private WebDriver driver;
	private Actions actions;
	
    String NseOrder = ConfigReader.getProperty("NseOrder");
    String SearcOpenNseOrder = ConfigReader.getProperty("SearcOpenNseOrder");
    String ModifyToastMessage = ConfigReader.getProperty("ModifyToastMessage");
    String SearcOpenBseOrder = ConfigReader.getProperty("SearcOpenBseOrder");
    
 // Constructor
    public OrderModification(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }
    
    
  //Actions
    public void OrderModification(Xpath xp, OrderEquity oe, String SearcOpenNseOrder, String SearcOpenBseOrder ) throws InterruptedException {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSelectTab())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getOrdersTab())).click();
    	
    	//Verifying NSE Order Modification
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSearchfield())).sendKeys(SearcOpenNseOrder);
    	
    	actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getHoverEquityOrder()))).perform();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getEquityThreeDots())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getEquityModify())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getEquityModifyPrice())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getBuyButton())).click();
    	
    	WebElement toastElement_1 = wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getEquityOrderModifyToast()));        
    	String actualText_1 = toastElement_1.getText().trim();
    	String expectedText_1 = ModifyToastMessage.trim();
    	Assert.assertEquals(actualText_1,expectedText_1,"Modify Toast message mismatch. Actual Toast: " + actualText_1);
    	System.out.println("Verified NSE Symbol Modify Order");
    	
    	
    	//Verifying BSE Order Modification
    	
//    	driver.navigate().refresh();
//    	
//    	Thread.sleep(3000);
//    	driver.findElement(SearchField).sendKeys(SearcOpenBseOrder);
//    	
//    	waitOneSecond();
//    	actions.moveToElement(driver.findElement(HoverEquityOrder)).perform();
//    	
//    	driver.findElement(EquityThreeDots).click();
//    	
//    	driver.findElement(EquityModify).click();
//    	
//    	waitOneSecond();
//    	driver.findElement(EquityModifyPrice).click();
//    	
//    	driver.findElement(oe.getBuyButton()).click();
//    	
//    	WebElement toastElement_2 = wait.until(ExpectedConditions.presenceOfElementLocated(EquityOrderModifyToast));        
//    	String actualText_2 = toastElement_2.getText().trim();
//    	String expectedText_2 = ModifyToastMessage.trim();
//    	Assert.assertEquals(actualText_2,expectedText_2,"Modify Toast message mismatch. Actual Toast: " + actualText_2);
//    	System.out.println("Verified BSE Symbol Modify Order");
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }

}
