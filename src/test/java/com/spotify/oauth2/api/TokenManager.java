package com.spotify.oauth2.api;

import com.spotify.oauth2.utils.ConfigLoader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.checkerframework.checker.units.qual.C;

import java.time.Instant;
import java.util.HashMap;

import static com.spotify.oauth2.api.SpecBuilder.getResponseSpecBuilder;
import static io.restassured.RestAssured.given;

public class TokenManager {

    private static String accessToken;
    private static Instant expiryTime;

    public static String getToken() {

        try {
            if (accessToken == null || Instant.now().isAfter(expiryTime)) {
                System.out.println("Renewing token");
                Response response = reNewToken();
                accessToken = response.path("access_token");
                int expiresIn = response.path("expires_in");
                expiryTime = Instant.now().plusSeconds(expiresIn-300);
            }else {
                System.out.println("Token is still valid");
            }
        } catch (Exception e) {
            throw new RuntimeException("Could not get access token", e);
        }
        return accessToken;
    }

    private static Response reNewToken() {
        HashMap<String, String> params = new HashMap<>();
        params.put("refresh_token", ConfigLoader.getInstance().getRefreshToken());
        params.put("grant_type", ConfigLoader.getInstance().grantType());
        params.put("client_secret", ConfigLoader.getInstance().getClientSecret());
        params.put("client_id", ConfigLoader.getInstance().getClientId());

Response response  = RestResource.postAccount(params);

          if (response.statusCode() != 200) {
              throw new RuntimeException("Could not get access token");
          }
            return response;
    }

}
