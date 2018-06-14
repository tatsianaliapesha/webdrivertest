package com.globoforce.testautomation.mentoring.webdriver.test.services.priority;

import com.globoforce.testautomation.mentoring.webdriver.test.entities.PriorityVO;
import com.globoforce.testautomation.mentoring.webdriver.test.pages.ConversationsDashboard;
import com.globoforce.testautomation.mentoring.webdriver.test.pages.priority.PriorityLightboxPage;
import org.openqa.selenium.WebDriver;

public class PriorityService {

    private WebDriver driver;

    public PriorityService(WebDriver driver) {
        this.driver = driver;
    }

    public void createPriority(PriorityVO priorityVO) {
        ConversationsDashboard conversationsDashboard = new ConversationsDashboard(driver);
        conversationsDashboard.getPrioritySwimlane().clickOnNewPriorityButton();
        PriorityLightboxPage priorityLightboxPage = new PriorityLightboxPage(driver);
        priorityLightboxPage.setPriorityTitle(priorityVO.getTitle()).setPriorityDescription(priorityVO.getDescription()).clickOnPriorityActionButton();
    }

    public void deletePriority(String priorityTitle) {
        ConversationsDashboard conversationsDashboard = new ConversationsDashboard(driver);
        conversationsDashboard.getPrioritySwimlane().getPriorityTitleElement(priorityTitle).click();
        PriorityLightboxPage priorityLightboxPage = new PriorityLightboxPage(driver);
        priorityLightboxPage.clickDropdownButton().clickDeleteButton().clickConfirmationYesButton();
        System.out.println("Priority is deleted.");
    }

    public boolean isPriorityOnSwimlane(String priorityTitle) {
        return new ConversationsDashboard(driver).isPriorityOnSwimlane(priorityTitle);
    }
}
