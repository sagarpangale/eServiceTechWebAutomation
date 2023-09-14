package com.eservicetechweb.qa.pages;

import com.eservicetechweb.qa.base.BaseClass;
import com.eservicetechweb.qa.util.StringSplitter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BaseClass {
    WebElement employeeCard;


    @FindBy(id = "txtUser")
    WebElement enterTechnicianSearchBox;

    @FindBy(id = "btnSearch")
    WebElement searchBtn;

    @FindBy(id = "btnClear")
    WebElement clearBtn;

    @FindBy(id = "txtPassword")
    WebElement passwordTextBox;

    @FindBy(id = "imgLogin")
    WebElement loginBtn;

    @FindBy(id = "lblVersion")
    WebElement appVersion;


    public LandingPage() {

        PageFactory.initElements(driver, this);

    }


    public void enterTechnicianCode() throws Exception {

        addWait(enterTechnicianSearchBox);
        sendKeys(enterTechnicianSearchBox, prop.getProperty("employee_code"));
    }

    public void clickSearchBtn() throws Exception {
        addWait(searchBtn);
        clickOn(searchBtn);

    }

    public void clickClearBtn() throws Exception {
        addWait(clearBtn);
        clickOn(clearBtn);

    }

    public void selectEmployeeCard() throws Exception {
        employeeCard = driver.findElement(By.xpath("//span[@id='dlEmployee_lblEmpNo_0'][contains(text(),'" + prop.getProperty("employee_code") + "')]"));
        addWait(employeeCard);
        clickOn(employeeCard);

    }

    public void enterPassword() throws Exception {
        addWait(passwordTextBox);
        sendKeys(passwordTextBox, prop.getProperty("login_password"));

    }

    public void clickLoginBtn() throws Exception {
        addWait(loginBtn);
        clickOn(loginBtn);

    }

    //  This method gets app version text from the landing page
    public String getAppVersionText() throws Exception {

        return appVersion.getText();

    }

    //  This method returns app version as string from the landing page
    public String getVersion(String app_version_text) {

        String[] arr = StringSplitter.splitString(app_version_text);
        return arr[1];
    }


    //  This method returns app environment as string from the landing page
    public String getEnvironment(String app_version_text) {

        String[] arr = StringSplitter.splitString(app_version_text);
        return arr[2];
    }

    public boolean validateLandingPage() {
        addWait(enterTechnicianSearchBox);
        return enterTechnicianSearchBox.isDisplayed();
    }

    public void loginWithTechnicianAccount() throws Exception {

        enterTechnicianCode();
        clickSearchBtn();
        Thread.sleep(2000);
        selectEmployeeCard();
        Thread.sleep(2000);
        enterPassword();
        Thread.sleep(2000);
        clickLoginBtn();
        Thread.sleep(5000);

    }


}
