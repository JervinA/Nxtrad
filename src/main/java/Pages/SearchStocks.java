	package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Config.ConfigReader;

public class SearchStocks {
	
private WebDriver driver;
	
	
    
//    String NseSymbolName = "IDEA";
//    String NseExchange = "NSE";
//    
//    
//    String BseSymbolName = "IDEA";
//    String BseExchange = "BSE";
//    
//    String NfoSymbolName = "ASIANPAINT";
//    String NfoExchange = "NFO";
//    
//    String BfoSymbolName = "SENSEX";
//    String BfoExchange = "BFO";
//    
//    String McxSymbolName = "";
//    String McxExchange = "";
    
    String NseSymbolName = ConfigReader.getProperty("NseSymbolName");
    String NseExchange = ConfigReader.getProperty("NseExchange");
    
    String BseSymbolName = ConfigReader.getProperty("BseSymbolName");
    String BseExchange = ConfigReader.getProperty("BseExchange");
    
    String NfoSymbolName = ConfigReader.getProperty("NfoSymbolName");
    String NfoExchange = ConfigReader.getProperty("NfoExchange");
    
    String BfoSymbolName = ConfigReader.getProperty("BfoSymbolName");
    String BfoExchange = ConfigReader.getProperty("BfoExchange");
    
    String McxSymbolName = ConfigReader.getProperty("McxSymbolName");
    String McxExchange = ConfigReader.getProperty("McxExchange");
    
    
    
    // Constructor
    public SearchStocks(WebDriver driver) {
        this.driver = driver;
        
    }
    
    //Actions
    public void SearchStocks(Xpath xp, String nse, String bse, String nfo, String bfo, String mcx) throws InterruptedException {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSelectTab())).click();
    	
    	//Searching and Verifying NSE symbol
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSearchfield())).sendKeys(nse);
    	
    	String actualText_1 = wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getValidateNseName())).getText();
    	Assert.assertEquals(actualText_1, NseSymbolName, "NSE Symbol Name Mismatch");
    	System.out.println("Verified NSE Symbol Name");
    	
    	String actualText_2 = wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getValidateNseExchange())).getText();
    	Assert.assertEquals(actualText_2, NseExchange, "NSE Symbol Exchange Mismatch");
    	System.out.println("Verified NSE Symbol Exchange");
    	
    	System.out.println("Searching and Verifying NSE symbol completed");
    	
    	
    	//Searching and Verifying BSE symbol
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSearchfield())).sendKeys(Keys.CONTROL + "a");
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSearchfield())).sendKeys(Keys.DELETE);
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSearchfield())).sendKeys(bse);
    	
    	Thread.sleep(3000);
    	
    	String actualText_3 = wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getValidateBseName())).getText();
    	Assert.assertEquals(actualText_3, BseSymbolName, "BSE Symbol Name Mismatch");
    	System.out.println("Verified BSE Symbol Name");
    	
    	String actualText_4 = wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getValidateBseExchange())).getText();
    	Assert.assertEquals(actualText_4, BseExchange, "BSE Symbol Exchange Mismatch");
    	System.out.println("Verified BSE Symbol Exchange");
    	
    	System.out.println("Searching and Verifying BSE symbol completed");
    	
    	
    	//Searching and Verifying NFO symbol
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSearchfield())).sendKeys(Keys.CONTROL + "a");
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSearchfield())).sendKeys(Keys.DELETE);
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSearchfield())).sendKeys(nfo);
    	
    	Thread.sleep(3000);
    	
    	String actualText_5 = wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getValidateNfoName())).getText();
    	if (actualText_5.length() > 14) {
    	    actualText_5 = actualText_5.substring(0, actualText_5.length() - 14);
    	}
    	Assert.assertEquals(actualText_5, NfoSymbolName, "NFO Symbol Name Mismatch");
    	System.out.println("Verified NFO Symbol Name");
    	
    	String actualText_6 = wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getValidateNfoExchange())).getText();
    	Assert.assertEquals(actualText_6, NfoExchange, "NFO Symbol Exchange Mismatch");
    	System.out.println("Verified NFO Symbol Exchange");
    	
    	System.out.println("Searching and Verifying NFO symbol completed");
    	
    	
    	//Searching and Verifying BFO symbol
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSearchfield())).sendKeys(Keys.CONTROL + "a");
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSearchfield())).sendKeys(Keys.DELETE);
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSearchfield())).sendKeys(bfo);
    	
    	Thread.sleep(3000);
    	
    	String actualText_7 = wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getValidateBfoName())).getText();
    	if (actualText_7.length() > 9) {
    	    actualText_7 = actualText_7.substring(0, actualText_7.length() - 13);
    	}
    	Assert.assertEquals(actualText_7, BfoSymbolName, "BFO Symbol Name Mismatch");
    	System.out.println("Verified BFO Symbol Name");
    	
    	String actualText_8 = wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getValidateBfoExchange())).getText();
    	Assert.assertEquals(actualText_8, BfoExchange, "BFO Symbol Exchange Mismatch");
    	System.out.println("Verified BFO Symbol Exchange");
    	
    	System.out.println("Searching and Verifying BFO symbol completed");
    	
    	
    	//Searching and Verifying MCX symbol
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSearchfield())).sendKeys(Keys.CONTROL + "a");
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSearchfield())).sendKeys(Keys.DELETE);
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSearchfield())).sendKeys(mcx);
    	
    	Thread.sleep(3000);
    	
    	String actualText_9 = wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getValidateMcxName())).getText();
    	if (actualText_9.length() > 9) {
    	    actualText_9 = actualText_9.substring(0, actualText_9.length() - 13);
    	}
    	Assert.assertEquals(actualText_9, McxSymbolName, "MCX Symbol Name Mismatch");
    	System.out.println("Verified MCX Symbol Name");
    	
    	String actualText_10 = wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getValidateMcxExchange())).getText();
    	Assert.assertEquals(actualText_10, McxExchange, "MCX Symbol Exchange Mismatch");
    	System.out.println("Verified MCX Symbol Exchange");
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSearchfield())).sendKeys(Keys.CONTROL + "a");
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSearchfield())).sendKeys(Keys.DELETE);
    	
    	System.out.println("Searching and Verifying MCX symbol completed");
    	
    }
    
    

}
