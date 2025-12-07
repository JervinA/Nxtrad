package Listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Reports.ExtentManager;

public class DriverListener implements WebDriverListener {

    private static final Logger log = LogManager.getLogger(DriverListener.class);

    // COMMON logger for Extent + Log4j
    private void logStep(String message) {
        ExtentTest test = ExtentManager.getTest();
        if (test != null) {
            test.log(Status.INFO, message);
        }
        log.info(message);  // Log4j
    }

    private String elementDescription(WebElement element) {
        try {
            String desc = element.toString();
            int index = desc.indexOf("->");
            return (index != -1) ? desc.substring(index) : desc;
        } catch (Exception e) {
            return "Unknown element";
        }
    }

    // CLICK
    @Override
    public void beforeClick(WebElement element) {
        logStep("Clicking on element: " + elementDescription(element));
    }

    // SEND KEYS
    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        logStep("Typing '" + String.join("", keysToSend) + "' into: " + elementDescription(element));
    }

    // GET TEXT
    @Override
    public void afterGetText(WebElement element, String result) {
        logStep("Captured text '" + result + "' from: " + elementDescription(element));
    }

    // CLEAR
    @Override
    public void beforeClear(WebElement element) {
        logStep("Clearing text from: " + elementDescription(element));
    }

    // SUBMIT
    @Override
    public void beforeSubmit(WebElement element) {
        logStep("Submitting: " + elementDescription(element));
    }

    // NAVIGATION
    @Override
    public void beforeGet(WebDriver driver, String url) {
        logStep("Navigating to URL: " + url);
    }

    public void beforeNavigateBack(WebDriver.Navigation navigation) {
        logStep("Navigating Back");
    }

    public void beforeNavigateForward(WebDriver.Navigation navigation) {
        logStep("Navigating Forward");
    }

    @Override
    public void beforeRefresh(WebDriver.Navigation navigation) {
        logStep("Refreshing page");
    }
}
