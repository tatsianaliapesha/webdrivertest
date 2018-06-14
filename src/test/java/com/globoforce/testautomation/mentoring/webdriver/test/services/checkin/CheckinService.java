package com.globoforce.testautomation.mentoring.webdriver.test.services.checkin;

import com.globoforce.testautomation.mentoring.webdriver.test.entities.CheckinVO;
import com.globoforce.testautomation.mentoring.webdriver.test.pages.ConversationsDashboard;
import com.globoforce.testautomation.mentoring.webdriver.test.pages.checkin.CheckinLightboxPage;
import org.openqa.selenium.WebDriver;

public class CheckinService {

    private WebDriver driver;

    public CheckinService(WebDriver driver) {
        this.driver = driver;
    }

    public void createCheckin(CheckinVO checkinVO) {
        ConversationsDashboard conversationsDashboard = new ConversationsDashboard(driver);
        conversationsDashboard.getCheckinSwimlane().clickOnNewCheckinButton();
        CheckinLightboxPage checkinLightboxPage = new CheckinLightboxPage(driver);
        checkinLightboxPage.setCheckinTitle(checkinVO.getTitle()).setCheckinDescription(checkinVO.getDescription()).clickOnCheckinActionButton();
    }

    public void openCheckin(String checkinTitle) {
        new ConversationsDashboard(this.driver)
                .getCheckinSwimlane()
                .getCheckinTitleElement(checkinTitle)
                .click();
    }

    public void editCheckinTitle(String title) {
        new CheckinLightboxPage(this.driver)
                .clickOnCheckinActionButton()
                .setCheckinTitle(title)
                .clickOnCheckinActionButton()
                .clickOnCloseLightboxButton();

    }

    public boolean isCheckinOnSwimlane(String checkinTitle) {
        return new ConversationsDashboard(this.driver).isCheckinOnSwimlane(checkinTitle);
    }


}
