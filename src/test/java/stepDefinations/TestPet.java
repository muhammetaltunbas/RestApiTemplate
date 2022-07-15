package stepDefinations;

import io.cucumber.java.en.And;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import resources.ApiResources;
import resources.Data;

import java.io.IOException;

import static io.restassured.RestAssured.given;


public class TestPet extends Utility {
    public static int idOfPet;
    public static RequestSpecification request;
    public static Response response;
    public static ApiResources resourceApi;
    public Data data = new Data();

    @Given("Prepare addPetAPI payload with {int} {string} {string}")
    public void prepare_add_pet_api_payload_with(Integer id, String categoryName, String name) throws IOException {
        request = given().spec(getCommonReq()).body(data.setMethodsForAddPet(id, categoryName, name));
    }

    @When("User calls {string} with {string} https request")
    public void user_calls_with_https_request(String resource, String method) {
        executeApi(resource, method);

    }

    @Then("The api call gets success with status code {int}")
    public void the_api_call_gets_success_with_status_code(Integer responseCode) {
        Assert.assertEquals(response.getStatusCode(), responseCode);
    }

    @Then("Verify in response body {string} area is not null")
    public void verify_in_response_body_area_is_not_null(String area) {
        Assert.assertTrue(nullCheckControl(response, area));
    }

    @Then("Verify in response body {string} area is {string}")
    public void verify_in_response_body_area_is(String area, String value) {
        Assert.assertEquals(getJsonPath(response, area), value);
    }

    @And("Verify {string} is proper using {string}")
    public void verify_is_proper_using(String expectedArea, String resources) throws IOException {
        //Burada bir refactoring yap. "name" dışında başka alanlarda da çalışması gerekiyor.
        idOfPet = Integer.parseInt(getJsonPath(response, "id"));
        request = given().spec(getCommonReq()).pathParam("id", idOfPet);
        user_calls_with_https_request(resources, "GET");// Yandaki komut'da aynı işlemi yapar => executeApi(resources,"GET");
        String actualName = getJsonPath(response, "name");
        Assert.assertEquals(actualName, expectedArea);

    }

    @Given("Prepare updatePetAPI payload with {string}")
    public void prepare_update_pet_api_payload_with(String petName) throws IOException {
        request = given().spec(getCommonReq()).body(data.setMethodsForUpdatePet(idOfPet, petName));
    }

    @Given("Prepare deletePetAPI payload")
    public void prepare_delete_pet_api_payload() throws IOException {
        request = given().spec(getCommonReq()).pathParam("id", idOfPet);

    }

    @Then("Verify in response body {string} area is {int}")
    public void verify_in_response_body_area_is(String area, Integer intValue) {
        Assert.assertEquals(Integer.parseInt(getJsonPath(response, area)), intValue);
    }

    @Given("Prepare updatePetMethod2 payload with {string} and {string}")
    public void prepare_update_pet_method2_payload_with_and(String name, String status) throws IOException {
        // Bu yöntem ile log dosyasına log atamıyoruz. Requesti reqSpec ile tanımlayıp,Base class'tan almaya çalış.
        request = given().pathParam("id", idOfPet)
                .baseUri(getGlobalValue("baseUri"))
                .formParam("name", name)
                .formParam("status", status);


    }


}