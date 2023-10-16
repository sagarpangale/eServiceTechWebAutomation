package com.eservicetechweb.qa.testcases;

import com.eservicetechweb.qa.base.BaseClass;
import com.eservicetechweb.qa.pages.*;
import com.eservicetechweb.qa.util.RandomStringGenerator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddEquipmentTest extends BaseClass {
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

    public AddEquipmentTest() {
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


    }


    @Test

    public void verifyAddEquipment() throws Exception {


        serial_num = addEquipmentPage.getRandomSerialNumber();
        cust_unit_num = addEquipmentPage.getRandomCustomerUnitNumber();

//      LOGIN
        changeCompanyPage.changeCompany();
        Thread.sleep(2000);
        landingPage.loginWithTechnicianAccount();
        Thread.sleep(2000);

//        ADDING NEW EQUIPMENT
        homePage.clickAddEquipmentTab();
        Thread.sleep(2000);
        addEquipmentPage.switchFocustoAddEquipment();
        Thread.sleep(2000);
        addEquipmentPage.enterCustomerCode(prop.getProperty("customer_code"));
        Thread.sleep(2000);
        addEquipmentPage.enterModelCode(prop.getProperty("equipment_model_code"));
        addEquipmentPage.enterSerialNumber(serial_num);
        Thread.sleep(2000);
        addEquipmentPage.enterCustomerUnitNumber(cust_unit_num);
        Thread.sleep(2000);
        addEquipmentPage.selectLineOfBuisness();
        Thread.sleep(2000);
        addEquipmentPage.clickAddEquipmentBtn();
        Thread.sleep(15000);
        Assert.assertTrue(addEquipmentPage.validateAddEquipmentPopup());
        addEquipmentPage.clickEquipmentAddedPopupYesBtn();
        Thread.sleep(2000);


//        CREATING SERVICE ORDER AFTER ADDING EQUIPMENT
        createServiceOrdersPage.switchFocustoCreateNewServiceOrder();
        Thread.sleep(2000);
        createServiceOrdersPage.clickCreateSOBtn();
        Thread.sleep(2000);
        Assert.assertTrue(createServiceOrdersPage.validateCreateSOCreationPopup());
        Thread.sleep(3000);
        createServiceOrdersPage.getServiceOrderPopupText();
        createServiceOrdersPage.clickCreateSOPopupOkBtn();


//        CREATING SERVICE ORDER SEGMENT FOR CREATED SERVICE ORDER

        homePage.clickAssignedOrderTab();
        Thread.sleep(5000);
        assignedOrdersPage.enterTextInSearchBox(cust_unit_num);
        Thread.sleep(2000);
        assignedOrdersPage.clickSearchBtn();
        Thread.sleep(20000);
        assignedOrdersPage.saveServiceOrderNumber(assignedOrdersPage.getSONumberForSelectedEntry());
        System.out.println(assignedOrdersPage.useServiceOrderNumber());
        Thread.sleep(2000);
        assignedOrdersPage.enterTextInSearchBox(assignedOrdersPage.useServiceOrderNumber());
        Thread.sleep(6000);
//        assignedOrdersPage.clickAddSegment();
//        Thread.sleep(2000);
//        assignedOrdersPage.switchFocusToAddNewSegment();
//        addSegmentPage.clickCreateSegment();
//        Assert.assertTrue(addSegmentPage.validateSOSegmentCreatedPopupText());
//        addSegmentPage.clickSOSegmentCreatedPopupOkBtn();
//        Thread.sleep(2000);

    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }

}
