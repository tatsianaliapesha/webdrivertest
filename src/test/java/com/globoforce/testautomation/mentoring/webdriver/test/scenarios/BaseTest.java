package com.globoforce.testautomation.mentoring.webdriver.test.scenarios;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browser) {

        if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        if (browser.equals("ie")) {
            /*InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
            internetExplorerOptions.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            internetExplorerOptions.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
            internetExplorerOptions.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
            internetExplorerOptions.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);*/
            System.setProperty("webdriver.ie.driver", ".\\src\\test\\resources\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
           // driver = new InternetExplorerDriver(internetExplorerOptions);
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        if (driver != null)
            driver.quit();
    }

    public void waitUntilClickable(WebElement webElement) {
        new WebDriverWait(driver, 10)
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions
                        .elementToBeClickable(webElement));
    }
/*
    public WebElement getElementByXpath(String locator, String parameter) {
        By webElementLocator = By.xpath(String.format(locator, parameter));
        return driver.findElement(webElementLocator);
    }

    public WebElement getElementByXpath(String locator) {
        By webElementLocator = By.xpath(locator);
        return driver.findElement(webElementLocator);
    }*/
}
