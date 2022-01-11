@UI_Only
Feature: check24 credit card result page

 @Test_UI
 Scenario: I want to test check24 credit card result page
    Given I am on the check24 credit card web Page
    Then  I Verify that cookie is set in headers  
    And   I click on the weiter button on the first of the listed products
    And   I Enter the email id and click on weiter button
    And   I click on radio button and click on weiter button
    Then  I Verify that for all blank field proper error message is displayed 
    And   I fill in all fields with valid values and click on weiter button
    Then  I Verify that page move to next page with out any error

  