package Config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties props = new Properties();
    static {
        try (FileInputStream fis = new FileInputStream("Config.Properties")) {
            props.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String get(String key) {
        return props.getProperty(key);
    }

}
