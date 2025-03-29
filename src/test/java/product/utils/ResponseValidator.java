package product.utils;

import io.restassured.response.Response;
import org.junit.Assert;

/**
 * This class contains utility methods for reuse.
 */

public class ResponseValidator {
    public static void validateStatusCode(Response response, int expectedStatusCode) {
        Assert.assertEquals("Status  expected :  " + expectedStatusCode + " but found : " +
                response.getStatusCode(), expectedStatusCode, response.getStatusCode());
    }
}
