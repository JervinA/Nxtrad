package Pages;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
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
	
	// Global wait method
    private void waitOneSecond() throws InterruptedException {
        Thread.sleep(2000);
    }
    
    
    private By Dashboard = By.xpath("//*[contains(text(),'Dashboard')]");
    private By BasketTab = By.xpath("//*[contains(text(),'Baskets')]");
    private By AllCheckbox = By.xpath("//span[@class='MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary PrivateSwitchBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-root MuiCheckbox-colorPrimary css-clw93t']");
    private By DeleteBasket = By.xpath("//*[contains(text(),'Delete')]");
    private By DeleteConfirmation = By.xpath("(//button[contains(text(),'Yes')])[2]");
    private By Createbasket = By.xpath("//*[contains(text(),'Add New Basket')]");
    private By BasketNameField = By.xpath("//input[@placeholder='Basket name']");
    private By CreateButton = By.xpath("//button[contains(text(),'Create')]");
    private By CreationMsg = By.xpath("//div[@class='MuiAlert-message css-1xsto0d']");
    private By OpenBasket = By.xpath("//span[normalize-space()='Automation']");
    private By EditIcon = By.xpath("//span[normalize-space()='Automation']/parent::div//button");
    private By EditField = By.xpath("//input[@placeholder='Basket name']");
    
    
    String BasketCreation = ConfigReader.getProperty("BasketCreation");
    
    
    // Constructor
    public Create_Edit_Delete_Basket(WebDriver driver) {
        this.driver = driver;
        
    }
    
    
  //Actions
    public void Create_Edit_Delete_Basket(OrderModification om, String basketname, String BasketCreation) throws InterruptedException {
    	
    	driver.findElement(Dashboard).click();
    	
    	driver.findElement(om.getOrdersTab()).click();
    	
    	driver.findElement(BasketTab).click();
    	
    	waitOneSecond();
    	
    	//Checking basket screen is empty
    	
    	System.out.println("Checking basket screen is empty or clearing the baskets");
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	List<WebElement> checkboxes = driver.findElements(AllCheckbox);

    	if (!checkboxes.isEmpty()) {

    	    wait.until(ExpectedConditions.visibilityOfElementLocated(AllCheckbox)).click();
    	    wait.until(ExpectedConditions.elementToBeClickable(DeleteBasket)).click();
    	    wait.until(ExpectedConditions.elementToBeClickable(DeleteConfirmation)).click();

    	} else {
    	    System.out.println("Basket is empty");
    	}
    	
    	waitOneSecond();
    	
    	//Creating baskets
    	driver.findElement(Createbasket).click();
    	
    	driver.findElement(BasketNameField).sendKeys(basketname);
    	
    	driver.findElement(CreateButton).click();
    	
    	//WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
    	WebElement toastElement_1 = wait.until(ExpectedConditions.presenceOfElementLocated(CreationMsg));        
    	String actualText_1 = toastElement_1.getText().trim();
    	String expectedText_1 = BasketCreation.trim();
    	Assert.assertEquals(actualText_1,expectedText_1,"Creation Toast message not match. Actual Toast: " + actualText_1);
    	System.out.println("Verified basket creation");
    	
    	//Editing Basket
    	driver.findElement(OpenBasket).click();
    	
    	driver.findElement(EditIcon).click();
    	
    	driver.findElement(EditField);
    	
    	
    }

}
