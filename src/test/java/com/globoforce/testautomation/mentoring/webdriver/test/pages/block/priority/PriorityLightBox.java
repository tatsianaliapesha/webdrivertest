package com.globoforce.testautomation.mentoring.webdriver.test.pages.block.priority;

import org.openqa.selenium.support.FindBy;
import org.testng.util.Strings;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@FindBy(xpath = "//gf-priority-details")
public class PriorityLightBox extends HtmlElement {

    @FindBy(xpath = "//input[@class='mergedInputs-inputTitle normalizePlaceholder']")
    private TextInput titleTextInput;

    @FindBy(xpath = "//textarea[@class='superTextarea-field']")
    private TextInput descriptionTextInput;

    @FindBy(xpath = "//button[@class='btn btn--priority']")
    private Button actionButton;

    public void setTitle(String title) {
        if (!Strings.isNullOrEmpty(title)) {
            titleTextInput.clear();
            titleTextInput.sendKeys(title);
        }
    }

    public void setDescription(String description) {
        if (!Strings.isNullOrEmpty(description)) {
            descriptionTextInput.clear();
            descriptionTextInput.sendKeys(description);
        }
    }

    public void clickActionButton() {
        actionButton.click();
    }

}
