package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.log4j.Logger;
import org.apache.log4j.FileAppender;
import org.apache.log4j.PatternLayout;

import Config.ConfigReader;
import Driver.DriverFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {

    protected WebDriver driver;
    protected Logger log;

    @Parameters({"browser"})
    @BeforeClass(alwaysRun = true)
    public void setUp(String browser) {

        // Initialize Logger with dynamic timestamped log file
        initLogger();

        log.info("===== Starting Test: " + this.getClass().getSimpleName() + " =====");

        // Initialize WebDriver via DriverFactory
        DriverFactory.initDriver(browser);
        driver = DriverFactory.getDriver();
        log.info(browser + " driver initialized.");

        // Navigate to URL
        String baseUrl = ConfigReader.get("baseUrl");
        driver.get(baseUrl);
        log.info("Navigated to URL: " + baseUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void afterEachTest() {
        pause(2000);
        // Optional: Add screenshot capture on failure here
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        log.info("===== Ending Test: " + this.getClass().getSimpleName() + " =====");
        pause(1000);
        DriverFactory.quitDriver();
        log.info("Driver closed successfully.");
    }

    /**
     * Helper method to pause execution
     * @param ms milliseconds
     */
    public void pause(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            log.error("Thread interrupted while pausing.", e);
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Initialize Log4j with a timestamped log file for each test run
     */
    private void initLogger() {
        try {
            log = Logger.getLogger(this.getClass());

            // Create timestamp
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            // Log file path (make sure 'logs' folder exists in project root)
            String logFile = "logs/testlog_" + timestamp + ".log";

            // Configure file appender
            FileAppender fileAppender = new FileAppender(
                    new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n"),
                    logFile,
                    false // false = overwrite each time
            );

            log.addAppender(fileAppender);

            // Optional: also log to console
            FileAppender consoleAppender = new FileAppender(
                    new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n"),
                    "CONSOLE",
                    true
            );
            log.addAppender(consoleAppender);

            log.info("Logger initialized. Logs will be saved in: " + logFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
