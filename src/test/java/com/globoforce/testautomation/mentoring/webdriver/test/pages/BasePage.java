package com.globoforce.testautomation.mentoring.webdriver.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class BasePage {

    protected final WebDriver webdriver;

    protected final int PAGE_LOAD_TIMEOUT = 300;
    protected final int IMPLICITLY_WAIT_TIMEOUT = 300;

    public BasePage(WebDriver driver) {
        webdriver = driver;
        webdriver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        webdriver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_TIMEOUT, TimeUnit.SECONDS);
        //PageFactory.initElements(webdriver, this);
        HtmlElementLoader.populatePageObject(this, this.webdriver);
    }


    public WebDriver getWebDriver() {
        return webdriver;
    }

    public boolean isElementPresent(By by) {
        int i = webdriver.findElements(by).size();
        return i != 0;
    }

    public boolean isElementPresent(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException nsee) {
            return false;
        }
    }

    public void navigateToUrl(String url) {
        webdriver.navigate().to(url);
    }
}
