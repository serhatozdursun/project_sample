package browserstac.cap;

import enums.Browsers;
import org.openqa.selenium.remote.AbstractDriverOptions;


public class BrowserStackCap {


    public AbstractDriverOptions getBrowserStackCaps(AbstractDriverOptions options, Browsers browsers) {
        String  browser_version = System.getProperty("browser_version");
        if (System.getProperty("device") != null) {
            options.setCapability("browserName", browsers.getBrowser());
            options.setCapability("platform", System.getProperty("platform"));
            options.setCapability("device", System.getProperty("device"));
        } else {
            options.setCapability("browser", browsers.getBrowser());
            options.setCapability("browser_version", "45");

            options.setCapability("os", System.getProperty("os"));
            options.setCapability("os_version", System.getProperty("osVersion"));
        }
        options.setCapability("browserstack.geoLocation",System.getProperty("geoLocation"));
        return options;
    }
}
