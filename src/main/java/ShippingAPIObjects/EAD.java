package ShippingAPIObjects;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import resources.data;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class EAD {
    protected static String resources = "api/v1/EstimatedArrivalDate/city-to-city/upsert";

    public String cityToCityUpsertResponse;

    public String cityToCityUpsertPayload(int seller,String cargo,String sender, String receiver, int day) {
        return "{\n" +
                "  \"eadInfos\": [\n" +
                "    {\n" +
                "    \"cargoFirm\": \"" + cargo + "\",\n" +
                "    \"seller\": \"" + seller + "\",\n" +
                "    \"senderCity\": \"" + sender + "\",\n" +
                "    \"receiverCity\": \"" + receiver + "\",\n" +
                "    \"expectedDays\": \"" + day + "\",\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }

    public void cityToCityUpsert(int seller,String cargo,String sender, String receiver, int day) {
        cityToCityUpsertResponse = given().log().all().header("Content-Type", "application/json")
                .body(cityToCityUpsertPayload(seller,cargo,sender,receiver,day))
                .when().post(resources)
                .then().log().all().assertThat().statusCode(200).body("success", equalTo(true)).extract()
                .response().asString();
    }
    public void bulkProcess() throws IOException
    {
        //This method adds data from csv to CalculatedCityToCityExpectedArrivalDate_V2 collection as bulk
        try (
                Reader reader = Files.newBufferedReader(Paths.get(data.filePath));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withFirstRecordAsHeader()
                        .withIgnoreHeaderCase()
                        .withTrim())
        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                int seller = Integer.parseInt(csvRecord.get(0));
                String cargo = csvRecord.get(1);
                String sender = csvRecord.get(2);
                String receiver = csvRecord.get(3);
                int day = Integer.parseInt(csvRecord.get(4));
                cityToCityUpsert(seller, cargo, sender, receiver, day);
                //System.out.println("Record No - " + csvRecord.getRecordNumber());
            }
        }
    }
}
