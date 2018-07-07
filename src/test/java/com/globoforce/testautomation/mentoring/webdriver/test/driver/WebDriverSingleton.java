package com.globoforce.testautomation.mentoring.webdriver.test.driver;

import com.globoforce.testautomation.mentoring.webdriver.test.driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class WebDriverSingleton {

    private static WebDriver driver;

    private WebDriverSingleton() {
    }

    public static WebDriver getInstance(String browser) {
        if (driver == null)
            driver = WebDriverFactory.create(browser);

        return driver;
    }

    public static WebDriver quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

        return driver;
    }
}
