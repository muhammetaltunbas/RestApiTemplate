package petStore;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
public class Test {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://petstore.swagger.io/";
          String test=   given().log().all().pathParam("id","19031341").header("Content-Type", "application/json")
                    .when().get("v2/pet/{id}")
                    .then().log().all().assertThat().statusCode(200)
                    .extract()
                    .response().asString();

          System.out.println(test);
    }
}
