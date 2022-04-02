package resources;

public class data {
    public static final String param1 = "key";
    public static final String param2 = "qaclick123";
    public static final String param3 = "ID";
    public static final String demoBaseUri = "https://rahulshettyacademy.com";
    public static final String demo2BaseUri = "http://216.10.245.166";
    public static final String baseUri = "http://shipping.qa.hepsiburada.com";
    public static int expectedStatus = 200;
    public static final String filePath = "./CalculatedCityToCityExpectedArrivalDate_V2.csv";

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

}
