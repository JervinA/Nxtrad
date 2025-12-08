package Tests;

import org.testng.annotations.Test;

import Pages.RiskDisclosure;
import Pages.SignUpPage;
import Pages.TraditionalLogin;

public class LoginTest extends BaseTest {
	

	@Test(priority = 1)
	    public void validTraditionalLoginTest() throws InterruptedException {
		TraditionalLogin lp = new TraditionalLogin(driver);
	        lp.login("6380885750", "123456", "1234");
	        // assertions using TestNG
	    }
	 
	
	 @Test(priority = 2)
	    public void validateSignUpPage() throws InterruptedException {
		 TraditionalLogin tl = new TraditionalLogin(driver);
		 SignUpPage sp = new SignUpPage(driver);
	       sp.signup(tl, "6385734750", "123456");  
	    }
	 
	 @Test(priority = 3) 
	 public void validateRiskDisclosure() throws InterruptedException {
		 TraditionalLogin tl = new TraditionalLogin(driver);
		 RiskDisclosure rd = new RiskDisclosure(driver);
			rd.riskdisclosure(tl, "6380885750", "123456", "1234");
		
	 }
	 
}
