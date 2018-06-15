package com.globoforce.testautomation.mentoring.webdriver.test.pages.block.checkin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;


@FindBy(xpath = "//gf-checkin-list")
public class CheckinSwimlane extends HtmlElement {

    @FindBy(xpath = "//a[@class='btn btn--checkin']//span")
    private HtmlElement newCheckinLink;

    public static final String CHECKIN_CARD_TITLE = "//h3[@class='checkinCard-title' and contains(text(), '%s')]";

    public HtmlElement getNewCheckinLink() {
        return newCheckinLink;
    }

    public void clickOnNewCheckinButton() {
        newCheckinLink.click();
    }


    public HtmlElement getCheckinTitleElement(String checkinTitle) {
        String checkinCardXp = String.format(CHECKIN_CARD_TITLE, checkinTitle);
        WebElement checkinCardTitle = findElement(By.xpath(checkinCardXp));
        HtmlElement htmlElement = new HtmlElement();
        htmlElement.setWrappedElement(checkinCardTitle);
        return htmlElement;
    }


}
