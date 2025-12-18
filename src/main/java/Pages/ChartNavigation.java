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
    private By ChartHover = By.cssSelector("tr[data-cy='market_movers-row-0']");
    private By ChartOpen = By.xpath("(//button[contains(@class,'chart-btn')])[4]");
    private By SwitchIframe = By.id("DEFAULT_CHART");
    private By SwitchInnerFrame = By.xpath("//*[@title='Financial Chart']");
    private By ChartValidation = By.xpath("//div[@class='title-l31H9iuA']");
    private By HoverChartRevamp = By.xpath("(//div[@class='arrow-merBkM5y'])[3]");
    private By ChartScroll = By.xpath("//div[@class='scrollRight-wXGVFOC9 isVisible-wXGVFOC9']");
    private By CloseChart = By.id("close-chart-window");
    private By NiftyDropdown = By.xpath("//button[contains(text(),'Nifty 50')]");
    private By ChangeBse = By.xpath("//button[@value='BSE']");
    private By CloseNifty = By.xpath("//button[contains(text(),'Top Gainers')]");
    private By Options = By.xpath("//div[contains(text(),'Options')]");
    
    
    String NseChart = ConfigReader.getProperty("NseChart");
    String BseChart = ConfigReader.getProperty("BseChart");
    String NfoOptionChart = ConfigReader.getProperty("NfoOptionChart");
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
    	actions.moveToElement(driver.findElement(ChartHover)).perform();
    	Thread.sleep(1000);
    	
    	waitOneSecond();
    	driver.findElement(ChartOpen).click();
    	Thread.sleep(5000);    	    	
    	
    	waitOneSecond();   	
    	driver.switchTo().frame(driver.findElement(SwitchIframe));
    	System.out.println("iframe changed");
    	
    	driver.switchTo().frame(driver.findElement(SwitchInnerFrame));
    	System.out.println("inneriframe changed");
    	
    	waitOneSecond();
    	String actualText_1 = driver.findElement(ChartValidation).getText();
    	Assert.assertEquals(actualText_1, NseChart, "NSE Chart Mismatch");
    	System.out.println("Verified NSE Chart");
    	
    	waitOneSecond();
    	actions.moveToElement(driver.findElement(HoverChartRevamp)).perform();
    	Thread.sleep(1000);
    	
    	driver.findElement(ChartScroll).click();
    	
    	driver.findElement(CloseChart).click();
    	
    	driver.switchTo().defaultContent();
    	
    	
    	// Validating BSE chart
    	
    	waitOneSecond();
    	driver.findElement(NiftyDropdown).click();
    	
    	driver.findElement(ChangeBse).click();
    	
    	driver.findElement(CloseNifty).click();
    	
    	waitOneSecond();
    	actions.moveToElement(driver.findElement(ChartHover)).perform();
    	Thread.sleep(1000);
    	
    	waitOneSecond();
    	driver.findElement(ChartOpen).click();
    	Thread.sleep(5000);
    	
    	waitOneSecond();   	
    	driver.switchTo().frame(driver.findElement(SwitchIframe));
    	System.out.println("iframe changed");
    	
    	driver.switchTo().frame(driver.findElement(SwitchInnerFrame));
    	System.out.println("inneriframe changed");
    	
    	waitOneSecond();
    	String actualText_2 = driver.findElement(ChartValidation).getText();
    	Assert.assertEquals(actualText_2, BseChart, "BSE Chart Mismatch");
    	System.out.println("Verified BSE Chart");
    	
    	waitOneSecond();
    	actions.moveToElement(driver.findElement(HoverChartRevamp)).perform();
    	Thread.sleep(1000);
    	
    	driver.findElement(ChartScroll).click();
    	
    	driver.findElement(CloseChart).click();
    	
    	driver.switchTo().defaultContent();
    	
    	
    	// Validating NFO OPTIONS chart
    	
    	waitOneSecond();
    	driver.findElement(Options).click();
    	
    	waitOneSecond();
    	actions.moveToElement(driver.findElement(ChartHover)).perform();
    	Thread.sleep(1000);
    	
    	waitOneSecond();
    	driver.findElement(ChartOpen).click();
    	Thread.sleep(5000);
    	
    	waitOneSecond();   	
    	driver.switchTo().frame(driver.findElement(SwitchIframe));
    	System.out.println("iframe changed");
    	
    	driver.switchTo().frame(driver.findElement(SwitchInnerFrame));
    	System.out.println("inneriframe changed");
    	
    	waitOneSecond();
    	String actualText_3 = driver.findElement(ChartValidation).getText();
    	Assert.assertEquals(actualText_3, NfoOptionChart, "NFO OPTION Chart Mismatch");
    	System.out.println("Verified NFO OPTION Chart");
    	
    	waitOneSecond();
    	actions.moveToElement(driver.findElement(HoverChartRevamp)).perform();
    	Thread.sleep(1000);
    	
    	driver.findElement(ChartScroll).click();
    	
    	driver.findElement(CloseChart).click();
    	
    	driver.switchTo().defaultContent();
    	
    	
    	// Validating BFO OPTIONS chart
    	
    	
    	
    	
    	
    }

}
