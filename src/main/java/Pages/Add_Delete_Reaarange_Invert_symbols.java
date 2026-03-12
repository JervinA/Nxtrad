package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    private By SelectNSEsymbol = By.xpath("(//div[@class='search-row search-row-selected'])[2]");
    private By ClickAdd = By.id("place-order");
    private By TringConfirmation = By.xpath("//div[@class='cancel-order-title cancel-sip-title']");
    private By HoverSymbol = By.xpath("(//div[@class='side-circle pointer buy-circle'])[1]");
    private By HoverSymbol2 = By.xpath("(//div[@class='side-circle pointer buy-circle'])[2]");
    private By DeleteSymbol = By.xpath("//button[contains(@class,'delete-icon')]");
    
    
    
    String SearchNSESymbol = ConfigReader.getProperty("SearchNSESymbol");
    String BasketSearch = ConfigReader.getProperty("BasketSearch");
    
    
 // Constructor
    public Add_Delete_Reaarange_Invert_symbols(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        
    }
    
    
    //Actions 
    public void Add_Delete_Reaarange_Invert_symbols(Create_Edit_Delete_Basket cb, String basketname, String SearchNSESymbol, String BasketSearch) {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(cb.getCreatebasket())).click();    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(cb.getBasketNameField())).sendKeys(basketname);    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(cb.getCreateButton())).click();   	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(cb.getOpenBasket())).click();
    	
    	//NSE symbols
    	
    	//Adding symbols
    	wait.until(ExpectedConditions.visibilityOfElementLocated(SearchSymbol)).sendKeys(SearchNSESymbol);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(SelectNSEsymbol)).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(ClickAdd)).click();
    	
    	if(wait.until(ExpectedConditions.visibilityOfElementLocated(TringConfirmation)).isDisplayed()) {
    	    actions.sendKeys(Keys.ENTER).perform();
    	} else {
    	    System.out.println("No confirmation is shown");
    	}
    	
    	System.out.println("Added  IDEA NSE symbol to basket");
    	
    	//Deleting symbols
    	actions.moveToElement(driver.findElement(HoverSymbol)).perform();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(DeleteSymbol)).click();
    	
    	System.out.println("Deleted IDEA NSE symbol to basket");
    	
    	//Rearranging symbols
    	wait.until(ExpectedConditions.visibilityOfElementLocated(SearchSymbol)).sendKeys(SearchNSESymbol);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(SelectNSEsymbol)).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(ClickAdd)).click();
    	
    	if(wait.until(ExpectedConditions.visibilityOfElementLocated(TringConfirmation)).isDisplayed()) {
    	    actions.sendKeys(Keys.ENTER).perform();
    	} else {
    	    System.out.println("No confirmation is shown");
    	}
    	
    	System.out.println("Added IDEA NSE symbol to basket for rearranging");
    	
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(SearchSymbol)).sendKeys(BasketSearch);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(SelectNSEsymbol)).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(ClickAdd)).click();
    	
//    	if(wait.until(ExpectedConditions.visibilityOfElementLocated(TringConfirmation)).isDisplayed()) {
//    	    actions.sendKeys(Keys.ENTER).perform();
//    	} else {
//    	    System.out.println("No confirmation is shown");
//    	}
    	
    	System.out.println("Added TCS NSE symbol to basket for rearranging");
    	
    	Actions actions = new Actions(driver);

    	WebElement source = driver.findElement(HoverSymbol);
    	WebElement target = driver.findElement(HoverSymbol2);
    	actions.dragAndDrop(source, target).perform();
    	
    }
    
	
	
}
