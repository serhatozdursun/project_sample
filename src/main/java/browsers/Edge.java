package browsers;

import browserstac.cap.BrowserStackCap;
import enums.Browserstack;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import static enums.Browsers.EDGE;

public class Edge implements BrowserSelectable {

    private EdgeDriverService EdgeDriverService;
    @Override
    public MutableCapabilities getCapabilities() {
        EdgeOptions options = new EdgeOptions();
        BrowserStackCap stackCap = new BrowserStackCap();
        options = (EdgeOptions) stackCap.getBrowserStackCaps(options,EDGE);
        return options;
    }

    @Override
    public RemoteWebDriver getBrowser()  {
        try {
            URL url = new URL(Browserstack.URL.getValue());
            return new RemoteWebDriver(url, getCapabilities());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

