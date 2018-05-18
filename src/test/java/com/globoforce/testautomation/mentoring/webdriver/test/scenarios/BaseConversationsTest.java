package com.globoforce.testautomation.mentoring.webdriver.test.scenarios;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseConversationsTest extends BaseTest {

    private static final String URL = "https://test-web3-05.corp.globoforce.com/conversations/#!dashboard/%s/%s";

    @BeforeClass
    @Parameters({"clientName", "userId", "userName", "password"})
    public void loginToConversations(String clientName, String userId, String userName, String password) {
        driver.get(String.format(URL, clientName, userId));
        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("signIn-button")).click();
    }
}
