package product.api;

import io.restassured.filter.log.LogDetail;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecBuilder {
    public static ResponseSpecification getResponseSpecBuilder() {
        return new io.restassured.builder.ResponseSpecBuilder().
                log(LogDetail.ALL).build();
    }
}
