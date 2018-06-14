package com.globoforce.testautomation.mentoring.webdriver.test.services.login;

import com.globoforce.testautomation.mentoring.webdriver.test.pages.ConversationsDashboard;
import com.globoforce.testautomation.mentoring.webdriver.test.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginService {

    private WebDriver driver;

    public LoginService(WebDriver driver) {
        this.driver = driver;
    }

    public ConversationsDashboard login(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
        return new ConversationsDashboard(driver);
    }


}
