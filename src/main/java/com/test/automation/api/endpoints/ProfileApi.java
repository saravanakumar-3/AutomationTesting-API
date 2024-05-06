package com.test.automation.api.endpoints;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class ProfileApi extends Endpoint {
  private String resource = "/gmail/v1/users/{user}/profile";

  public Response get(String user) {
    return given(requestSpec).pathParam("user", user).get(resource);
  }
}
