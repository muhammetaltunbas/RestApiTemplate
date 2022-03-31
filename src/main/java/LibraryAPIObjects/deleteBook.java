package LibraryAPIObjects;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class deleteBook {
    public String deleteResponse;
    private static String resources = "Library/DeleteBook.php";

    public String deletePayload(String id) {
        return "{\n" +
                "    \"ID\": \"" + id + "\"\n" +
                "}";
    }

    public void deleteBook(String id)
    {
        deleteResponse=given().log().all().header("Content-Type", "application/json")
                .body(deletePayload(id))
                .when().post(resources)
                .then().log().all().assertThat().statusCode(200).body("msg", equalTo("book is successfully deleted")).extract()
                .response().asString();
    }
    public void verifyDeleted(String id)
    {

    }



}
