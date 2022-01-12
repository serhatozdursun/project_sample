package enums;

public enum Browsers {
    CHROME("Chrome"),
    FIREFOX("firefox"),
    OPERA("opera"),
    SAFARI("safari"),
    EDGE("edge");
    private final String browser;

    Browsers(String browser) {
        this.browser = browser;
    }

    public String getBrowser() {
        return this.browser;
    }
}

