package base.browser;

import com.thoughtworks.gauge.AfterScenario;
import driver.DriverManager;
import utils.StoreApiInfo;

public class BaseBrowser {
    public void setUp() {
        DriverManager.getInstances().createLocalDriver();
    }

    @AfterScenario
    public void tearDown() {
        DriverManager.getInstances().quitDriver();
        StoreApiInfo.remove();
    }
}
