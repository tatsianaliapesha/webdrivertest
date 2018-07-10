package com.globoforce.testautomation.mentoring.webdriver.test.scenarios.priority;

import com.globoforce.testautomation.mentoring.webdriver.test.entities.PriorityVO;
import com.globoforce.testautomation.mentoring.webdriver.test.scenarios.BaseConversationsTest;
import com.globoforce.testautomation.mentoring.webdriver.test.services.priority.PriorityService;
import com.globoforce.testautomation.mentoring.webdriver.test.factory.priority.PriorityStaticFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class CreatePriorityTest extends BaseConversationsTest {

    protected String priorityTitle;
    private Random rand = new Random();
    private PriorityService priorityService;
    private PriorityVO priorityVO;

    @BeforeClass
    public void setUpInitialData() {
        priorityTitle = String.valueOf(rand.nextInt(random_generator_int));
        priorityVO = PriorityStaticFactory.createPriority(priorityTitle, priorityTitle);
    }

    @Test
    public void createPriority() {
        priorityService = new PriorityService(driver);
        priorityService.createPriority(priorityVO);
        Assert.assertTrue(priorityService.isPriorityOnSwimlane(priorityTitle), "Priority with title " + priorityTitle + "was not created.");
    }
}
