package driver;

import browsers.*;
import enums.Browsers;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.StoreApiInfo;

import java.util.Locale;

public class DriverManager {

    private static DriverManager instances = null;
    private BrowserSelectable browserSelectable;

    private Browsers browsersType;

    private DriverManager() {

    }

    public static DriverManager getInstances() {
        if (instances == null) {
            instances = new DriverManager();
        }
        return instances;
    }

    public void createLocalDriver() {
        String browserName = System.getProperty("browser");
        Browsers browserType = Browsers.valueOf(browserName.toUpperCase(Locale.ROOT));
        setBrowsersType(browserType);
        switch (browserType) {
            case EDGE:
                browserSelectable = new Edge();
                setDriver(browserSelectable.getBrowser());
                break;
            case FIREFOX:
                browserSelectable = new Firefox();
                setDriver(browserSelectable.getBrowser());
                getDriver().manage().window().maximize();
                break;
            case CHROME:
                browserSelectable = new Chrome();
                setDriver(browserSelectable.getBrowser());
                break;
            default:
                throw new IllegalArgumentException(String.format("%s undefined type of browser", browserType));
        }
    }

    public void setDriver(RemoteWebDriver driver) {
        StoreApiInfo.put("driver", driver);
    }

    public RemoteWebDriver getDriver() {
        return ((RemoteWebDriver) StoreApiInfo.get("driver"));
    }

    public void setBrowsersType(Browsers browsers) {
        this.browsersType = browsers;
    }

    public void quitDriver() {
        try {
            if (getDriver() != null) {
                getDriver().close();
                getDriver().quit();
            }
        } catch (NoSuchSessionException e) {
        }
    }
}
