package browsers;

import browserstac.cap.BrowserStackCap;
import enums.Browserstack;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import static enums.Browsers.CHROME;

public class Chrome implements BrowserSelectable {

    private ChromeDriverService chromeDriverService;

    @Override
    public MutableCapabilities getCapabilities() {
        ChromeOptions options = new ChromeOptions();
        BrowserStackCap stackCap = new BrowserStackCap();
        HashMap<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.addArguments("--kiosk");
        options.addArguments("--log-level=3");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-fullscreen");
        options.addArguments("--disable-logging");
        options.merge(stackCap.getBrowserStackCaps(options,CHROME));
        return options;
    }

    @Override
    public RemoteWebDriver getBrowser() {
        try {
            URL url = new URL(Browserstack.URL.getValue());
            return new RemoteWebDriver(url, getCapabilities());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
