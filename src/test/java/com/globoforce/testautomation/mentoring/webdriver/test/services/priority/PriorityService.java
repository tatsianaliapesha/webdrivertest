package com.globoforce.testautomation.mentoring.webdriver.test.services.priority;

import com.globoforce.testautomation.mentoring.webdriver.test.entities.PriorityVO;
import com.globoforce.testautomation.mentoring.webdriver.test.pages.ConversationsDashboard;
import com.globoforce.testautomation.mentoring.webdriver.test.pages.priority.LightboxConfirmationPage;
import com.globoforce.testautomation.mentoring.webdriver.test.pages.priority.PriorityLightboxPage;
import org.openqa.selenium.WebDriver;

public class PriorityService {

    private WebDriver driver;

    public PriorityService(WebDriver driver) {
        this.driver = driver;
    }

    public void createPriority(PriorityVO priorityVO) {
        new ConversationsDashboard(driver)
                .getPrioritySwimlane()
                .clickOnNewPriorityButton();
        new PriorityLightboxPage(driver)
                .setPriorityTitle(priorityVO.getTitle())
                .setPriorityDescription(priorityVO.getDescription())
                .clickOnPriorityActionButton();
    }

    public void deletePriority(String priorityTitle) {
        new ConversationsDashboard(driver)
                .getPrioritySwimlane()
                .getPriorityTitleElement(priorityTitle)
                .click();
        new PriorityLightboxPage(driver)
                .clickDropdownButton()
                .clickDeleteButton()
                .clickYes();
        System.out.println("Priority is deleted.");
    }

    public boolean isPriorityOnSwimlane(String priorityTitle) {
        return new ConversationsDashboard(driver).isPriorityOnSwimlane(priorityTitle);
    }

    public ConversationsDashboard clickConfirmationYesButton() {
        return new LightboxConfirmationPage(driver).clickYes();
    }
}
