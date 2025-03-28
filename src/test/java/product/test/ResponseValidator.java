package product.test;

import io.restassured.response.Response;
import org.junit.Assert;

public class ResponseValidator {


    public static void validateResponse(Response response) {

        Assert.assertEquals("Response code is 200, but got " +
                response.getStatusCode(), 200, response.getStatusCode());


    }
}
