package com.eservicetechweb.qa.testcases;

import com.eservicetechweb.qa.base.BaseClass;
import com.eservicetechweb.qa.pages.*;
import com.eservicetechweb.qa.util.RandomStringGenerator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PartManipulationTest extends BaseClass {
    String service_order_no;
    String serial_num;
    String cust_unit_num;
    ChangeCompanyPage changeCompanyPage;
    LandingPage landingPage;
    HomePage homePage;
    AddEquipmentPage addEquipmentPage;
    CreateServiceOrdersPage createServiceOrdersPage;
    RandomStringGenerator randomStringGenerator;
    AssignedOrdersPage assignedOrdersPage;

    AddSegmentPage addSegmentPage;
    PartsPage partsPage;
    SoftAssert softAssert;

    public PartManipulationTest() {
        super();
    }


    @BeforeMethod
    public void setup() {
        initialization();
        changeCompanyPage = new ChangeCompanyPage();
        landingPage = new LandingPage();
        homePage = new HomePage();
        addEquipmentPage = new AddEquipmentPage();
        randomStringGenerator = new RandomStringGenerator();
        createServiceOrdersPage = new CreateServiceOrdersPage();
        assignedOrdersPage = new AssignedOrdersPage();
        addSegmentPage = new AddSegmentPage();
        partsPage = new PartsPage();
        softAssert = new SoftAssert();


    }


    @Test

    public void verifyPartManipulation() throws Exception {


        changeCompanyPage.changeCompany();
        Thread.sleep(2000);
        landingPage.loginWithTechnicianAccount();
        Thread.sleep(2000);

        System.out.println("Test " + assignedOrdersPage.useServiceOrderNumber());
        homePage.clickAssignedOrderTab();
        Thread.sleep(4000);
        assignedOrdersPage.enterTextInSearchBox(assignedOrdersPage.useServiceOrderNumber());
        Thread.sleep(3000);
        assignedOrdersPage.clickSearchBtn();
        Thread.sleep(10000);
        assignedOrdersPage.clickPartsBtn();


//      Adding part
        partsPage.addNewPart();
        Thread.sleep(10000);
        Assert.assertEquals(partsPage.getPopupMessage(), prop.getProperty("part_added_success_message"));
        partsPage.clickSucessPopupOKBtn();


//      Edit part
        partsPage.editPart();
        softAssert.assertEquals(partsPage.getPopupMessage(), prop.getProperty("part_edited_success_message"));
        partsPage.clickSucessPopupOKBtn();

//      Delete task
        partsPage.deletePart();
        Assert.assertEquals(partsPage.getPopupMessage(), prop.getProperty("part_deleted_success_message"));
        partsPage.clickDeleteTaskPopupYesBtn();

//      Pick and confirm

//        partsPage.addNewPart();
//        Assert.assertEquals(partsPage.getPopupMessage(), prop.getProperty("part_added_success_message"));
//        partsPage.clickSucessPopupOKBtn();
//
//        partsPage.clickPickAndConfirmBtn();
//        Thread.sleep(2000);


    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }
}
