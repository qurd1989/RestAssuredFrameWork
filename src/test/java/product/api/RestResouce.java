package product.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import product.api.ResponseSpecBuilder;
import static product.api.SpecBuilder.getRequestSpecBuilder;

import static io.restassured.RestAssured.given;

public class RestResouce {

    /**
     * This class is used to create a post, get and put
     * method for All the API's, They are optimized,
     * @return
     */
    //Generic method to send a get request
    public static Response sendGetRequest(String endPoint) {
        return RestAssured
                .given()
                .spec(SpecBuilder.getRequestSpecBuilder())
                .when()
                .get(endPoint)
                .then()
                .log().all()
                .extract().response();

    }

    //Generic method to send a post request
    public static Response sendPostRequest(String endPoint, Object body) {
        return RestAssured
                .given()
                .spec(SpecBuilder.getRequestSpecBuilder())
                .body(body)
                .when()
                .post(endPoint)
                .then()
                .log().all()
                .extract().response();
    }
}
