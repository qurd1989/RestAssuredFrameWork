package product.test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import product.api.SpecBuilder;

public class ResponseValidator {


    public static void validateResponse(Response response) {

        Assert.assertEquals("Response code is 200, but got " +
                response.getStatusCode(), 200, response.getStatusCode());


    }
}
