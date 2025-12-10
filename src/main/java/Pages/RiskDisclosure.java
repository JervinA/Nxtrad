package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RiskDisclosure {
	
	private WebDriver driver;
	
	// Global wait method
    private void waitOneSecond() throws InterruptedException {
        Thread.sleep(1000);
    }
	
	private By riskdisclosuretitle = By.xpath("//span[@class='eula-title']");
	String text = "RISK DISCLOSURES ON DERIVATIVES";
	
	
	 // Constructor
    public RiskDisclosure(WebDriver driver) {
        this.driver = driver;
    }
    
 // Actions
    public void riskdisclosure(TraditionalLogin tl, String mobileno, String Otp, String pin) throws InterruptedException {
    	
    	waitOneSecond();
    	driver.navigate().refresh();
    	
    	Thread.sleep(5000);
    	
    	waitOneSecond();
    	driver.findElement(tl.getmobileno()).sendKeys(mobileno);
    	
    	waitOneSecond();
    	driver.findElement(tl.getcontinueBtn1()).click();
    	
    	waitOneSecond();
    	driver.findElement(tl.getOtp()).sendKeys(Otp);
    	
    	waitOneSecond();
    	driver.findElement(tl.getselectId()).click();
    	
    	waitOneSecond();
    	driver.findElement(tl.getokBtn()).click();
    	
    	waitOneSecond();
    	driver.findElement(tl.getPin()).sendKeys(pin);
    	
    	waitOneSecond();
    	driver.findElement(tl.getcontinueBtn2()).click();
    	
    	waitOneSecond();
    	
    	String actualText = driver.findElement(riskdisclosuretitle).getText();
    	Assert.assertEquals(actualText, text, "Risk Disclosure text mismatch!");
    	System.out.println("Verified Riskdisclosure");

    	
    	waitOneSecond();
        driver.findElement(tl.getRiskclosure()).click();
    }

}
