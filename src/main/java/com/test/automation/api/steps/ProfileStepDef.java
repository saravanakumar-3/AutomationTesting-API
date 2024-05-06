package com.test.automation.api.steps;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

import com.test.automation.api.endpoints.ProfileApi;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.common.mapper.TypeRef;
import java.util.Map;

public class ProfileStepDef extends BaseStepDef {
  private final ProfileApi profileApi = new ProfileApi();

  @Given("a valid profile request is created for user {string}")
  public void aValidProfileRequestIsCreated(String user) {
    response = profileApi.get(user);
  }

  @And("validate the response body of profile get request")
  public void validateTheResponseBodyOfProfileGetRequest() {
    Map<String, String> map = response.as(new TypeRef<>() {});
    assertThat(map.get("emailAddress"), is("automation6677@gmail.com"));
    assertThat(Integer.parseInt(map.get("messagesTotal")), greaterThan(1));
    assertThat(Integer.parseInt(map.get("threadsTotal")), greaterThan(1));
    assertThat(Integer.parseInt(map.get("historyId")), greaterThan(1));
  }
}
