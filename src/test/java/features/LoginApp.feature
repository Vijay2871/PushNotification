Feature: Login Red App


  Scenario: Register Customer

    Given I Login to Red App
    And I register a customer with no preferred store
    Then I see the customer details
    And I see the salesforce id in Database