package com.eservicetechweb.qa.pages;

import com.eservicetechweb.qa.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ImportEmployeePage extends BaseClass {


    @FindBy(id = "MainContent_tabAdmin_tpImport_btnImport")
    WebElement importBtn;

    @FindBy(id = "MainContent_tabAdmin_tpImport_btnImportSearch")
    WebElement searchBtn;

    @FindBy(id = "MainContent_tabAdmin_tpImport_btnClearEmployee")
    WebElement clearBtn;
    @FindBy(id = "MainContent_tabAdmin_tpImport_txtImportSearch")
    WebElement importSearchBox;

    @FindBy(xpath = "//span[@id='MainContent_tabAdmin_tpImport_gvImportEmployees_lblEmpNo_0']//parent::td/parent::tr")
    WebElement firstEmployeeEntry;

    @FindBy(id = "MainContent_tabAdmin_tpImport_gvImportEmployees_lblEmpNo_0")
    WebElement firstEmployeeNo;


    @FindBy(id = "MainContent_tabAdmin_tpImport_gvImportEmployees_lblEmpName_0")
    WebElement firstEmployeeName;

    @FindBy(id = "imgClose")
    WebElement crossBtn;
    @FindBy(id = "btnSave")
    WebElement saveBtn;

    @FindBy(id = "btnCancel")
    WebElement closeBtn;

    @FindBy(id = "popup_message")
    WebElement importSuccessPopupText;

    @FindBy(id = "popup_ok")
    WebElement importSuccessPopupOnBtn;


    public ImportEmployeePage() {
        PageFactory.initElements(driver, this);
    }

    public String getFirstEmployeeNo() {

        return firstEmployeeNo.getText();
    }

    public String getFirstEmployeeName() {

        return firstEmployeeName.getText();
    }

    public String getImportSuccessPopupText() {

        return importSuccessPopupText.getText();
    }

    public void clickImportSuccessPopupOkBtn() throws Exception {

        addWait(importSuccessPopupOnBtn);
        clickOn(importSuccessPopupOnBtn);

    }

    public void clickFirstRecord() throws Exception {

        addWait(firstEmployeeEntry);
        jsClick(firstEmployeeEntry);

    }

    public void clickImportBtn() throws Exception {

        addWait(importBtn);
        jsClick(importBtn);

    }

    public void switchFocusToImportEmployeeFrame() {

        driver.switchTo().defaultContent();
        driver.switchTo().frame("divCommon");
    }

    public void clickSaveBtn() throws Exception {

        addWait(saveBtn);
        clickOn(saveBtn);

    }


}


