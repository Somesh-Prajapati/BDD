package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.RegisterUserPageObjects;
import utils.TestContextSetup;

public class RegisterUserStep {

    TestContextSetup testContextSetup;
    RegisterUserPageObjects registerUserPage;


    public RegisterUserStep(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
        this.registerUserPage = testContextSetup.pageObjectManager.getRegisterUserPage();
    }

    @Given("User is on login page")
    public void user_is_on_login_page() {
        registerUserPage.verifyTitle();
        registerUserPage.verifyRegisterLabel();
    }

    @When("user register and try to login with new credentials")
    public void user_register_and_try_to_login_with_new_credentials() {
        registerUserPage.registerUser();
        registerUserPage.clickOnLogOut();
        registerUserPage.loginWithValidCredentials();
    }

    @Then("Validate if users Mail id is available on Homepage")
    public void validate_if_users_mail_id_is_available_on_homepage() {
        registerUserPage.verifyEMailAddressOnLoginPage();
    }

    @When("User register with Already Existed Mail Id")
    public void user_register_with_already_existed_mail_id() {
        registerUserPage.registerUserWithSameEmail();
    }
    @Then("Validate if user is getting proper Validation Message")
    public void validate_if_user_is_getting_proper_validation_message() {
        registerUserPage.verifyAlreadyExistMailValidation();
    }

}
