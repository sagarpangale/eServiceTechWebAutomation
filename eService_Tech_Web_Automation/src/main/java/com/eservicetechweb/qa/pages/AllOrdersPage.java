package com.eservicetechweb.qa.pages;

import com.eservicetechweb.qa.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AllOrdersPage extends BaseClass {


    @FindBy(xpath = "//tr[@class='SelectedRowStyle']")
    WebElement defaultSelectedTableEntry;


    public AllOrdersPage() {
        PageFactory.initElements(driver, this);
    }


    public boolean validateAllOrdersPage() {

        return defaultSelectedTableEntry.isDisplayed();
    }
}
