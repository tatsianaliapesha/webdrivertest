package com.globoforce.testautomation.mentoring.webdriver.test.services.checkin;

import com.globoforce.testautomation.mentoring.webdriver.test.pages.ConversationsDashboard;
import org.openqa.selenium.WebDriver;

public class CheckinService {

    private WebDriver driver;

    public CheckinService(WebDriver driver) {
        this.driver = driver;
    }

    public void createCheckin(String title, String description) {
        ConversationsDashboard conversationsDashboard = new ConversationsDashboard(this.driver);
        conversationsDashboard.getCheckinSwimlane().clickOnNewCheckinButton();
        conversationsDashboard.setCheckinTitle(title).setCheckinDescription(description).clickOnCheckinActionButton();
    }

    public void openCheckin(String checkinTitle) {
        new ConversationsDashboard(this.driver)
                .getCheckinSwimlane()
                .getCheckinTitleElement(checkinTitle)
                .click();
    }

    public void editCheckinTitle(String title) {
        new ConversationsDashboard(this.driver)
                .clickOnCheckinActionButton()
                .setCheckinTitle(title)
                .clickOnCheckinActionButton()
                .clickOnCloseLightboxButton();

    }

    public boolean isCheckinOnSwimlane(String checkinTitle) {
        return new ConversationsDashboard(this.driver).isCheckinOnSwimlane(checkinTitle);
    }


}
