package Tests;

import ShippingAPIObjects.MPUpdateHighDeci;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Base;

import java.io.IOException;


public class TestBulkMPHighDeci extends Base {
    public MPUpdateHighDeci mpu = new MPUpdateHighDeci();

    @BeforeTest
    public void beforeTest() {
        initializeTest();
    }

    @Test
    public void startBulkProcess() throws IOException {
        mpu.bulkProcess();
    }
    //Next step is: Verify on DB

    @AfterTest
    public void printConsole() {
        System.out.println("Test Bitti");
    }

}
