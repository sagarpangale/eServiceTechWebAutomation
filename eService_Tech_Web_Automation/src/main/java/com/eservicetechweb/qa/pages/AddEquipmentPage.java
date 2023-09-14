package com.eservicetechweb.qa.pages;

import com.eservicetechweb.qa.base.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AddEquipmentPage extends BaseClass {

    @FindBy(id = "btnSaveClose")
    WebElement addEquipmentBtn;


    @FindBy(id = "txtCustomer")
    WebElement customerTextBox;

    @FindBy(id = "txtEquipment")
    WebElement modelCodeTextBox;

    @FindBy(id = "txtSerialNo")
    WebElement serialNoTextBox;

    @FindBy(id = "txtCustomerUnit")
    WebElement customerUnitTextBox;

    @FindBy(id = "ddlLOB")
    WebElement lineOfBuisnessDropdown;


    @FindBy(id = "popup_title")
    WebElement equipmentAddedPopupTitle;

    @FindBy(id = "popup_ok")
    WebElement equipmentAddedPopupYesBtn;

    @FindBy(id = "popup_cancel")
    WebElement equipmentAddedPopupNoBtn;

    @FindBy(id = "imgClose")
    WebElement closeBtn;


    public AddEquipmentPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickAddEquipmentBtn() throws Exception {

        clickOn(addEquipmentBtn);

    }


    public void clickCloseBtn() throws Exception {

        clickOn(closeBtn);

    }

    public void switchFocustoAddEquipment() throws Exception {

        driver.switchTo().defaultContent();
        driver.switchTo().frame("divCommon1");

    }

    public void enterCustomerCode(String customer_code) throws Exception {
        sendKeys(customerTextBox, customer_code);
        Thread.sleep(2000);
        sendKeys(customerTextBox, String.valueOf(Keys.ARROW_DOWN));
        sendKeys(customerTextBox, String.valueOf(Keys.ENTER));

    }

    public void enterModelCode(String equipment_model_code) throws Exception {


        sendKeys(modelCodeTextBox, equipment_model_code);
        Thread.sleep(2000);
        sendKeys(modelCodeTextBox, String.valueOf(Keys.ARROW_DOWN));
        Thread.sleep(2000);
        sendKeys(modelCodeTextBox, String.valueOf(Keys.ARROW_RIGHT));
        Thread.sleep(2000);
        sendKeys(modelCodeTextBox, String.valueOf(Keys.ARROW_DOWN));
        Thread.sleep(2000);
        sendKeys(modelCodeTextBox, String.valueOf(Keys.ENTER));
        Thread.sleep(2000);
    }


    public void enterSerialNumber(String serialNum) throws Exception {

        sendKeys(serialNoTextBox, serialNum);


    }

    public void enterCustomerUnitNumber(String customerUnitNum) throws Exception {

        sendKeys(customerUnitTextBox, customerUnitNum);


    }

    public void selectLineOfBuisness() throws Exception {

        select = new Select(lineOfBuisnessDropdown);
        select.selectByValue("040");


    }


    public void clickEquipmentAddedPopupYesBtn() throws Exception {
        addWait(equipmentAddedPopupYesBtn);
        clickOn(equipmentAddedPopupYesBtn);

    }

    public void clickEquipmentAddedPopupNoBtn() throws Exception {
        addWait(equipmentAddedPopupNoBtn);
        clickOn(equipmentAddedPopupNoBtn);

    }

    public boolean validateAddEquipmentPage() {
        addWait(addEquipmentBtn);
        return addEquipmentBtn.isDisplayed();
    }

    public boolean validateAddEquipmentPopup() {

        addWait(equipmentAddedPopupTitle);

        return equipmentAddedPopupTitle.isDisplayed();

    }
}
