package petStore;


import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.Base;
import resources.Data;

import static io.restassured.RestAssured.given;


public class Pet extends Base {
    protected static String resources = "v2/pet";
    public Data data = new Data();
    private RequestSpecification request;

    public String insertPetPayload() {
        return "{\n" +
                "  \"id\": 14530001,\n" +
                "  \"category\": {\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"Categor-1\"\n" +
                "    \n" +
                "  },\n" +
                "  \"name\": \"Pamuk-5\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"string\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 1,\n" +
                "      \"name\": \"Tag-1\"\n" +
                "    },\n" +
                "     {\n" +
                "      \"id\": 2,\n" +
                "      \"name\": \"Tag-2\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"available\"\n" +
                "}";
    }

    public void addPetPayload() {
        /*insertPetResponse = given().log().all().header("Content-Type", "application/json")
                .body(insertPetPayload())
                .when().post(resources)
                .then().log().all().assertThat().statusCode(200).extract()
                .response().asString();*/
        request = given().spec(getCommonReq()).body(data.setMethodsForAddPet());
    }

    public Response executeAddPetApi() {
        //return request.when().post(resources).then().spec(getCommonRes()).extract().response().as(PetPayload.class);
        return request.when().post(resources).then().spec(getCommonRes()).extract().response();
    }

    public Boolean nullCheckControl(String responseArea) {
        String res = executeAddPetApi().asString();
        //System.out.println(rawToJson(res).get(responseArea).toString());
        //return rawToJson(res).get(responseArea).toString();
        if (rawToJson(res).get(responseArea) == null)
            return false;
        if (rawToJson(res).get(responseArea) == "")
            return false;
        return true;
    }


}
