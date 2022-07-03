package resources;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class Base {

    public JsonPath rawToJson(String response) {
        JsonPath js = new JsonPath(response);
        return js;
    }

    public void initializeTest() {
        RestAssured.baseURI = Data.baseUri;
    }

    public RequestSpecification getCommonReq() {
        return new RequestSpecBuilder().setBaseUri(Data.baseUri)
                .addHeader("Content-Type", "application/json")
                .setContentType(ContentType.JSON).build();
    }

    public ResponseSpecification getCommonRes() {
        return new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
    }



}
