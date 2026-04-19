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
    private By LoginwithNo = By.xpath("//span[text()='Login with Mobile No']");
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
    
    //Orders Equity
    private By HoverEquitySymbol = By.xpath("//div[@class='search-row search-row-selected']");
    private By BuyIcon = By.cssSelector("button[data-cy='search-buy-icon']");
    private By CheckLimit = By.cssSelector("input[data-cy='orderpad-limit']");
    private By BuyButton = By.id("place-order");
    private By NseConfirmation = By.xpath("(//button[contains(text(),'Yes')])[2]");
    private By NseOrderToast = By.xpath("//*[contains(text(),'Submitted')]");
    private By OrdersTab = By.xpath("//*[contains(text(),'Orders')]");
    
    //Order Modification
    private By SearchField = By.xpath("(//input[@placeholder='Search'])[1]");
    private By HoverEquityOrder = By.xpath("(//div[@class='side-circle pointer buy-circle'])[1]");
    private By EquityThreeDots = By.cssSelector("button[data-cy='OPEN_ORDERS-more']");
    private By EquityModify = By.xpath("(//span[contains(text(),'Modify')])[1]");
    private By EquityModifyPrice = By.cssSelector("div[data-cy='orderpad-down-arrow-price']");
    private By EquityOrderModifyToast = By.xpath("//div[contains(text(),'Modification request submitted')]");
    
    //Order Cancellation
    private By OrderCheckBox = By.xpath("(//input[@class='PrivateSwitchBase-input css-1m9pwf3'])[2]");
    private By Cancelbutton = By.xpath("//*[contains(text(),'Cancel')]");
    private By CancelConfirmation = By.cssSelector("button[data-cy='orderbook-cancel']");
    private By CancelToast = By.xpath("//div[contains(text(),'Cancellation request submitted')]");
    
    //Create_Edit_Delete_Basket
    private By Dashboard = By.xpath("//*[contains(text(),'Dashboard')]");
    private By BasketTab = By.xpath("//*[contains(text(),'Baskets')]");
    private By AllCheckbox = By.xpath("//span[@class='MuiButtonBase-root MuiCheckbox-root MuiCheckbox-colorPrimary PrivateSwitchBase-root MuiCheckbox-root MuiCheckbox-colorPrimary MuiCheckbox-root MuiCheckbox-colorPrimary css-clw93t']");
    private By DeleteBasket = By.xpath("//*[contains(text(),'Delete')]");
    private By DeleteConfirmation = By.xpath("(//button[contains(text(),'Yes')])[2]");
    private By Createbasket = By.xpath("//*[contains(text(),'Add New Basket')]");
    private By BasketNameField = By.xpath("//input[@placeholder='Basket name']");
    private By CreateButton = By.xpath("//button[contains(text(),'Create')]");
    private By CreationMsg = By.xpath("//div[@class='MuiAlert-message css-1xsto0d']");
    private By OpenBasket = By.xpath("//span[normalize-space()='Automation']");
    private By EditIcon = By.xpath("//span[normalize-space()='Automation']/parent::div//button");
    private By EditField = By.xpath("//input[@placeholder='Basket name']");
    private By ModifyMessage = By.xpath("//*[contains(text(),'Basket name updated successfully.')]");
    private By CloseBasket = By.xpath("//span[@class='basket-btn-container']//button");
    private By DeleteMessage = By.xpath("//div[contains(text(),'Basket deleted successfully.')]");
    
  //Add_Delete_Reaarange_Invert symbol
    private By SearchSymbol = By.xpath("(//input[@placeholder='Search by Stock Name'])[2]");
    private By SelectNSEsymbol = By.xpath("(//div[@class='search-row search-row-selected'])[2]");
    private By ClickAdd = By.id("place-order");
    private By TringConfirmation = By.xpath("//div[@class='cancel-order-title cancel-sip-title']");
    private By HoverSymbol = By.xpath("(//div[@class='side-circle pointer buy-circle'])[1]");
    private By HoverSymbol2 = By.xpath("(//div[@class='side-circle pointer buy-circle'])[2]");
    private By DeleteSymbol = By.xpath("//button[contains(@class,'delete-icon')]");
    private By InvertSymbol = By.xpath("//span[@class='reverse-order']");
    private By HoverSymbol3 = By.xpath("//div[@class='side-circle pointer sell-circle']");
    
    //Symbol modification in basket
    private By EditIcon2 = By.xpath("(//button[contains(@class,'edit-icon')])[3]");
    private By GetPrice = By.xpath("//*[@data-cy='BASKET_SCRIPS-body']/tr[1]/td[7]");
    
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
    
    //Orders Equity
    
    public By getHoverEquitySymbol() {
    	return HoverEquitySymbol;
    }
    
    public By getBuyIcon() {
    	return BuyIcon;
    }
    
    public By getCheckLimit() {
    	return CheckLimit;
    }
    
    public By getBuyButton() {
    	return BuyButton;
    }
    
    public By getNseConfirmation() {
    	return NseConfirmation;
    }
    
    public By getNseOrderToast() {
    	return NseOrderToast;
    }
    
    public By getOrdersTab() {
    	return OrdersTab;
    }
    
    //Order Modification
    public By getSearchField() {
    	return SearchField;
    }
    
    public By getHoverEquityOrder() {
    	return HoverEquityOrder;
    }
    
    public By getEquityThreeDots() {
    	return EquityThreeDots;
    }
    
    public By getEquityModify() {
    	return EquityModify;
    }
    
    public By getEquityModifyPrice() {
    	return EquityModifyPrice;
    }
    
    public By getEquityOrderModifyToast() {
    	return EquityOrderModifyToast;
    }
    
    //Order Cancellation
    public By getOrderCheckBox() {
    	return OrderCheckBox;
    }
    
    public By getCancelbutton() {
    	return Cancelbutton;
    }
    
    public By getCancelConfirmation() {
    	return CancelConfirmation;
    }
    
    public By getCancelToast() {
    	return CancelToast;
    }
    
  //Create_Edit_Delete_Basket
    public By getDashboard() {
    	return Dashboard;
    }
    
    public By getBasketTab() {
    	return BasketTab;
    }
    
    public By getAllCheckbox() {
    	return AllCheckbox;
    }
    
    public By getDeleteBasket() {
    	return DeleteBasket;
    }
    
    public By getDeleteConfirmation() {
    	return DeleteConfirmation;
    }
    
    public By getCreatebasket() {
    	return Createbasket;
    }
    
    public By getBasketNameField() {
    	return BasketNameField;
    }
    
    public By getCreateButton() {
    	return CreateButton;
    }
    
    public By getCreationMsg() {
    	return CreationMsg;
    }
    
    public By getOpenBasket() {
    	return OpenBasket;
    }
    
    public By getEditIcon() {
    	return EditIcon;
    }
    
    public By getEditField() {
    	return EditField;
    }
    
    public By getModifyMessage() {
    	return ModifyMessage;
    }
    
    public By getCloseBasket() {
    	return CloseBasket;
    }
    
    public By getDeleteMessage() {
    	return DeleteMessage;
    }
    
  //Add_Delete_Reaarange_Invert symbol
    public By getSearchSymbol() {
    	return SearchSymbol;
    }
    
    public By getSelectNSEsymbol() {
    	return SelectNSEsymbol;
    }
    
    public By getClickAdd() {
    	return ClickAdd;
    }
    
    public By getTringConfirmation() {
    	return TringConfirmation;
    }
    
    public By getHoverSymbol() {
    	return HoverSymbol;
    }
    
    public By getHoverSymbol2() {
    	return HoverSymbol2;
    }
    
    public By getDeleteSymbol() {
    	return DeleteSymbol;
    }
    
    public By getInvertSymbol() {
    	return InvertSymbol;
    }
    
    public By getHoverSymbol3() {
    	return HoverSymbol3;
    }
    
  //Symbol modification in basket
    public By getEditIcon2() {
    	return EditIcon2;
    }
    
    public By getGetPrice() {
    	return GetPrice;
    }
}
