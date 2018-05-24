package com.globoforce.testautomation.mentoring.webdriver.test.pages.block.priority;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(xpath = "//gf-priority-list")
public class PrioritySwimlane extends HtmlElement {

    public static final String PRIORITY_TITLE = "//span[@class='priorityList-item-text' and contains(text(), '%s')]";

    @FindBy(xpath = "//a[@class='btn btn--priority']//span")
    private HtmlElement newPriorityLink;

    public void clickOnNewPriorityButton() {
        newPriorityLink.click();
    }

    public WebElement getPriorityTitleElement(String priorityTitle) {
        String priorityXp = String.format(PRIORITY_TITLE, priorityTitle);
        WebElement priorityTitleElement = findElement(By.xpath(priorityXp));
        return priorityTitleElement;
    }

}
