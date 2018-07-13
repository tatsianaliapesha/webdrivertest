package com.globoforce.testautomation.mentoring.webdriver.test.listeners;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private Logger logger = Logger.getLogger(getClass());

    public void onTestStart(ITestResult result) {
        logger.info("TEST METHOD '" + result.getName()+ "' STARTED");
    }

    public void onTestSuccess(ITestResult result) {
        logger.info("TEST METHOD '" + result.getName() + "' PASSED");
    }

    public void onTestFailure(ITestResult result) {
        logger.info("TEST METHOD '" + result.getName() + "' FAILED");
    }

    public void onTestSkipped(ITestResult result) {
        logger.info("TEST METHOD '" + result.getName() + "' SKIPPED");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.info("TEST METHOD '" + result.getName() + "' correspond threshold of success rate");
    }

    public void onStart(ITestContext iTestContext) {
        logger.info("TEST CLASS '" + iTestContext.getName()+ "' STARTED");
    }

    public void onFinish(ITestContext iTestContext) {
        logger.info("TEST CLASS '" + iTestContext.getName()+  "' FINISHED");
    }
}
