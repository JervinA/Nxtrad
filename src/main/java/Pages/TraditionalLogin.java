package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.Xpath.VerifytheLogin;

public class TraditionalLogin {
	
	private WebDriver driver;
	

    // Constructor
    public TraditionalLogin(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void login(Xpath xp, String mobile, String otp, String pin, String Id, String Totp) throws InterruptedException {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	
    	//Login with ID
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getLoginwithId())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getEnterId())).sendKeys(Id);
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getEnterPin())).sendKeys(pin);
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getEnterTotp())).sendKeys(Totp);
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getProceed())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getSkiptour())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getRiskclosure())).click();
    	
    	System.out.println("Verified ID login");
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getprofile())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getlogout())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getOkBtn())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getswitchacc())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getLoginwithNo())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getmobileno())).sendKeys(mobile);
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getcontinueBtn1())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getOtp())).sendKeys(otp);
    	
    	Thread.sleep(6000);
    	
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getselectId())).click();
    	driver.findElement(xp.getselectId()).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getOkBtn())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getEnterPin())).sendKeys(pin);
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getRiskclosure())).click();
    	
//    	try {
//          wait.until(ExpectedConditions.visibilityOfElementLocated(Skiptour));
//          driver.findElement(Skiptour).click();
//      } catch (Exception e) {
//          // Element not found or not visible even after 10 sec — safely ignore
//          System.out.println("Skip Tour button not displayed.");
//      }
    	
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getRiskclosure())).click();
    	
    	try {
    		wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getCloseTOTP())).click();
        } catch (Exception e) {
        	System.out.println("Register TOTP not found");
        }
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getVerifylogin())).equals(VerifytheLogin.VerifyLogins);
		
		
        
    }
}
