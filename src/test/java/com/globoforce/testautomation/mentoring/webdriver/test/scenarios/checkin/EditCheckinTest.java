package com.globoforce.testautomation.mentoring.webdriver.test.scenarios.checkin;

import com.globoforce.testautomation.mentoring.webdriver.test.pages.ConversationsDashboard;
import com.globoforce.testautomation.mentoring.webdriver.test.scenarios.BaseConversationsTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class EditCheckinTest extends BaseConversationsTest {

    private String checkinTitleInit;
    private String checkinTitleUpd;
    private Random rand = new Random();
    ConversationsDashboard conversationsDashboard;

    @Test
    public void createCheckinWithManager() {
        checkinTitleInit = String.valueOf(rand.nextInt(999999));
        conversationsDashboard = new ConversationsDashboard(driver);
        conversationsDashboard.addCheckin(checkinTitleInit, checkinTitleInit);
        Assert.assertTrue(conversationsDashboard.isCheckinOnSwimlane(checkinTitleInit), "Checkin with title " + checkinTitleInit + "was not created.");
    }

    @Test(dependsOnMethods = "createCheckinWithManager")
    public void updateCreatedCheckin() {
        conversationsDashboard.openCheckin(checkinTitleInit);
        checkinTitleUpd = String.valueOf(rand.nextInt(999999));
        conversationsDashboard.editCheckinTitle(checkinTitleUpd);
        Assert.assertTrue(conversationsDashboard.isCheckinOnSwimlane(checkinTitleUpd), "Checkin with title " + checkinTitleInit + "was not found.");
    }


}
