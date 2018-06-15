package com.globoforce.testautomation.mentoring.webdriver.test.pages;

import com.globoforce.testautomation.mentoring.webdriver.test.pages.block.checkin.CheckinSwimlane;
import com.globoforce.testautomation.mentoring.webdriver.test.pages.block.priority.PrioritySwimlane;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.globoforce.testautomation.mentoring.webdriver.test.pages.block.priority.PrioritySwimlane.PRIORITY_TITLE;

public class ConversationsDashboard extends BasePage {

    private CheckinSwimlane checkinSwimlane;
    private PrioritySwimlane prioritySwimlane;

    public ConversationsDashboard(WebDriver driver) {
        super(driver);
    }


    public CheckinSwimlane getCheckinSwimlane() {
        return checkinSwimlane;
    }

    public PrioritySwimlane getPrioritySwimlane() {
        return prioritySwimlane;
    }

    public boolean isCheckinOnSwimlane(String checkinTitle) {
        return isElementPresent(checkinSwimlane.getCheckinTitleElement(checkinTitle));
    }

    public boolean isPriorityOnSwimlane(String priorityTitle) {
        String priorityXp = String.format(PRIORITY_TITLE, priorityTitle);
        return isElementPresent(By.xpath(priorityXp));
    }


}
