package com.globoforce.testautomation.mentoring.webdriver.test.factory.priority;

import com.globoforce.testautomation.mentoring.webdriver.test.entities.PriorityVO;

public class PriorityStaticFactory {

    public static PriorityVO createPriority(String title, String description) {
        PriorityVO priorityVO = new PriorityVO();
        priorityVO.setTitle(title);
        priorityVO.setDescription(description);
        return priorityVO;
    }
}
