package pages;

import base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class StartPage extends BasePage {
    private By btnStart = By.id("com.happyverse.bfftest:id/BUTTON5");

    public StartPage(AndroidDriver driver) {
        super(driver);
    }


    public void start() throws Exception {
        this._actionkeyword.click(btnStart);
    }


}
