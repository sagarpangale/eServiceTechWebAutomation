package com.eservicetechweb.qa.testcases;

import com.eservicetechweb.qa.base.BaseClass;
import com.eservicetechweb.qa.pages.*;
import com.eservicetechweb.qa.util.RandomStringGenerator;
import org.apache.xmlbeans.soap.SOAPArrayType;
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
//      Adding new equipment
        serial_num = randomStringGenerator.getRandomString(8);
        cust_unit_num = randomStringGenerator.getRandomString(8);

        changeCompanyPage.changeCompany();
        Thread.sleep(2000);
        landingPage.loginWithTechnicianAccount();
        Thread.sleep(2000);
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
        Thread.sleep(10000);
        Assert.assertTrue(addEquipmentPage.validateAddEquipmentPopup());
        addEquipmentPage.clickEquipmentAddedPopupYesBtn();
        Thread.sleep(2000);

//        Creating service order after adding equipment
        createServiceOrdersPage.switchFocustoCreateNewServiceOrder();
        Thread.sleep(2000);
        createServiceOrdersPage.clickCreateSOBtn();
        Thread.sleep(2000);
        Assert.assertTrue(createServiceOrdersPage.validateCreateSOCreationPopup());
        Thread.sleep(5000);

//        System.out.println(createServiceOrdersPage.getServiceOrderCreatedNumber(createServiceOrdersPage.getServiceOrderCreatedPopupText()));
        createServiceOrdersPage.clickCreateSOPopupOkBtn();
        Thread.sleep(2000);
        createServiceOrdersPage.clickCloseBtn();

//        Creating service order segment for created SO
        homePage.switchFocusToDefaultFrame();
        homePage.clickAssignedOrderTab();
        Thread.sleep(2000);
        assignedOrdersPage.enterSearchBox(cust_unit_num);
        System.out.println("Customer Unit No: " + cust_unit_num);
        Thread.sleep(2000);
        assignedOrdersPage.clickSearchBtn();
        Thread.sleep(20000);
        assignedOrdersPage.clickAddSegment();
        Thread.sleep(2000);
        assignedOrdersPage.switchFocusToAddNewSegment();
        addSegmentPage.clickCreateSegment();
        Assert.assertTrue(addSegmentPage.validateSOSegmentCreatedPopupText());
        addSegmentPage.clickSOSegmentCreatedPopupOkBtn();

    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }

}
