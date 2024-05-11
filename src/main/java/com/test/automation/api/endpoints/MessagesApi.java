package com.test.automation.api.endpoints;

import static io.restassured.RestAssured.given;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import java.util.Base64;
import java.util.Map;
import lombok.SneakyThrows;

public class MessagesApi extends Endpoint {
  private String resource = "/gmail/v1/users/{userId}/messages/send";

  @SneakyThrows
  public Response post(String userId, String message) {
    String messageEncoded = Base64.getUrlEncoder().encodeToString(message.getBytes());
    String body = new ObjectMapper().writeValueAsString(Map.of("raw", messageEncoded));
    return given(requestSpec).pathParam("userId", userId).body(body).post(resource);
  }
}
