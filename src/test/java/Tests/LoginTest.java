package Tests;

import org.testng.annotations.Test;

import Config.ConfigReader;
import Pages.Add_Delete_Reaarange_Invert_symbols;
import Pages.ChartNavigation;
import Pages.Create_Edit_Delete_Basket;
import Pages.OrderCancellation;
import Pages.OrderEquity;
import Pages.OrderModification;
import Pages.RiskDisclosure;
import Pages.SearchIndicesSpots;
import Pages.SearchStocks;
import Pages.SignUpPage;
import Pages.Symbol_modification_Basket;
import Pages.TraditionalLogin;
import Pages.Xpath;

public class LoginTest extends BaseTest {
	
	 String mobileno_1 = ConfigReader.getProperty("mobileNumber_1");
	 String mobileno_2 = ConfigReader.getProperty("mobileNumber_2");
     String otp = ConfigReader.getProperty("otp");
     String pin = ConfigReader.getProperty("pin");
     String Id = ConfigReader.getProperty("Id");
     String Totp = ConfigReader.getProperty("Totp");
     
     String nse = ConfigReader.getProperty("nse");
     String bse = ConfigReader.getProperty("bse");
     String nfo = ConfigReader.getProperty("nfo");
     String bfo = ConfigReader.getProperty("bfo");
     String mcx = ConfigReader.getProperty("mcx");
     
     String indices = ConfigReader.getProperty("indices");
     String spots = ConfigReader.getProperty("spots");
     
     String NseOrder = ConfigReader.getProperty("NseOrder");
     String BseOrder = ConfigReader.getProperty("BseOrder");
     
     String SearcOpenNseOrder = ConfigReader.getProperty("SearcOpenNseOrder");
     String SearcOpenBseOrder = ConfigReader.getProperty("SearcOpenBseOrder");
     
     String basketname = ConfigReader.getProperty("basketname");
     String BasketCreation = ConfigReader.getProperty("BasketCreation");
     String Editname = ConfigReader.getProperty("Editname");
     String BasketModification = ConfigReader.getProperty("BasketModification");
     String BasketDeletion = ConfigReader.getProperty("BasketDeletion");
     String SearchNSESymbol = ConfigReader.getProperty("SearchNSESymbol");
     String BasketSearch = ConfigReader.getProperty("BasketSearch");
	

	@Test(priority = 1)
	    public void validTraditionalLoginTest() throws InterruptedException {
		Xpath xp = new Xpath(driver);
		TraditionalLogin lp = new TraditionalLogin(driver);
	    lp.login(xp, mobileno_1, otp, pin, Id, Totp);
	 
	    }
	 
	
	 @Test(priority = 2)
	    public void validateSignUpPage() throws InterruptedException {
		 Xpath xp = new Xpath(driver);
		 SignUpPage sp = new SignUpPage(driver);
	       sp.signup(xp, mobileno_2, otp);  
	    }
	 

	 @Test(priority = 3) 
	 public void validateRiskDisclosure() throws InterruptedException {
		 Xpath xp = new Xpath(driver);
		 RiskDisclosure rd = new RiskDisclosure(driver);
			rd.riskdisclosure(xp, mobileno_1, otp, pin);
		
	 }
	 
	 
	 @Test(priority = 4)
	 public void validateSearchStocks() throws InterruptedException {
		 Xpath xp = new Xpath(driver);
		 SearchStocks ss = new SearchStocks(driver);
		 ss.SearchStocks(xp, nse, bse, nfo, bfo, mcx);
	 }
	
	 
	 @Test(priority = 5)
	 public void ValidateSearchIndicesAndSpots() throws InterruptedException {
		 Xpath xp = new Xpath(driver);
		 SearchIndicesSpots is = new SearchIndicesSpots(driver);
		 is.SearchIndicesSpots(xp, indices, spots);
	 }
	
	 
	 @Test(priority = 6)
	 public void ValidateChartOpening() throws InterruptedException {
		 Xpath xp = new Xpath(driver);
		 ChartNavigation cn = new ChartNavigation(driver);
		 cn.chartnavigation(xp);
	 }
	
	 
//	 @Test(priority = 7)
//	 public void ValidateOrderPlacement() throws InterruptedException {
//		 Xpath xp = new Xpath(driver);
//		 OrderEquity oe = new OrderEquity(driver);
//		 oe.OrderEquity(xp, NseOrder, BseOrder);	 
//	 }
	 
	 
//	 @Test(priority = 8)
//	 public void ValidateOrderModification() throws InterruptedException {
//		 Xpath xp = new Xpath(driver);
//		 OrderModification om = new OrderModification(driver);
//		 om.OrderModification(xp, SearcOpenNseOrder, SearcOpenBseOrder);
//	 }
	 
	 
//	 @Test(priority = 9)
//	 public void ValidateOrderCancellation() throws InterruptedException {
//		 Xpath xp = new Xpath(driver);
//		 OrderCancellation oc = new OrderCancellation(driver);
//		 oc.OrderCancellation(xp, SearcOpenNseOrder, SearcOpenBseOrder);
//	 }
	 
	 
	 @Test(priority = 10)
	 public void ValidateCreate_Edit_Delete_Basket() throws InterruptedException{
		 Xpath xp = new Xpath(driver);
		 Create_Edit_Delete_Basket cb = new Create_Edit_Delete_Basket(driver);
		 cb.Create_Edit_Delete_Basket(xp, basketname, BasketCreation, Editname, BasketModification, BasketDeletion);
	 }
	 
	 
	 @Test(priority = 11)
	 public void ValidateAdd_Delete_Rearrange_Invert_Symbols() throws InterruptedException {
		 Xpath xp = new Xpath(driver);
		 Add_Delete_Reaarange_Invert_symbols ad = new Add_Delete_Reaarange_Invert_symbols(driver);
		 ad.Add_Delete_Reaarange_Invert_symbols(xp, basketname, SearchNSESymbol, BasketSearch);
	 }
	 
//	 @Test(priority = 12)
//	 public void ValidateSymbol_modification_Basket() throws InterruptedException {
//		 Xpath xp = new Xpath(driver);
//		 Symbol_modification_Basket sm = new Symbol_modification_Basket(driver);
//		 sm.Symbol_modification_Basket(ad);
//	 }
	 
}
