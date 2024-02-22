package base;

import io.appium.java_client.android.AndroidDriver;
import keyword.WebActionKeywords;

public class BasePage {
    protected AndroidDriver _driver;
    protected WebActionKeywords _actionkeyword;

    public BasePage(AndroidDriver driver) {
        this._driver = driver;
        this._actionkeyword=new WebActionKeywords(this._driver);
    }
    public void navigate(String url) throws Exception {
        this._actionkeyword.openUrl(url);
    }
}
