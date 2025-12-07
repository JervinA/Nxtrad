package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.support.events.EventFiringDecorator;

import io.github.bonigarcia.wdm.WebDriverManager;
import Listeners.DriverListener;

public class DriverFactory {

    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return tlDriver.get();
    }

    public static void initDriver(String browser) {

        if (browser == null) browser = "chrome";

        WebDriver rawDriver;

        switch (browser.toLowerCase()) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                rawDriver = new ChromeDriver(options);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                rawDriver = new FirefoxDriver();
                rawDriver.manage().window().maximize();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                rawDriver = new EdgeDriver();
                rawDriver.manage().window().maximize();
                break;

            default:
                throw new RuntimeException("Browser not supported: " + browser);
        }

        // attach listener using decorator
        EventFiringDecorator<WebDriver> decorator = new EventFiringDecorator<>(new DriverListener());
        WebDriver decoratedDriver = decorator.decorate(rawDriver);

        tlDriver.set(decoratedDriver);

        getDriver().manage().deleteAllCookies();
    }

    public static void quitDriver() {
        if (getDriver() != null) {
            getDriver().quit();
            tlDriver.remove();
        }
    }
}
