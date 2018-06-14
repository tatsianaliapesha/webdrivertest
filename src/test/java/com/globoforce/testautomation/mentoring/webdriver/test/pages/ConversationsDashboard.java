package com.globoforce.testautomation.mentoring.webdriver.test.pages;

import com.globoforce.testautomation.mentoring.webdriver.test.pages.block.checkin.CheckinLightBox;
import com.globoforce.testautomation.mentoring.webdriver.test.pages.block.checkin.CheckinSwimlane;
import com.globoforce.testautomation.mentoring.webdriver.test.pages.block.priority.PriorityLightBox;
import com.globoforce.testautomation.mentoring.webdriver.test.pages.block.priority.PrioritySwimlane;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.globoforce.testautomation.mentoring.webdriver.test.pages.block.priority.PrioritySwimlane.PRIORITY_TITLE;

public class ConversationsDashboard extends BasePage {

    private CheckinSwimlane checkinSwimlane;
    private CheckinLightBox checkinLightBox;
    private PriorityLightBox priorityLightBox;
    private PrioritySwimlane prioritySwimlane;

    public ConversationsDashboard(WebDriver driver) {
        super(driver);
    }


    public CheckinSwimlane getCheckinSwimlane() {
        return checkinSwimlane;
    }

    public CheckinLightBox getCheckinLightBox() {
        return checkinLightBox;
    }

    public PrioritySwimlane getPrioritySwimlane() {
        return prioritySwimlane;
    }

    public PriorityLightBox getPriorityLightBox() {
        return priorityLightBox;
    }


    public boolean isCheckinOnSwimlane(String checkinTitle) {
        return isElementPresent(checkinSwimlane.getCheckinTitleElement(checkinTitle));
    }

    public boolean isPriorityOnSwimlane(String priorityTitle) {
        String priorityXp = String.format(PRIORITY_TITLE, priorityTitle);
        return isElementPresent(By.xpath(priorityXp));
    }

    public WebElement getElementByXpath(String locator, String parameter) {
        By webElementLocator = By.xpath(String.format(locator, parameter));
        return getWebDriver().findElement(webElementLocator);
    }

}
