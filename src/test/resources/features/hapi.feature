Feature: HAPI FHIR server web interface

  Scenario: I want to test CRUD operations tabs error messges are correct
    Given I am on the website HAPI web Page
    And   I navigate to Patient Page
    And   I click on CRUD Operations tab
    And   I click the Read button without filling in an ID
    Then  I Verify that correct error message is displyed on the page

 