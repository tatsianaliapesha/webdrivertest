package com.globoforce.testautomation.mentoring.webdriver.test.scenarios.checkin;

import com.globoforce.testautomation.mentoring.webdriver.test.entities.CheckinVO;
import com.globoforce.testautomation.mentoring.webdriver.test.scenarios.BaseConversationsTest;
import com.globoforce.testautomation.mentoring.webdriver.test.services.checkin.CheckinService;
import com.globoforce.testautomation.mentoring.webdriver.test.factory.checkin.CheckinStaticFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class EditCheckinTest extends BaseConversationsTest {

    private String checkinTitleInit;
    private String checkinTitleUpd;
    private Random rand = new Random();
    private CheckinService checkinService;
    private CheckinVO checkinVO;

    @BeforeClass
    public void setUpInitialData() {
        checkinTitleInit = String.valueOf(rand.nextInt(999999));
        checkinVO = CheckinStaticFactory.createRandomCheckin(checkinTitleInit, checkinTitleInit);
    }

    @Test
    public void createCheckinWithManager() {
        checkinService = new CheckinService(driver);
        checkinService.createCheckin(checkinVO);
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
