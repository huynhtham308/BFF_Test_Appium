package keyword;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.element.Element;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WebActionKeywords {
    AndroidDriver _driver;
    Wait _wait;

    public WebActionKeywords(AndroidDriver driver) {
        this._driver = driver;
        this._wait = new WebDriverWait(this._driver, Duration.ofSeconds(70));
    }
    public void openUrl(String url) throws Exception {
        if (url.startsWith("http:") || (url.startsWith("https:"))) {
            this._driver.get(url);
        } else {
            throw new Exception("url invalid");
        }
    }
    public void openLink(By locator) throws Exception {
        click(locator);
        String mainWindowHandle = this._driver.getWindowHandle();//return id unique
        Set<String> allWindowHandles = this._driver.getWindowHandles();//return set id unique
        for (String window : allWindowHandles) {
            if (!mainWindowHandle.equalsIgnoreCase(window)) {

                this._driver.switchTo().window(window);
            }
        }
    }

    public WebElement findElement(By locator) throws Exception {
        try {

            return (WebElement) this._wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    public List<WebElement> findElements(By locator) throws Exception {
        try {

            return (List<WebElement>) this._wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    // sendkeys, click, select, openUrl
    public void sendKey(By locator, String key) {
        try {
            WebElement element = this._driver.findElement(locator);

            element.clear();
            element.sendKeys(key);
        } catch (WebDriverException e) {

            e.printStackTrace();
        }
    }
    public boolean visible( By locator) {
        WebElement e = (WebElement) this._wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        if (e.isDisplayed()) return true;
        return false;
    }
    public  WebElement click(By locator) throws Exception {
        WebElement element=findElement(locator);
        Actions actions = new Actions(this._driver);
        actions.moveToElement(element).build().perform();
        element.click();
        return element;
    }
    public void scrollToElement(String text) {
        this._driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + text +"?"+ "\").instance(0));"));
    }
    public By findXPathByName(String name) {
        return By.xpath(String.format("//*[@text='%s']", name));
    }

}
