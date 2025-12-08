package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RiskDisclosure {
	
	private WebDriver driver;
	
	// Global wait method
    private void waitOneSecond() throws InterruptedException {
        Thread.sleep(2000);
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
    	driver.findElement(riskdisclosuretitle).equals(text);
    	
    	waitOneSecond();
        driver.findElement(tl.getRiskclosure()).click();
    }

}
