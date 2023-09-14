package com.eservicetechweb.qa.pages;

import com.eservicetechweb.qa.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AdministrationPage extends BaseClass {


    @FindBy(id = "MainContent_tabAdmin_tpRoleManagement_tdManageRole")
    WebElement roleManagementTab;

    @FindBy(id = "MainContent_tabAdmin_tpImport_tdImportEmp")
    WebElement importEmployeeTab;

    @FindBy(id = "MainContent_tabAdmin_tpManageEmployee_tdManageEmp")
    WebElement manageEmployeeTab;
    @FindBy(id = "MainContent_tabAdmin_tpRoleManagement_gvManageRole_lblRoleName_0")
    WebElement roleNameAdmin;


    public AdministrationPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickRoleManagementTab() throws Exception {

        addWait(roleManagementTab);
        clickOn(roleManagementTab);
    }

    public void clickImportEmployeeTab() throws Exception {

        addWait(importEmployeeTab);
        jsClick(importEmployeeTab);
    }

    public void clickManageEmployeeTab() throws Exception {

        addWait(manageEmployeeTab);
        jsClick(manageEmployeeTab);
    }

    public boolean validateAdministrationPage() {
        addWait(roleNameAdmin);
        return roleNameAdmin.isDisplayed();
    }
}
