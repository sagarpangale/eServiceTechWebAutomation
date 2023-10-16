package com.eservicetechweb.qa.testcases;

import com.eservicetechweb.qa.base.BaseClass;
import com.eservicetechweb.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AllScreensTest extends BaseClass {
    ChangeCompanyPage changeCompanyPage;
    LandingPage landingPage;
    HomePage homePage;

    AssignedOrdersPage assignedOrdersPage;
    AllOrdersPage allOrdersPage;
    CreateServiceOrdersPage createServiceOrdersPage;

    ApproveLaborPage approveLaborPage;
    AddEquipmentPage addEquipmentPage;

    AdministrationPage administrationPage;
    AccountSettingsPage accountSettingsPage;

    TechniciansStatusPage techniciansStatusPage;

    public AllScreensTest() {

        super();
    }

    @BeforeClass
    public void setup() throws Exception {
        initialization();

        changeCompanyPage = new ChangeCompanyPage();
        landingPage = new LandingPage();
        homePage = new HomePage();
        assignedOrdersPage = new AssignedOrdersPage();
        allOrdersPage = new AllOrdersPage();
        approveLaborPage = new ApproveLaborPage();
        createServiceOrdersPage = new CreateServiceOrdersPage();
        addEquipmentPage = new AddEquipmentPage();
        administrationPage = new AdministrationPage();
        accountSettingsPage = new AccountSettingsPage();
        techniciansStatusPage = new TechniciansStatusPage();


        changeCompanyPage.changeCompany();
    }


    @Test(priority = -1)

    public void verifyAllOrdersTab() throws Exception {
//        changeCompanyPage.changeCompany();
        Thread.sleep(2000);
        landingPage.loginWithTechnicianAccount();
        homePage.clickAllOrderTab();
        Thread.sleep(2000);
        Assert.assertTrue(allOrdersPage.validateAllOrdersPage());
        homePage.clickLogoutTab();
    }


    @Test
    public void verifyAssignedOrdersTab() throws Exception {

        landingPage.loginWithTechnicianAccount();
        homePage.clickAssignedOrderTab();
        assignedOrdersPage.clickShowAllBtn();
        Thread.sleep(2000);
        Assert.assertTrue(assignedOrdersPage.validateAssignedOrdersPage());
        homePage.clickLogoutTab();

    }

    @Test
    public void verifyApproveLaborsTab() throws Exception {

        landingPage.loginWithTechnicianAccount();
        homePage.clickApproveLaborTab();
        Thread.sleep(2000);
        Assert.assertTrue(approveLaborPage.validateApproveLaborPage());
        homePage.clickLogoutTab();

    }


    @Test
    public void verifyCreateServiceOrderTab() throws Exception {

        landingPage.loginWithTechnicianAccount();
        homePage.clickCreateServiceOrderTab();
        Thread.sleep(2000);
        homePage.switchFocusToCreateSO();
        Thread.sleep(2000);
        Assert.assertTrue(createServiceOrdersPage.validateCreateServiceOrdersPage());
        homePage.switchFocusToDefaultFrame();
        homePage.clickLogoutTab();

    }

    @Test
    public void verifyAddEquipmentTab() throws Exception {

        landingPage.loginWithTechnicianAccount();
        homePage.clickAddEquipmentTab();
        Thread.sleep(2000);
        homePage.switchFocusToAddNewEquipment();
        Thread.sleep(2000);
        Assert.assertTrue(addEquipmentPage.validateAddEquipmentPage());
        homePage.switchFocusToDefaultFrame();
        homePage.clickLogoutTab();

    }

    @Test
    public void verifyAdministrationTab() throws Exception {

        landingPage.loginWithTechnicianAccount();
        homePage.clickAdminstrationTab();
        Thread.sleep(2000);
        administrationPage.clickRoleManagementTab();
        Thread.sleep(2000);
        Assert.assertTrue(administrationPage.validateAdministrationPage());
        homePage.clickLogoutTab();

    }

    @Test
    public void verifyAccountSettingsTab() throws Exception {

        landingPage.loginWithTechnicianAccount();
        homePage.clickAccountSettingsTab();
        Thread.sleep(2000);
        Assert.assertTrue(accountSettingsPage.validateAccountSettingsPage());
        homePage.clickLogoutTab();

    }

    @Test(dependsOnMethods = "verifyClockOutTab")
    public void verifyClockInTab() throws Exception {

        landingPage.loginWithTechnicianAccount();
        Thread.sleep(2000);
        Assert.assertTrue(homePage.validateClockIn());
        homePage.clickClockInTab();
        Thread.sleep(2000);
        homePage.clickLogoutTab();

    }

    @Test
    public void verifyClockOutTab() throws Exception {

        landingPage.loginWithTechnicianAccount();
        Thread.sleep(2000);
        Assert.assertTrue(homePage.validateClockout());
        homePage.clickClockOutTab();
        Thread.sleep(2000);
        homePage.clickLogoutTab();

    }

    @Test
    public void verifyStartBreakTab() throws Exception {

        landingPage.loginWithTechnicianAccount();
        Thread.sleep(2000);
        Assert.assertTrue(homePage.validateStartBreak());
        homePage.clickStartBreakTab();
        homePage.clickLogoutTab();

    }

    @Test
    public void verifyStopBreakTab() throws Exception {

        landingPage.loginWithTechnicianAccount();
        Thread.sleep(2000);
        Assert.assertTrue(homePage.validateStopBreak());
        homePage.clickStopBreakTab();
        homePage.clickLogoutTab();

    }


    @Test
    public void verifyLogoutTab() throws Exception {

        landingPage.loginWithTechnicianAccount();
        Thread.sleep(2000);
        homePage.clickLogoutTab();
        Assert.assertTrue(landingPage.validateLandingPage());

    }

//    @Test
//    public void verifyTechniciansStatusTab() throws Exception {
//
//        landingPage.loginWithTechnicianAccount();
//        Thread.sleep(2000);
//        homePage.moveScroll();
//        Thread.sleep(2000);
//        homePage.clickTechnicianStatusTab();
//        Thread.sleep(10000);
//        Assert.assertTrue(techniciansStatusPage.validateTechnicianStatusPage());
//        homePage.clickLogoutTab();
//
//
//    }

//        homePage.clickStartedTaskTab();
//        Thread.sleep(2000);
//        homePage.clickApproveLaborTab();
//        Thread.sleep(2000);
//        homePage.clickCreateServiceOrderTab();
//        Thread.sleep(2000);
//        homePage.clickAddEquipmentTab();
//        Thread.sleep(2000);
//        homePage.clickRetryFailedOrderTab();
//        Thread.sleep(2000);
//        homePage.clickAdminstrationTab();
//        Thread.sleep(2000);
//        homePage.clickTechnicianStatusTab();
//        Thread.sleep(2000);
//        homePage.clickAccountSettingsTab();
//        Thread.sleep(2000);
//
//        homePage.clickClockOutTab();
//        Thread.sleep(2000);
//        homePage.clickClockInTab();
//        Thread.sleep(2000);
//        homePage.clickStartBreakTab();
//        Thread.sleep(2000);
//        homePage.clickStopBreakTab();
//        Thread.sleep(2000);
//        homePage.clickLogoutTab();
//        Thread.sleep(2000);
//        System.out.println("loggedout");

//    }


    @AfterClass
    public void teardown() {
        driver.close();
    }

}
