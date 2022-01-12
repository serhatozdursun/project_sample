package enums;

public enum Browsers {
    CHROME("Chrome"),
    FIREFOX("Firefox"),
    OPERA("Opera"),
    SAFARI("Safari"),
    EDGE("Edge");
    private final String browser;

    Browsers(String browser) {
        this.browser = browser;
    }

    public String getBrowser() {
        return this.browser;
    }
}

