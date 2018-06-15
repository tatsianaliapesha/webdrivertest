package com.globoforce.testautomation.mentoring.webdriver.test.pages.priority;

import com.globoforce.testautomation.mentoring.webdriver.test.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.util.Strings;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class PriorityLightboxPage extends BasePage {

    private static final String PRIORITY_LIGHTBOX_PAGE = "//gf-priority-details";

    @FindBy(xpath = PRIORITY_LIGHTBOX_PAGE + "//input[@class='mergedInputs-inputTitle normalizePlaceholder']")
    private TextInput titleTextInput;

    @FindBy(xpath = PRIORITY_LIGHTBOX_PAGE + "//textarea[@class='superTextarea-field']")
    private TextInput descriptionTextInput;

    @FindBy(xpath = PRIORITY_LIGHTBOX_PAGE + "//button[@class='btn btn--priority']")
    private Button actionButton;

    @FindBy(xpath = PRIORITY_LIGHTBOX_PAGE + "//button[@class='btn btn--priority btn--toggle-split']")
    private Button dropdownButton;

    @FindBy(xpath = PRIORITY_LIGHTBOX_PAGE + "//div[@class='dropdown-menu dropdown-menu--priority']//button[2]")
    private Button deleteButton;

    public PriorityLightboxPage(WebDriver driver) {
        super(driver);
    }

    public PriorityLightboxPage setPriorityTitle(String title) {
        if (!Strings.isNullOrEmpty(title)) {
            titleTextInput.clear();
            titleTextInput.sendKeys(title);
        }
        return this;
    }

    public PriorityLightboxPage setPriorityDescription(String description) {
        if (!Strings.isNullOrEmpty(description)) {
            descriptionTextInput.clear();
            descriptionTextInput.sendKeys(description);
        }
        return this;
    }

    public PriorityLightboxPage clickOnPriorityActionButton() {
        waitUntilClickable(actionButton);
        actionButton.click();
        return this;
    }

    public PriorityLightboxPage clickDropdownButton() {
        waitUntilClickable(dropdownButton);
        dropdownButton.click();
        return this;
    }

    public PriorityLightboxPage clickDeleteButton() {
        waitUntilClickable(deleteButton);
        deleteButton.click();
        return this;
    }


}
