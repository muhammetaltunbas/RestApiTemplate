package Tests;

import petStore.Pet;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Base;
import java.io.IOException;

public class TestPet extends Base {
    public Pet cr = new Pet();

    @BeforeTest
    public void beforeTest() {
        initializeTest();
    }

    @Test
    public void insertPet() throws IOException {
       // cr.addPet();
    }


    @AfterTest
    public void printConsole() {
        System.out.println("Test Bitti");
    }
}
