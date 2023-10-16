package com.eservicetechweb.qa.pages;

import com.eservicetechweb.qa.base.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OthersPage extends BaseClass {


    @FindBy(id = "btnAddOthers")
    WebElement addOthersBtn;

    @FindBy(id = "imgClose")
    WebElement closeBtn;











    @FindBy(id = "txtCostComponent")
    WebElement costComponentTextBox;

    @FindBy(id = "btnSaveNew")
    WebElement saveNewBtn;
    @FindBy(id = "btnSaveClose")
    WebElement saveCloseBtn;

    @FindBy(id = "popup_message")
    WebElement popupMessage;
    @FindBy(id = "popup_ok")
    WebElement okBtnSucessPopup;

    @FindBy(xpath = "//tr[@class='SelectedRowStyle']//a[@id='SegmentOthersGrid_ctl02_lnkEdit']")
    WebElement editOthersBtn;

    @FindBy(xpath = "//tr[@class='HeaderStyle']/following-sibling::tr//child::a[@id='SegmentOthersGrid_ctl02_lnkEdit']")
    WebElement saveOthersBtn;

    @FindBy(xpath = "//tr[@class='SelectedRowStyle']//a[@id='SegmentOthersGrid_ctl02_lnkDelete']")
    WebElement deleteOthersBtn;

    @FindBy(id = "SegmentOthersGrid_ctl02_txtActualQuantity")
    WebElement actualQtyTextbox;

    @FindBy(id = "popup_ok")
    WebElement deleteTaskYesBtn;

    @FindBy(id = "popup_cancel")
    WebElement deleteTaskNoBtn;


    public OthersPage() {
        PageFactory.initElements(driver, this);
    }


    public void clickAddOthersBtn() throws Exception {

        addWait(addOthersBtn);
        clickOn(addOthersBtn);
    }

    public void clickCloseBtn() throws Exception {

        addWait(closeBtn);
        clickOn(closeBtn);

    }

    public void clickSaveAndCloseBtn() throws Exception {

        addWait(saveCloseBtn);
        clickOn(saveCloseBtn);

    };
    public void clickSucessPopupOKBtn() throws Exception {

        addWait(okBtnSucessPopup);
        clickOn(okBtnSucessPopup);
    }

    public void switchFocusToOthersWindow() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("divCommon");


    }

    public void switchFocusToAddOthersWindow() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("divCommon1");


    }

    public void clickEditOthersBtn() throws Exception {
            addWait(editOthersBtn);
            clickOn(editOthersBtn);
    }
    public void clickSaveOthersBtn() throws Exception {
        addWait(saveOthersBtn);
        clickOn(saveOthersBtn);
    }

    public void clickDeleteOthersBtn() throws Exception {
        addWait(deleteOthersBtn);
        clickOn(deleteOthersBtn);
    }

    public void clickDeleteOthersPopupYesBtn() throws Exception {

        addWait(deleteTaskYesBtn);
        clickOn(deleteTaskYesBtn);
    }

    public void clickDeleteOthersPopupNoBtn() throws Exception {

        addWait(deleteTaskNoBtn);
        clickOn(deleteTaskNoBtn);
    }



    public void enterOthersCode() throws Exception {

        sendKeys(costComponentTextBox, "Oil");
        Thread.sleep(2000);
        sendKeys(costComponentTextBox, String.valueOf(Keys.ARROW_DOWN));
        sendKeys(costComponentTextBox, String.valueOf(Keys.ARROW_RIGHT));
        sendKeys(costComponentTextBox, String.valueOf(Keys.ENTER));

    }

    public String getPopupMessage(){

        return popupMessage.getText();
    }

    public void enterActualQuantity() throws Exception {

        actualQtyTextbox.clear();
        sendKeys(actualQtyTextbox, String.valueOf(2));

    }


    public void addNewOthers() throws Exception {
        switchFocusToOthersWindow();
        clickAddOthersBtn();
        switchFocusToAddOthersWindow();
        Thread.sleep(2000);
        enterOthersCode();
        Thread.sleep(8000);
        clickSaveAndCloseBtn();
        Thread.sleep(2000);

    }

    public void editOthers() throws Exception {
        switchFocusToOthersWindow();
        clickEditOthersBtn();
        Thread.sleep(2000);
        enterActualQuantity();
        Thread.sleep(2000);
        clickSaveOthersBtn();
        Thread.sleep(2000);


    }

    public void deleteOthers() throws Exception {
        switchFocusToOthersWindow();
        clickDeleteOthersBtn();
        Thread.sleep(2000);
        clickDeleteOthersPopupYesBtn();
        Thread.sleep(2000);



    }





}

