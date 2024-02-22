package pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CrushFillInformationPage extends FillInformationPage {
    private By txtFriendName = By.id("com.happyverse.bfftest:id/FriendName");
    private By btnStart = By.id("com.happyverse.bfftest:id/BUTTON5");
    public CrushFillInformationPage(AndroidDriver driver) {
        super(driver);
    }

    public void fillInformation(String yourName, String friendName) throws Exception {
        this.fillYourName(yourName);
        this._actionkeyword.sendKey(txtFriendName, friendName);
        this._actionkeyword.click(btnStart);

    }

}
