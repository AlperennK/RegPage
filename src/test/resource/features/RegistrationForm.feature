# new feature
# Tags: optional
    
Feature: User should be able to fill form with valid values
    
Scenario: Fill the form with invalid phone number and receive error message
    Given I have registration page
    When I fill the mobile number with invalid values
    Then I should see error message displayed on UI

Scenario: Fill the form with valid phone number
    Given I have registration page
    When I fill the mobile number with correct values
    Then I should see valid message on UI