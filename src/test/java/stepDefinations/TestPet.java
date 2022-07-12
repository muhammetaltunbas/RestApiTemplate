package stepDefinations;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import petStore.Pet;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import resources.ApiResources;
import resources.Base;
import resources.Data;

import java.io.IOException;

import static io.restassured.RestAssured.given;


public class TestPet extends Base {
    Data data = new Data();
    Pet pet = new Pet();
    RequestSpecification request;
    Response response;
    private int idOfPet;

    @Given("Prepare addPet payload with {int} {string} {string}")
    public void prepare_addPet_payload_with(Integer id, String categoryName, String name) throws IOException {
        request = given().spec(getCommonReq()).body(data.setMethodsForAddPet(id, categoryName, name));

    }

    @When("User calls {string} with {string} https request")
    public void user_calls_with_https_request(String resource, String method) {
        // Constructor (inside of ApiResources enum) will be called with value of resource which you pass
        ApiResources resourceApi = ApiResources.valueOf(resource);

        if (method.equalsIgnoreCase("POST"))
            response = request.when().post(resourceApi.getResources());
        else if (method.equalsIgnoreCase("GET"))
            response = request.when().get(resourceApi.getResources());

    }

    @Then("The api call gets success with status code {int}")
    public void the_api_call_gets_success_with_status_code(Integer responseCode) {
        Assert.assertEquals(response.getStatusCode(), responseCode);
    }

    @Then("Verify in response body {string} area is not null")
    public void verify_in_response_body_area_is_not_null(String area) {
        Assert.assertTrue(pet.nullCheckControl(response, area));
    }

    @Then("Verify {string} is proper using {string}")
    public void verify_is_proper_using(String area, String resources) throws IOException {

        idOfPet = Integer.parseInt(getJsonPath(response, "id"));//get id value from addGetApi response
        request = given().spec(getCommonReq()).pathParam("id", idOfPet);
        user_calls_with_https_request(resources, "GET");
        String actualName = getJsonPath(response, "name");
        Assert.assertEquals(actualName, area);


    }
}