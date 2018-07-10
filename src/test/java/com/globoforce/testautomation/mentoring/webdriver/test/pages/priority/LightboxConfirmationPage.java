package com.globoforce.testautomation.mentoring.webdriver.test.pages.priority;

import com.globoforce.testautomation.mentoring.webdriver.test.pages.BasePage;
import com.globoforce.testautomation.mentoring.webdriver.test.pages.ConversationsDashboard;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;

public class LightboxConfirmationPage extends BasePage {


    public LightboxConfirmationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class = 'lightbox-confirmation ']//button[1]")
    private Button noButton;

    @FindBy(xpath = "//div[@class = 'lightbox-confirmation ']//button[2]")
    private Button yesButton;

    public ConversationsDashboard clickYes() {
        waitUntilClickable(yesButton);
        yesButton.click();
        return new ConversationsDashboard(getWebDriver());
    }

    public void clickNo() {
        waitUntilClickable(noButton);
        noButton.click();
    }


}
