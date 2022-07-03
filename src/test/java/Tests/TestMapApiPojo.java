package Tests;

import MapApiPojoClassStyle.AddPlaceWork;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Base;
import java.io.IOException;

public class TestMapApiPojo extends Base {
    AddPlaceWork addPlace = new AddPlaceWork();

    @BeforeTest
    public void beforeTest() {
        initializeTest();
    }

    @Test
    public void addNewPlace() throws IOException {
        addPlace.addNewPlace();
    }


    @AfterTest
    public void printConsole() {
        System.out.println("Test Bitti");
    }
}
