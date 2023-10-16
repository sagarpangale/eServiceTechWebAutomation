package com.eservicetechweb.qa.pages;

import com.eservicetechweb.qa.base.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class PartsPage extends BaseClass {


    @FindBy(id = "btnAddPart")
    WebElement addPartBtn;

    @FindBy(id = "imgClose")
    WebElement closeBtn;


    @FindBy(id = "btnPickNConfirm")
    WebElement pickAndConfirmBtn;

    @FindBy(id = "btnReturnPart")
    WebElement partReturnBtn;

    @FindBy(id = "btnReceiptPart")
    WebElement partReceiptBtn;


    @FindBy(id = "btnKomatsuCSS")
    WebElement addPartUsingCatalogBtn;

    @FindBy(id = "txtPartCode")
    WebElement partCodeTextBox;

    @FindBy(id = "btnSaveNew")
    WebElement saveNewBtn;
    @FindBy(id = "btnSaveClose")
    WebElement saveCloseBtn;

    @FindBy(id = "popup_message")
    WebElement popupMessage;
    @FindBy(id = "popup_ok")
    WebElement okBtnSucessPopup;

    @FindBy(xpath = "//tr[@class='SelectedRowStyle']//a[@id='lnkEdit']")
    WebElement editPartBtn;

    @FindBy(xpath = "//tr[@class='HeaderStyle']/following-sibling::tr//child::a[@id='lnkEdit']")
    WebElement savePartBtn;

    @FindBy(xpath = "//tr[@class='SelectedRowStyle']//a[@id='lnkDelete']")
    WebElement deletePartBtn;

    @FindBy(id = "txtQuantity")
    WebElement partQtyTextbox;

    @FindBy(id = "popup_ok")
    WebElement deleteTaskYesBtn;

    @FindBy(id = "popup_cancel")
    WebElement deleteTaskNoBtn;


    @FindBy(id = "ddlWarehouse")
    WebElement warehouseDropdown;

    @FindBy(id = "lblToBeDelivered")
    WebElement qtyTobeDeliveredText;

    @FindBy(id = "lblDelivered")
    WebElement qtyDeliveredText;


    public PartsPage() {
        PageFactory.initElements(driver, this);
    }


    public void clickAddPartBtn() throws Exception {

        addWait(addPartBtn);
        clickOn(addPartBtn);
    }

    public void clickCloseBtn() throws Exception {

        addWait(closeBtn);
        clickOn(closeBtn);

    }

    public void clickPickAndConfirmBtn() throws Exception {

        addWait(pickAndConfirmBtn);
        clickOn(pickAndConfirmBtn);

    }

    public void clickPickReturnBtn() throws Exception {

        addWait(partReturnBtn);
        clickOn(partReturnBtn);

    }

    public void clickPickReceiptBtn() throws Exception {

        addWait(partReceiptBtn);
        clickOn(partReceiptBtn);

    }

    public void clickSaveAndCloseBtn() throws Exception {

        addWait(saveCloseBtn);
        clickOn(saveCloseBtn);

    }

    ;

    public void clickSucessPopupOKBtn() throws Exception {

        addWait(okBtnSucessPopup);
        clickOn(okBtnSucessPopup);
    }

    public void switchFocusToPartsWindow() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("divCommon");


    }

    public void switchFocusToAddPartWindow() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("divCommon1");


    }

    public void clickEditPartBtn() throws Exception {
        addWait(editPartBtn);
        clickOn(editPartBtn);
    }

    public void clickSavePartBtn() throws Exception {
        addWait(savePartBtn);
        clickOn(savePartBtn);
    }

    public void clickDeletePartBtn() throws Exception {
        addWait(deletePartBtn);
        clickOn(deletePartBtn);
    }

    public void clickDeleteTaskPopupYesBtn() throws Exception {

        addWait(deleteTaskYesBtn);
        clickOn(deleteTaskYesBtn);
    }

    public void clickDeleteTaskPopupNoBtn() throws Exception {

        addWait(deleteTaskNoBtn);
        clickOn(deleteTaskNoBtn);
    }


    public void enterPartCode() throws Exception {

        sendKeys(partCodeTextBox, "0000");
        Thread.sleep(2000);
        sendKeys(partCodeTextBox, String.valueOf(Keys.ARROW_DOWN));
        sendKeys(partCodeTextBox, String.valueOf(Keys.ARROW_DOWN));
        sendKeys(partCodeTextBox, String.valueOf(Keys.ARROW_RIGHT));
        sendKeys(partCodeTextBox, String.valueOf(Keys.ENTER));

    }

    public String getPopupMessage() {

        addWait(popupMessage);
        return popupMessage.getText();
    }

    public void enterQuantity() throws Exception {

        partQtyTextbox.clear();
        sendKeys(partQtyTextbox, String.valueOf(2));

    }

    public void clickWarehouseDropdown() throws Exception {

        addWait(warehouseDropdown);
        clickOn(warehouseDropdown);

    }

    public void selectWarehouse() {

        select = new Select(warehouseDropdown);
        select.selectByVisibleText("WAREHOUSE- MADISON");


    }

    public String getQtyToBeDelivered() {


        return qtyTobeDeliveredText.getText();
    }

    public String getQtyDelivered() {


        return qtyDeliveredText.getText();
    }


    public void addNewPart() throws Exception {
        switchFocusToPartsWindow();
        clickAddPartBtn();
        switchFocusToAddPartWindow();
        Thread.sleep(2000);
        enterPartCode();
        clickWarehouseDropdown();
        selectWarehouse();
        Thread.sleep(2000);
        clickSaveAndCloseBtn();
        Thread.sleep(2000);

    }

    public void editPart() throws Exception {
        switchFocusToPartsWindow();
        clickEditPartBtn();
        Thread.sleep(2000);
        enterQuantity();
        Thread.sleep(2000);
        clickSavePartBtn();
        Thread.sleep(2000);


    }

    public void deletePart() throws Exception {
        switchFocusToPartsWindow();
        clickDeletePartBtn();
        Thread.sleep(2000);
        clickDeleteTaskPopupYesBtn();
        Thread.sleep(2000);

    }


}

