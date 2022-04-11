package ShippingAPIObjects;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.testng.Assert;
import resources.Base;
import resources.data;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

public class MPUpdateHighDeci extends Base {
    protected static String resources = "techops/update-merchant-deci-limit";
    public String deciUpdateResponse;
    public String checkMessage;
    public Boolean checkSuccess;
    public String updateMerchantDeciPaylaod(String merchant, int deci) {
        return "{\n" +
                "    \"merchantId\": \"" + merchant + "\",\n" +
                "    \"highDeciMinLimit\": \"" + deci + "\"\n" +
                "}";
    }

    public boolean updateMerchantDeci(String merchant, int deci) {
        deciUpdateResponse = given().header("Content-Type", "application/json")
                .body(updateMerchantDeciPaylaod(merchant, deci))
                .when().post(resources)
                .then()
                .extract()
                .response().asString();
        checkMessage = rawToJson(deciUpdateResponse).get("message");
        checkSuccess = rawToJson(deciUpdateResponse).getBoolean("success");
        if (checkMessage.contains("İşlem başarılı oldu") && checkSuccess)
            return true;
        else
            return false;

    }

    public void bulkProcess() throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(data.filePathMerchant));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withFirstRecordAsHeader()
                        .withIgnoreHeaderCase()
                        .withTrim())
        ) {
            for (CSVRecord csvRecord : csvParser) {
                String merchant = csvRecord.get(0);
                int deci = Integer.parseInt(csvRecord.get(1));
                if (updateMerchantDeci(merchant, deci))
                    System.out.println("Success: MerchantID: " + merchant + " Deci: " + deci);
                else
                    System.out.println("Failed!: MerchantID:  " + merchant + " Deci: " + deci + "- " + checkMessage);
            }
        }
    }
}
