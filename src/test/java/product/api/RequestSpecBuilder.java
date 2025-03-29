package product.api;

import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import product.utils.ConfigLoader;
import product.utils.Project;

public class RequestSpecBuilder {
    //this code needs to be optimized, to make it more readable and maintainable uri should be passed as dynamic value
    private static final Project project = new Project("fakestore");


    public static RequestSpecification getRequestSpecBuilder() {
        return new io.restassured.builder.RequestSpecBuilder().
                setBaseUri(project.getBaseUri()).
                log(LogDetail.ALL).build();

    }


}
