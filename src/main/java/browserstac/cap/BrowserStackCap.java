package browserstac.cap;

import enums.Browsers;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.firefox.FirefoxOptions;


public class BrowserStackCap {


    public MutableCapabilities getBrowserStackCaps(MutableCapabilities options, Browsers browsers) {
        if (System.getProperty("device") != null) {
            options.setCapability("browserName", browsers.getBrowser());
            options.setCapability("platform", System.getProperty("platform"));
            options.setCapability("device", System.getProperty("device"));
        } else {
            options.setCapability("browser", browsers.getBrowser());
            options.setCapability("browser_version", System.getProperty("browser_version"));

            options.setCapability("os", System.getProperty("os"));
            options.setCapability("os_version", System.getProperty("osVersion"));
        }
        options.setCapability("browserstack.local", "false");
        options.setCapability("browserstack.selenium_version","3.141.59");
        options.setCapability("browserstack.geoLocation",System.getProperty("geoLocation"));
        options.setCapability(" browserstack.networkLogs",true);
        options.setCapability("browserstack.networkLogs",true);
        return options;
    }
}
