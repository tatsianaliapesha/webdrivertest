package com.globoforce.testautomation.mentoring.webdriver.test.pages.checkin;

import com.globoforce.testautomation.mentoring.webdriver.test.pages.BasePage;
import com.globoforce.testautomation.mentoring.webdriver.test.pages.ConversationsDashboard;
import com.globoforce.testautomation.mentoring.webdriver.test.pages.block.checkin.CheckinLightBox;
import org.openqa.selenium.WebDriver;

public class CheckinLightboxPage extends BasePage {

    private CheckinLightBox checkinLightBox;

    public CheckinLightboxPage(WebDriver driver) {
        super(driver);
    }

    public CheckinLightboxPage setCheckinTitle(String title) {
        checkinLightBox.setTitle(title);
        return this;
    }

    public CheckinLightboxPage setCheckinDescription(String description) {
        checkinLightBox.setDescription(description);
        return this;
    }

    public CheckinLightboxPage clickOnCheckinActionButton() {
        checkinLightBox.clickActionButton();
        return this;
    }

    public ConversationsDashboard clickOnCloseLightboxButton() {
        checkinLightBox.closeLightBox();
        return new ConversationsDashboard(webdriver);
    }


}
