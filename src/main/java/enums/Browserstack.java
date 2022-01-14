package enums;

import java.net.MalformedURLException;
import java.net.URL;

public enum Browserstack {

    USERNAME("USERNAME"),
    AUTOMATE_KEY("AUTOMATE_KEY"),
    URL("https://" + USERNAME.value + ":" + AUTOMATE_KEY.value + "@hub-cloud.browserstack.com/wd/hub");

    private String value;

    Browserstack(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }



}
