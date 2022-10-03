package Homework05Refactor;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestHomework05_02 extends BaseTest {
    @Test(dataProvider = "getData")
    public void test1(String url) throws InterruptedException{
        DemoQaPage page = new DemoQaPage(super.driver, url);
        page.goTo(url);
        page.testForms();
        page.testPracticeForms();
        page.testFillForm();
        page.testMaleGender();
        page.testDate();
        page.testHobby();
        page.testImage();
        //page.testDropdown(); //check cant find svg image.
        //page.testSubmitButton(); //check, same case as before.
    }

    @DataProvider(name = "getData")
    public Object[][] dpMethod() {
        return new Object[][]{{"https://demoqa.com/"}};
    }
}
