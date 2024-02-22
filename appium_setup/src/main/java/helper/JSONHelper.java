package helper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class JSONHelper {

    public static Object[][] readJsonFromFile(String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(filePath));

            int height = rootNode.size();
            int width = determineWidth(rootNode);
            Object[][] dataProvider = new Object[height][width];

            for (int i = 0; i < height; i++) {
                JsonNode obj = rootNode.get(i);
                Iterator<String> fieldNames = obj.fieldNames();
                List<Object> rowData = new LinkedList<>();

                while (fieldNames.hasNext()) {
                    String key = fieldNames.next();
                    Object dataFromKey = convertJsonNodeToObject(obj.get(key));
                    rowData.add(dataFromKey);
                }

                dataProvider[i] = rowData.toArray();
            }
            return dataProvider;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Object[0][0];
    }

    private static int determineWidth(JsonNode rootNode) {
        int maxWidth = 0;

        for (JsonNode obj : rootNode) {
            int currentWidth = obj.size();
            if (currentWidth > maxWidth) {
                maxWidth = currentWidth;
            }
        }

        return maxWidth;
    }

    private static Object convertJsonNodeToObject(JsonNode jsonNode) {
        if (jsonNode.isTextual()) {
            return jsonNode.asText();
        } else if (jsonNode.isNumber()) {
            return jsonNode.numberValue();
        } else if (jsonNode.isBoolean()) {
            return jsonNode.asBoolean();
        } else if (jsonNode.isArray()) {
            List<Object> arrayData = new ArrayList<>();
            for (JsonNode element : jsonNode) {
                arrayData.add(convertJsonNodeToObject(element));
            }
            return arrayData.toArray();
        } else {
            // Handle other data types as needed
            return null;
        }
    }

    public static void main(String[] args) {
        String filePath ="src\\test\\java\\data\\driver\\data.json";
        Object[][] result = readJsonFromFile(new File(filePath).getAbsolutePath());

        // Loop through the array and print the values
        for (Object[] row : result) {
            for (Object value : row) {
                if (value instanceof Object[]) {
                    // If the value is an array, print its elements
                    System.out.print("[");
                    for (Object element : (Object[]) value) {
                        System.out.print(element + ", ");
                    }
                    System.out.print("]");
                } else {
                    // If the value is not an array, print it directly
                    System.out.print(value);
                }
                System.out.print("\t");
            }
            System.out.println(); // Move to the next line after printing each row
        }
    }

}