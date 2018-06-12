package com.globoforce.testautomation.mentoring.webdriver.test.scenarios;

import com.globoforce.testautomation.mentoring.webdriver.test.pages.LoginPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseConversationsTest extends BaseTest {

    private static final String URL = "https://test-web3-05.corp.globoforce.com/conversations/#!dashboard/%s/%s";

    @BeforeClass
    @Parameters({"clientName", "userId", "userName", "password"})
    public void loginToConversations(String clientName, String userId, String userName, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(clientName, userId);
        loginPage.login(userName, password);
    }
}
