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

import java.io.*;
import java.util.Properties;


public class Base {
    public static RequestSpecification req;
    PrintStream log;

    public static String getGlobalValue(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "//src//main//java//resources//globalData.properties");
        prop.load(fis);
        return prop.getProperty(key);
    }

    public JsonPath rawToJson(String response) {
        JsonPath js = new JsonPath(response);
        return js;
    }

    public RequestSpecification getCommonReq() throws IOException {
        if (req == null) {
            log = new PrintStream(new FileOutputStream("logging.txt"));
            req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUri"))
                    .addHeader("Content-Type", "application/json")
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON).build();
            return req;
        }
        return req;

    }

    public ResponseSpecification getCommonRes() {
        return new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
    }


}
