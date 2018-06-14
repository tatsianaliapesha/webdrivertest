package com.globoforce.testautomation.mentoring.webdriver.test.pages.block.login;

import org.openqa.selenium.support.FindBy;
import org.testng.util.Strings;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

@FindBy(id = "loginForm")
public class LoginForm extends HtmlElement {

    @FindBy(name = "username")
    private TextInput usernameTextInput;

    @FindBy(name = "password")
    private TextInput passwordTextInput;

    @FindBy(id = "signIn-button")
    private Button logInButton;

    public void setUsername(String username) {
        if (!Strings.isNullOrEmpty(username)) {
            usernameTextInput.clear();
            usernameTextInput.sendKeys(username);
        }
    }

    public void setPassword(String password) {
        if (!Strings.isNullOrEmpty(password)) {
            passwordTextInput.clear();
            passwordTextInput.sendKeys(password);
        }
    }

    public void clickOnLogInButton() {
        logInButton.click();
    }

    public void login(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickOnLogInButton();
    }
}
