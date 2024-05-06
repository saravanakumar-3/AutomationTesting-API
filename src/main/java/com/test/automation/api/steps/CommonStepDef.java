package com.test.automation.api.steps;

import io.cucumber.java.en.Then;

public class CommonStepDef extends BaseStepDef {
  @Then("successful response is received")
  public void successfulResponseIsReceived() {
    response.then().log().all().statusCode(200);
  }
}
