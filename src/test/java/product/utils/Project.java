package product.utils;

public class Project {
    private String baseUri;
    private String apiName;

    public Project(String apiName) {
        this.apiName = apiName;
        configureAPI();

    }

    private void configureAPI() {
        switch(apiName ){
            case"fakestore":
                baseUri = ConfigLoader.getProperty("fakestore.baseuri");
                break;
            case"google":
                baseUri = ConfigLoader.getProperty("google.baseuri");
                break;
            default:
                throw new RuntimeException("Invalid API name");
        }
    }
    public String getBaseUri() {
        return baseUri;
    }
    public String getApiName() {
        return apiName;
    }

}
