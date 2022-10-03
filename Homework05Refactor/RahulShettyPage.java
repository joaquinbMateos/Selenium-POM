package Homework05Refactor;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RahulShettyPage extends BasePage{
    //constructor:
    public RahulShettyPage(WebDriver driver) {
        super(driver);
    }
    //locators:
    By elements = By.xpath("//input[@class=\"radioButton\"]");
    By input_one = By.xpath("//input[@class=\"inputs ui-autocomplete-input\"]");
    By input_first_option = By.xpath("//ul[contains(@class,'ui-menu ui-widget ui-widget-content ui-autocomplete ui-front')]");
    ////div[contains(text(),'El Salvador')]
    By drop_down = By.xpath("//select[contains(@name,'dropdown-class-example')]");
    By header_buttons = By.xpath("//header//child::button[contains(@class,'btn')]");
    By open_tab_btn = By.xpath("//a[contains(@id,'opentab')]");

    //Js Executor:
    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

    //Test Scenarios:
    public void testRadioButtons(){
        Random rand = new Random();
        int randomButton = rand.nextInt(2);
        List<WebElement> radioBTS = driver.findElements(elements);
        radioBTS.get(randomButton).click();
    }
    public void testInputPlaceHolder(){
        System.out.println(find(input_one).getAttribute("placeholder"));
        //type(input_one, "El Sal");
        find(input_one).sendKeys("El Sal");
        find(input_one).sendKeys(Keys.ARROW_DOWN);
        find(input_one).sendKeys(Keys.ENTER);
        System.out.println(text(input_one));
    }

    public void testDropDown() {
        Select dropDown = new Select(find(drop_down));
        dropDown.selectByVisibleText("Option2");
        System.out.println(dropDown.getFirstSelectedOption().getText());

        WebElement drop_down_menu = find(drop_down);
        Actions mouse = new Actions(driver);
        mouse.moveToElement(drop_down_menu).click().perform();

        Select option3 = new Select(find(drop_down));
        option3.selectByValue("option3");
        System.out.println(option3.getFirstSelectedOption().getText());
    }

    public void assertHeaderButtons(){
        List<WebElement> elements = driver.findElements(header_buttons);
        for (int i = 0;i < elements.size();i++){
            System.out.println(elements.get(i).getText());
            System.out.println(elements.get(i).getTagName());
        }
    }

    public void testHeaderButtons() {
        String expectedUrl = "https://rahulshettyacademy.com/AutomationPractice/";
        List<WebElement> elements = driver.findElements(header_buttons);

        By btn1 = By.xpath("//button[contains(text(),'Home')]");
        By btn2 = By.xpath("//button[contains(text(),'Practice')]");
        By btn3 = By.xpath("//button[contains(text(),'Login')]");
        By btn4 = By.xpath("//button[contains(text(),'Signup')]");

        click(btn1);
        String actualUrl = getNewUrl();
        boolean assertUrl = actualUrl.equals(expectedUrl);
        if (!assertUrl){
            System.out.println("Incorrect URL");
            driver.navigate().back();
        }else{
            System.out.println("Correct URL");
        }

        click(btn2);
        String actualUrl2 = getNewUrl();
        boolean assertUrl2 = actualUrl2.equals(expectedUrl);
        if (!assertUrl2){
            System.out.println("Incorrect URL");
            driver.navigate().back();
        }else{
            System.out.println("Correct URL");
        }

        click(btn3);
        String actualUrl3 = getNewUrl();
        boolean assertUrl3 = actualUrl3.equals(expectedUrl);
        if (!assertUrl3){
            System.out.println("Incorrect URL");
            driver.navigate().back();
        }else{
            System.out.println("Correct URL");
        }

        click(btn4);
        String actualUrl4 = getNewUrl();
        boolean assertUrl4 = actualUrl4.equals(expectedUrl);
        if (!assertUrl4){
            System.out.println("Incorrect URL");
            driver.navigate().back();
        }else{
            System.out.println("Correct URL");
        }
        //Should be refactored. Tried to use an iterative structure using index from list of web elements
        //but clicking on buttons was not working properly.
    }
    public void testTabs(){
        for (int i = 0; i < 8; i++){
            String handle = driver.getWindowHandle();
            click(open_tab_btn);
            driver.switchTo().window(handle);
        }
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        System.out.println("Number of tabs: " + tabs.size());

    }
}
