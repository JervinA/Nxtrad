package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {

	private WebDriver driver;

 // Constructor
    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

 // Actions
    public void signup(Xpath xp, String mobileno, String otp) throws InterruptedException {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getprofile())).click();
        
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getlogout())).click();
        
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getokBtn())).click();
        
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getswitchacc())).click();
        
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getLoginwithNo())).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getmobileno())).sendKeys(mobileno);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getcontinueBtn1())).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getOtp())).sendKeys(otp);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getcreateacc())).click();
        
     // Get current window
        String currentWindow = driver.getWindowHandle();
        
     // Switch to new window
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        
        Thread.sleep(3000);
        
//        driver.close();
        
     // Switch back to original tab
        driver.switchTo().window(currentWindow);
        
//        waitOneSecond();
//        driver.findElement(tryotherno).click();
        
//        waitOneSecond();
//        driver.findElement(tl.getmobileno()).clear();
        
        
    }
	
}
