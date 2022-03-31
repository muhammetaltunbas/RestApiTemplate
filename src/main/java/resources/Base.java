package resources;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class Base {


    public JsonPath rawToJson(String response) {
        JsonPath js = new JsonPath(response);
        return js;

    }

    public void initializeTest() {
        RestAssured.baseURI = data.baseUri;
    }


}
