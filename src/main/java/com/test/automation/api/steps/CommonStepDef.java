package com.test.automation.api.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Value;

public class CommonStepDef extends BaseStepDef {

  @Value("${spring.application.name}")
  String name;

  @Then("successful response is received")
  public void successfulResponseIsReceived() {
    response.then().log().all().statusCode(200);
  }

  @Given("test step hi")
  public void testStep() {
    System.out.println("Inside step 1");
    System.out.println("Name: " + name);
  }
}
