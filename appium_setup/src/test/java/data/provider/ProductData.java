package data.provider;

import helper.ExcelHelper;
import helper.JSONHelper;
import org.testng.annotations.DataProvider;

public class ProductData {


    @DataProvider(name = "productDataFromExcel")
    public Object[][] dataFromExcel(){
        return ExcelHelper.readJsonFromExcel("src\\test\\java\\data\\driver\\data.xlsx");
    }
    @DataProvider(name = "dataFromJSONForm")
    public Object[][] dataFromJSONForm(){
        return JSONHelper.readJsonFromFile("src\\test\\java\\data\\driver\\data.json");
    }
}
