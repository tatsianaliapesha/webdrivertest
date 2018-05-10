package com.globoforce.testautomation.mentoring.webdriver.test.scenarios;

import com.globoforce.testautomation.mentoring.webdriver.test.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class EditCheckinPreparation extends BaseTest {

    protected String checkinTitleInit;
    protected String checkinTitleUpd;
    protected Random rand = new Random();

    protected final String CHECKIN_LIGHTBOX_TITLE = "//input[@class='checkinDetails-titleInput normalizePlaceholder']";
    protected final String CHECKIN_LIGHTBOX_SAVE_EDIT_BUTTON = "//button[@class='btn btn--checkin']";
    protected final String CHECKIN_CARD_TITLE = "//h3[@class='checkinCard-title' and contains(text(), '%s')]";


    protected WebElement getElementByXpath(String locator, String parameter) {
        By webElementLocator = By.xpath(String.format(locator, parameter));
        return driver.findElement(webElementLocator);
    }

    protected WebElement getElementByXpath(String locator) {
        By webElementLocator = By.xpath(locator);
        return driver.findElement(webElementLocator);
    }

}
