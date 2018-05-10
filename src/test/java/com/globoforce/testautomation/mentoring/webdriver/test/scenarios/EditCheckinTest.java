package com.globoforce.testautomation.mentoring.webdriver.test.scenarios;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class EditCheckinTest extends EditCheckinPreparation {

    @Test
    public void createCheckinWithManager() {
        checkinTitleInit = String.valueOf(rand.nextInt(999999));
        driver.findElement(By.xpath("//a[@class='btn btn--checkin']")).click();
        getElementByXpath(CHECKIN_LIGHTBOX_TITLE).sendKeys(checkinTitleInit);
        driver.findElement(By.xpath("//textarea[@class='superTextarea-field']")).sendKeys(checkinTitleInit);
        getElementByXpath(CHECKIN_LIGHTBOX_SAVE_EDIT_BUTTON).click();
        WebElement checkinTitleOnTheCard = getElementByXpath(CHECKIN_CARD_TITLE, checkinTitleInit);
        Assert.assertEquals(checkinTitleOnTheCard.getText(), checkinTitleInit, "The check-in with title " + checkinTitleInit + " was not created.");
    }

    @Test(dependsOnMethods = "createCheckinWithManager")
    public void updateCreatedCheckin() {
        WebElement checkinCard = getElementByXpath(CHECKIN_CARD_TITLE, checkinTitleInit);
        waitUntilClickable(checkinCard);
        checkinCard.click();
        getElementByXpath(CHECKIN_LIGHTBOX_SAVE_EDIT_BUTTON).click();
        checkinTitleUpd = String.valueOf(rand.nextInt(999999));
        getElementByXpath(CHECKIN_LIGHTBOX_TITLE).clear();
        getElementByXpath(CHECKIN_LIGHTBOX_TITLE).sendKeys(checkinTitleUpd);
        getElementByXpath(CHECKIN_LIGHTBOX_SAVE_EDIT_BUTTON).click();
        driver.findElement(By.cssSelector("button.lightboxContainer-close")).click();
        WebElement checkinTitleOnTheCard = getElementByXpath(CHECKIN_CARD_TITLE, checkinTitleUpd);
        Assert.assertEquals(checkinTitleOnTheCard.getText(), checkinTitleUpd, "The check-in with title " + checkinTitleUpd + " was not found.");
    }

    private void waitUntilClickable(WebElement webElement) {
        new WebDriverWait(driver, 10)
                .pollingEvery(Duration.ofSeconds(1))
                .until(ExpectedConditions
                        .elementToBeClickable(webElement));
    }


}
