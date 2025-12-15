package Tests;

import org.testng.annotations.Test;

import Config.ConfigReader;
import Pages.RiskDisclosure;
import Pages.SearchStocks;
import Pages.SignUpPage;
import Pages.TraditionalLogin;

public class LoginTest extends BaseTest {
	
	 String mobileno_1 = ConfigReader.getProperty("mobileNumber_1");
	 String mobileno_2 = ConfigReader.getProperty("mobileNumber_2");
     String otp = ConfigReader.getProperty("otp");
     String pin = ConfigReader.getProperty("pin");
     
     String nse = ConfigReader.getProperty("nse");
     String bse = ConfigReader.getProperty("bse");
     String nfo = ConfigReader.getProperty("nfo");
     String bfo = ConfigReader.getProperty("bfo");
     String mcx = ConfigReader.getProperty("mcx");
	

	@Test(priority = 1)
	    public void validTraditionalLoginTest() throws InterruptedException {
		TraditionalLogin lp = new TraditionalLogin(driver);
	        lp.login(mobileno_1, otp, pin);
	        // assertions using TestNG
	    }
	 
	
	 @Test(priority = 2)
	    public void validateSignUpPage() throws InterruptedException {
		 TraditionalLogin tl = new TraditionalLogin(driver);
		 SignUpPage sp = new SignUpPage(driver);
	       sp.signup(tl, mobileno_2, otp);  
	    }
	 
	 @Test(priority = 3) 
	 public void validateRiskDisclosure() throws InterruptedException {
		 TraditionalLogin tl = new TraditionalLogin(driver);
		 RiskDisclosure rd = new RiskDisclosure(driver);
			rd.riskdisclosure(tl, mobileno_1, otp, pin);
		
	 }
	 
	 @Test(priority = 4)
	 public void validateSearchStocks() throws InterruptedException {
		 SearchStocks ss = new SearchStocks(driver);
		 ss.SearchStocks(nse, bse, nfo, bfo, mcx);
	 }
	 
}
