package Pages;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Config.ConfigReader;

public class Create_Edit_Delete_Basket {
	
	private WebDriver driver;
	private Actions actions;
    
    String BasketCreation = ConfigReader.getProperty("BasketCreation");
    String BasketModification = ConfigReader.getProperty("BasketModification");
    String BasketDeletion = ConfigReader.getProperty("BasketDeletion");
    
    
    // Constructor
    public Create_Edit_Delete_Basket(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        
    }
    
    
  //Actions
    public void Create_Edit_Delete_Basket(Xpath xp, String basketname, String BasketCreation, String Editname, String BasketModification, String BasketDeletion) throws InterruptedException {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getDashboard())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getOrdersTab())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getBasketTab())).click();
    	
    	//Checking basket screen is empty
    	
    	System.out.println("Checking basket screen is empty or clearing the baskets");
    	
    	Thread.sleep(2000);
    	List<WebElement> checkboxes = driver.findElements(xp.getAllCheckbox());

    	if (!checkboxes.isEmpty()) {

    		wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getAllCheckbox())).click();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getDeleteBasket())).click();
    		wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getDeleteConfirmation())).click();

    	} else {
    	    System.out.println("Basket is empty");
    	}
    	
    	Thread.sleep(5000);
    	
    	//Creating baskets
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getCreatebasket())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getBasketNameField())).sendKeys(basketname);
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getCreateButton())).click();
    	
    	//WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
//    	WebElement toastElement_1 = wait.until(ExpectedConditions.presenceOfElementLocated(CreationMsg));        
//    	String actualText_1 = toastElement_1.getText().trim();
//    	String expectedText_1 = BasketCreation.trim();
//    	Thread.sleep(2000);
//    	Assert.assertEquals(actualText_1,expectedText_1,"Creation Toast message not match. Actual Toast: " + actualText_1);
//    	System.out.println("Verified basket creation");
    	
    	//Editing Basket
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getOpenBasket())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getEditIcon())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getEditField())).sendKeys(Editname);
    	
    	actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
    	
    	WebElement toastElement_2 = wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getModifyMessage()));        
    	String actualText_2 = toastElement_2.getText().trim();
    	String expectedText_2 = BasketModification.trim();
    	Thread.sleep(2000);
    	Assert.assertEquals(actualText_2,expectedText_2,"Modification Toast message not match. Actual Toast: " + actualText_2);
    	System.out.println("Verified basket modification");
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getCloseBasket())).click();
    	
    	//Deleting basket
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getAllCheckbox())).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getDeleteBasket())).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getDeleteConfirmation())).click();
	    
	    Thread.sleep(2000);
	    
	    WebElement toastElement_3 = wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getDeleteMessage()));        
    	String actualText_3 = toastElement_3.getText().trim();
    	String expectedText_3 = BasketDeletion.trim();
    	Thread.sleep(2000);
    	Assert.assertEquals(actualText_3,expectedText_3,"Deletion Toast message not match. Actual Toast: " + actualText_3);
    	System.out.println("Verified basket Deletion");
    	
    	Thread.sleep(2000);
	    
	    
    	
    	
    	
    	
    	
    	
    }

}
