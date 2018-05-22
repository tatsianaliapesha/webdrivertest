package com.globoforce.testautomation.mentoring.webdriver.test.pages;

import com.globoforce.testautomation.mentoring.webdriver.test.pages.block.login.LoginForm;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {

    private final String LOGIN_PAGE_URL = "https://test-web3-05.corp.globoforce.com/conversations/#!dashboard/%s/%s";

    private LoginForm loginForm;

    public LoginPage open(String clientName, String userId) {
        String url = String.format(LOGIN_PAGE_URL, clientName, userId);
        navigateToUrl(url);
        return new LoginPage(getWebDriver());
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public ConversationsDashboard login(String username, String password){
        loginForm.login(username, password);
        return new ConversationsDashboard(getWebDriver());
    }


}
