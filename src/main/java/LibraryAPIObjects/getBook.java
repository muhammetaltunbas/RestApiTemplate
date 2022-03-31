package LibraryAPIObjects;

import resources.data;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class getBook {

    private static String resources = "Library/GetBook.php";
    public String getResponse;

    public void getBook(String id) {
        getResponse = given().log().all().queryParam(data.param3, id)
                .when().get(resources)
                .then().log().all().assertThat().statusCode(404).body("msg", equalTo("The book by requested bookid / author name does not exists!")).extract()
                .response().asString();
    }

}
