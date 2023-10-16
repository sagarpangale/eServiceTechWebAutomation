package com.eservicetechweb.qa.testcases;

import com.eservicetechweb.qa.base.BaseClass;
import com.eservicetechweb.qa.pages.*;
import com.eservicetechweb.qa.util.RandomStringGenerator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OthersPartManipulationTest extends BaseClass {
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
    OthersPage othersPage;
    SoftAssert softAssert;

    public OthersPartManipulationTest() {
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
        othersPage = new OthersPage();
        softAssert = new SoftAssert();


    }


    @Test

    public void verifyOtherPartsManipulation() throws Exception {
//      Adding new equipment
        serial_num = addEquipmentPage.getRandomSerialNumber();
        cust_unit_num = addEquipmentPage.getRandomCustomerUnitNumber();
        System.out.println(serial_num);
        System.out.println(cust_unit_num);

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
        assignedOrdersPage.clickOthersBtn();
        Thread.sleep(2000);


//      Adding Others
        othersPage.addNewOthers();
        Assert.assertEquals(othersPage.getPopupMessage(), prop.getProperty("others_added_success_message"));
        othersPage.clickSucessPopupOKBtn();


//      Edit Others
        othersPage.editOthers();
        softAssert.assertEquals(othersPage.getPopupMessage(), prop.getProperty("others_edited_success_message"));
        othersPage.clickSucessPopupOKBtn();


//      Delete Others
        othersPage.deleteOthers();
        Assert.assertEquals(othersPage.getPopupMessage(), prop.getProperty("others_deleted_success_message"));
        othersPage.clickDeleteOthersPopupYesBtn();

    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }
}
