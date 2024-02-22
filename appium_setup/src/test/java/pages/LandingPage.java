package pages;

import base.BasePage;
import helper.Utilities;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class LandingPage extends BasePage {
private By typeQuizlist= By.id("com.happyverse.bfftest:id/IMAGE_VIEW13");
    public LandingPage(AndroidDriver driver) {
        super(driver);
    }
    public void clickTypeQuiz(String typeQuiz) throws Exception {
        String propertyName = typeQuiz.replace(" ", "");
        String index = Utilities.getValue("quiz_categories.properties", propertyName);
        this._actionkeyword.scrollToElement(typeQuiz);
        WebElement element= this._actionkeyword.findElements(typeQuizlist).get(Integer.parseInt(index));
        element.click();
    }
}
