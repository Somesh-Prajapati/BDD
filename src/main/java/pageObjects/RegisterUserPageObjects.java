package pageObjects;

import enums.RegisterUserConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import reusableComponents.SeleniumHelper;

public class RegisterUserPageObjects extends SeleniumHelper {
    WebDriver driver;
    String email;
    String password;

    public RegisterUserPageObjects(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private static final By LBL_REGISTER = By.xpath("//div[@class='page-title']/h1");
    private static final By CHECKBOX_GENDER_MALE = By.xpath("//input[@id='gender-male']");
    private static final By CHECKBOX_GENDER_FEMALE = By.xpath("//input[@id='gender-female']");
    private static final By TXT_FIRST_NAME = By.xpath("//input[@id='FirstName']");
    private static final By TXT_LAST_NAME = By.xpath("//input[@id='LastName']");
    private static final By TXT_EMAIL = By.xpath("//input[@id='Email']");
    private static final By TXT_PASSWORD = By.xpath("//input[@id='Password']");
    private static final By TXT_CONFIRM_PASSWORD = By.xpath("//input[@id='ConfirmPassword']");
    private static final By BTN_REGISTER = By.xpath("//input[@id='register-button']");
    private static final By LBL_EMAIL_ADDRESS = By.xpath("//div[@class='header-links']//a[@class='account']");
    private static final By BTN_LOG_IN = By.xpath("//a[@class='ico-login']");
    private static final By TXT_EMAIL_FIELD = By.xpath("//input[@id='Email']");
    private static final By TXT_PASSWORD_FIELD = By.xpath("//input[@id='Password']");
    private static final By BTN_LOGIN = By.xpath("//input[@value='Log in']");
    private static final By BTN_LOG_OUT = By.xpath("//a[@class='ico-logout']");
    private static final By LBL_YOUR_PERSONAL_DETAILS = By.xpath("(//div[@class='page registration-page']//div[@class='title']/strong)[1]");
    private static final By LBL_YOUR_PASSWORD = By.xpath("(//div[@class='page registration-page']//div[@class='title']/strong)[2]");
    private static final By LBL_GENDER = By.xpath("(//div[@class='inputs']/label)[1]");
    private static final By LBL_MALE = By.xpath("//label[@for='gender-male']");
    private static final By LBL_FEMALE = By.xpath("//label[@for='gender-female']");
    private static final By LBL_FIRST_NAME = By.xpath("//label[@for='FirstName']");
    private static final By LBL_LAST_NAME = By.xpath("//label[@for='LastName']");
    private static final By LBL_EMAIL = By.xpath("//label[@for='Email']");
    private static final By LBL_PASSWORD = By.xpath("//label[@for='Password']");
    private static final By LBL_CONFIRM_PASSWORD = By.xpath("//label[@for='ConfirmPassword']");
    private static final By VALIDATION_TEXT_MESSAGE = By.xpath("//div[@class='validation-summary-errors']/ul/li");


    public void verifyAlreadyExistMailValidation(){
        waitForElementToBeVisible(VALIDATION_TEXT_MESSAGE);
        verifyText(VALIDATION_TEXT_MESSAGE, RegisterUserConstants.VALIDATION_MESSAGE_LABEL);
    }

    public void verifyYourPersonalDetailsLabel(){
        waitForElementToBeVisible(LBL_YOUR_PERSONAL_DETAILS);
        verifyLabel(LBL_YOUR_PERSONAL_DETAILS, RegisterUserConstants.YOUR_PERSONAL_DETAILS_LABEL);
    }
    public void verifyYourPasswordLabel(){
        waitForElementToBeVisible(LBL_YOUR_PASSWORD);
        verifyLabel(LBL_YOUR_PASSWORD, RegisterUserConstants.YOUR_PASSWORD_LABEL);
    }
    public void verifyGenderLabel(){
        waitForElementToBeVisible(LBL_GENDER);
        verifyLabel(LBL_GENDER, RegisterUserConstants.GENDER_LABEL);
    }
    public void verifyMaleLabel(){
        waitForElementToBeVisible(LBL_MALE);
        verifyLabel(LBL_MALE, RegisterUserConstants.MALE_LABEL);
    }
    public void verifyFemaleLabel(){
        waitForElementToBeVisible(LBL_FEMALE);
        verifyLabel(LBL_FEMALE, RegisterUserConstants.FEMALE_LABEL);
    }
    public void verifyFirstNameLabel(){
        waitForElementToBeVisible(LBL_FIRST_NAME);
        verifyLabel(LBL_FIRST_NAME, RegisterUserConstants.FIRST_NAME_LABEL);
    }
    public void verifyLastNameLabel(){
        waitForElementToBeVisible(LBL_LAST_NAME);
        verifyLabel(LBL_LAST_NAME, RegisterUserConstants.LAST_NAME_LABEL);
    }

    public void verifyEmailLabel(){
        waitForElementToBeVisible(LBL_EMAIL);
        verifyLabel(LBL_EMAIL, RegisterUserConstants.EMAIL_LABEL);
    }

    public void verifyPasswordLabel(){
        waitForElementToBeVisible(LBL_PASSWORD);
        verifyLabel(LBL_PASSWORD, RegisterUserConstants.PASSWORD_LABEL);
    }

    public void verifyConfirmPasswordLabel(){
        waitForElementToBeVisible(LBL_CONFIRM_PASSWORD);
        verifyLabel(LBL_CONFIRM_PASSWORD, RegisterUserConstants.CONFIRM_PASSWORD_LABEL);
    }
    public void verifyRegisterLabel() {
        waitForElementToBeVisible(LBL_REGISTER);
        verifyLabel(LBL_REGISTER, RegisterUserConstants.REGISTER_LABEL);
    }

    public void registerUser() {
        String firstName = "FN_" + getRandomAlphabet(5);
        String LastName = "LN_" + getRandomAlphabet(5);
        email = getRandomAlphaNumeric(5) + "@gmail.com";
        password = passwordValue();
        verifyYourPersonalDetailsLabel();
        verifyGenderLabel();
        verifyMaleLabel();
        click(CHECKBOX_GENDER_MALE);
        verifyFirstNameLabel();
        enterInputText(TXT_FIRST_NAME, firstName);
        verifyLastNameLabel();
        enterInputText(TXT_LAST_NAME, LastName);
        verifyEmailLabel();
        enterInputText(TXT_EMAIL, email);
        verifyPasswordLabel();
        enterInputText(TXT_PASSWORD, password);
        verifyConfirmPasswordLabel();
        enterInputText(TXT_CONFIRM_PASSWORD, password);
        click(BTN_REGISTER);
    }

    public void registerUserWithSameEmail() {
        String firstName = "FN_" + getRandomAlphabet(5);
        String LastName = "LN_" + getRandomAlphabet(5);
        email = "svedant2388@gmail.com";
        password = passwordValue();
        click(CHECKBOX_GENDER_MALE);
        enterInputText(TXT_FIRST_NAME, firstName);
        enterInputText(TXT_LAST_NAME, LastName);
        enterInputText(TXT_EMAIL, email);
        enterInputText(TXT_PASSWORD, password);
        enterInputText(TXT_CONFIRM_PASSWORD, password);
        click(BTN_REGISTER);
    }

    public void verifyTitle() {
        waitForElementToBeVisible(LBL_REGISTER);
        verifyExpectedAndActualResult(getCurrentTitle(), RegisterUserConstants.REGISTER_PAGE_TITLE);
    }

    public void loginWithValidCredentials() {
        waitForElementToBeVisible(BTN_LOG_IN);
        click(BTN_LOG_IN);
        enterInputText(TXT_EMAIL_FIELD, email);
        enterInputText(TXT_PASSWORD_FIELD, password);
        click(BTN_LOGIN);
    }

    public void loginWithCredentials(String email, String password) {
        waitForElementToBeVisible(BTN_LOG_IN);
        click(BTN_LOG_IN);
        enterInputText(TXT_EMAIL_FIELD, email);
        enterInputText(TXT_PASSWORD_FIELD, password);
        click(BTN_LOGIN);
    }

    public void verifyEMailAddressOnLoginPage() {
        waitForElementToBeVisible(LBL_EMAIL_ADDRESS);
        verifyExpectedAndActualResult(getText(LBL_EMAIL_ADDRESS), email);
    }

    public void clickOnLogOut(){
        waitForElementToBeVisible(BTN_LOG_OUT);
        click(BTN_LOG_OUT);
    }


}
