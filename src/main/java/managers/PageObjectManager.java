package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.RegisterUserPageObjects;

public class PageObjectManager {
    WebDriver driver;
    RegisterUserPageObjects registerUserPage;

    public PageObjectManager(WebDriver driver){
        this.driver=driver;
    }

    public RegisterUserPageObjects getRegisterUserPage(){
        registerUserPage = new RegisterUserPageObjects(driver);
        return registerUserPage;
    }
}
