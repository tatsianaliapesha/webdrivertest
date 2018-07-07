package com.globoforce.testautomation.mentoring.webdriver.test.driver;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    public static WebDriver create(String browser) {

        IDriverCreator driverCreator;
        if (browser.equals("firefox")) {
            driverCreator = new FirefoxCreator();
        } else if (browser.equals("chrome")) {
            driverCreator = new ChromeCreator();
        } else {
            driverCreator = new IECreator();
        }

        return driverCreator.startDriver();
    }
}
