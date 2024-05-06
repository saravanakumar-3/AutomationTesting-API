Feature: Validations for Message endpoint

  Scenario: Happy path for Message
    Given a valid message request is created for user 'automation6677@gmail.com'
    Then successful response is received
    And validate the response body of message post request