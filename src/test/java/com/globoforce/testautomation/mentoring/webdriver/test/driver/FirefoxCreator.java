package com.globoforce.testautomation.mentoring.webdriver.test.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxCreator implements IDriverCreator {

    @Override
    public WebDriver startDriver() {
        System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\drivers\\geckodriver.exe");
        return new FirefoxDriver();
    }
}
