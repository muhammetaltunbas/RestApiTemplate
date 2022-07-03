package resources;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;


public class Base {
    PrintStream log;

    public JsonPath rawToJson(String response) {
        JsonPath js = new JsonPath(response);
        return js;
    }

    public void initializeTest() {
        RestAssured.baseURI = Data.baseUri;
    }

    public RequestSpecification getCommonReq() throws FileNotFoundException {
        log = new PrintStream(new FileOutputStream("logging.txt"));
        return new RequestSpecBuilder().setBaseUri(Data.baseUri)
                .addHeader("Content-Type", "application/json")
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setContentType(ContentType.JSON).build();
    }

    public ResponseSpecification getCommonRes() {
        return new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
    }


}
