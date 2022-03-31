package LibraryAPIObjects;

import resources.Base;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class addBook extends Base {
    public String addBookApiResponse;
    private static String resources = "Library/Addbook.php";

    public String addPayload(String name,String id1,String id2,String author) {
        return "{\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"isbn\": \""+id1+"\",\n" +
                "    \"aisle\": \""+id2+"\",\n" +
                "    \"author\": \""+author+"\"\n" +
                "}";
    }

    public void addNewBook(String name,String id1,String id2,String author) {
        addBookApiResponse = given().log().all().header("Content-Type", "application/json")
                .body(addPayload(name,id1,id2,author))
                .when().post(resources)
                .then().log().all().assertThat().statusCode(200).body("Msg", equalTo("successfully added")).extract()
                .response().asString();
    }

    public String getResponse() {
        return rawToJson(addBookApiResponse).get("ID");
    }

}
