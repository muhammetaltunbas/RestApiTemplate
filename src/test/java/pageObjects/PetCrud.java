package pageObjects;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.ApiResources;
import resources.Base;
import resources.Data;

public class PetCrud extends Base {

    public static int idOfPet;
    public static RequestSpecification request;
    public static Response response;
    public static ApiResources resourceApi;
    public Data data = new Data();


    public PetCrud(RequestSpecification request, Response response) {
        this.response = response;
        this.request = request;
    }




}
