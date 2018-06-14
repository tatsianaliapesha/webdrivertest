package com.globoforce.testautomation.mentoring.webdriver.test.factory.checkin;

import com.globoforce.testautomation.mentoring.webdriver.test.entities.CheckinVO;

public class CheckinStaticFactory {

    public static CheckinVO createRandomCheckin(String title, String description) {
        CheckinVO checkinVO = new CheckinVO();
        checkinVO.setTitle(title);
        checkinVO.setDescription(description);
        return checkinVO;
    }
}
