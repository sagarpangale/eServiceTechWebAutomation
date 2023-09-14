package com.eservicetechweb.qa.pages;

import com.eservicetechweb.qa.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

    @FindBy(id = "alnkOrders")
    WebElement assignedOrderTab;

    @FindBy(id = "alnkAllOrders")
    WebElement allOrderTab;

    @FindBy(id = "alnkStarted")
    WebElement startedTaskTab;

    @FindBy(id = "alnkApproveLabor")
    WebElement approveLaborTab;

    @FindBy(id = "alnkCreateSO")
    WebElement createSOTab;

    @FindBy(id = "alnkAddEquipment")
    WebElement addEquipmentTab;


    @FindBy(id = "alnkRetry")
    WebElement retryFailedOrdersTab;

    @FindBy(id = "hyperlnkadmin")
    WebElement administrationTab;

    @FindBy(xpath = "//li[@id='lnkTechStatus']")
    WebElement technicianStatusTab;


    @FindBy(id = "aAccSettings")
    WebElement accountSettingTab;

    @FindBy(id = "btnClockIn")
    WebElement clockinTab;
    @FindBy(id = "btnClockOut")
    WebElement clockoutTab;

    @FindBy(id = "btnMealBreak")
    WebElement startBreakTab;

    @FindBy(id = "btnMealBreakEnd")
    WebElement stopBreakTab;

    @FindBy(id = "btnLogOut")
    WebElement logoutTab;


    @FindBy(id = "lblEmpNameV")
    WebElement employeeName;


    public HomePage() {

        PageFactory.initElements(driver, this);

    }

    public String getEmployeeName() {

        return employeeName.getText();

    }

    public void clickAssignedOrderTab() throws Exception {
        addWait(assignedOrderTab);
        jsClick(assignedOrderTab);
    }

    public void clickAllOrderTab() throws Exception {
        addWait(allOrderTab);
        jsClick(allOrderTab);
    }

    public void clickStartedTaskTab() throws Exception {
        addWait(startedTaskTab);
        jsClick(startedTaskTab);
    }

    public void clickApproveLaborTab() throws Exception {
        addWait(approveLaborTab);
        jsClick(approveLaborTab);
    }


    public void clickCreateServiceOrderTab() throws Exception {
        addWait(createSOTab);
        jsClick(createSOTab);
    }

    public void switchFocusToCreateSO() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("divCommon");
    }

    public void clickAddEquipmentTab() throws Exception {
        addWait(addEquipmentTab);
        jsClick(addEquipmentTab);
    }

    public void switchFocusToAddNewEquipment() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame("divCommon1");
    }

    public void switchFocusToDefaultFrame() {
        driver.switchTo().defaultContent();
    }

    public void clickRetryFailedOrderTab() throws Exception {
        addWait(retryFailedOrdersTab);
        jsClick(retryFailedOrdersTab);
    }

    public void clickAdminstrationTab() throws Exception {
        addWait(administrationTab);
        jsClick(administrationTab);
    }


    public void clickTechnicianStatusTab() throws Exception {

        addWait(technicianStatusTab);
        jsClick(technicianStatusTab);
    }


    public void clickAccountSettingsTab() throws Exception {
        addWait(accountSettingTab);
        jsClick(accountSettingTab);
    }

    public void clickClockInTab() throws Exception {
        addWait(clockinTab);
        jsClick(clockinTab);
    }

    public boolean validateClockIn() {

        return clockinTab.isDisplayed();
    }

    public void clickClockOutTab() throws Exception {
        addWait(clockoutTab);
        jsClick(clockoutTab);
    }

    public boolean validateClockout() {

        return clockoutTab.isDisplayed();

    }

    public void clickStartBreakTab() throws Exception {
        addWait(startBreakTab);
        jsClick(startBreakTab);
    }

    public boolean validateStartBreak() {

        return startBreakTab.isDisplayed();

    }

    public void clickStopBreakTab() throws Exception {
        addWait(stopBreakTab);
        jsClick(stopBreakTab);
    }

    public boolean validateStopBreak() {

        return stopBreakTab.isDisplayed();

    }

    public void clickLogoutTab() throws Exception {

        addWait(logoutTab);
        jsClick(logoutTab);
    }

    public void moveScroll() {
        actions.scrollToElement(technicianStatusTab).build().perform();
//        jsMoveToElement(technicianStatusTab);

    }


}
