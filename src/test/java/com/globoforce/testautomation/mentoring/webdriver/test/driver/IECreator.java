package com.globoforce.testautomation.mentoring.webdriver.test.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IECreator implements IDriverCreator {
    @Override
    public WebDriver startDriver() {
        System.setProperty("webdriver.ie.driver", ".\\src\\test\\resources\\drivers\\IEDriverServer.exe");
        return new InternetExplorerDriver();
    }
}
