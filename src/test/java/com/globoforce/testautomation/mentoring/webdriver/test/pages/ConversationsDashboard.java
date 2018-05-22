package com.globoforce.testautomation.mentoring.webdriver.test.pages;

import com.globoforce.testautomation.mentoring.webdriver.test.pages.block.checkin.CheckinLightBox;
import com.globoforce.testautomation.mentoring.webdriver.test.pages.block.checkin.CheckinSwimlane;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConversationsDashboard extends BasePage {

    CheckinSwimlane checkinSwimlane;
    CheckinLightBox checkinLightBox;

    public ConversationsDashboard(WebDriver driver) {
        super(driver);
    }

    public void addCheckin(String title, String description) {
        checkinSwimlane.clickOnNewCheckinButton();
        checkinLightBox.createCheckin(title, description);
    }

    public void editCheckinTitle(String title) {
        checkinLightBox.clickEditButton();
        checkinLightBox.setTitle(title);
        checkinLightBox.clickSaveButton();
        checkinLightBox.closeLightBox();
    }

    public void openCheckin(String checkinTitle) {
        checkinSwimlane.getCheckinTitleElement(checkinTitle).click();
    }

    public boolean isCheckinOnSwimlane(String checkinTitle) {
        return isElementPresent(checkinSwimlane.getCheckinTitleElement(checkinTitle));
    }

    public WebElement getElementByXpath(String locator, String parameter) {
        By webElementLocator = By.xpath(String.format(locator, parameter));
        return getWebDriver().findElement(webElementLocator);
    }

}
