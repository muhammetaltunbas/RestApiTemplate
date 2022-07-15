package stepDefinations;

import io.cucumber.java.Before;
import resources.ApiResources;

import java.io.IOException;

public class Hooks {
    TestPet t = new TestPet();

    @Before("@UpdatePetMethod2")
    public void beforeUpdateScenario() throws IOException {

        if (TestPet.idOfPet == 0) {
            t.prepare_add_pet_api_payload_with(10000071, "Kuş", "Name is from Hooks");
            t.user_calls_with_https_request("addPetAPI", "POST");
            t.verify_is_proper_using("Name is from Hooks", "getPetAPI");

        }
    }






}
