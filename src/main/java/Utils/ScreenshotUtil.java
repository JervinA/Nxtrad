package Utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Driver.DriverFactory;

public class ScreenshotUtil {
	
	 public static String takeScreenshot(WebDriver driver, String name) {
	        try {
	            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	            String path = "ScreenShots/screenshots/" + name + "_" + System.currentTimeMillis() + ".png";
	            File dest = new File(path);
	            dest.getParentFile().mkdirs();
	            FileUtils.copyFile(src, dest);
	            return dest.getAbsolutePath();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }




}
