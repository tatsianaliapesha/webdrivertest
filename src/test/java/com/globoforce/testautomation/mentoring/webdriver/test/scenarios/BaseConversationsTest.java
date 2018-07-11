package com.globoforce.testautomation.mentoring.webdriver.test.scenarios;

import com.globoforce.testautomation.mentoring.webdriver.test.services.login.LoginService;
import com.globoforce.testautomation.mentoring.webdriver.test.utils.ScreenshotUtils;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseConversationsTest extends BaseTest {

    private static final String URL = "https://test-web3-05.corp.globoforce.com/conversations/#!dashboard/%s/%s";
    protected int random_generator_int = 999999;

    @BeforeClass
    @Parameters({"clientName", "userId", "userName", "password"})
    public void loginToConversations(String clientName, String userId, String username, String password) {
        logger.info("Login to Conversations.");
        String url = String.format(URL, clientName, userId);
        driver.navigate().to(url);
        LoginService loginService = new LoginService(driver);
        loginService.login(username, password);
    }

    @AfterMethod
    public void takeScreenshot(ITestResult result) {
        ScreenshotUtils.captureScreenshot(driver, result);
    }

}
