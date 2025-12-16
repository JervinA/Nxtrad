package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import Config.ConfigReader;

public class ChartNavigation {
private WebDriver driver;
private Actions actions;

	
	// Global wait method
    private void waitOneSecond() throws InterruptedException {
        Thread.sleep(2000);
    }
    
    private By MarketScan = By.xpath("//*[contains(text(),'Market Scan')]");
    private By Equity = By.xpath("//*[contains(text(),'Equity')]");
    private By NseChartHover = By.cssSelector("tr[data-cy='market_movers-row-0']");
    private By NseChartOpen = By.xpath("(//button[contains(@class,'chart-btn')])[4]");
    private By SwitchIframe = By.xpath("//*[@title='Financial Chart']");
    private By NseChartValidation = By.xpath("//div[@class='title-l31H9iuA']");
    
    
    String NseChart = ConfigReader.getProperty("NseChart");
    String IframeName = "iframeWebView";
	
    
    
    
 // Constructor
    public ChartNavigation(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        
    }
    
  //Actions
    public void chartnavigation() throws InterruptedException {
    	
    	waitOneSecond();
    	driver.findElement(MarketScan).click();
    	
    	waitOneSecond();
    	driver.findElement(Equity).click();
    	
    	
    	//validating NSE Chart
    	
    	waitOneSecond();
    	actions.moveToElement(driver.findElement(NseChartHover)).perform();
    	Thread.sleep(10000);
    	
    	waitOneSecond();
    	driver.findElement(NseChartOpen).click();
    	Thread.sleep(5000);
    	
    	waitOneSecond();
    	driver.switchTo().frame(0);
    	System.out.println("iframe changed");
    	
    	waitOneSecond();
    	String actualText_1 = driver.findElement(NseChartValidation).getText();
    	Assert.assertEquals(actualText_1, NseChart, "NSE Chart Mismatch");
    	System.out.println("Verified NSE Chart");

    	
    	
    	
    }

}
