package com.globoforce.testautomation.mentoring.webdriver.test.pages.block.checkin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.util.List;

@FindBy(xpath = "//gf-checkin-list")
public class CheckinSwimlane extends HtmlElement {

    @FindBy(xpath = "//a[@class='btn btn--checkin']//span")
    private HtmlElement newCheckinLink;

    public static final String CHECKIN_CARD_TITLE = "//h3[@class='checkinCard-title' and contains(text(), '%s')]";

    public HtmlElement getNewCheckinLink() {
        return newCheckinLink;
    }

    public void clickOnNewCheckinButton(){
        newCheckinLink.click();
    }


 public WebElement getCheckinTitleElement(String checkinTitle){
     String checkinCardXp = String.format(CHECKIN_CARD_TITLE, checkinTitle);
     WebElement checkinCardTitle = findElement(By.xpath(checkinCardXp));
     return checkinCardTitle;
 }



}
