package MapAPIObjects;


import resources.Base;
import resources.data;

import static io.restassured.RestAssured.given;

public class getPlace extends Base {
    String getApiResponse;
    private String resources = "maps/api/place/get/json";

    public void checkData(String placeId) {
        getApiResponse = given().log().all().queryParam(data.param1, data.param2).queryParam("place_id", placeId)
                .when().get(resources)
                .then().log().all().assertThat().statusCode(200).extract()
                .response().asString();
    }

    public String verifyAddress() {

        return rawToJson(getApiResponse).get("address");
    }


}
