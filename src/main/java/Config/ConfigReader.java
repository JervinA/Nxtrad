package Config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties props = new Properties();

    static {
        try {
            // Read from current project location
            String projectPath = System.getProperty("user.dir");
            FileInputStream fis =
                    new FileInputStream(projectPath + "/Config.Properties");
            props.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Existing method
    public static String get(String key) {
        return props.getProperty(key);
    }

    // ✅ Add implementation here
    public static String getProperty(String key) {
        return get(key);   // delegate to get()
    }
}
