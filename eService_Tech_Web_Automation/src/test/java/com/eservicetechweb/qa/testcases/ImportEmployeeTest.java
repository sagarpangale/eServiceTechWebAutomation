package com.eservicetechweb.qa.testcases;

import com.eservicetechweb.qa.base.BaseClass;
import com.eservicetechweb.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ImportEmployeeTest extends BaseClass {

    ChangeCompanyPage changeCompanyPage;
    LandingPage landingPage;
    HomePage homePage;

    AdministrationPage administrationPage;
    ImportEmployeePage importEmployeePage;

    ManageEmployeePage manageEmployeePage;
    String import_employee_code;
    String popup_success_message;
    String import_employee_name;

    @BeforeMethod
    public void setup() {
        initialization();
        changeCompanyPage = new ChangeCompanyPage();
        landingPage = new LandingPage();
        homePage = new HomePage();
        administrationPage = new AdministrationPage();
        importEmployeePage = new ImportEmployeePage();
        manageEmployeePage = new ManageEmployeePage();
    }

    @Test
    public void verifyImportEmployee() throws Exception {


        changeCompanyPage.changeCompany();
        Thread.sleep(2000);
        landingPage.loginWithTechnicianAccount();
        homePage.clickAdminstrationTab();
        Thread.sleep(3000);
        administrationPage.clickImportEmployeeTab();
        Thread.sleep(8000);

        import_employee_code = importEmployeePage.getFirstEmployeeNo();
        import_employee_name = importEmployeePage.getFirstEmployeeName();

        System.out.println(import_employee_code);
        System.out.println(import_employee_name);

        importEmployeePage.clickFirstRecord();
        Thread.sleep(4000);
        importEmployeePage.clickImportBtn();
        Thread.sleep(2000);
        importEmployeePage.switchFocusToImportEmployeeFrame();
        Thread.sleep(2000);
        importEmployeePage.clickSaveBtn();
        Thread.sleep(3000);

        popup_success_message = importEmployeePage.getImportSuccessPopupText();

        System.out.println(popup_success_message);
        Assert.assertEquals(popup_success_message, import_employee_name + " " + prop.getProperty("import_emp_popup_success_message"));
        importEmployeePage.clickImportSuccessPopupOkBtn();
        Thread.sleep(2000);

        administrationPage.clickManageEmployeeTab();
        Thread.sleep(3000);
        manageEmployeePage.searchEmployeeCode(import_employee_name);
        Thread.sleep(2000);
        manageEmployeePage.clickSearchBtn();
        Thread.sleep(5000);
        System.out.println("Employee code shown");
        System.out.println(manageEmployeePage.getFirstEmployeeNo());


        Assert.assertEquals(manageEmployeePage.getFirstEmployeeName(), import_employee_name);


    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }

}

