package utils;



import java.io.InputStream;
import java.util.Properties;


public class Configuration {

    private static Configuration instance;
    Properties configProps;
    Properties systemProp;
    static final String PROP_FILE_NAME = "config.properties";

    public static Configuration getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }

    private static synchronized void createInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
    }

    private Configuration() {
        systemProp = System.getProperties();
        try (InputStream is = ClassLoader.getSystemResourceAsStream(PROP_FILE_NAME)) {
            configProps = new Properties();
            configProps.load(is);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Properties read finished.");
        }
    }

    public String getStringValueOfProp(String propKey) {
        String value = systemProp.getProperty(propKey);
        return value == null ? systemProp.getProperty(propKey) : value;
    }

    public Integer getIntegerValueOfProp(String propKey) {
        String value = systemProp.getProperty(propKey);
        value = value == null ? systemProp.getProperty(propKey) : value;
        return value != null ? Integer.parseInt(value) : null;
    }
}