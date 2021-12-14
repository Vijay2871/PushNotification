Feature: Loyalty Sign-Up

  Background: Register to Warehouse App

    Given I login as a Guest via the Red App
    And I register as a customer
    Then I can now login as a registered Red App Customer

  @SmokeTest
  Scenario: Sign-Up to MarketClub with SFSC customer Id

    Given my SFSC Customer ID is available
    Then I can start signing up to MarketClub
    And I can validate my phone number
    And I can choose a cause that I like

