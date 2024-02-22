package pages;

import base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class FillInformationPage extends BasePage {
    protected By btnStart = By.id("com.happyverse.bfftest:id/BUTTON5");
    protected By txtYourName = By.id("com.happyverse.bfftest:id/YourName");

    public FillInformationPage(AndroidDriver driver) {
        super(driver);
    }

    public void fillYourName(String yourName) {
        this._actionkeyword.sendKey(txtYourName, yourName);
    }

    public QuestionPage start() throws Exception {
        this._actionkeyword.click(btnStart);
        return new QuestionPage(this._driver);
    }

}
