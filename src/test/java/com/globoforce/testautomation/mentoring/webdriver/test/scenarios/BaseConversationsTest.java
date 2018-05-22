package com.globoforce.testautomation.mentoring.webdriver.test.scenarios;

import com.globoforce.testautomation.mentoring.webdriver.test.pages.ConversationsDashboard;
import com.globoforce.testautomation.mentoring.webdriver.test.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseConversationsTest extends BaseTest {

    private static final String URL = "https://test-web3-05.corp.globoforce.com/conversations/#!dashboard/%s/%s";

    protected LoginPage loginPage;
    protected ConversationsDashboard conversationsDashboard;

    @BeforeClass
    @Parameters({"clientName", "userId", "userName", "password"})
    public void loginToConversations(String clientName, String userId, String userName, String password) {
       loginPage = new LoginPage(driver);
       loginPage.open(clientName, userId);
       conversationsDashboard = loginPage.login(userName, password);
    }
}
