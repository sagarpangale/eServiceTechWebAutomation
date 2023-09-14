package com.eservicetechweb.qa.pages;

import com.eservicetechweb.qa.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class AccountSettingsPage extends BaseClass {
    WebElement employeeName;


    public AccountSettingsPage() {
        PageFactory.initElements(driver, this);
    }


    public boolean validateAccountSettingsPage() {
        employeeName = driver.findElement(By.xpath("//span[@id='MainContent_lblEmpNameV'][contains(text(),'" + prop.getProperty("employee_name") + "')]"));
        addWait(employeeName);
        return employeeName.isDisplayed();
    }
}
