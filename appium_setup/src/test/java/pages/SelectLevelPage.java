package pages;

import base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
public class SelectLevelPage extends BasePage {
    private By btnLevel1= By.id("com.happyverse.bfftest:id/IMAGE_VIEW32");
    private By btnLevel2= By.id("com.happyverse.bfftest:id/IMAGE_VIEW34");
    private By btnLevel3= By.id("com.happyverse.bfftest:id/IMAGE_VIEW35");
    private By btnLevel4= By.id("com.happyverse.bfftest:id/IMAGE_VIEW71");

    public SelectLevelPage(AndroidDriver driver) {
        super(driver);
    }
    public void clickLevel(String level) throws Exception {
        switch (level){
            case "Level 1":
                this._actionkeyword.click(btnLevel1);
                break;
            case "Level 2":
                this._actionkeyword.click(btnLevel2);
                break;
            case "Level 3":
                this._actionkeyword.click(btnLevel3);
                break;
            case "Level 4":
                this._actionkeyword.click(btnLevel4);
                break;
            default:
        }
    }

}
