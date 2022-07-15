package stepDefinations;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.ApiResources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class Utility {

    public static RequestSpecification req;
    PrintStream log;

    public static String getGlobalValue(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "//src//main//java//resources//globalData.properties");
        prop.load(fis);
        return prop.getProperty(key);
    }

    public Boolean nullCheckControl(Response response, String responseArea) {
        if (getJsonPath(response, responseArea) == null)
            return false;
        if (getJsonPath(response, responseArea) == "")
            return false;
        return true;
    }

    public String getJsonPath(Response response, String key) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
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

    public void executeApi(String resource, String method) {
        // Constructor (inside of ApiResources enum) will be called with value of resource which you pass
        TestPet.resourceApi = ApiResources.valueOf(resource);
        if (method.equalsIgnoreCase("POST"))
            TestPet.response = TestPet.request.when().post(TestPet.resourceApi.getResources());
        else if (method.equalsIgnoreCase("GET"))
            TestPet.response = TestPet.request.when().get(TestPet.resourceApi.getResources());
        else if (method.equalsIgnoreCase("PUT"))
            TestPet.response = TestPet.request.when().put(TestPet.resourceApi.getResources());
        else if (method.equalsIgnoreCase("DELETE")) {
            TestPet.response = TestPet.request.when().delete(TestPet.resourceApi.getResources());
            TestPet.idOfPet = 0;
        }
    }
}
