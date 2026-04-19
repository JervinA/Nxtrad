package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Pages.Xpath.VerifyLoginText;

public class RiskDisclosure {
	
	private WebDriver driver;
	
//	private By riskdisclosuretitle = By.xpath("//span[@class='eula-title']");
//	String text = "RISK DISCLOSURES ON DERIVATIVES";
	
	
	 // Constructor
    public RiskDisclosure(WebDriver driver) {
        this.driver = driver;
    }
    
 // Actions
    public void riskdisclosure(Xpath xp, String mobileno, String Otp, String pin) throws InterruptedException {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	
    	driver.navigate().refresh();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getmobileno())).sendKeys(mobileno);
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getcontinueBtn1())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getOtp())).sendKeys(Otp);
    	
    	Thread.sleep(2000);
    	driver.findElement(xp.getselectId()).click();
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getselectId())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getokBtn())).click();
    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getEnterPin())).sendKeys(pin);
    	
//    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getRiskclosure())).click();
    	
    	String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getriskdisclosuretitle())).getText();
    	Assert.assertEquals(actualText, VerifyLoginText.text, "Risk Disclosure text mismatch!");
    	System.out.println("Verified Riskdisclosure");

    	
    	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getRiskclosure())).click();
        
        try {
        	wait.until(ExpectedConditions.visibilityOfElementLocated(xp.getCloseTOTP())).click();
        } catch (Exception e) {
        	System.out.println("Register TOTP not found");
        }
    }

}
