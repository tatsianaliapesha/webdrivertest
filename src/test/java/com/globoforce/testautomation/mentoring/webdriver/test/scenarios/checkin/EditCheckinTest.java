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
        checkinTitleInit = String.valueOf(rand.nextInt(random_generator_int));
        checkinVO = CheckinStaticFactory.createCheckin(checkinTitleInit, checkinTitleInit);
    }

    @Test
    public void createCheckinWithManager() {
        logger.info("Create check-in with manager test");
        checkinService = new CheckinService(driver);
        checkinService.createCheckin(checkinVO);
        Assert.assertTrue(checkinService.isCheckinOnSwimlane(checkinTitleInit), "Checkin with title " + checkinTitleInit + "was not created.");
    }

    @Test(dependsOnMethods = "createCheckinWithManager")
    public void updateCreatedCheckin() {
        logger.info("Update created check-in test");
        checkinService.openCheckin(checkinTitleInit);
        checkinTitleUpd = String.valueOf(rand.nextInt(random_generator_int));
        checkinService.editCheckinTitle(checkinTitleUpd);
        Assert.assertTrue(checkinService.isCheckinOnSwimlane(checkinTitleUpd), "Checkin with title " + checkinTitleUpd + "was not found.");
    }


}
