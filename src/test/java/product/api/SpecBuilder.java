package product.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import product.utils.ConfigLoader;
import product.utils.Project;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SpecBuilder {
    private static final Project project = new Project("fakestore");
    private static final String END_POINT = ConfigLoader.getProperty("end_point");


    public static RequestSpecification getRequestSpecBuilder() {
        return new RequestSpecBuilder().
                setBaseUri(project.getBaseUri()).
                log(LogDetail.ALL).build();

    }

//    public static RequestSpecification getaccountRequestSpecBuilder() {
//        return new RequestSpecBuilder().
//                setBaseUri(BASE_URI).
//                setBasePath(BASE_PATH).
//                log(LogDetail.ALL).build();
//
//    }
    public static String getEndPoint() {
        return END_POINT;
    }

}
