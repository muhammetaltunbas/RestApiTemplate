package Tests;

import ShippingAPIObjects.EAD;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resources.Base;

public class TestShipping extends Base {
    public EAD ead = new EAD();

    //db.getCollection('CalculatedCityToCityExpectedArrivalDate_V2').find({CargoFirm:2,SenderCity:'SİNOP',ReceiverCity:'AMASYA'})
    @BeforeTest
    public void beforeTest() {
        initializeTest();
    }

    @Test(dataProvider = "eadDataset")
    public void updateCityToCityEAD(int seller,String cargo,  String sender, String receiver, int day) {
        ead.cityToCityUpsert(seller,cargo, sender, receiver, day);
    }

    @AfterTest
    public void printConsole() {
        System.out.println("Test Bitti");
    }

    @DataProvider(name = "eadDataset")
    public Object[][] getData() {
        return new Object[][]{{2,"Aras Kargo", "SİNOP", "AMASYA", 1}};

    }


}

