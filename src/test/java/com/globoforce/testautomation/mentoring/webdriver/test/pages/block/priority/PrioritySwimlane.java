package com.globoforce.testautomation.mentoring.webdriver.test.pages.block.priority;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

import java.util.List;

@FindBy(xpath = "//gf-priority-list")
public class PrioritySwimlane extends HtmlElement {

    public static final String PRIORITY_TITLE = "//div[@class='prioritySection']//ul[@class='priorityList']//li[@class='priorityList-item']//span[text()='%s']";

    @FindBy(xpath = "//a[@class='btn btn--priority']//span")
    private Link newPriorityLink;

    public void clickOnNewPriorityButton() {
        newPriorityLink.click();
    }

    public WebElement getPriorityTitleElement(String priorityTitle) {
        String priorityXp = String.format(PRIORITY_TITLE, priorityTitle);
        List<WebElement> priorityList = findElements(By.xpath(priorityXp));
        WebElement resultElement = null;
        if (priorityList.size() == 1) {
            resultElement = priorityList.get(0);
        } else if (priorityList.size() > 1) {
            System.out.println(String.format("More than one priority was found by exact match with '%s' title!", priorityTitle));
        } else if (priorityList.size() == 0) {
            System.out.println(String.format("Priority with '%s' title was not found!", priorityTitle));
        }
        return resultElement;
    }

}
