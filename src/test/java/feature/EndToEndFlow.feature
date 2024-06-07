Feature: Verify End to End Flow

  Scenario: Register User and perform End to End Journey with one specific product
    Given User is on login page
    When user register and try to login with new credentials
    Then User hover on Computers option from top menu bar and select Desktop option
    Then User verifies the Page and clicks on Add to cart button on the selected product
    Then User verify the product and Defines the specification of the product with providing Details of Product like Processor and click on add to cart button

