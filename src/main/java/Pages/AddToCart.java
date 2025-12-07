package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCart {
	
	private WebDriver driver;
	
	private By AddtoCart = By.xpath("//b[contains(text(),'ZARA COAT 3')]/ancestor::div[contains(@class,'card-body')]//button[contains(text(),'Add To Cart')]");
	
	
	 // Constructor
    public AddToCart(WebDriver driver) {
        this.driver = driver;
    }
    
 // Actions
    public void cart() {
        driver.findElement(AddtoCart).click();
    }

}
