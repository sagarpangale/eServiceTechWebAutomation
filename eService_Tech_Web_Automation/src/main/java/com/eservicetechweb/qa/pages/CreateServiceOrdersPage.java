package com.eservicetechweb.qa.pages;

import com.eservicetechweb.qa.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CreateServiceOrdersPage extends BaseClass {

    @FindBy(id = "tcAddSegment_tpSegmentDetails_btnAddEquipment")
    WebElement addEquipmentBtn;

    @FindBy(id = "btnCreateOrder")
    WebElement createServiceOrderBtn;

    @FindBy(id = "btnCancel")
    WebElement cancelBtn;

    @FindBy(id = "imgBtnClose")
    WebElement closeBtn;


    @FindBy(id = "tcAddSegment_tpSegmentDetails_txtEquipment")
    WebElement equipmentCode;

    @FindBy(id = "tcAddSegment_tpSegmentDetails_txtJobCode")
    WebElement jobCode;

    @FindBy(id = "tcAddSegment_tpSegmentDetails_txtJobGroup")
    WebElement jobGroup;

    @FindBy(id = "popup_title")
    WebElement serviceOrderCreatedPopupTitle;

    @FindBy(id = "popup_ok")
    WebElement serviceOrderCreatedPopupOkBtn;

    @FindBy(id = "popup_content")
    WebElement serviceOrderPopupText;


    public CreateServiceOrdersPage() {
        PageFactory.initElements(driver, this);
    }


    public void switchFocustoCreateNewServiceOrder() throws Exception {

        driver.switchTo().defaultContent();
        driver.switchTo().frame("divCommon");

    }

    public void clickAddEquipmentBtn() throws Exception {

        clickOn(addEquipmentBtn);

    }

    public void clickCreateSOBtn() throws Exception {
        addWait(createServiceOrderBtn);
        clickOn(createServiceOrderBtn);

    }

    public void clickCancelBtn() throws Exception {

        clickOn(cancelBtn);

    }


    public void clickCreateSOPopupOkBtn() throws Exception {
        addWait(serviceOrderCreatedPopupOkBtn);
        clickOn(serviceOrderCreatedPopupOkBtn);

    }

    public void getServiceOrderPopupText() {

        System.out.println(serviceOrderPopupText.getText());
    }


    public boolean validateCreateServiceOrdersPage() {
        addWait(addEquipmentBtn);
        return addEquipmentBtn.isDisplayed();
    }

    public boolean validateCreateSOCreationPopup() {

        addWait(serviceOrderCreatedPopupTitle);
        return serviceOrderCreatedPopupTitle.isDisplayed();

    }

    public void clickCloseBtn() throws Exception {
        addWait(closeBtn);
        clickOn(closeBtn);

    }
}
