package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchStocks {
	
private WebDriver driver;
	
	// Global wait method
    private void waitOneSecond() throws InterruptedException {
        Thread.sleep(1000);
    }
    
    private By SelectTab = By.xpath("//div[@class='MuiTabs-scroller MuiTabs-hideScrollbar MuiTabs-scrollableX css-12qnib']//button[contains(.,'Automation')]");
    private By Searchfield = By.id("search-input");
    private By ValidateNseName = By.xpath("//*[contains(text(),'IDEA')]");
    private By ValidateNseExchange = By.xpath("//*[contains(text(),'NSE')]");
    private By ValidateBseName = By.xpath("//*[contains(text(),'IDEA')]");
    private By ValidateBseExchange = By.xpath("//*[contains(text(),'BSE')]");
    private By ValidateNfoName = By.xpath("//*[contains(text(),'ASIANPAINT')]");
    private By ValidateNfoExchange = By.xpath("//*[contains(text(),'NFO')]");
    private By ValidateBfoName = By.xpath("//*[contains(text(),'SENSEX 24DEC')]");
    private By ValidateBfoExchange = By.xpath("(//*[contains(text(),'BFO')])[1]");
    
    
    
    String NseSymbolName = "IDEA";
    String NseExchange = "NSE";
    
    
    String BseSymbolName = "IDEA";
    String BseExchange = "BSE";
    
    String NfoSymbolName = "ASIANPAINT";
    String NfoExchange = "NFO";
    
    String BfoSymbolName = "SENSEX";
    String BfoExchange = "BFO";
    
    
    // Constructor
    public SearchStocks(WebDriver driver) {
        this.driver = driver;
        
    }
    
    //Actions
    public void SearchStocks(String nse, String bse, String nfo, String bfo) throws InterruptedException {
    	
    	waitOneSecond();
    	driver.findElement(SelectTab).click();
    	
    	//Searching and Verifying NSE symbol
    	waitOneSecond();
    	driver.findElement(Searchfield).sendKeys(nse);
    	
    	waitOneSecond();
    	String actualText_1 = driver.findElement(ValidateNseName).getText();
    	Assert.assertEquals(actualText_1, NseSymbolName, "NSE Symbol Name Mismatch");
    	System.out.println("Verified NSE Symbol Name");
    	
    	String actualText_2 = driver.findElement(ValidateNseExchange).getText();
    	Assert.assertEquals(actualText_2, NseExchange, "NSE Symbol Exchange Mismatch");
    	System.out.println("Verified NSE Symbol Exchange");
    	
    	System.out.println("Searching and Verifying NSE symbol completed");
    	
    	
    	//Searching and Verifying BSE symbol
    	
    	waitOneSecond();
    	driver.findElement(Searchfield).sendKeys(Keys.CONTROL + "a");
    	driver.findElement(Searchfield).sendKeys(Keys.DELETE);
    	
    	waitOneSecond();
    	driver.findElement(Searchfield).sendKeys(bse);
    	
    	waitOneSecond();
    	String actualText_3 = driver.findElement(ValidateBseName).getText();
    	Assert.assertEquals(actualText_3, BseSymbolName, "BSE Symbol Name Mismatch");
    	System.out.println("Verified BSE Symbol Name");
    	
    	String actualText_4 = driver.findElement(ValidateBseExchange).getText();
    	Assert.assertEquals(actualText_4, BseExchange, "BSE Symbol Exchange Mismatch");
    	System.out.println("Verified BSE Symbol Exchange");
    	
    	System.out.println("Searching and Verifying BSE symbol completed");
    	
    	
    	//Searching and Verifying NFO symbol
    	
    	waitOneSecond();
    	driver.findElement(Searchfield).sendKeys(Keys.CONTROL + "a");
    	driver.findElement(Searchfield).sendKeys(Keys.DELETE);
    	
    	waitOneSecond();
    	driver.findElement(Searchfield).sendKeys(nfo);
    	
    	waitOneSecond();
    	String actualText_5 = driver.findElement(ValidateNfoName).getText();
    	if (actualText_5.length() > 14) {
    	    actualText_5 = actualText_5.substring(0, actualText_5.length() - 14);
    	}
    	Assert.assertEquals(actualText_5, NfoSymbolName, "NFO Symbol Name Mismatch");
    	System.out.println("Verified NFO Symbol Name");
    	
    	String actualText_6 = driver.findElement(ValidateNfoExchange).getText();
    	Assert.assertEquals(actualText_6, NfoExchange, "NFO Symbol Exchange Mismatch");
    	System.out.println("Verified NFO Symbol Exchange");
    	
    	System.out.println("Searching and Verifying NFO symbol completed");
    	
    	
    	//Searching and Verifying BFO symbol
    	
    	waitOneSecond();
    	driver.findElement(Searchfield).sendKeys(Keys.CONTROL + "a");
    	driver.findElement(Searchfield).sendKeys(Keys.DELETE);
    	
    	waitOneSecond();
    	driver.findElement(Searchfield).sendKeys(bfo);
    	
    	waitOneSecond();
    	String actualText_7 = driver.findElement(ValidateBfoName).getText();
    	if (actualText_7.length() > 9) {
    	    actualText_7 = actualText_7.substring(0, actualText_7.length() - 10);
    	}
    	Assert.assertEquals(actualText_7, BfoSymbolName, "BFO Symbol Name Mismatch");
    	System.out.println("Verified BFO Symbol Name");
    	
    	String actualText_8 = driver.findElement(ValidateBfoExchange).getText();
    	Assert.assertEquals(actualText_8, BfoExchange, "BFO Symbol Exchange Mismatch");
    	System.out.println("Verified BFO Symbol Exchange");
    	
    	System.out.println("Searching and Verifying BFO symbol completed");
    	
    }
    
    

}
