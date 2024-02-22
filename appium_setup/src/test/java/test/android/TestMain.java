package test.android;

import data.provider.ProductData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import base.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestMain extends TestBase {
//    @Test(dataProvider = "dataFromJSONForm", dataProviderClass = ProductData.class)
//    public void quizTest(String yourName,String friendName,Object[] answers,String result) throws Exception {
//        List<Integer> listIndexAnswer = Arrays.stream(answers)
//                .map(object -> (Integer) object)
//                .collect(Collectors.toList());
//
//        StartPage startPage = new StartPage(this._driver);
//        startPage.start();
//        SelectLanguagePage selectLanguagePage = new SelectLanguagePage(this._driver);
//        selectLanguagePage.selectLanguage("Vietnamese");
//        LandingPage landingPage = new LandingPage(this._driver);
//        landingPage.clickTypeQuiz("Crush Test");//CrushTest
//        SelectLevelPage selectLevelPage = new SelectLevelPage(this._driver);
//        selectLevelPage.clickLevel("Level 1");
//        CrushFillInformationPage crushFillInformationPage = new CrushFillInformationPage(this._driver);
//        crushFillInformationPage.fillInformation(yourName, friendName);
//        QuestionPage questionPage = new QuestionPage(this._driver);
//        questionPage.choseOptions(listIndexAnswer);
//        ResultPage resultPage = new ResultPage(this._driver);
//        Assert.assertTrue(resultPage.isDisplay());
//    }
        @Test(dataProvider = "dataFromJSONForm", dataProviderClass = ProductData.class)
    public void fillMean(String yourName,String friendName,Object[] answers,String result) throws Exception {
            List<Integer> listIndexAnswer = Arrays.stream(answers)
                .map(object -> (Integer) object)
                .collect(Collectors.toList());

        StartPage startPage = new StartPage(this._driver);
        startPage.start();
        SelectLanguagePage selectLanguagePage = new SelectLanguagePage(this._driver);
        selectLanguagePage.selectLanguage("English");
        LandingPage landingPage = new LandingPage(this._driver);
        landingPage.clickTypeQuiz("Are you mean");
        MeanFillInformationPage meanFillInformationPage=new MeanFillInformationPage(this._driver);
        meanFillInformationPage.fillYourName("Tham");
            QuestionPage questionPage = meanFillInformationPage.start();
        questionPage.choseOptions(listIndexAnswer);
        ResultPage resultPage = new ResultPage(this._driver);
        Assert.assertTrue(resultPage.isDisplay());

        }

}
