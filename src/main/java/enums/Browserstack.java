package enums;

import java.net.MalformedURLException;
import java.net.URL;

public enum Browserstack {

    USERNAME("browserstacktest_08OMFi"),
    AUTOMATE_KEY("TVCMaxakNiqqzTnFpx54"),
    URL("https://" + USERNAME.value + ":" + AUTOMATE_KEY.value + "@hub-cloud.browserstack.com/wd/hub");

    private String value;

    Browserstack(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }



}
