package helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utilities {
    public static String getValue(String propertiesFilePath, String propertyName) throws IOException {
        String result = "";
        Properties prop = new Properties();
        InputStream input = new FileInputStream(propertiesFilePath);
        try {
            if (input != null) {
                prop.load(input);
            } else {
                throw new FileNotFoundException("property file '" + propertiesFilePath + "' not found in the classpath");
            }

            result = prop.getProperty(propertyName);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            input.close();
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getValue("quiz_categories.properties","CrushTest"));
    }

}
