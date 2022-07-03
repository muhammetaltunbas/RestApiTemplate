package stepDefinations;

import petStore.Pet;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import resources.Base;

import java.io.FileNotFoundException;

public class TestAddPet extends Base {
    Pet pet = new Pet();

    @Given("Add pet payload")
    public void add_pet_payload() throws FileNotFoundException {
        pet.addPetPayload();

    }
    @When("User calls {string} with post https request")
    public void user_calls_with_post_https_request(String string) {
        pet.executeAddPetApi();

    }
    @Then("The api call gets success with status code {int}")
    public void the_api_call_gets_success_with_status_code(Integer responseCode) {
        Assert.assertEquals(pet.executeAddPetApi().getStatusCode(),responseCode);
        //Aşağıdaki jUnit assertion'ı.
        //assertEquals();
    }
    @Then("Verify in response body {string} area is not null")
    public void verify_in_response_body_area_is_not_null(String area) {
        Assert.assertTrue(pet.nullCheckControl(area));
    }
}
