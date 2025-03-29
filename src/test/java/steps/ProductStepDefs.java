package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import product.api.RestResouce;
import product.test.ProductResponseValidator;
import product.utils.ConfigLoader;

import static io.restassured.RestAssured.given;


public class ProductStepDefs {
    private Response response;
    private String endpoint;

    @When("I send a get reqwest to the API")
    public void i_send_a_get_reqwest_to_the_api() {
         endpoint = ConfigLoader.getProperty("end_point");
        response = RestResouce.sendGetRequest(endpoint);
    }
    @Then("The  response should have valid data")
    public void the_response_should_have_valid_data() {
        ProductResponseValidator.validateResponse(response);
    }

}
