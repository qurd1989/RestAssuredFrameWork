package product.utils;

/**
 * The Project class is responsible for configuring the base URI for different APIs.
 * It initializes the base URI based on the provided API name.
 */
public class Project {
    private String baseUri;
    private String apiName;

    /**
     * Constructs a Project instance with the specified API name.
     *
     * @param apiName the name of the API
     */
    public Project(String apiName) {
        this.apiName = apiName;
        configureAPI();

    }
    /**
     * Configures the base URI based on the API name.
     * Throws a RuntimeException if the API name is invalid.
     */
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

    /**
     * Returns the base URI of the API.
     *
     * @return the base URI
     */
    public String getBaseUri() {
        return baseUri;
    }
    /**
     * Returns the name of the API.
     *
     * @return the API name
     */
    public String getApiName() {
        return apiName;
    }

}
