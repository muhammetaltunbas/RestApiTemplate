package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import stepDefinations.TestOrder;
import stepDefinations.TestPet;

import java.io.*;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class Base {

    public static RequestSpecification req;
    public static PrintStream log;

    static {
        try {
            log = new PrintStream(new FileOutputStream("logging.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String getGlobalValue(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "//src//test//java//resources//globalData.properties");
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
            req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUri"))
                    .addHeader("Content-Type", "application/json")
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON).build();
            return req;
        }
        return req;

    }

   /* public ResponseSpecification getCommonRes() {
        return new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
    }*/

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

    public void executeApiForOrder(String resource, String method) {
        TestOrder.resourceApi = ApiResources.valueOf(resource);
        if (method.equalsIgnoreCase("POST"))
            TestOrder.response = TestOrder.request.when().post(TestOrder.resourceApi.getResources());
        else if (method.equalsIgnoreCase("GET"))
            TestOrder.response = TestOrder.request.when().post(TestOrder.resourceApi.getResources());
    }


    public String checkAreaUsingAPI(String resources) throws IOException {
        TestPet.idOfPet = Integer.parseInt(getJsonPath(TestPet.response, "id"));
        TestPet.request = given().spec(getCommonReq()).pathParam("id", TestPet.idOfPet);// GET Request
        executeApi(resources, "GET");
        return getJsonPath(TestPet.response, "name");

    }

}
