package MapAPIObjects;

import resources.data;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class updatePlace {
    private String resources = "maps/api/place/update/json";

    public void update(String placeId, String newAddress) {

        given().log().all().queryParam(data.param1, data.param2).header("Content-Type", "application/json")
                .body(updatePlaceBody(placeId, newAddress)).when().put(resources).then().log()
                .all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
    }

    public String updatePlaceBody(String placeId, String address) {
        return "{\r\n" +
                "\"place_id\":\"" + placeId + "\",\r\n" +
                "\"address\":\"" + address + "\",\r\n"
                + "\"key\":\"qaclick123\"\r\n" + "}";
    }
}
