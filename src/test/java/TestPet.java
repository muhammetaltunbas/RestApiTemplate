import PetStoreAPIObjects.Crud;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Base;

import java.io.IOException;

public class TestPet extends Base {
    public Crud cr= new Crud();
    @BeforeTest
    public void beforeTest() {
        initializeTest();
    }

    @Test
    public void insertPet() throws IOException {
        cr.insertPet();
    }


    @AfterTest
    public void printConsole() {
        System.out.println("Test Bitti");
    }
}
