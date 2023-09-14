package com.eservicetechweb.qa.testcases;

import com.eservicetechweb.qa.base.BaseClass;
import com.eservicetechweb.qa.pages.*;
import com.eservicetechweb.qa.util.RandomStringGenerator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VerifyTaskManipulationTest extends BaseClass {
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
    TasksPage tasksPage;

    public VerifyTaskManipulationTest() {
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
        tasksPage = new TasksPage();

    }


    @Test

    public void verifyAddEquipment() throws Exception {
//      Adding new equipment
        serial_num = randomStringGenerator.getRandomString(8);
        cust_unit_num = randomStringGenerator.getRandomString(8);
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
        assignedOrdersPage.clickTasksBtn();
        Thread.sleep(2000);

//        Adding task
        tasksPage.switchFocusToTasksWindow();
//        tasksPage.clickAddTaskBtn();
//        tasksPage.switchFocusToAddTaskWindow();
//        Thread.sleep(2000);
//        tasksPage.enterTaskCode();
//        Thread.sleep(2000);
//        tasksPage.clickSaveAndCloseBtn();
//        Thread.sleep(2000);
//        Assert.assertEquals(tasksPage.getPopupMessage(), prop.getProperty("task_added_success_message"));
//        tasksPage.clickSucessPopupOKBtn();


//        Edit task
        tasksPage.clickEditBtn();
        Thread.sleep(2000);
        tasksPage.enterHours();
        Thread.sleep(2000);
        tasksPage.clickEditBtn();

//        Delete task
//        tasksPage.clickDeleteBtn();
//        tasksPage.clickDeleteTaskPopupYesBtn();
//        Thread.sleep(2000);


    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }
}
