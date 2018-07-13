package com.globoforce.testautomation.mentoring.webdriver.test.scenarios;

import com.globoforce.testautomation.mentoring.webdriver.test.driver.WebDriverSingleton;
import com.globoforce.testautomation.mentoring.webdriver.test.listeners.TestListener;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;

    protected Logger logger = Logger.getLogger(getClass());

    @BeforeClass
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browser) {

        driver = WebDriverSingleton.getInstance(browser);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        driver = WebDriverSingleton.quit();
    }

}
