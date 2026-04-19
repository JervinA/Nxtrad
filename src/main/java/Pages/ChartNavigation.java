package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Config.ConfigReader;

public class ChartNavigation {
private WebDriver driver;
private Actions actions;
    
    String NseChart = ConfigReader.getProperty("NseChart");
    String BseChart = ConfigReader.getProperty("BseChart");
    String NfoOptionChart = ConfigReader.getProperty("NfoOptionChart");
    String BfoOptionChart = ConfigReader.getProperty("BfoOptionChart");
    String BfoFutureChart = ConfigReader.getProperty("BfoFutureChart");
    String NfoFutureChart = ConfigReader.getProperty("NfoFutureChart");
    String McxFutureChart = ConfigReader.getProperty("McxFutureChart");
    String McxOptionChart = ConfigReader.getProperty("McxOptionChart");
    String IframeName = "iframeWebView";

    
 // Constructor
    public ChartNavigation(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        
    }
    
  //Actions
    public void chartnavigation(Xpath xp) throws InterruptedException {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getMarketScan())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getEquity())).click();
    	
    	
    	//validating NSE Chart
    	
    	actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChartHover()))).perform();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChartOpen())).click();
    	 	
    	driver.switchTo().frame(driver.findElement(xp.getSwitchIframe()));
    	System.out.println("iframe changed");
    	
    	driver.switchTo().frame(driver.findElement(xp.getSwitchInnerFrame()));
    	System.out.println("inneriframe changed");
    	
    	String actualText_1 = wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChartValidation())).getText();
    	Assert.assertEquals(actualText_1, NseChart, "NSE Chart Mismatch");
    	System.out.println("Verified NSE Chart");
    	
    	actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getHoverChartRevamp()))).perform();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChartScroll())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getCloseChart())).click();
    	
    	driver.switchTo().defaultContent();
    	
    	
    	// Validating BSE chart
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getNiftyDropdown())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChangeBse())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getCloseNifty())).click();
    	
    	actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChartHover()))).perform();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChartOpen())).click();
    	 	
    	driver.switchTo().frame(driver.findElement(xp.getSwitchIframe()));
    	System.out.println("iframe changed");
    	
    	driver.switchTo().frame(driver.findElement(xp.getSwitchInnerFrame()));
    	System.out.println("inneriframe changed");
    	
    	String actualText_2 = wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChartValidation())).getText();
    	Assert.assertEquals(actualText_2, BseChart, "BSE Chart Mismatch");
    	System.out.println("Verified BSE Chart");
    	
    	actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getHoverChartRevamp()))).perform();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChartScroll())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getCloseChart())).click();
    	
    	driver.switchTo().defaultContent();
    	
    	
    	// Validating NFO OPTIONS chart
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getOptions())).click();
    	
    	actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChartHover()))).perform();
    
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChartOpen())).click();
    		
    	driver.switchTo().frame(driver.findElement(xp.getSwitchIframe()));
    	System.out.println("iframe changed");
    	
    	driver.switchTo().frame(driver.findElement(xp.getSwitchInnerFrame()));
    	System.out.println("inneriframe changed");
    	
    	String actualText_3 = wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChartValidation())).getText();
    	Assert.assertEquals(actualText_3, NfoOptionChart, "NFO OPTION Chart Mismatch");
    	System.out.println("Verified NFO OPTION Chart");
    	
    	actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getHoverChartRevamp()))).perform();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChartScroll())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getCloseChart())).click();
    	
    	driver.switchTo().defaultContent();
    	
    	
    	// Validating BFO OPTIONS chart
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getNfoDropdown())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChangeOptionBfo())).click();
    	
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getCloseNifty())).click();
//    	
//    	actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChartHover()))).perform();
//    	
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChartOpen())).click();
//    	  	
//    	driver.switchTo().frame(driver.findElement(xp.getSwitchIframe()));
//    	System.out.println("iframe changed");
//    	
//    	driver.switchTo().frame(driver.findElement(xp.getSwitchInnerFrame()));
//    	System.out.println("inneriframe changed");
//    	
//    	String actualText_4 = wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChartValidation())).getText();
//    	Assert.assertEquals(actualText_4, BfoOptionChart, "BFO OPTION Chart Mismatch");
//    	System.out.println("Verified BFO OPTION Chart");
//    	
//    	actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getHoverChartRevamp()))).perform();
//    	
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChartScroll())).click();
//    	
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getCloseChart())).click();
//    	
//    	driver.switchTo().defaultContent();
    	
    	
    	// Validating BFO FUTURE chart
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getFutures())).click();
    	
//    	actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChartHover()))).perform();
//    	
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChartOpen())).click();
//    	  	
//    	driver.switchTo().frame(driver.findElement(xp.getSwitchIframe()));
//    	System.out.println("iframe changed");
//    	
//    	driver.switchTo().frame(driver.findElement(xp.getSwitchInnerFrame()));
//    	System.out.println("inneriframe changed");
//    	
//    	String actualText_5 = wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChartValidation())).getText();
//    	Assert.assertEquals(actualText_5, BfoFutureChart, "BFO FUTURE Chart Mismatch");
//    	System.out.println("Verified BFO FUTURE Chart");
//    	
//    	actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getHoverChartRevamp()))).perform();
//    	
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChartScroll())).click();
//    	
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getCloseChart())).click();
//    	
//    	driver.switchTo().defaultContent();
    	
    	
    	// Validating NFO FUTURE chart
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getBfoDropdown())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChangeFutureNfo())).click();
    	
    	actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChartHover()))).perform();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChartOpen())).click();
    	   	
    	driver.switchTo().frame(driver.findElement(xp.getSwitchIframe()));
    	System.out.println("iframe changed");
    	
    	driver.switchTo().frame(driver.findElement(xp.getSwitchInnerFrame()));
    	System.out.println("inneriframe changed");
    	
    	String actualText_6 = wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChartValidation())).getText();
    	Assert.assertEquals(actualText_6, NfoFutureChart, "NFO FUTURE Chart Mismatch");
    	System.out.println("Verified NFO FUTURE Chart");
    	
    	actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getHoverChartRevamp()))).perform();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChartScroll())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getCloseChart())).click();
    	
    	driver.switchTo().defaultContent();
    	
    	
    	// Validating MCX FUTURE chart
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getCommodity())).click();
    	
    	actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChartHover()))).perform();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChartOpen())).click();
    	 	
    	driver.switchTo().frame(driver.findElement(xp.getSwitchIframe()));
    	System.out.println("iframe changed");
    	
    	driver.switchTo().frame(driver.findElement(xp.getSwitchInnerFrame()));
    	System.out.println("inneriframe changed");
    	
    	String actualText_7 = wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChartValidation())).getText();
    	Assert.assertEquals(actualText_7, McxFutureChart, "MCX FUTURE Chart Mismatch");
    	System.out.println("Verified MCX FUTURE Chart");
    	
    	actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getHoverChartRevamp()))).perform();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChartScroll())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getCloseChart())).click();
    	
    	driver.switchTo().defaultContent();
    	
    	
    	// Validating MCX OPTION chart
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getCommodity())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getMcxDropdown())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChangeOptionMcx())).click();
    	
    	actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChartHover()))).perform();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChartOpen())).click();
    	 	
    	driver.switchTo().frame(driver.findElement(xp.getSwitchIframe()));
    	System.out.println("iframe changed");
    	
    	driver.switchTo().frame(driver.findElement(xp.getSwitchInnerFrame()));
    	System.out.println("inneriframe changed");
    	
    	String actualText_8 = wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChartValidation())).getText();
    	Assert.assertEquals(actualText_8, McxOptionChart, "MCX OPTION Chart Mismatch");
    	System.out.println("Verified MCX OPTION Chart");
    	
    	actions.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getHoverChartRevamp()))).perform();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getChartScroll())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getCloseChart())).click();
    	
    	driver.switchTo().defaultContent();
    	
    	
    }

}
