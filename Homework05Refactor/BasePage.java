package Homework05Refactor;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {
    protected WebDriver driver;
    //constructor:
    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    protected void goTo(String url){
        driver.get(url);
    }
    protected WebElement find (By locator){
        return driver.findElement(locator);
    }

    protected String getNewUrl(){
        return driver.getCurrentUrl();
    }
    protected void type (By locator, String text){
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected void click (By locator){
        find(locator).click();
    }

    protected String text(By locator){
        return driver.findElement(locator).getText();
    }

    protected void getAttribute(By locator, String attributeName){
        driver.findElement(locator).getAttribute(attributeName);
    }

    protected Boolean isDisplayed(By locator){
        try{
            return find(locator).isDisplayed();
        }
        catch (NoSuchElementException exc){
            return false;
        }
    }


}
