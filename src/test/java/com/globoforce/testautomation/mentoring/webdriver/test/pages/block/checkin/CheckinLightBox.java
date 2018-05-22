package com.globoforce.testautomation.mentoring.webdriver.test.pages.block.checkin;

import org.openqa.selenium.support.FindBy;
import org.testng.util.Strings;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;


@FindBy(xpath = "//gf-checkin-details")
public class CheckinLightBox extends HtmlElement {

    @FindBy(xpath = "//input[@class='checkinDetails-titleInput normalizePlaceholder']")
    private TextInput titleTextInput;

    @FindBy(xpath = "//textarea[@class='superTextarea-field']")
    private TextInput descriptionTextInput;

    @FindBy(xpath = "//button[@class='btn btn--checkin']")
    private Button actionButton;

    @Name("'X' icon")
    @FindBy(xpath = "//button[@class='lightboxContainer-close']")
    private Button closeIcon;

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

    public void closeLightBox(){
        closeIcon.click();
    }
/*

    public void createCheckin(String title, String description) {
        setTitle(title);
        setDescription(description);
        actionButton.click();
    }
*/


}
