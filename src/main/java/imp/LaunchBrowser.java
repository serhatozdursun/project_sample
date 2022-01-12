package imp;

import base.browser.BaseBrowser;
import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import driver.DriverManager;

public class LaunchBrowser {

    @Step("Open <url> with <geoLocation> with belowsetting <table>")
    public void openBrowser(String url, String geLocation, Table table) {
        System.setProperty("geLocation", geLocation);
        Gauge.writeMessage(geLocation);

        String browser = table.getTableRows().get(0).getCell("Browser");
        String browser_version = table.getTableRows().get(0).getCell("Version");
        System.out.println(browser_version);
        String os = table.getTableRows().get(0).getCell("OS");
        String os_version = table.getTableRows().get(0).getCell("OS Version");
        System.setProperty("browser", browser);
        System.getProperty("browser_version", browser_version);
        System.setProperty("os", os);
        System.setProperty("osVersion", os_version);
        System.setProperty("geoLocation", geLocation);
        System.out.println(url);

        BaseBrowser base = new BaseBrowser();
        base.setUp();
        DriverManager.getInstances().getDriver().get(url);
        System.out.println(DriverManager.getInstances().getDriver().getCurrentUrl());
    }
}
