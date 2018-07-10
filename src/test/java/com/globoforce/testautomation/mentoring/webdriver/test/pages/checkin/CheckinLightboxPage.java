package com.globoforce.testautomation.mentoring.webdriver.test.pages.checkin;

import com.globoforce.testautomation.mentoring.webdriver.test.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.util.Strings;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class CheckinLightboxPage extends BasePage {

    private static final String CHECKIN_LIGHTBOX_PAGE = "//gf-checkin-details";

    @FindBy(xpath = CHECKIN_LIGHTBOX_PAGE + "//input[@class='checkinDetails-titleInput normalizePlaceholder']")
    private TextInput titleTextInput;

    @FindBy(xpath = CHECKIN_LIGHTBOX_PAGE + "//textarea[@class='superTextarea-field']")
    private TextInput descriptionTextInput;

    @FindBy(xpath = CHECKIN_LIGHTBOX_PAGE + "//button[@class='btn btn--checkin']")
    private Button actionButton;

    @Name("'X' icon")
    @FindBy(xpath = "//button[@class='lightboxContainer-close']")
    private Button closeIcon;

    public CheckinLightboxPage setCheckinTitle(String title) {
        if (!Strings.isNullOrEmpty(title)) {
            titleTextInput.clear();
            titleTextInput.sendKeys(title);
        }
        return this;
    }

    public CheckinLightboxPage setCheckinDescription(String description) {
        if (!Strings.isNullOrEmpty(description)) {
            descriptionTextInput.clear();
            descriptionTextInput.sendKeys(description);
        }
        return this;
    }

    public CheckinLightboxPage clickOnCheckinActionButton() {
        waitUntilClickable(actionButton);
        actionButton.click();
        return this;
    }

    public void clickOnCloseLightboxButton() {
        waitUntilClickable(closeIcon);
        closeIcon.click();
    }


    public CheckinLightboxPage(WebDriver driver) {
        super(driver);
    }


}
