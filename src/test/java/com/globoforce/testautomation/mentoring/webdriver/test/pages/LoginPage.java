package com.globoforce.testautomation.mentoring.webdriver.test.pages;

import com.globoforce.testautomation.mentoring.webdriver.test.pages.block.login.LoginForm;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {

    private LoginForm loginForm;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage setUsername(String username) {
        loginForm.setUsername(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        loginForm.setPassword(password);
        return this;
    }

    public void clickLoginButton() {
        loginForm.clickOnLogInButton();
    }


}
