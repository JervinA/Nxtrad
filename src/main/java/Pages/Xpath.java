package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Xpath {

	private WebDriver driver;
	
	// Locators
	
	//Login locators
    private By LoginwithId = By.xpath("//*[contains(text(),'Login with User ID')]");
    private By EnterId = By.id("USER_ID");
    private By EnterPin = By.xpath("//*[@data-cy='login-pin']");
    private By EnterTotp = By.xpath("//*[@data-cy='validate-otp']");
    private By Proceed = By.xpath("//*[contains(text(),'Proceed')]");
    private By LoginwithNo = By.xpath("//*[contains(text(),\"Don't know your User ID? Login with Mobile No\")]");
    private By mobileno = By.id("MOBILE_NO");
    private By continueBtn1 = By.cssSelector("button[data-cy='login-submit-btn']");
    private By Otp = By.xpath("//*[@data-cy='validate-otp']");
    private By selectId = By.xpath("//input[@value='IOU105']");
    private By okBtn = By.cssSelector("button[data-cy='dialog-confirm-btn']");
    private By Pin = By.id("pin");   
    private By continueBtn2 = By.cssSelector("button[data-cy='validate-submit-btn']");
    private By Skiptour = By.xpath("//*[contains(text(),'Skip tour')]");
    private By Riskclosure = By.xpath("//button[contains(text(),'I Understand')]");
    private By Verifylogin = By.xpath("//*[contains(text(),'Trading Terminals')]");
    private By CloseTOTP = By.xpath("(//div[@class='MuiAlert-action css-1mzcepu'])[2]");
    String VerifyLogins = "Trading Terminals";
    private By profile = By.cssSelector("div[data-cy='profile-btn']");
    private By logout = By.cssSelector("div[data-cy='logout-btn']");
    private By OkBtn = By.cssSelector("button[data-cy='dialog-confirm-btn']");
    private By switchacc = By.xpath("//span[@class='switch-acc']");
    private By createacc = By.xpath("//button[contains(text(),'Create Account')]");
    private By tryotherno = By.xpath("//*[contains(text(),'Try with new number?')]");
    private By riskdisclosuretitle = By.xpath("//span[@class='eula-title']");
    String text = "RISK DISCLOSURES ON DERIVATIVES";
    
    //Search Stocks & Indices & Spots
    private By SelectTab = By.xpath("//div[@class='MuiTabs-scroller MuiTabs-hideScrollbar MuiTabs-scrollableX css-12qnib']//button[contains(.,'Automation')]");
    private By Searchfield = By.id("search-input");
    private By ValidateNseName = By.xpath("//*[contains(text(),'IDEA')]");
    private By ValidateNseExchange = By.xpath("//*[contains(text(),'NSE')]");
    private By ValidateBseName = By.xpath("//*[contains(text(),'IDEA')]");
    private By ValidateBseExchange = By.xpath("//*[contains(text(),'BSE')]");
    private By ValidateNfoName = By.xpath("(//*[contains(text(),'ASIANPAINT')])[1]");
    private By ValidateNfoExchange = By.xpath("(//*[contains(text(),'NFO')])[1]");
    private By ValidateBfoName = By.xpath("//div[@id='search-results']/div[1]");
    private By ValidateBfoExchange = By.xpath("(//*[contains(text(),'BFO')])[1]");
    private By ValidateMcxName = By.cssSelector("div[data-cy='search-row-0']");
    private By ValidateMcxExchange = By.xpath("(//*[contains(text(),'MCX')])[1]");
    private By ValidateIndicesName = By.xpath("(//*[contains(text(),'Nifty 50')])[2]");
    private By ValidateIndicesExchange = By.xpath("(//div[@class='disp-exchange '])[1]");
    private By ValidateSpotExchange = By.xpath("(//div[@class='disp-exchange '])[1]");
    private By ClickDashboard = By.cssSelector("div[date-cy='menu-dashboard']");
    
    //Charts
    private By MarketScan = By.xpath("//*[contains(text(),'Market Scan')]");
    private By Equity = By.xpath("//*[contains(text(),'Equity')]");
    private By ChartHover = By.cssSelector("tr[data-cy='market_movers-row-0']");
    private By ChartOpen = By.xpath("(//button[contains(@class,'chart-btn')])[4]");
    private By SwitchIframe = By.id("DEFAULT_CHART");
    private By SwitchInnerFrame = By.xpath("//*[@title='Financial Chart']");
    private By ChartValidation = By.xpath("//div[@class='title-l31H9iuA']");
    private By HoverChartRevamp = By.xpath("(//div[@class='arrow-merBkM5y'])[3]");
    private By ChartScroll = By.xpath("//div[@class='scrollRight-wXGVFOC9 isVisible-wXGVFOC9']");
    private By CloseChart = By.id("close-chart-window");
    private By NiftyDropdown = By.xpath("//button[contains(text(),'Nifty 50')]");
    private By ChangeBse = By.xpath("//button[@value='BSE']");
    private By CloseNifty = By.xpath("//button[contains(text(),'Top Gainers')]");
    private By Options = By.xpath("//div[contains(text(),'Options')]");
    private By NfoDropdown = By.xpath("//button[contains(text(),'NFO')]");
    private By ChangeOptionBfo = By.xpath("//span[contains(text(),'BFO')]");
    private By Futures = By.xpath("//*[contains(text(),'Futures')]");
    private By BfoDropdown = By.xpath("//button[contains(text(),'BFO')]");
    private By ChangeFutureNfo = By.xpath("//span[contains(text(),'NFO')]");
    private By Commodity = By.xpath("//*[contains(text(),'Commodity')]");
    private By McxDropdown = By.xpath("//button[contains(text(),'FUTURES')]");
    private By ChangeOptionMcx = By.xpath("//span[contains(text(),'Options')]");
    
    
 // Constructor
  public Xpath(WebDriver driver) {
      this.driver = driver;
  }

	//Reuse xpath
  
  	//Login reuse
    public By getLoginwithId() {
    	return LoginwithId;
    }
    
    public By getEnterId() {
    	return EnterId;
    }
    
    public By getEnterPin() {
    	return EnterPin;
    }
    
    public By getEnterTotp() {
    	return EnterTotp;
    }
    
    public By getProceed() {
    	return Proceed;
    }
    
    public By getLoginwithNo() {
    	return LoginwithNo;
    }
    
    public By getmobileno() {
    	return mobileno;
    }
    
    public By getcontinueBtn1() {
    	return continueBtn1;
    }
    
    public By getOtp() {
    	return Otp;
    }
    
    public By getselectId() {
    	return selectId;
    }
    
    public By getokBtn() {
    	return okBtn;
    }
    
    public By getPin() {
    	return Pin;
    }
    
    public By getcontinueBtn2() {
    	return continueBtn2;
    }
    
    public By getSkiptour() {
    	return Skiptour;
    }
    
    public By getRiskclosure() {
    	return Riskclosure;
    }
    
    public By getVerifylogin() {
    	return Verifylogin;
    }
    
    public By getCloseTOTP() {
    	return CloseTOTP;
    }
    
    public By getprofile() {
    	return profile;
    }
    
    public By getlogout() {
    	return logout;
    }
    
    public By getOkBtn() {
    	return OkBtn;
    }
    
    public By getswitchacc() {
    	return switchacc;
    }
    
    public By getcreateacc() {
    	return createacc;
    }
    
    public By gettryotherno() {
    	return tryotherno;
    }
    
    public class VerifytheLogin {
        public static String VerifyLogins = "Trading Terminals";
    }
    
    public By getriskdisclosuretitle() {
    	return riskdisclosuretitle;
    }
    
    public class VerifyLoginText {
        public static String text = "RISK DISCLOSURES ON DERIVATIVES";
    }
    
    //Search Stock
    public By getSelectTab() {
    	return SelectTab;
    }
    
    public By getSearchfield() {
    	return Searchfield;
    }
    
    public By getValidateNseName() {
    	return ValidateNseName;
    }
    
    public By getValidateNseExchange() {
    	return ValidateNseExchange;
    }
    
    public By getValidateBseName() {
    	return ValidateBseName;
    }
    
    public By getValidateBseExchange() {
    	return ValidateBseExchange;
    }
    
    public By getValidateNfoName() {
    	return ValidateNfoName;
    }
    
    public By getValidateNfoExchange() {
    	return ValidateNfoExchange;
    }
    
    public By getValidateBfoName() {
    	return ValidateBfoName;
    }
    
    public By getValidateBfoExchange() {
    	return ValidateBfoExchange;
    }
    
    public By getValidateMcxName() {
    	return ValidateMcxName;
    }
    
    public By getValidateMcxExchange() {
    	return ValidateMcxExchange;
    }
    
    public By getValidateIndicesName() {
    	return ValidateIndicesName;
    }
    
    public By getValidateIndicesExchange() {
    	return ValidateIndicesExchange;
    }
    
    public By getValidateSpotExchange() {
    	return ValidateSpotExchange;
    }
    
    public By getClickDashboard() {
    	return ClickDashboard;
    }
    
    //Charts
    public By getMarketScan() {
    	return MarketScan;
    }
    
    public By getEquity() {
    	return Equity;
    }
    
    public By getChartHover() {
    	return ChartHover;
    }
    
    public By getChartOpen() {
    	return ChartOpen;
    }
    
    public By getSwitchIframe() {
    	return SwitchIframe;
    }
    
    public By getSwitchInnerFrame() {
    	return SwitchInnerFrame;
    }
    
    public By getChartValidation() {
    	return ChartValidation	;
    }
    
    public By getHoverChartRevamp() {
    	return HoverChartRevamp;
    }
    
    public By getChartScroll() {
    	return ChartScroll;
    }
    
    public By getCloseChart() {
    	return CloseChart;
    }
    
    public By getNiftyDropdown() {
    	return NiftyDropdown;
    }
    
    public By getChangeBse() {
    	return ChangeBse;
    }
    
    public By getCloseNifty() {
    	return CloseNifty;
    }
    
    public By getOptions() {
    	return Options;
    }
    
    public By getNfoDropdown() {
    	return NfoDropdown;
    }
    
    public By getChangeOptionBfo() {
    	return ChangeOptionBfo;
    }
    
    public By getFutures() {
    	return Futures;
    }
    
    public By getBfoDropdown() {
    	return BfoDropdown;
    }
    
    public By getChangeFutureNfo() {
    	return ChangeFutureNfo;
    }
    
    public By getCommodity() {
    	return Commodity;
    }
    
    public By getMcxDropdown() {
    	return McxDropdown;
    }
    
    public By getChangeOptionMcx() {
    	return ChangeOptionMcx;
    }
    
}
