package product.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static product.api.SpecBuilder.getRequestSpecBuilder;
import static product.api.SpecBuilder.getResponseSpecBuilder;
import static io.restassured.RestAssured.given;

public class RestResouce {

    /**
     * This class is used to create a post, get and put
     * method for All the API's, They are optimized,
     * @return
     */
    //Get method
    public static Response sendGetRequest() {
        return RestAssured
                .given()
                .spec(SpecBuilder.getRequestSpecBuilder())
                .when()
                .get(SpecBuilder.getEndPoint())
                .then()
                .log().all()
                .extract().response();

    }
}
