package com.globoforce.testautomation.mentoring.webdriver.test.scenarios.checkin;

import com.globoforce.testautomation.mentoring.webdriver.test.scenarios.BaseConversationsTest;
import com.globoforce.testautomation.mentoring.webdriver.test.services.checkin.CheckinService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class EditCheckinTest extends BaseConversationsTest {

    private String checkinTitleInit;
    private String checkinTitleUpd;
    private Random rand = new Random();
    CheckinService checkinService;

    @Test
    public void createCheckinWithManager() {
        checkinTitleInit = String.valueOf(rand.nextInt(999999));
        checkinService = new CheckinService(driver);
        checkinService.createCheckin(checkinTitleInit, checkinTitleInit);
        Assert.assertTrue(checkinService.isCheckinOnSwimlane(checkinTitleInit), "Checkin with title " + checkinTitleInit + "was not created.");
    }

    @Test(dependsOnMethods = "createCheckinWithManager")
    public void updateCreatedCheckin() {
        checkinService.openCheckin(checkinTitleInit);
        checkinTitleUpd = String.valueOf(rand.nextInt(999999));
        checkinService.editCheckinTitle(checkinTitleUpd);
        Assert.assertTrue(checkinService.isCheckinOnSwimlane(checkinTitleUpd), "Checkin with title " + checkinTitleUpd + "was not found.");
    }


}
