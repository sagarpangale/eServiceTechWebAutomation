package com.eservicetechweb.qa.pages;

import com.eservicetechweb.qa.base.BaseClass;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangeCompanyPage extends BaseClass {

    WebElement selectCompanyRow;

    @FindBy(xpath = "//div[@id='UpServiceCenter']//span[@id='lstServiceCenter_lblServiceCenter_2']")
    WebElement selectServiceCenterRow;

    @FindBy(id = "btnChangeCompanyServiceCenter")
    WebElement changeBtn;

    @FindBy(id = "btnCancelChangeCompanyServiceCenter")
    WebElement cancelBtn;


    public ChangeCompanyPage() {

        PageFactory.initElements(driver, this);

    }

    public void switchFrame() {

        driver.switchTo().defaultContent();
        driver.switchTo().frame("divCommonMod");


    }

    public void selectCompany() throws Exception {

        selectCompanyRow = driver.findElement(By.xpath("//div//tbody//td[contains(text(),'" + prop.getProperty("company_code") + "')]"));
        addWait(selectCompanyRow);
        clickOn(selectCompanyRow);


    }

    public void selectServiceCenter() throws Exception {
        addWait(selectServiceCenterRow);
        clickOn(selectServiceCenterRow);


    }

    public void clickChangeBtn() throws Exception {
        addWait(changeBtn);
        clickOn(changeBtn);
    }

    public void clickCancelBtn() throws Exception {
        addWait(cancelBtn);
        clickOn(cancelBtn);
    }


    public void changeCompany() throws Exception {

        switchFrame();
        selectCompany();
        Thread.sleep(2000);
        selectServiceCenter();
        Thread.sleep(2000);
        clickChangeBtn();

    }


}
