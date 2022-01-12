package browsers;

import browserstac.cap.BrowserStackCap;
import enums.Browserstack;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import static enums.Browsers.FIREFOX;

public class Firefox implements BrowserSelectable {

    @Override
    public MutableCapabilities getCapabilities() {
        FirefoxOptions options = new FirefoxOptions();
        BrowserStackCap stackCap = new BrowserStackCap();
        options = (FirefoxOptions) stackCap.getBrowserStackCaps(options,FIREFOX);
        HashMap prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);

        options.addArguments("--kiosk");
        options.addArguments("--disable-notifications");
        options.addArguments("--start-fullscreen");
        return options;
    }
//burda neden buildli startli kullandik ??? porttan calistirmak istedigimiz icin mi
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
