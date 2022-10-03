package Homework05Refactor;

//import Homework05Refactor.drivers.DriverFactory;
import Homework05.test.BrowserType;
import Homework05Refactor.drivers.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import java.sql.Driver;

public abstract class BaseTest {
    /**
     * Driver Factory:
     * CHROME,FIREFOX,EDGE
     */
    protected WebDriver driver;

    @BeforeTest
    public void setUp(){
        this.driver = DriverFactory.getDriver(BrowserType.FIREFOX);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown(){
        //driver.close();
    }


}
