package stepDefinations;

import io.cucumber.java.Before;
import resources.ApiResources;

import java.io.IOException;

public class Hooks {
    public TestPet t = new TestPet();

    @Before("@UpdatePet")
    public void beforeUpdateScenario() throws IOException {

        if (TestPet.idOfPet == 0) {
            t.prepare_add_pet_api_payload_with(10711923, "Kuş is From Hooks class", "Name is from Hooks class");
            t.user_calls_with_https_request("addPetAPI", "POST");
            t.verify_is_proper_using("Name is from Hooks class", "getPetAPI");

        }
    }






}
