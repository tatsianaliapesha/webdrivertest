package com.globoforce.testautomation.mentoring.webdriver.test.scenarios.priority;

import com.globoforce.testautomation.mentoring.webdriver.test.scenarios.BaseConversationsTest;
import com.globoforce.testautomation.mentoring.webdriver.test.services.priority.PriorityService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class CreatePriorityTest extends BaseConversationsTest {

    private String priorityTitle;
    private Random rand = new Random();
    PriorityService priorityService;

    @Test
    public void createPriority() {
        priorityTitle = String.valueOf(rand.nextInt(999999));
        priorityService = new PriorityService(driver);
        priorityService.createPriority(priorityTitle, priorityTitle);
        Assert.assertTrue(priorityService.isPriorityOnSwimlane(priorityTitle), "Priority with title " + priorityTitle + "was not created.");
    }
}
