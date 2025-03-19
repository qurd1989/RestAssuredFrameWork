package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import product.api.RestResouce;
import product.api.SpecBuilder;
import product.test.ResponseValidator;

import static io.restassured.RestAssured.given;


public class ProductStepDefs {
    private Response response;
RestResouce restResouce = new RestResouce();
    @When("I send a get reqwest to the API")
    public void i_send_a_get_reqwest_to_the_api() {
  response = RestResouce.sendGetRequest();
    }
    @Then("The  response should have valid data")
    public void the_response_should_have_valid_data() {
        ResponseValidator.validateResponse(response);
    }

}
