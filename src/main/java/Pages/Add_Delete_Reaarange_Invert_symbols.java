package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Config.ConfigReader;

public class Add_Delete_Reaarange_Invert_symbols {

	
	private WebDriver driver;
	private Actions actions;
    
    String SearchNSESymbol = ConfigReader.getProperty("SearchNSESymbol");
    String BasketSearch = ConfigReader.getProperty("BasketSearch");
    String BuyIcon = ConfigReader.getProperty("BuyIcon");
    String SellIcon = ConfigReader.getProperty("SellIcon");
    
 // Constructor
    public Add_Delete_Reaarange_Invert_symbols(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        
    }
    
    
    //Actions 
    public void Add_Delete_Reaarange_Invert_symbols(Xpath xp, String basketname, String SearchNSESymbol, String BasketSearch) throws InterruptedException {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getCreatebasket())).click();    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getBasketNameField())).sendKeys(basketname);    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getCreateButton())).click();   	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getOpenBasket())).click();
    	
    	//NSE symbols
    	
    	//Adding symbols
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSearchSymbol())).sendKeys(SearchNSESymbol);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSelectNSEsymbol())).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getClickAdd())).click();
    	
    	if(wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getTringConfirmation())).isDisplayed()) {
    	    actions.sendKeys(Keys.ENTER).perform();
    	} else {
    	    System.out.println("No confirmation is shown");
    	}
    	
    	System.out.println("Added  IDEA NSE symbol to basket");
    	
    	//Deleting symbols
    	actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getHoverSymbol()))).perform();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getDeleteSymbol())).click();
    	
    	System.out.println("Deleted IDEA NSE symbol to basket");
    	
    	//Rearranging symbols
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSearchSymbol())).sendKeys(SearchNSESymbol);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSelectNSEsymbol())).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getClickAdd())).click();
    	
    	if(wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getTringConfirmation())).isDisplayed()) {
    	    actions.sendKeys(Keys.ENTER).perform();
    	} else {
    	    System.out.println("No confirmation is shown");
    	}
    	
    	System.out.println("Added IDEA NSE symbol to basket for rearranging");
    	
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSearchSymbol())).sendKeys(BasketSearch);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSelectNSEsymbol())).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getClickAdd())).click();
    	
//    	if(wait.until(ExpectedConditions.visibilityOfElementLocated(TringConfirmation)).isDisplayed()) {
//    	    actions.sendKeys(Keys.ENTER).perform();
//    	} else {
//    	    System.out.println("No confirmation is shown");
//    	}
    	
    	System.out.println("Added TCS NSE symbol to basket for rearranging");
    	
    	WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getHoverSymbol()));

    	actions.clickAndHold(source)
    	       .pause(Duration.ofMillis(500))
    	       .moveByOffset(0,100)
    	       .release()
    	       .perform();
    	
    	System.out.println("Rearranging for NSE completed");
    	
    	
    	//Invert Actions
    	
    	actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getHoverSymbol()))).perform();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getDeleteSymbol())).click();
    	
    	//Confirming Buy icon is there
    	String actualText_1 = wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getHoverSymbol())).getText();
    	Assert.assertEquals(actualText_1, BuyIcon, "Buy icon mismatch");
    	System.out.println(actualText_1);
    	
    	//Inverting
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getInvertSymbol())).click();
    	
    	//Confirming sell icon is there after invert
    	Thread.sleep(2000);
    	String actualText_2 = wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getHoverSymbol3())).getText();
    	Assert.assertEquals(actualText_2, SellIcon, "Sell icon mismatch");
    	System.out.println(actualText_2);
    	
    	//Comparing both actual text are different before and after conversion
    	Assert.assertNotEquals(actualText_1, actualText_2, "Buy and Sell icons should not be the same");
    }
    
	
	
}
