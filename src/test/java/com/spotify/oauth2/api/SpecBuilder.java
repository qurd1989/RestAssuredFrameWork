package com.spotify.oauth2.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {
    public static RequestSpecification getRequestSpecBuilder() {
                return new RequestSpecBuilder().
                        setBaseUri("https://api.spotify.com").
                    setBasePath("/v1").
                    log(LogDetail.ALL).build();

        }

    public static ResponseSpecification getResponseSpecBuilder() {
        return new ResponseSpecBuilder().
                log(LogDetail.ALL).build();
    }
    public static RequestSpecification getaccountRequestSpecBuilder() {
        return new RequestSpecBuilder().
                setBaseUri("https://accounts.spotify.com").
                setBasePath("/v1").
                log(LogDetail.ALL).build();

    }

}
