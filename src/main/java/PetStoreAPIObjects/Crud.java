package PetStoreAPIObjects;

import io.restassured.parsing.Parser;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Crud {
    protected static String resources = "v2/pet";
    public String insertPetResponse;

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


    public void insertPet() {
        /*insertPetResponse = given().log().all().header("Content-Type", "application/json")
                .body(insertPetPayload())
                .when().post(resources)
                .then().log().all().assertThat().statusCode(200).extract()
                .response().asString();*/
        Pet pet = given().log().all().header("Content-Type", "application/json")
                .body(insertPetPayload()).expect().defaultParser(Parser.JSON)
                .when().post(resources)
                .then().log().all().assertThat().statusCode(200).extract().response().as(Pet.class);
        // The above code says that, convert response of service to Pet Class object.

        System.out.println("Pet Name: " + pet.getName());
        System.out.println("Category Name: " + pet.getCategory().getName());

        List <Tags> tag = pet.getTags();
        for(int i=0;i<tag.size();i++)
        {
          if(tag.get(i).getName().equalsIgnoreCase("Tag-1"))
          {
              System.out.println("Id Of Tag: "+ tag.get(i).getId());
          }
        }


    }

}
