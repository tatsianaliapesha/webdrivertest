package com.globoforce.testautomation.mentoring.webdriver.test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver;

    private static final String URL = "https://test-web3-05.corp.globoforce.com/conversations/#!dashboard/%s/%s";
    private String clientName = "testclient5020";
    private String userId = "3194304";
    private String userName = "norma_nominator";
    private String password = "norma_nominator1";


    @BeforeClass
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browser) {

        if (browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        if (browser.equals("ie")) {
            System.setProperty("webdriver.ie.driver", ".\\src\\test\\resources\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @BeforeClass(dependsOnMethods = "startDriver")
    public void loginToConversations() {
        driver.get(String.format(URL, clientName, userId));
        driver.findElement(By.name("username")).sendKeys(userName);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("signIn-button")).click();
    }

    @AfterClass(alwaysRun = true)
    public void closeDriver() {
        if (driver != null)
            driver.quit();
    }
}
