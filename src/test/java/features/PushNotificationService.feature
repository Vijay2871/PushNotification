Feature:  Notification Service Test
  Testing Notification using different scenarios both positive and negative test

  @MandatoryFields @ComponentTest
  Scenario: Verify that mandatory fields are processed successfully

    Given I have email and firebaseToken
    When I hit POST
    Then I get a successful Response
    And the database is populated correctly
    And the status is New

  @InvalidKey @ComponentTest
  Scenario: Access denied to invalid Ocp-Apim-Subscription-Key

    Given I have email and firebaseToken
    When I hit POST with invalid Ocp-Apim-Subscription-Key
    Then I get a Unauthorised Response
    And I get a error message as access denied


  @NullFieldsEmail @ComponentTest
  Scenario: Verify that invalid fields are not processed successfully

    Given I have null email and firebaseToken
    When I hit POST
    Then I get a error code for email
    Then I get a error message as Invalid email

  @DuplicateEmail @ComponentTest
  Scenario: Verify that invalid fields are not processed successfully

    Given I have duplicate email and firebaseToken
    When I hit POST
    Then I get a successful Response
    And the database is populated correctly
    And the datetime is modified

  @NullFieldsToken @ComponentTest
  Scenario: Verify that invalid fields are not processed successfully

    Given I have  email and null firebaseToken
    When I hit POST
    Then I get a error code for token
    Then I get a error Response as Invalid Firebase Token




