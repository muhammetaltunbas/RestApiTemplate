package Tests;

import MapAPIObjects.addPlace;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Base;

public class TestPlace extends Base {

    public addPlace add = new addPlace();

    @BeforeTest
    public void beforeTest() {
        initializeTest();
    }

    @Test(priority = 0)
    public void addPlace() {
        add.addNewPlace();
        add.verifyAdding();
    }
    /* @Test(priority = 1)
     public void addMultiplePlace() {
         //..
     }*/
    @Test(priority = 1)
    public void updatePlace() {
        add.updateAddress("Ümraniye/Ist/Turkey");
        add.verifyUpdating("Ümraniye/Ist/Turkey");
    }

    @Test(priority = 2)
    public void deletePlace() {
        //..
    }

    @AfterTest
    public void printConsole() {
        System.out.println("Test Bitti");
    }

}
