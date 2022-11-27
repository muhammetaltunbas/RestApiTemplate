package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor;
import org.testng.Assert;
import petStore.OrderPetPayload;
import resources.ApiResources;
import resources.Base;
import resources.Data;

import java.io.IOException;

import static io.restassured.RestAssured.given;


public class TestOrder extends Base {
    public static RequestSpecification request;
    public static Response response;
    public static ApiResources resourceApi;
    public Data data = new Data();

    @Given("Prepare createOrder payload with {int} {int} {int}")
    public void prepare_add_pet_api_payload_with(Integer orderId, int petId, int quantity) throws IOException {
        request = given().spec(getCommonReq()).body(data.setMethodsForCreateOrder(orderId, petId, quantity));
    }

    @When("User runs {string} with {string} https request")
    public void user_calls_with_https_request(String resource, String method) {
        executeApiForOrder(resource, method);
    }

    @Then("Verify if status code is equal {int}")
    public void verify_if_status_code_is_equal(int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode);
    }
    @Then("Verify in response body {string} area is not null for order")
    public void verify_in_response_body_area_is_not_null_for_order(String area) {
        Assert.assertTrue(nullCheckControl(response, area));
    }
    @And("Verify in response body {string} area is {string} for order")
    public void verify_in_response_body_area_is_for_order(String area, String value) {
        Assert.assertEquals(getJsonPath(response, area), value);
    }


}