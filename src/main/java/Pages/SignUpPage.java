package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {

	private WebDriver driver;
	
	
	// Global wait method
    private void waitOneSecond() throws InterruptedException {
        Thread.sleep(1000);
    }

    // Locators
    private By profile = By.cssSelector("div[data-cy='profile-btn']");
    private By logout = By.cssSelector("div[data-cy='logout-btn']");
    private By OkBtn = By.cssSelector("button[data-cy='dialog-confirm-btn']");
    private By switchacc = By.xpath("//*[contains(text(),' Switch account')]");
    
    

 // Constructor
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

 // Actions
    public void signup(TraditionalLogin tl, String mobileno, String otp) throws InterruptedException {
    	
    	waitOneSecond();
        driver.findElement(profile).click();
        
        waitOneSecond();
        driver.findElement(logout).click();
        
        waitOneSecond();
        driver.findElement(OkBtn).click();
        
        waitOneSecond();
        driver.findElement(switchacc).click();
        
        waitOneSecond();
        driver.findElement(tl.getmobileno()).sendKeys(mobileno);
        
        waitOneSecond();
        driver.findElement(tl.getcontinueBtn1()).click();
        
        waitOneSecond();
        driver.findElement(tl.getOtp()).sendKeys(otp);
        
    }
	
}
