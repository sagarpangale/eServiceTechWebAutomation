package com.eservicetechweb.qa.pages;

import com.eservicetechweb.qa.base.BaseClass;
import com.eservicetechweb.qa.util.RandomNumberGenerator;
import com.eservicetechweb.qa.util.RandomStringGenerator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignOffReportsPage extends BaseClass {

    RandomStringGenerator randomStringGenerator;
    RandomNumberGenerator randomNumberGenerator;


    @FindBy(id = "MainContent_btnReportFilter")
    WebElement signoffReportFilterBtn;

    @FindBy(id = "MainContent_btnSignature")
    WebElement captureSignatureBtn;

    @FindBy(id = "signatureCanvas")
    WebElement signatureCanvas;

    @FindBy(id = "txtName")
    WebElement nameTextBox;

    @FindBy(id = "btnAccept")
    WebElement acceptBtn;

    @FindBy(id = "btnClear")
    WebElement clearBtn;


    public SignOffReportsPage() {
        PageFactory.initElements(driver, this);
    }


    public void clickSignOffFilterBtn() throws Exception {

        addWait(signoffReportFilterBtn);
        clickOn(signoffReportFilterBtn);
    }

    public void clickCaptureSignatureBtn() throws Exception {

        addWait(captureSignatureBtn);
        clickOn(captureSignatureBtn);

    }

    public void clickAcceptBtn() throws Exception {

        addWait(acceptBtn);
        clickOn(acceptBtn);

    }

    public void clickClearBtn() throws Exception {

        addWait(clearBtn);
        clickOn(clearBtn);

    }

    public void switchFrameToSignatureCanvas() {

        driver.switchTo().defaultContent();
        driver.switchTo().frame("divCommon");

    }

    public void createSignature() throws InterruptedException {
        Thread.sleep(5000);
        actions.moveToElement(signatureCanvas, -100, -60).click().clickAndHold().moveToElement(signatureCanvas, 100, 60).release().perform();
        Thread.sleep(2000);
        actions.moveToElement(signatureCanvas, -100, 60).click().clickAndHold().moveToElement(signatureCanvas, 100, -60).release().perform();

    }

    public String getRandomTechnicianName() {

        randomStringGenerator = new RandomStringGenerator();
        randomNumberGenerator = new RandomNumberGenerator();

        return "Technician name" + randomStringGenerator.getRandomString(RandomNumberGenerator.getRandomNumber(10, 5));

    }

    public void enterTechnicianName(String random_technician_name) throws Exception {

        sendKeys(nameTextBox, getRandomTechnicianName());


    }

    public String getRandomCustomerName() {

        randomStringGenerator = new RandomStringGenerator();
        randomNumberGenerator = new RandomNumberGenerator();

        return "Customer name" + randomStringGenerator.getRandomString(RandomNumberGenerator.getRandomNumber(10, 5));

    }

    public void enterCustomerName(String random_customer_name) throws Exception {

        sendKeys(nameTextBox, getRandomCustomerName());


    }


}

