package com.globoforce.testautomation.mentoring.webdriver.test.pages.priority;

import com.globoforce.testautomation.mentoring.webdriver.test.pages.BasePage;
import com.globoforce.testautomation.mentoring.webdriver.test.pages.ConversationsDashboard;
import com.globoforce.testautomation.mentoring.webdriver.test.pages.block.priority.PriorityLightBox;
import org.openqa.selenium.WebDriver;

public class PriorityLightboxPage extends BasePage {

    private PriorityLightBox priorityLightBox;

    public PriorityLightboxPage(WebDriver driver) {
        super(driver);
    }

    public PriorityLightboxPage setPriorityTitle(String title) {
        priorityLightBox.setTitle(title);
        return this;
    }

    public PriorityLightboxPage setPriorityDescription(String description) {
        priorityLightBox.setDescription(description);
        return this;
    }

    public PriorityLightboxPage clickOnPriorityActionButton() {
        priorityLightBox.clickActionButton();
        return this;
    }

    public PriorityLightboxPage clickDropdownButton() {
        priorityLightBox.clickDropdownButton();
        return this;
    }

    public PriorityLightboxPage clickDeleteButton() {
        priorityLightBox.clickDeleteButton();
        return this;
    }




}
