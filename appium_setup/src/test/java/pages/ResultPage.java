package pages;

import base.BasePage;
import io.appium.java_client.android.AndroidDriver;
import net.sourceforge.tess4j.ITessAPI;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ResultPage extends BasePage {
    private By icon = By.id("com.happyverse.bfftest:id/IMAGE_VIEW14");

    public ResultPage(AndroidDriver driver) {
        super(driver);
    }
    public boolean isDisplay(){
        if(this._actionkeyword.visible(icon)) return true;
        return false;
    }

//    public static File captureElementScreenshot(WebDriver driver, WebElement element, String outputDirectory, String fileName) {
//        // Chụp ảnh toàn bộ trang
//        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
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
//            int height = 140; // Set your desired height
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


    //    public static String extractNumberFromImage(String imagePath) {
//        ITesseract tess = new Tesseract();
//        tess.setDatapath("tessdata-4.1.0");
//
//
//        try {
//            File imageFile = new File(imagePath);
//            String result = tess.doOCR(imageFile);
//            // Trích xuất và lọc các ký tự số từ kết quả OCR
//            result = result.replaceAll("[^\\d]", "");
//            return result;
//        } catch (TesseractException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//    public static String extractNumberFromImage(String imagePath) {
//        try {
//            // Khởi tạo đối tượng Tesseract
//            Tesseract tesseract = new Tesseract();
//
//            // Đặt đường dẫn đến thư mục tessdata
//            tesseract.setDatapath("tessdata-4.1.0");
//
//            // Đặt chế độ xử lý hình ảnh tự động
//            tesseract.setPageSegMode(ITessAPI.TessPageSegMode.PSM_AUTO);
//
//            // Đặt độ phân giải hình ảnh (hãy kiểm tra độ phân giải thực tế của hình ảnh)
//            tesseract.setTessVariable("tessedit_image_dpi", "70"); // Thay 300 bằng độ phân giải thực tế của hình ảnh
//
//            // Đặt ngôn ngữ của văn bản trong hình ảnh
//            tesseract.setLanguage("eng");
//
//            // Thực hiện OCR trên tệp hình ảnh
//            String result = tesseract.doOCR(new File(imagePath));
//            System.out.println(result);
//            // Trích xuất số từ kết quả OCR
//            String number = result.replaceAll("[^\\d]", "");
//
//            return number;
//        } catch (TesseractException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }


//    public boolean isTrue(String percent) throws Exception {
//
//        File image = captureElementScreenshot(this._driver, _actionkeyword.findElement(icon), "src\\test\\java\\data\\image", "image" + generateRandomNumbers(3, 1, 1000));
//        String number = extractNumberFromImage(image.getAbsolutePath());
//
//        System.out.println(number);
//
//        if (number.trim().equals(percent.trim())) return true;
//        return false;
//    }


//    private String generateRandomNumbers(int count, int min, int max) {
//        Random random = new Random();
//        List<Integer> numbers = new ArrayList<>();
//        String res = "";
//        for (int i = 0; i < count; i++) {
//            int randomNumber = random.nextInt((max - min) + 1) + min;
//            numbers.add(randomNumber);
//        }
//        for (int i : numbers) {
//            res += i;
//        }
//        System.out.println(res);
//        return res;
//    }

    public static void main(String[] args) throws IOException {



    }

}
