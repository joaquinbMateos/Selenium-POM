package Homework05Refactor;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestHomework05_01 extends BaseTest{
    @Test(dataProvider = "getData")
    public void test1(String url){
        RahulShettyPage page = new RahulShettyPage(super.driver);
        page.goTo(url);
        page.testRadioButtons();
        page.testInputPlaceHolder(); //need to print.
        page.testDropDown();
        page.assertHeaderButtons();
        page.testHeaderButtons();  //works but needs refactor
        page.testTabs();
    }

    @DataProvider (name = "getData")
    public Object[][] dpMethod() {
        return new Object[][]{{"https://rahulshettyacademy.com/AutomationPractice/"}};
    }
}
