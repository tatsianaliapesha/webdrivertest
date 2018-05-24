package com.globoforce.testautomation.mentoring.webdriver.test.services.priority;

import com.globoforce.testautomation.mentoring.webdriver.test.pages.ConversationsDashboard;
import org.openqa.selenium.WebDriver;

public class PriorityService {

    private WebDriver driver;

    public PriorityService(WebDriver driver) {
        this.driver = driver;
    }

    public void createPriority(String title, String description) {
        ConversationsDashboard conversationsDashboard = new ConversationsDashboard(this.driver);
        conversationsDashboard.getPrioritySwimlane().clickOnNewPriorityButton();
        conversationsDashboard.setPriorityTitle(title).setPriorityDescription(description).clickOnPriorityActionButton();
    }

    public boolean isPriorityOnSwimlane(String priorityTitle) {
        return new ConversationsDashboard(this.driver).isPriorityOnSwimlane(priorityTitle);
    }
}
