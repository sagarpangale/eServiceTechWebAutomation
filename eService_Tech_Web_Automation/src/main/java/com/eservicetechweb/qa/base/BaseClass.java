package com.eservicetechweb.qa.base;

//import io.github.bonigarcia.wdm.WebDriverManager;

//import org.apache.commons.io.FileUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {


    public static WebDriver driver;

    public static Actions actions;
    public static Properties prop;
    public static Select select;


    public BaseClass() {
        try {
            prop = new Properties();


            FileInputStream ip = new FileInputStream(

                    (System.getProperty("user.dir") + "/src/main/java/com/eservicetechweb/qa/config/config.eServiceTechWeb"));


            prop.load(ip);


        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }

//    public static String getScreenshot() throws IOException {
//
//        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        File source = ts.getScreenshotAs(OutputType.FILE);
//
//// after execution, you could see a folder "Reports" under root folder
//        String destination = System.getProperty("user.dir") + File.separator + "Reports" + File.separator + dateName + ".png";
//        File finalDestination = new File(destination);
//        FileUtils.copyFile(source, finalDestination);
//        return destination;
//    }

    public void initialization() {

        String browserName = prop.getProperty("browser");


        if (browserName.equals("chrome")) {
            ChromeOptions option = new ChromeOptions();
            option.setBrowserVersion("116");

//            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(option);
            actions = new Actions(driver);

        } else if (browserName.equals("firefox")) {

//            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            actions = new Actions(driver);

        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.PAGE_LOADOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));

//      Getting url from config file
        driver.get(prop.getProperty("URL"));

    }

    //    	Common method for sending keys to web element
    public void sendKeys(WebElement element, String keys) throws Exception {
        element.sendKeys(keys);
    }

    //   	Common method for normally clicking a web element
    public void clickOn(WebElement element) throws Exception {
        element.click();
    }

    //    Common method adding explicit wait
    public void addWait(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    //    	Common method  using javascript for clicking a web element
    public void jsClick(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

    }

    public void jsMoveToElement(WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);

    }
}
