package resources;

import petStore.Category;
import petStore.PetPayload;
import petStore.Tags;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static final String param1 = "key";
    public static final String param2 = "qaclick123";
    public static final String param3 = "ID";
    public static final String demo2BaseUri = "http://216.10.245.166";
    public static final String filePath = "./CalculatedCityToCityExpectedArrivalDate_V2.csv";
    public static final String filePathMerchant = "./merchantDeci.csv";
    //public static final String baseUri = "https://rahulshettyacademy.com";
    public static final String baseUri = "https://petstore.swagger.io/";
    //public static final String baseUri = "http://shipping.qa.hepsiburada.com";
    //public static final String baseUri = "http://shipping-ops.hepsiburada.com";
    //public static final String baseUri = "http://shipping-ops.qa.hepsiburada.com";
    public static int expectedStatus = 200;
    public static String mockData() {
        return "{\n" +
                "  \"dashboard\": {\n" +
                "    \"purchaseAmount\": 910,\n" +
                "    \"website\": \"muhammetaltunbas.com\"\n" +
                "  },\n" +
                "  \"courses\": [\n" +
                "    {\n" +
                "      \"title\": \"Selenium Python\",\n" +
                "      \"price\": 50,\n" +
                "      \"copies\": 6\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"Cypress\",\n" +
                "      \"price\": 40,\n" +
                "      \"copies\": 4\n" +
                "    },\n" +
                "    {\n" +
                "      \"title\": \"RPA\",\n" +
                "      \"price\": 45,\n" +
                "      \"copies\": 10\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }

    Category cgr = new Category();
    Tags tg = new Tags();
    PetPayload petPayload = new PetPayload();
    List<String> photoList = new ArrayList<String>();
    List<Tags> tag = new ArrayList<Tags>();

    public PetPayload setMethodsForAddPet() {
        petPayload.setId(19030000);

        cgr.setId(1);
        cgr.setName("Kuş");
        petPayload.setCategory(cgr);

        petPayload.setName("Kara Kartal-1");

        photoList.add("https://images.app.goo.gl/sa9kMb9HEjnt1wox7");
        petPayload.setPhotoUrls(photoList);
        //Burada birden fazla tag nasıl göndereceğiz bunu düşün!
        tg.setId(1);
        tg.setName("Tag-1");
        tag.add(tg);
        petPayload.setTags(tag);

        petPayload.setStatus("Mevcut");
        return petPayload;
    }


}
