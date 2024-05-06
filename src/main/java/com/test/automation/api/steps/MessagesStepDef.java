package com.test.automation.api.steps;

import com.test.automation.api.endpoints.MessagesApi;
import com.test.automation.api.pojo.MessageResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class MessagesStepDef extends BaseStepDef {
  private final MessagesApi messagesApi = new MessagesApi();

  @Given("a valid message request is created for user {string}")
  public void aValidMessageRequestIsCreated(String user) {
    String message = getGmailMessage(user);
    response = messagesApi.post(user, message);
  }

  private static String getGmailMessage(String user) {
    return "From: "
        + user
        + "\n"
        + "To: "
        + user
        + "\n"
        + "Subject: Mail sent from Restassured\n\n"
        + "Hi there, How are you?";
  }

  @And("validate the response body of message post request")
  public void validateTheResponseBodyOfMessagePostRequest() {
    MessageResponse messageResponse = response.as(MessageResponse.class);
    System.out.println(messageResponse.getLabelIds());
  }
}
