package com.eservicetechweb.qa.pages;

import com.eservicetechweb.qa.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddSegmentPage extends BaseClass {
    @FindBy(id = "btnCreateSegment")
    WebElement createSegmentBtn;

    @FindBy(xpath = "//h1[@id='popup_title'][contains(text(),'Service Order Segment Created')]")
    WebElement soSegmentCreatedPopupTitle;

    @FindBy(id = "popup_ok")
    WebElement soSegmentCreatedPopupOKbtn;


    public AddSegmentPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickCreateSegment() throws Exception {

        addWait(createSegmentBtn);
        clickOn(createSegmentBtn);

    }

    public void clickSOSegmentCreatedPopupOkBtn() throws Exception {

        addWait(soSegmentCreatedPopupOKbtn);
        clickOn(soSegmentCreatedPopupOKbtn);

    }

    public boolean validateSOSegmentCreatedPopupText() {

        addWait(soSegmentCreatedPopupTitle);
        return soSegmentCreatedPopupTitle.isDisplayed();
    }

}
