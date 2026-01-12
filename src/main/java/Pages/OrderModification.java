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
	
	// Global wait method
    private void waitOneSecond() throws InterruptedException {
        Thread.sleep(1000);
    }
    
    
    
    private By OrdersTab = By.xpath("//*[contains(text(),'Orders')]");
    private By SearchField = By.xpath("(//input[@placeholder='Search'])[1]");
    private By HoverEquityOrder = By.xpath("(//div[@class='side-circle pointer buy-circle'])[1]");
    private By EquityThreeDots = By.cssSelector("button[data-cy='OPEN_ORDERS-more']");
    private By EquityModify = By.xpath("(//span[contains(text(),'Modify')])[1]");
    private By EquityModifyPrice = By.cssSelector("div[data-cy='orderpad-down-arrow-price']");
    private By EquityOrderModifyToast = By.xpath("//div[contains(text(),'Modification request submitted')]");
    
    
    String NseOrder = ConfigReader.getProperty("NseOrder");
    String SearcOpenNseOrder = ConfigReader.getProperty("SearcOpenNseOrder");
    String ModifyToastMessage = ConfigReader.getProperty("ModifyToastMessage");
    String SearcOpenBseOrder = ConfigReader.getProperty("SearcOpenBseOrder");
    
    
  //Reuse xpath
    public By getSearchField() {
    	return SearchField;
    }
    
    public By getOrdersTab() {
    	return OrdersTab;
    }
    
    
 // Constructor
    public OrderModification(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }
    
    
  //Actions
    public void OrderModification(SearchStocks ss, OrderEquity oe, String SearcOpenNseOrder, String SearcOpenBseOrder ) throws InterruptedException {
    	
    	
    	driver.findElement(ss.getSelectTab()).click();
    	
    	driver.findElement(OrdersTab).click();
    	
    	
    	//Verifying NSE Order Modification
    	
    	driver.findElement(SearchField).sendKeys(SearcOpenNseOrder);
    	
    	waitOneSecond();
    	actions.moveToElement(driver.findElement(HoverEquityOrder)).perform();
    	
    	driver.findElement(EquityThreeDots).click();
    	
    	driver.findElement(EquityModify).click();
    	
    	waitOneSecond();
    	driver.findElement(EquityModifyPrice).click();
    	
    	driver.findElement(oe.getBuyButton()).click();
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    	WebElement toastElement_1 = wait.until(ExpectedConditions.presenceOfElementLocated(EquityOrderModifyToast));        
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
