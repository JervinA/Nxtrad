package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Config.ConfigReader;

public class SearchIndicesSpots {
	
private WebDriver driver;
    
    String IndexName = ConfigReader.getProperty("IndexName");
    String IndexExchange = ConfigReader.get("IndexExchange");
    String Spots = ConfigReader.get("Spots");
    
    
 // Constructor
    public SearchIndicesSpots(WebDriver driver) {
        this.driver = driver;
        
    }
    
    public void SearchIndicesSpots(Xpath xp, String indices, String spots) throws InterruptedException {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	
    	//Verifying INDEX
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSearchfield())).sendKeys(Keys.CONTROL + "a");
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSearchfield())).sendKeys(Keys.DELETE);
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSearchfield())).sendKeys(indices);
    	
    	String actualText_1 = wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getValidateIndicesName())).getText();
    	Assert.assertEquals(actualText_1, IndexName, "INDEX Name Mismatch");
    	System.out.println("Verified INDEX Name");
    	
    	String actualText_2 = wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getValidateIndicesExchange())).getText();
    	Assert.assertEquals(actualText_2, IndexExchange, "INDEX Exchange Mismatch");
    	System.out.println("Verified INDEX Exchange");
    	
    	System.out.println("Searching and Verifying INDEX completed");
    	
    	
    	//Verifying SPOT
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSearchfield())).sendKeys(Keys.CONTROL + "a");
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSearchfield())).sendKeys(Keys.DELETE);
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSearchfield())).sendKeys(spots);
    	
    	String actualText_3 = wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getValidateSpotExchange())).getText();
    	Assert.assertEquals(actualText_3, Spots, "SPOT Exchange Name Mismatch");
    	System.out.println("Verified SPOT Exchange Name");
    	
    	System.out.println("Searching and Verifying SPOT completed");
    	
    	driver.navigate().refresh();
    	Thread.sleep(2000);
    	
    	
    	
    }
    
    

}
