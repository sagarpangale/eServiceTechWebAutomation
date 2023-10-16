package com.eservicetechweb.qa.testcases;

import com.eservicetechweb.qa.base.BaseClass;
import com.eservicetechweb.qa.pages.*;
import com.eservicetechweb.qa.util.RandomStringGenerator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class GenerateSignoffReportTest extends BaseClass {
    String service_order_no;
    String serial_num;
    String cust_unit_num;

    String random_technician_name;
    String random_customer_name;
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

    SignOffReportsPage signOffReportsPage;

    public GenerateSignoffReportTest() {
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
        signOffReportsPage = new SignOffReportsPage();


    }


    @Test

    public void verifySignoffReport() throws Exception {
//      Adding new equipment
        serial_num = addEquipmentPage.getRandomSerialNumber();
        cust_unit_num = addEquipmentPage.getRandomCustomerUnitNumber();
        random_technician_name = randomStringGenerator.getRandomString(8);
        random_customer_name = randomStringGenerator.getRandomString(8);

        System.out.println(serial_num);
        System.out.println(cust_unit_num);

        changeCompanyPage.changeCompany();
        Thread.sleep(2000);
        landingPage.loginWithTechnicianAccount();
        Thread.sleep(2000);

//        homePage.clickAddEquipmentTab();
//        Thread.sleep(2000);
//        addEquipmentPage.switchFocustoAddEquipment();
//        Thread.sleep(2000);
//        addEquipmentPage.enterCustomerCode(prop.getProperty("customer_code"));
//        Thread.sleep(2000);
//        addEquipmentPage.enterModelCode(prop.getProperty("equipment_model_code"));
//        addEquipmentPage.enterSerialNumber(serial_num);
//        Thread.sleep(2000);
//        addEquipmentPage.enterCustomerUnitNumber(cust_unit_num);
//        Thread.sleep(2000);
//        addEquipmentPage.selectLineOfBuisness();
//        Thread.sleep(2000);
//        addEquipmentPage.clickAddEquipmentBtn();
//        Thread.sleep(4000);
//        addEquipmentPage.clickEquipmentAddedPopupYesBtn();
//        Thread.sleep(2000);
//
////        Creating service order after adding equipment
//        createServiceOrdersPage.switchFocustoCreateNewServiceOrder();
//        Thread.sleep(2000);
//        createServiceOrdersPage.clickCreateSOBtn();
//        Thread.sleep(5000);
//
////        System.out.println(createServiceOrdersPage.getServiceOrderCreatedNumber(createServiceOrdersPage.getServiceOrderCreatedPopupText()));
//        createServiceOrdersPage.clickCreateSOPopupOkBtn();
//        Thread.sleep(2000);
//        createServiceOrdersPage.clickCloseBtn();
//
//        homePage.switchFocusToDefaultFrame();
//
//        homePage.clickAssignedOrderTab();
//        Thread.sleep(2000);


//        ///////////////////////////////////////////////////////////////////
//                Temp changes for testing
//      ///////////////////////////////////////////////////////////

        Thread.sleep(5000);
        homePage.clickAssignedOrderTab();
        Thread.sleep(5000);
        assignedOrdersPage.clickShowAllBtn();


//        ///////////////////////////////////////////////////////////////////
//        assignedOrdersPage.enterSearchBox(serial_num);
//        assignedOrdersPage.clickSearchBtn();
        Thread.sleep(5000);
        assignedOrdersPage.clickSelectedEntry();
        Thread.sleep(5000);
        assignedOrdersPage.clickSignOffReportBtn();
        Thread.sleep(2000);
        assignedOrdersPage.clickConfirmationPopupYesBtn();
        assignedOrdersPage.switchFocusToSignOffReportFilter();
        assignedOrdersPage.clickOkBtn();
        Thread.sleep(2000);
        signOffReportsPage.clickCaptureSignatureBtn();
        Thread.sleep(5000);

//      Entering technician signoff
        signOffReportsPage.switchFrameToSignatureCanvas();
        Thread.sleep(5000);
        signOffReportsPage.createSignature();
        Thread.sleep(5000);
        signOffReportsPage.enterTechnicianName(random_technician_name);
        Thread.sleep(2000);
        signOffReportsPage.clickAcceptBtn();
        Thread.sleep(5000);


//      Entering customer signoff
        signOffReportsPage.switchFrameToSignatureCanvas();
        Thread.sleep(5000);
        signOffReportsPage.createSignature();
        Thread.sleep(2000);
        signOffReportsPage.enterCustomerName(random_customer_name);
        Thread.sleep(2000);
        signOffReportsPage.clickAcceptBtn();
        Thread.sleep(5000);


    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }
}
