Feature: Validations for Profile endpoint

  Scenario: Happy path for Profile
    Given a valid profile request is created for user 'automation6677@gmail.com'
    Then successful response is received
    And validate the response body of profile get request