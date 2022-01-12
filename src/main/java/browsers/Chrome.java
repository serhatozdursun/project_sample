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
        options = (ChromeOptions) stackCap.getBrowserStackCaps(options,CHROME);
        HashMap prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.addArguments("--kiosk");
        options.addArguments("--log-level=3");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-fullscreen");
        options.addArguments("--disable-logging");

        return options;
    }

    @Override
    public RemoteWebDriver getBrowser() {
        try {
            System.out.println(Browserstack.URL.getValue());
            URL url = new URL(Browserstack.URL.getValue());
            return new RemoteWebDriver(url, getCapabilities());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
