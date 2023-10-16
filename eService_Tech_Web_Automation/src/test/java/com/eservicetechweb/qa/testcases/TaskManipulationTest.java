package com.eservicetechweb.qa.testcases;

import com.eservicetechweb.qa.base.BaseClass;
import com.eservicetechweb.qa.pages.*;
import com.eservicetechweb.qa.util.RandomStringGenerator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TaskManipulationTest extends BaseClass {
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

    public TaskManipulationTest() {
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

    public void verifyTaskManipulation() throws Exception {

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
        assignedOrdersPage.clickTasksBtn();
        Thread.sleep(2000);


//      Adding task
        tasksPage.addNewTask();
        Assert.assertEquals(tasksPage.getPopupMessage(), prop.getProperty("task_added_success_message"));
        tasksPage.clickSucessPopupOKBtn();


//      Edit task
        tasksPage.editTask();
        Assert.assertEquals(tasksPage.getPopupMessage(), prop.getProperty("task_edited_success_message"));
        tasksPage.clickSucessPopupOKBtn();


//      Delete task
        tasksPage.deleteTask();
        Assert.assertEquals(tasksPage.getPopupMessage(), prop.getProperty("task_deleted_success_message"));
        tasksPage.clickDeleteTaskPopupYesBtn();

    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }
}
