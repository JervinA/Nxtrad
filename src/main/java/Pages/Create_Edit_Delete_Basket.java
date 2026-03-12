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
    private By ModifyMessage = By.xpath("//*[contains(text(),'Basket name updated successfully.')]");
    private By CloseBasket = By.xpath("//span[@class='basket-btn-container']//button");
    private By DeleteMessage = By.xpath("//div[contains(text(),'Basket deleted successfully.')]");
    
    //Resue Xpath
    
    public By getCreatebasket() {
        return Createbasket;
    }
    
    public By getBasketNameField() {
        return BasketNameField;
    }
    
    public By getCreateButton() {
    	return CreateButton;
    }
    
    public By getOpenBasket() {
    	return OpenBasket;
    }
    
    String BasketCreation = ConfigReader.getProperty("BasketCreation");
    String BasketModification = ConfigReader.getProperty("BasketModification");
    String BasketDeletion = ConfigReader.getProperty("BasketDeletion");
    
    
    // Constructor
    public Create_Edit_Delete_Basket(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        
    }
    
    
  //Actions
    public void Create_Edit_Delete_Basket(OrderModification om, String basketname, String BasketCreation, String Editname, String BasketModification, String BasketDeletion) throws InterruptedException {
    	
    	driver.findElement(Dashboard).click();
    	
    	driver.findElement(om.getOrdersTab()).click();
    	
    	driver.findElement(BasketTab).click();
    	
    	waitOneSecond();
    	
    	//Checking basket screen is empty
    	
    	System.out.println("Checking basket screen is empty or clearing the baskets");
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    	List<WebElement> checkboxes = driver.findElements(AllCheckbox);

    	if (!checkboxes.isEmpty()) {

    	    wait.until(ExpectedConditions.visibilityOfElementLocated(AllCheckbox)).click();
    	    wait.until(ExpectedConditions.elementToBeClickable(DeleteBasket)).click();
    	    wait.until(ExpectedConditions.elementToBeClickable(DeleteConfirmation)).click();

    	} else {
    	    System.out.println("Basket is empty");
    	}
    	
    	Thread.sleep(5000);
    	
    	//Creating baskets
    	wait.until(ExpectedConditions.elementToBeClickable(Createbasket)).click();
    	
    	wait.until(ExpectedConditions.elementToBeClickable(BasketNameField)).sendKeys(basketname);
    	
    	wait.until(ExpectedConditions.elementToBeClickable(CreateButton)).click();
    	
    	//WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
//    	WebElement toastElement_1 = wait.until(ExpectedConditions.presenceOfElementLocated(CreationMsg));        
//    	String actualText_1 = toastElement_1.getText().trim();
//    	String expectedText_1 = BasketCreation.trim();
//    	Thread.sleep(2000);
//    	Assert.assertEquals(actualText_1,expectedText_1,"Creation Toast message not match. Actual Toast: " + actualText_1);
//    	System.out.println("Verified basket creation");
    	
    	//Editing Basket
    	wait.until(ExpectedConditions.elementToBeClickable(OpenBasket)).click();
    	
    	wait.until(ExpectedConditions.elementToBeClickable(EditIcon)).click();
    	
    	wait.until(ExpectedConditions.elementToBeClickable(EditField)).sendKeys(Editname);
    	
    	actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
    	
    	WebElement toastElement_2 = wait.until(ExpectedConditions.presenceOfElementLocated(ModifyMessage));        
    	String actualText_2 = toastElement_2.getText().trim();
    	String expectedText_2 = BasketModification.trim();
    	Thread.sleep(2000);
    	Assert.assertEquals(actualText_2,expectedText_2,"Modification Toast message not match. Actual Toast: " + actualText_2);
    	System.out.println("Verified basket modification");
    	
    	driver.findElement(CloseBasket).click();
    	
    	//Deleting basket
    	wait.until(ExpectedConditions.visibilityOfElementLocated(AllCheckbox)).click();
	    wait.until(ExpectedConditions.elementToBeClickable(DeleteBasket)).click();
	    wait.until(ExpectedConditions.elementToBeClickable(DeleteConfirmation)).click();
	    
	    Thread.sleep(2000);
	    
	    WebElement toastElement_3 = wait.until(ExpectedConditions.presenceOfElementLocated(DeleteMessage));        
    	String actualText_3 = toastElement_3.getText().trim();
    	String expectedText_3 = BasketDeletion.trim();
    	Thread.sleep(2000);
    	Assert.assertEquals(actualText_3,expectedText_3,"Deletion Toast message not match. Actual Toast: " + actualText_3);
    	System.out.println("Verified basket Deletion");
    	
    	Thread.sleep(2000);
	    
	    
    	
    	
    	
    	
    	
    	
    }

}
