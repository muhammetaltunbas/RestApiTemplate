package Tests;

import ShippingAPIObjects.EAD;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Base;

import java.io.IOException;


public class TestBulkEad extends Base {
    public EAD ead = new EAD();

    @BeforeTest
    public void beforeTest() {
        initializeTest();
    }

    @Test
    public void startBulkProcess() throws IOException {
        ead.bulkProcess();
    }
    @Test
    public void verifyProcessOnDatabase() throws IOException {
        // i need to access mongo db.

    }


    @AfterTest
    public void printConsole() {
        System.out.println("Test Bitti");
    }

}
