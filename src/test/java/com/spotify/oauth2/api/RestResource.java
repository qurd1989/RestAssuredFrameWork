package com.spotify.oauth2.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static com.spotify.oauth2.api.SpecBuilder.getRequestSpecBuilder;
import static com.spotify.oauth2.api.SpecBuilder.getResponseSpecBuilder;
import static io.restassured.RestAssured.given;

public class RestResource {

    /**
     * This class is used to create a post, get and put
     * method for All the API's, They are optimized,
     * @param endPoint
     * @param token
     * @param requestApi
     * @return
     */
    //Post method for  Playlist  Api
    public static Response post(String endPoint, String token, Object requestApi) {
        return  given(getRequestSpecBuilder()).
                body(requestApi).
                header("Authorization", "Bearer " + token).
                when().
                post(endPoint).
                then().spec(getResponseSpecBuilder()).
                extract().response();
    }
//Get method for  Playlist  Api
    public static Response get(String endPoint, String token, Object requestApi) {
        return  given(getRequestSpecBuilder()).
                header("Authorization", "Bearer " + token).
                contentType(ContentType.JSON).
                when().
                get(endPoint).
                then().spec(getResponseSpecBuilder()).
                extract().response();
    }
//Put method for  Playlist  Api
public static Response put(String endPoint, String token, Object requestApi) {
    return  given(getRequestSpecBuilder()).
            body(requestApi).
            header("Authorization", "Bearer " + token).
            contentType(ContentType.JSON).
            put(endPoint).
            then().spec(getResponseSpecBuilder()).
            extract().response();
}
    //Negative test case for Playlist Api
    public static Response postError(String endPoint , String token,  Object requestApi) {
        return  given(getRequestSpecBuilder()).
                body(requestApi).
                header("Authorization", "Bearer " + token).
                contentType(ContentType.JSON).
                post(endPoint).
                then().spec(getResponseSpecBuilder()).
                extract().response();
    }

    public static Response postAccount(HashMap<String, String> params) {
        return  given().
                baseUri("https://accounts.spotify.com").
                contentType(ContentType.URLENC).
                formParams(params).
                log().all().
                when().
                post("/api/token").
                then().spec(getResponseSpecBuilder()).
                extract().response();
    }
}
