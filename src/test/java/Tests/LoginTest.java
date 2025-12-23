package Tests;

import org.testng.annotations.Test;

import Config.ConfigReader;
import Pages.ChartNavigation;
import Pages.OrderEquity;
import Pages.OrderModification;
import Pages.RiskDisclosure;
import Pages.SearchIndicesSpots;
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
     
     String indices = ConfigReader.getProperty("indices");
     String spots = ConfigReader.getProperty("spots");
     
     String NseOrder = ConfigReader.getProperty("NseOrder");
     String BseOrder = ConfigReader.getProperty("BseOrder");
     
     String SearcOpenOrder = ConfigReader.getProperty("SearcOpenOrder");
	

	@Test(priority = 1)
	    public void validTraditionalLoginTest() throws InterruptedException {
		TraditionalLogin lp = new TraditionalLogin(driver);
	        lp.login(mobileno_1, otp, pin);
	 
	    }
	 
	
//	 @Test(priority = 2)
//	    public void validateSignUpPage() throws InterruptedException {
//		 TraditionalLogin tl = new TraditionalLogin(driver);
//		 SignUpPage sp = new SignUpPage(driver);
//	       sp.signup(tl, mobileno_2, otp);  
//	    }
	 

//	 @Test(priority = 3) 
//	 public void validateRiskDisclosure() throws InterruptedException {
//		 TraditionalLogin tl = new TraditionalLogin(driver);
//		 RiskDisclosure rd = new RiskDisclosure(driver);
//			rd.riskdisclosure(tl, mobileno_1, otp, pin);
//		
//	 }
	 
	 
 
//	 @Test(priority = 4)
//	 public void validateSearchStocks() throws InterruptedException {
//		 SearchStocks ss = new SearchStocks(driver);
//		 ss.SearchStocks(nse, bse, nfo, bfo, mcx);
//	 }
	
	 
//	 @Test(priority = 5)
//	 public void ValidateSearchIndicesAndSpots() throws InterruptedException {
//		 SearchStocks ss = new SearchStocks(driver);
//		 SearchIndicesSpots is = new SearchIndicesSpots(driver);
//		 is.SearchIndicesSpots(ss, indices, spots);
//	 }
	
	 
//	 @Test(priority = 6)
//	 public void ValidateChartOpening() throws InterruptedException {
//		 ChartNavigation cn = new ChartNavigation(driver);
//		 cn.chartnavigation();
//	 }
	
	 
//	 @Test(priority = 7)
//	 public void ValidateOrderPlacement() throws InterruptedException {
//		 SearchStocks ss = new SearchStocks(driver);
//		 OrderEquity oe = new OrderEquity(driver);
//		 oe.OrderEquity(ss, NseOrder, BseOrder);	 
//	 }
	 
	 
	 @Test(priority = 8)
	 public void ValidateOrderModification() throws InterruptedException {
		 SearchStocks ss = new SearchStocks(driver);
		 OrderEquity oe = new OrderEquity(driver);
		 OrderModification om = new OrderModification(driver);
		 om.OrderModification(ss, oe, SearcOpenOrder);
	 }
}
