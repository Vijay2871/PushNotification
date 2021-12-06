Feature: Notification Register

@MandatoryFields
Scenario: Check account details in Database

Given I send the the email
And I send the firebase token
Then I see the above details in Database


