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


    public CheckinSwimlane getCheckinSwimlane() {
        return checkinSwimlane;
    }

    public CheckinLightBox getCheckinLightBox() {
        return checkinLightBox;
    }

    public ConversationsDashboard setCheckinTitle(String title) {
        checkinLightBox.setTitle(title);
        return this;
    }

    public ConversationsDashboard setCheckinDescription(String description) {
        checkinLightBox.setDescription(description);
        return this;
    }

    public ConversationsDashboard clickOnCheckinActionButton() {
        checkinLightBox.clickActionButton();
        return this;
    }

    public ConversationsDashboard clickOnCloseLightboxButton() {
        checkinLightBox.closeLightBox();
        return this;
    }

    public boolean isCheckinOnSwimlane(String checkinTitle) {
        return isElementPresent(checkinSwimlane.getCheckinTitleElement(checkinTitle));
    }

    public WebElement getElementByXpath(String locator, String parameter) {
        By webElementLocator = By.xpath(String.format(locator, parameter));
        return getWebDriver().findElement(webElementLocator);
    }

}
