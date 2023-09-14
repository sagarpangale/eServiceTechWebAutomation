package com.eservicetechweb.qa.pages;

import com.eservicetechweb.qa.base.BaseClass;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TasksPage extends BaseClass {


    @FindBy(id = "btnAddTask")
    WebElement addTaskBtn;

    @FindBy(id = "imgClose")
    WebElement closeBtn;
    @FindBy(id = "txtTaskCode")
    WebElement taskCodeTextBox;
    @FindBy(id = "txtDescription")
    WebElement taskDescpextBox;

    @FindBy(id = "btnSaveNew")
    WebElement saveNewBtn;

    @FindBy(id = "btnSaveClose")
    WebElement saveCloseBtn;

    @FindBy(id = "popup_ok")
    WebElement okBtnSucessPopup;


    @FindBy(id = "popup_message")
    WebElement popupMessage;

    @FindBy(xpath = "//tr[@class='RowStyle']//a[@id='SegmentTasksGrid_ctl02_lnkEdit']")
    WebElement editTaskBtn;

    @FindBy(id = "SegmentTasksGrid_ctl02_imgDelete")
    WebElement deleteBtn;

    @FindBy(xpath = "//tr[@class='RowStyle']//input[@id='SegmentTasksGrid_ctl02_txtEstHours']")
    WebElement estHoursTextBox;

    @FindBy(id = "popup_ok")
    WebElement deleteTaskYesBtn;

    @FindBy(id = "popup_cancel")
    WebElement deleteTaskNoBtn;


    public TasksPage() {
        PageFactory.initElements(driver, this);
    }


    public void clickAddTaskBtn() throws Exception {

        addWait(addTaskBtn);
        clickOn(addTaskBtn);
    }

    public void clickCloseBtn() throws Exception {

        addWait(closeBtn);
        clickOn(closeBtn);

    }

    public void switchFocusToTasksWindow() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("divCommon");


    }

    public void switchFocusToAddTaskWindow() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("divCommon1");


    }

    public void enterTaskCode() throws Exception {

        sendKeys(taskCodeTextBox, "welding");
        Thread.sleep(2000);
        sendKeys(taskCodeTextBox, String.valueOf(Keys.ARROW_DOWN));
        sendKeys(taskCodeTextBox, String.valueOf(Keys.ARROW_RIGHT));
        sendKeys(taskCodeTextBox, String.valueOf(Keys.ENTER));

    }

    public void clickSaveAndCloseBtn() throws Exception {

        addWait(saveCloseBtn);
        clickOn(saveCloseBtn);
    }

    public void clickSucessPopupOKBtn() throws Exception {

        addWait(okBtnSucessPopup);
        clickOn(okBtnSucessPopup);
    }


    public void clickDeleteBtn() throws Exception {

        addWait(deleteBtn);
        clickOn(deleteBtn);
    }


    public void clickDeleteTaskPopupYesBtn() throws Exception {

        addWait(deleteTaskYesBtn);
        clickOn(deleteTaskYesBtn);
    }

    public void clickDeleteTaskPopupNoBtn() throws Exception {

        addWait(deleteTaskNoBtn);
        clickOn(deleteTaskNoBtn);
    }

    public void enterHours() throws Exception {

        estHoursTextBox.clear();
        sendKeys(estHoursTextBox, String.valueOf(2));

    }

    public void clickEditBtn() throws Exception {
        addWait(editTaskBtn);
        clickOn(editTaskBtn);
    }


    public String getPopupMessage() {

        return popupMessage.getText();
    }

}

