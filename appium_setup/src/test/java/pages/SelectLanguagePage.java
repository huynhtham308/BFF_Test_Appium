package pages;

import base.BasePage;
import io.appium.java_client.android.AndroidDriver;

public class SelectLanguagePage extends BasePage {


    public SelectLanguagePage(AndroidDriver driver) {
        super(driver);
    }

    public void selectLanguage(String language) throws Exception {
        this._actionkeyword.click(this._actionkeyword.findXPathByName(language));

    }
}
