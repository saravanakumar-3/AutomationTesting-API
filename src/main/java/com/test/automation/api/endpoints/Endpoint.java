package com.test.automation.api.endpoints;

import static com.test.automation.api.utils.AppConstants.*;
import static io.restassured.RestAssured.given;

import io.restassured.common.mapper.TypeRef;
import io.restassured.specification.RequestSpecification;
import java.time.Instant;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

public class Endpoint {
  protected static String ACCESS_TOKEN = "";
  protected static Instant accessTokenExpire;
  RequestSpecification requestSpec =
      given().baseUri(GMAIL_URL).auth().oauth2(getAccessToken()).log().all();

  protected String getAccessToken() {
    if (StringUtils.isEmpty(ACCESS_TOKEN) || isTokenExpired()) {
      ACCESS_TOKEN = refreshAccessToken();
    }
    return ACCESS_TOKEN;
  }

  private String refreshAccessToken() {
    Map<String, String> map =
        given()
            .baseUri(TOKEN_URL)
            .log()
            .all()
            .formParam("client_id", CLIENT_ID)
            .formParam("client_secret", CLIENT_SECRET)
            .formParam("grant_type", "refresh_token")
            .formParam("refresh_token", REFRESH_TOKEN)
            .post()
            .as(new TypeRef<>() {});
    accessTokenExpire = Instant.now().plusSeconds(Integer.parseInt(map.get("expires_in")));
    return map.get("access_token");
  }

  private boolean isTokenExpired() {
    if (Objects.nonNull(accessTokenExpire) && accessTokenExpire.isBefore(Instant.now())) {
      return false;
    } else return true;
  }
}
