package com.eservicetechweb.qa.pages;

import com.eservicetechweb.qa.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AssignedOrdersPage extends BaseClass {
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


    public AssignedOrdersPage() {
        PageFactory.initElements(driver, this);
    }


    public void switchFocusToAddNewSegment() {

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

    public void clickShowAllBtn() throws Exception {

        addWait(showAllBtn);
        clickOn(showAllBtn);

    }


    public void clickSearchBtn() throws Exception {


        addWait(searchBtn);
        jsClick(searchBtn);

    }

    public void enterSearchBox(String service_order_number) throws Exception {
        searchTextBox.clear();
        addWait(searchTextBox);
        sendKeys(searchTextBox, service_order_number);
    }

    public void clickSelectedEntry() throws Exception {

        addWait(defaultSelectedTableEntry);
        clickOn(defaultSelectedTableEntry);
    }


    public boolean validateAssignedOrdersPage() {

        return defaultSelectedTableEntry.isDisplayed();
    }
}
