package pages;

import base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.List;

public class QuestionPage extends BasePage {
//    By btnoption = By.id(String.format("com.happyverse.bfftest:id/OPTIONS",));

    public QuestionPage(AndroidDriver driver) {
        super(driver);
    }

    public By findXPathByIndex(String index) {
        return By.id(String.format("com.happyverse.bfftest:id/OPTIONS%s", index));
    }

    public void choseOptions(List<Integer> listIndexAnswer) throws Exception {
        for (int i : listIndexAnswer) {
            switch (i) {
                case 0:
                    By answer=findXPathByIndex("");
                    this._actionkeyword.click(answer);
                    break;
                case 1:
                    this._actionkeyword.click(findXPathByIndex("2"));

                    break;
                case 2:
                    this._actionkeyword.click(findXPathByIndex("3"));
                    break;
            }
        }

    }
}
