package com.globoforce.testautomation.mentoring.webdriver.test.scenarios.priority;

import com.globoforce.testautomation.mentoring.webdriver.test.services.priority.PriorityService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeletePriorityTest extends CreatePriorityTest {

    @Test(description = "delete created priority and verify it is not displayed on a swimlane")
    public void deletePriority() {
        PriorityService priorityService = new PriorityService(driver);
        priorityService.deletePriority(priorityTitle);
        Assert.assertFalse(priorityService.isPriorityOnSwimlane(priorityTitle),
                "Priority with title " + priorityTitle + "was not deleted.");
    }
}
