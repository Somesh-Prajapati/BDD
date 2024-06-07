Feature: Register the User and Validate credentials

  @registerUser @smoke
  Scenario: Create a user and validate if successfully logged in or not
    Given User is on login page
    When user register and try to login with new credentials
    Then Validate if users Mail id is available on Homepage

  @registerUserWithExistingMailId @smoke
  Scenario: Create a User with already existed Mail Id
    Given User is on login page
    When User register with Already Existed Mail Id
    Then Validate if user is getting proper Validation Message