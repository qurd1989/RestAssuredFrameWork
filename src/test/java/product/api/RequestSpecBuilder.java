package product.api;

import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import product.utils.ConfigLoader;
import product.utils.Project;

public class RequestSpecBuilder {
    private static final Project project = new Project("fakestore");
    private static final String END_POINT = ConfigLoader.getProperty("end_point");


    public static RequestSpecification getRequestSpecBuilder() {
        return new io.restassured.builder.RequestSpecBuilder().
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
