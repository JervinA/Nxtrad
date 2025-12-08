package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TraditionalLogin {
	
	private WebDriver driver;
	
	// Global wait method
    private void waitOneSecond() throws InterruptedException {
        Thread.sleep(2000);
    }

    // Locators
    private By mobileno = By.id("mobileNo");
    private By continueBtn1 = By.cssSelector("button[data-cy='login-submit-btn']");
    private By Otp = By.id("otp");
    private By selectId = By.xpath("//input[@value='IOU105']");
    private By okBtn = By.cssSelector("button[data-cy='dialog-confirm-btn']");
    private By Pin = By.id("pin");   
    private By continueBtn2 = By.cssSelector("button[data-cy='validate-submit-btn']");
    private By Skiptour = By.xpath("//*[contains(text(),'Skip tour')]");
    private By Riskclosure = By.xpath("//button[contains(text(),'I Understand')]");
    private By Verifylogin = By.xpath("//*[contains(text(),'Trading Terminals')]");
    String VerifyLogins = "Trading Terminals";
    
    
    //Reuse xpath
    public By getmobileno() {
    	return mobileno;
    }
    
    public By getcontinueBtn1() {
    	return continueBtn1;
    }
    
    public By getOtp() {
    	return Otp;
    }
    
    public By getselectId() {
    	return selectId;
    }
    
    public By getokBtn() {
    	return okBtn;
    }
    
    public By getPin() {
    	return Pin;
    }
    
    public By getcontinueBtn2() {
    	return continueBtn2;
    }
    
    public By getSkiptour() {
    	return Skiptour;
    }
    
    public By getRiskclosure() {
    	return Riskclosure;
    }

    // Constructor
    public TraditionalLogin(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void login(String mobile, String otp, String pin) throws InterruptedException {
    	
    	waitOneSecond();
        driver.findElement(mobileno).sendKeys(mobile);
        
        waitOneSecond();
        driver.findElement(continueBtn1).click();
        
        waitOneSecond();
        driver.findElement(Otp).sendKeys(otp);
        
        waitOneSecond();
        driver.findElement(selectId).click();
        
        waitOneSecond();
        driver.findElement(okBtn).click();
        
        waitOneSecond();
        driver.findElement(Pin).sendKeys(pin);
                   
        waitOneSecond();
        driver.findElement(continueBtn2).click();
        
        waitOneSecond();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(Skiptour));
            driver.findElement(Skiptour).click();
        } catch (Exception e) {
            // Element not found or not visible even after 10 sec — safely ignore
            System.out.println("Skip Tour button not displayed.");
        }
        
        waitOneSecond();
        driver.findElement(Riskclosure).click();
        
        waitOneSecond();
        driver.findElement(Verifylogin).equals(VerifyLogins);
        System.out.println(VerifyLogins);
        
    }
}
