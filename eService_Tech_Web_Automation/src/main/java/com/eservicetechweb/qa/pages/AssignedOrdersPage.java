package com.eservicetechweb.qa.pages;

import com.eservicetechweb.qa.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AssignedOrdersPage extends BaseClass {

    static String SERVICE_ORDER;
    @FindBy(id = "MainContent_btnShowAll")
    WebElement tableEntrySelection;
    @FindBy(id = "MainContent_btnShowAll")
    WebElement showAllBtn;

    @FindBy(id = "MainContent_txtSearch")
    WebElement searchTextBox;

    @FindBy(id = "MainContent_imgbtnSearch")
    WebElement searchBtn;

    @FindBy(xpath = "//tr[@class='SelectedRowStyle']")
    WebElement defaultSelectedTableEntry;

    @FindBy(id = "MainContent_btnAddSegment")
    WebElement addSegmentBtn;

    @FindBy(id = "MainContent_btnTasks")
    WebElement taskBtn;

    @FindBy(id = "MainContent_btnParts")
    WebElement partsBtn;

    @FindBy(id = "MainContent_btnOthers")
    WebElement othersBtn;

    @FindBy(id = "MainContent_btnSignOffReport")
    WebElement signOffReportBtn;

    @FindBy(id = "popup_ok")
    WebElement confirmationPopupYesBtn;
    @FindBy(id = "popup_cancel")
    WebElement confirmationPopupNoBtn;

    @FindBy(id = "btnOK")
    WebElement popupOkBtn;

    @FindBy(id = "btnCancel")
    WebElement popupCancelBtn;

    @FindBy(xpath = "//tr[@class='SelectedRowStyle']/td[contains(text(),'SC001')]/following-sibling::td")
    WebElement serviceOrderNumber;


    public AssignedOrdersPage() {
        PageFactory.initElements(driver, this);
    }


    public void switchFocusToAddNewSegment() {

        driver.switchTo().defaultContent();
        driver.switchTo().frame("divCommon");

    }

    public void switchFocusToSignOffReportFilter() {

        driver.switchTo().defaultContent();
        driver.switchTo().frame("divCommon");

    }

    public void clickAddSegment() throws Exception {

        addWait(addSegmentBtn);
        clickOn(addSegmentBtn);

    }

    public void clickTasksBtn() throws Exception {

        addWait(taskBtn);
        clickOn(taskBtn);

    }

    public void clickPartsBtn() throws Exception {

        addWait(partsBtn);
        clickOn(partsBtn);

    }


    public void clickOthersBtn() throws Exception {

        addWait(othersBtn);
        clickOn(othersBtn);

    }

    public void clickSignOffReportBtn() throws Exception {

        addWait(signOffReportBtn);
        clickOn(signOffReportBtn);

    }

    public void clickShowAllBtn() throws Exception {

        addWait(showAllBtn);
        clickOn(showAllBtn);

    }


    public void clickSearchBtn() throws Exception {


        addWait(searchBtn);
        jsClick(searchBtn);

    }


    public void enterTextInSearchBox(String service_order_number) throws Exception {

        addWait(searchTextBox);
        searchTextBox.clear();
        sendKeys(searchTextBox, service_order_number);


    }

    public void clickSelectedEntry() throws Exception {

        addWait(defaultSelectedTableEntry);
        clickOn(defaultSelectedTableEntry);
    }


    public void clickConfirmationPopupYesBtn() throws Exception {

        addWait(confirmationPopupYesBtn);
        clickOn(confirmationPopupYesBtn);
    }

    public void clickConfirmationPopupNoBtn() throws Exception {

        addWait(confirmationPopupNoBtn);
        clickOn(confirmationPopupNoBtn);
    }

    public void clickOkBtn() throws Exception {

        addWait(popupOkBtn);
        clickOn(popupOkBtn);
    }

    public void clickCancelBtn() throws Exception {

        addWait(popupCancelBtn);
        clickOn(popupCancelBtn);
    }

    public void saveServiceOrderNumber(String service_order_num) {
        SERVICE_ORDER = service_order_num;
    }

    public String useServiceOrderNumber() {

        return SERVICE_ORDER;

    }

    public String getSONumberForSelectedEntry() {

        addWait(serviceOrderNumber);
        return serviceOrderNumber.getText();
    }


    public boolean validateAssignedOrdersPage() {

        return defaultSelectedTableEntry.isDisplayed();
    }
}
