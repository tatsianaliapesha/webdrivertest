package com.globoforce.testautomation.mentoring.webdriver.test.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeCreator implements IDriverCreator {

    @Override
    public WebDriver startDriver() {
        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\drivers\\chromedriver.exe");
        return new ChromeDriver();
    }
}
