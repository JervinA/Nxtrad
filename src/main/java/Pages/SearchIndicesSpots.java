package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Config.ConfigReader;

public class SearchIndicesSpots {
	
private WebDriver driver;
	
	// Global wait method
    private void waitOneSecond() throws InterruptedException {
        Thread.sleep(1000);
    }
    
    private By ValidateIndicesName = By.xpath("(//*[contains(text(),'Nifty 50')])[2]");
    private By ValidateIndicesExchange = By.xpath("(//div[@class='disp-exchange '])[1]");
    private By ValidateSpotExchange = By.xpath("(//div[@class='disp-exchange '])[1]");
    private By ClickDashboard = By.cssSelector("div[date-cy='menu-dashboard']");
    
    
    String IndexName = ConfigReader.getProperty("IndexName");
    String IndexExchange = ConfigReader.get("IndexExchange");
    String Spots = ConfigReader.get("Spots");
    
    
 // Constructor
    public SearchIndicesSpots(WebDriver driver) {
        this.driver = driver;
        
    }
    
    public void SearchIndicesSpots(SearchStocks ss, String indices, String spots) throws InterruptedException {
    	
    	//Verifying INDEX
    	
    	waitOneSecond();
    	driver.findElement(ss.getSearchfield()).sendKeys(indices);
    	
    	waitOneSecond();
    	String actualText_1 = driver.findElement(ValidateIndicesName).getText();
    	Assert.assertEquals(actualText_1, IndexName, "INDEX Name Mismatch");
    	System.out.println("Verified INDEX Name");
    	
    	String actualText_2 = driver.findElement(ValidateIndicesExchange).getText();
    	Assert.assertEquals(actualText_2, IndexExchange, "INDEX Exchange Mismatch");
    	System.out.println("Verified INDEX Exchange");
    	
    	System.out.println("Searching and Verifying INDEX completed");
    	
    	
    	//Verifying SPOT
    	
    	waitOneSecond();
    	driver.findElement(ss.getSearchfield()).sendKeys(Keys.CONTROL + "a");
    	driver.findElement(ss.getSearchfield()).sendKeys(Keys.DELETE);
    	
    	waitOneSecond();
    	driver.findElement(ss.getSearchfield()).sendKeys(spots);
    	
    	waitOneSecond();
    	String actualText_3 = driver.findElement(ValidateSpotExchange).getText();
    	Assert.assertEquals(actualText_3, Spots, "SPOT Exchange Name Mismatch");
    	System.out.println("Verified SPOT Exchange Name");
    	
    	System.out.println("Searching and Verifying SPOT completed");
    	
    	driver.navigate().refresh();
    	Thread.sleep(2000);
    	
    	
    	
    }
    
    

}
