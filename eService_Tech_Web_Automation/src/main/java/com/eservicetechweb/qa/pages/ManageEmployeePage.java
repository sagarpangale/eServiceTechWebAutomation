package com.eservicetechweb.qa.pages;

import com.eservicetechweb.qa.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ManageEmployeePage extends BaseClass {


    @FindBy(id = "MainContent_tabAdmin_tpManageEmployee_btnResetPassword")
    WebElement resetPasswordBtn;

    @FindBy(id = "MainContent_tabAdmin_tpManageEmployee_btnEditEmployee")
    WebElement editEmployeeBtn;

    @FindBy(id = "MainContent_tabAdmin_tpManageEmployee_btnManageSearch")
    WebElement searchBtn;

    @FindBy(id = "MainContent_tabAdmin_tpManageEmployee_btnClearEmployee1")
    WebElement clearBtn;
    @FindBy(id = "MainContent_tabAdmin_tpManageEmployee_txtManageSearch")
    WebElement employeeSearchBox;

    @FindBy(id = "MainContent_tabAdmin_tpManageEmployee_gvManageEmployee_lblEmployeeNo_0")
    WebElement firstEmployeeNo;

    @FindBy(id = "MainContent_tabAdmin_tpManageEmployee_gvManageEmployee_lblEmployeeName_0")
    WebElement firstEmployeeName;


    public ManageEmployeePage() {
        PageFactory.initElements(driver, this);
    }

    public String getFirstEmployeeNo() {
        addWait(firstEmployeeNo);
        return firstEmployeeNo.getText();
    }

    public String getFirstEmployeeName() {
        addWait(firstEmployeeName);
        return firstEmployeeName.getText();
    }

    public void clickFirstRecord() throws Exception {

        clickOn(firstEmployeeNo);

    }

    public void clickSearchBtn() throws Exception {
        addWait(searchBtn);
        clickOn(searchBtn);

    }

    public void clickClearBtn() throws Exception {
        addWait(clearBtn);
        clickOn(clearBtn);

    }

    public void searchEmployeeCode(String employee_code) throws Exception {
        addWait(employeeSearchBox);
        sendKeys(employeeSearchBox, employee_code);

    }

    public void searchEmployeeName(String employee_name) throws Exception {
        addWait(employeeSearchBox);
        sendKeys(employeeSearchBox, employee_name);

    }

}
