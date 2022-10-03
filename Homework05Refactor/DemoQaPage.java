package Homework05Refactor;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DemoQaPage extends BasePage{
    String homeUrl;
    public DemoQaPage(WebDriver driver, String url) {
        super(driver);
        this.homeUrl = url;
    }

    By forms = By.xpath("//*[contains(text(),'Forms')]");

    By practice_forms = By.xpath("//li[contains(@class,'btn btn-light')]//child::span[contains(text(),'Practice Form')]");
    ////*[name()='svg']//*[name()='g']//*[name()='path']
    By name = By.xpath("//input[contains(@id,'firstName')]");
    By lastName = By.xpath("//input[contains(@id,'lastName')]");
    By email = By.xpath("//input[contains(@id,'userEmail')]");
    By mobile = By.xpath("//input[contains(@id,'userNumber')]");
    By subject = By.xpath("//input[contains(@id,'subjectsInput')]");
    By adress = By.xpath("//textarea[contains(@id,'currentAddress')]");
    By male_gender = By.xpath("//input[contains(@id,'gender-radio-1')]");
    By birth_date = By.xpath("//input[contains(@id,'dateOfBirthInput')]");
    By month = By.xpath("//select[contains(@class,'react-datepicker__month-select')]");
    By year = By.xpath("//select[contains(@class,'react-datepicker__year-select')]");
    By day = By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[5]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/div[4]/div[6]"); //I know it's bad practice
    // day: //div[contains(@class,'react-datepicker__day react-datepicker__day--022 react-datepicker__day--selected')]
    By music_hobby = By.xpath("//label[contains(text(),'Music')]");
    By picture = By.xpath("//input[contains(@id,'uploadPicture')]");
    By select_state = By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[10]/div[2]/div[1]/div[1]/div[2]/div[1]/*[1]"); //Again: I know it's bad practice
    By sumbit_button = By.xpath("//button[contains(text(),'Submit')]");

    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

    public void testForms(){
        jsExecutor.executeScript("window.scrollBy(0,400)");
        click(forms);
        String expectedUrl = "demoqa.com/forms";
        String actualUrl = getNewUrl();
        boolean assertFormsUrl = actualUrl.equals(expectedUrl);
        if (!assertFormsUrl){
            System.out.println("Incorrect URL");
        }else{
            System.out.println("Correct URL");
        }
        //given url = demoqa.com/forms
        //actual url = https://demoqa.com/forms
    }

    public void testPracticeForms(){
        click(practice_forms);
        String expectedUrl = "demoqa.com/automation-practice-form";
        String actualUrl = getNewUrl();
        boolean assertFormsUrl = actualUrl.equals(expectedUrl);
        if (!assertFormsUrl){
            System.out.println("Incorrect URL");
        }else{
            System.out.println("Correct URL");
        }
        //given url = demoqa.com/automation-practice-form
        //actual url = https://demoqa.com/automation-practice-form
    }
    public void testFillForm(){
        /*
         * Fill the inputs for Name, Email, Mobile, Subjects and Current Address using the
         * correct method and assert that each input contains the correct text.
         */
        type(name, "joaquin");
        type(lastName, "mateos");
        type(email, "jmateos@applaudostudios.dev");
        type(mobile,"6543218847");
        find(subject).sendKeys("Computer Science");
        find(subject).sendKeys(Keys.ARROW_DOWN);
        find(subject).sendKeys(Keys.ENTER);
        type(adress, "very real adress");

        //asserts could be refactor into iterative structure using lists.
        boolean assertName = find(name).getAttribute("value").equals("joaquin");
        if (!assertName){
            System.out.println("Incorrect text in first name field");
        }

        boolean assertLastName = find(lastName).getAttribute("value").equals("mateos");
        if (!assertLastName){
            System.out.println("Incorrect text in last name field");
        }

        boolean assertEmail = find(email).getAttribute("value").equals("jmateos@applaudostudios.dev");
        if (!assertEmail){
            System.out.println("Incorrect text in email field");
        }

        boolean assertNumber = find(mobile).getAttribute("value").equals("6543218847");
        if (!assertNumber){
            System.out.println("Incorrect text in number field");
        }

        boolean assertSubject = find(subject).getAttribute("value").equals("Computer Science");
        if (!assertSubject){
            System.out.println("Incorrect text in subject field");
        }

        boolean assertAdress = find(adress).getAttribute("value").equals("very real adress");
        if (!assertAdress){
            System.out.println("Incorrect text in adress field");
        }
    }
    public void testMaleGender(){
        Actions action = new Actions(driver);
        WebElement radioButton = driver.findElement(male_gender);
        action.moveToElement(radioButton).click().build().perform();
    }

    public void testDate() {
        //Complete the Date of Birth using clicks and then assert the input has the correct date.
        jsExecutor.executeScript("window.scrollBy(0,400)");
        Actions action = new Actions(driver);
        action.moveToElement(find(birth_date)).click().build().perform();
        action.moveToElement(find(month)).click().build().perform();
        Select month_option = new Select(find(month));
        month_option.selectByValue("2");
        Select year_option = new Select(find(year));
        year_option.selectByValue("1991");
        action.moveToElement(find(day)).click().build().perform();

        boolean asserDate = find(birth_date).getAttribute("value").equals("22 Mar 1991");
        if (!asserDate){
            System.out.println("Incorrect text in date field");
        }else{
            System.out.println("Correct birth date");
        }
    }
    public void testHobby(){ //data should be parameterized;
        Actions action = new Actions(driver);
        action.moveToElement(find(music_hobby)).click().build().perform(); //checkbox is not clicked
        //find(music_hobby).sendKeys(Keys.ENTER);
    }
    public void testImage(){
        WebElement upload_file = driver.findElement(picture);
        upload_file.sendKeys("C:\\Users\\Joaco\\Desktop\\Joaco\\CV\\profile.png");
    }

    public void testDropdown(){
        //Complete the dropdown of State and City and validate the text displayed is correct.
        jsExecutor.executeScript("window.scrollBy(0,600)");
        click(select_state);
    }

    public void testSubmitButton(){
        click(sumbit_button);
    }

    public void removeAdd(){
        jsExecutor.executeScript("return document.getElementsByid('canvas')[0].remove();");
    }
}
