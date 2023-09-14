package com.eservicetechweb.qa.testcases;

import com.eservicetechweb.qa.base.BaseClass;
import com.eservicetechweb.qa.pages.ChangeCompanyPage;
import com.eservicetechweb.qa.pages.HomePage;
import com.eservicetechweb.qa.pages.LandingPage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {
    ChangeCompanyPage changeCompanyPage;
    LandingPage landingPage;
    HomePage homePage;


    public LoginTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        changeCompanyPage = new ChangeCompanyPage();
        landingPage = new LandingPage();
        homePage = new HomePage();

    }

    @Test
    public void verifyAppVersionTest() throws Exception {
        changeCompanyPage.changeCompany();
        Assert.assertEquals(landingPage.getVersion(landingPage.getAppVersionText()), prop.getProperty("app_version"));

    }

    @Test
    public void verifyAppEnvironmentTest() throws Exception {
        changeCompanyPage.changeCompany();
        Assert.assertEquals(landingPage.getEnvironment(landingPage.getAppVersionText()), prop.getProperty("app_environment"));

    }

    @Test
    public void verifyUserLoginTest() throws Exception {

        changeCompanyPage.changeCompany();
        Thread.sleep(2000);
        landingPage.loginWithTechnicianAccount();
        Assert.assertEquals(homePage.getEmployeeName(), prop.getProperty("employee_name"));


    }


    @AfterMethod
    public void teardown() {
        driver.close();
    }

}
