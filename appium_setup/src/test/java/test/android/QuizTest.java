//package test.android;
//
//import data.provider.ProductData;
//import io.appium.java_client.android.AndroidDriver;
//import net.sourceforge.tess4j.ITesseract;
//import net.sourceforge.tess4j.Tesseract;
//import net.sourceforge.tess4j.TesseractException;
//import org.openqa.selenium.*;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//import java.net.URL;
//import java.nio.file.Paths;
//import java.time.Duration;
//
//public class QuizTest extends TestBase{
//    private AndroidDriver _driver;
//    private WebDriverWait _wait;
//
//
//    private By btnStart = By.id("com.happyverse.bfftest:id/BUTTON5");
//    private By btnVietnamese = By.xpath("//*[@text = 'Vietnamese']");
//    private By btnCheck = By.xpath("//*[@text = 'Kiểm tra sự nghiền nát']");
//    private By txtFriendName = By.id("FriendName");
//    //.//*[[@id=  'YourName']
//    private By txtYourName = By.id("YourName");
//    private By btnStartLevel = By.xpath("//*[@text = 'Khởi đầu']");
//
//    public static String extractNumberFromImage(String imagePath) {
//        ITesseract tess = new Tesseract();
//        tess.setDatapath("tessdata-4.1.0");
//        try {
//            File imageFile = new File(imagePath);
//            String result = tess.doOCR(imageFile);
//            // Trích xuất và lọc các ký tự số từ kết quả OCR
//            result = result.replaceAll("[^\\d]", "");
//
//            return result;
//        } catch (TesseractException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    public boolean checkFriend(String yourName, String friendName, String level, String answer1, String answer2, String answer3, String answer4, String answer5, String answer6, String answer7, String answer8, String answer9, String answer10,String result
//    ) throws Exception {
//
//        findElement(btnStart).click();
//        findElement(btnVietnamese).click();
//        findElement(btnCheck).click();
//        //click level 1
//        findElement(findXPathByName(level)).click();
//        findElement(txtYourName).sendKeys(yourName);
//        findElement(txtFriendName).sendKeys(friendName);
//        findElement(btnStartLevel).click();
//        findElement(findXPathByName(answer1)).click();
//        findElement(findXPathByName(answer2)).click();
//        findElement(findXPathByName(answer3)).click();
//        findElement(findXPathByName(answer4)).click();
//        findElement(findXPathByName(answer5)).click();
//        findElement(findXPathByName(answer6)).click();
//        findElement(findXPathByName(answer7)).click();
//        findElement(findXPathByName(answer8)).click();
//        findElement(findXPathByName(answer9)).click();
//        findElement(findXPathByName(friendName + " " + answer10)).click();
//        WebElement icon = findElement(By.id("IMAGE_VIEW14"));
//        File image = captureElementScreenshot(this._driver, icon, "src\\test\\java\\data\\image", "image");
//        String number=extractNumberFromImage(image.getAbsolutePath());
//        if (number.trim().equals(result.trim())) return true;
//        return false;
//
//
//    }
//
//    public static File captureElementScreenshot(WebDriver driver, WebElement element, String outputDirectory, String fileName) {
//        // Chụp ảnh toàn bộ trang
//        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//        // Lấy kích thước của phần tử
////        int width = element.getSize().getWidth();
////        int height = element.getSize().getHeight();
//
//        try {
//            // Đọc ảnh từ file
//            BufferedImage fullImg = ImageIO.read(screenshot);
//
//
//            // Calculate the center coordinates and dimensions
//            int centerX = element.getLocation().getX() + element.getSize().getWidth() / 2;
//            int centerY = element.getLocation().getY() + element.getSize().getHeight() / 2;
//            int width = 150; // Set your desired width
//            int height = 120; // Set your desired height
//
//            // Calculate the top-left coordinates of the subimage
//            int startX = centerX - width / 2;
//            int startY = centerY - height / 2;
//
//            // Ensure the subimage coordinates are within bounds
//            startX = Math.max(startX, 0);
//            startY = Math.max(startY, 0);
//
//            // Ensure the subimage dimensions are within bounds
//            width = Math.min(width, fullImg.getWidth() - startX);
//            height = Math.min(height, fullImg.getHeight() - startY);
//
//            // Tạo ảnh mới để giữ lại chỉ phần bạn quan tâm
////            BufferedImage elementScreenshot = fullImg.getSubimage(element.getLocation().getX(), element.getLocation().getY(), 230, 190);
//            BufferedImage elementScreenshot = fullImg.getSubimage(startX, startY, width, height);
//
//            // Tạo đường dẫn đầy đủ cho file ảnh
//            String fullPath = Paths.get(outputDirectory, fileName + ".png").toString();
//
//            // Ghi ảnh mới ra file
//            ImageIO.write(elementScreenshot, "png", new File(fullPath));
//
//            // Trả về đối tượng File mới tạo
//            return new File(fullPath);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//
//    public WebElement findElement(By locator) throws Exception {
//        try {
//            return this._wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new Exception(e.getMessage());
//        }
//    }
//
//    public By findXPathByName(String name) {
//        return By.xpath(String.format("//*[@text='%s']", name));
//    }
//
//    @Test(dataProvider = "productDataFromExcel", dataProviderClass = ProductData.class)
//    public void test(String yourName, String friendName, String level, String answer1, String answer2, String answer3, String answer4, String answer5, String answer6, String answer7, String answer8, String answer9, String answer10,String result) throws Exception {
//        Assert.assertTrue(checkFriend(yourName, friendName, level, answer1, answer2, answer3, answer4, answer5, answer6, answer7, answer8, answer9, answer10,result));
//    }
//}
