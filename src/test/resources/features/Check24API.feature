@API_TEST_Only
Feature: check24 rest GET API service 

 
 @Test_API
 Scenario Outline: I want to test check24 rest GET API service 
    Given I hit the rest GET API service with ID as "<ID>"
   
    Examples: 
      | ID |
      |        200007 |
      |        abcd   |
      |        5456   |