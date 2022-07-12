package petStore;

import io.restassured.response.Response;
import resources.Base;

public class Pet extends Base {


    public Boolean nullCheckControl(Response response, String responseArea) {
        if (getJsonPath(response,responseArea) == null)
            return false;
        if (getJsonPath(response,responseArea) == "")
            return false;
        return true;
    }


}