package com.eservicetechweb.qa.pages;

import com.eservicetechweb.qa.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ApproveLaborPage extends BaseClass {


    @FindBy(xpath = "//tbody/tr[@class=\"RowStyle\"]")
    WebElement firstTableEntry;


    public ApproveLaborPage() {
        PageFactory.initElements(driver, this);
    }


    public boolean validateApproveLaborPage() {
        addWait(firstTableEntry);
        return firstTableEntry.isDisplayed();
    }
}
