package MapAPIObjects;

import org.testng.Assert;
import resources.Base;
import resources.data;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class addPlace extends Base {

    public static String addApiResponse;
    getPlace gp = new getPlace();
    updatePlace up = new updatePlace();
    private String resources = "maps/api/place/add/json";

    public String addPlace() {
        return "{\n" +
                "    \"location\": {\n" +
                "        \"lat\": 41.02527193356345,\n" +
                "        \"lng\": 29.100695046035877\n" +
                "    },\n" +
                "    \"accuracy\": 10,\n" +
                "    \"name\": \"Ümraniye Kzn-2 Eczanesi\",\n" +
                "    \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "    \"address\": \"Ümraniye, Küçüksu Caddesi\",\n" +
                "    \"types\": [\n" +
                "        \"pharmacy\",\n" +
                "        \"shop\"\n" +
                "    ],\n" +
                "    \"website\": \"http://google.com\",\n" +
                "    \"language\": \"Turkish-IN\"\n" +
                "}";
    }

    public void addNewPlace() {
        addApiResponse = given().log().all().queryParam(data.param1, data.param2).header("Content-Type", "application/json")
                .body(addPlace())
                .when().post(resources)
                .then().log().all().assertThat().statusCode(200).body("status", equalTo("OK"))
                .header("Server", "Apache/2.4.41 (Ubuntu)")
                .extract()
                .response().asString();
    }

    public String getResponse() {
        return rawToJson(addApiResponse).get("place_id");
    }

    public void verifyAdding() {
        gp.checkData(getResponse());
    }

    public void updateAddress(String address) {
        up.update(getResponse(), address);
    }

    public void verifyUpdating(String address) {
        gp.checkData(getResponse());
        Assert.assertEquals(gp.verifyAddress(), address);
    }

}
