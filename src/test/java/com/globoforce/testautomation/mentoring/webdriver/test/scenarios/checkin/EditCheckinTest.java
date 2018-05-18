package com.globoforce.testautomation.mentoring.webdriver.test.scenarios.checkin;

import com.globoforce.testautomation.mentoring.webdriver.test.constants.CheckinConstants;
import com.globoforce.testautomation.mentoring.webdriver.test.scenarios.BaseConversationsTest;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class EditCheckinTest extends BaseConversationsTest {

    private String checkinTitleInit;
    private String checkinTitleUpd;
    private Random rand = new Random();

    @Test
    public void createCheckinWithManager() {
        checkinTitleInit = String.valueOf(rand.nextInt(999999));
        driver.findElement(By.xpath("//a[@class='btn btn--checkin']")).click();
        getElementByXpath(CheckinConstants.CHECKIN_LIGHTBOX_TITLE).sendKeys(checkinTitleInit);
        driver.findElement(By.xpath("//textarea[@class='superTextarea-field']")).sendKeys(checkinTitleInit);
        getElementByXpath(CheckinConstants.CHECKIN_LIGHTBOX_SAVE_EDIT_BUTTON).click();
        WebElement checkinTitleOnTheCard = getElementByXpath(CheckinConstants.CHECKIN_CARD_TITLE, checkinTitleInit);
        Assert.assertEquals(checkinTitleOnTheCard.getText(), checkinTitleInit, "The check-in with title " + checkinTitleInit + " was not created.");
    }

    @Test(dependsOnMethods = "createCheckinWithManager")
    public void updateCreatedCheckin() {
        WebElement checkinCard = getElementByXpath(CheckinConstants.CHECKIN_CARD_TITLE, checkinTitleInit);
        waitUntilClickable(checkinCard);
        checkinCard.click();
        getElementByXpath(CheckinConstants.CHECKIN_LIGHTBOX_SAVE_EDIT_BUTTON).click();
        checkinTitleUpd = String.valueOf(rand.nextInt(999999));
        getElementByXpath(CheckinConstants.CHECKIN_LIGHTBOX_TITLE).clear();
        getElementByXpath(CheckinConstants.CHECKIN_LIGHTBOX_TITLE).sendKeys(checkinTitleUpd);
        getElementByXpath(CheckinConstants.CHECKIN_LIGHTBOX_SAVE_EDIT_BUTTON).click();
        driver.findElement(By.cssSelector("button.lightboxContainer-close")).click();
        WebElement checkinTitleOnTheCard = getElementByXpath(CheckinConstants.CHECKIN_CARD_TITLE, checkinTitleUpd);
        Assert.assertEquals(checkinTitleOnTheCard.getText(), checkinTitleUpd, "The check-in with title " + checkinTitleUpd + " was not found.");
    }


}
