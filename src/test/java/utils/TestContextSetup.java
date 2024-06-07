package utils;

import managers.PageObjectManager;
import org.openqa.selenium.WebDriver;

public class TestContextSetup {
    public WebDriver driver;
    public PageObjectManager pageObjectManager;
    public BaseTest baseTest;

    public TestContextSetup(){
        baseTest = new BaseTest();
        pageObjectManager = new PageObjectManager(baseTest.initializeDriver());
    }

}
