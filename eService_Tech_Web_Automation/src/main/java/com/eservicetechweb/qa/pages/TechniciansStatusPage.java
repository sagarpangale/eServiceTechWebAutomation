package com.eservicetechweb.qa.pages;

import com.eservicetechweb.qa.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TechniciansStatusPage extends BaseClass {


    @FindBy(xpath = "//td//span[contains(text(),'ADAM')]")
    WebElement firstTableEntryName;


    public TechniciansStatusPage() {
        PageFactory.initElements(driver, this);
    }


    public boolean validateTechnicianStatusPage() {
        addWait(firstTableEntryName);
        return firstTableEntryName.isDisplayed();
    }
}
