package Tests;

import LibraryAPIObjects.addBook;
import LibraryAPIObjects.deleteBook;
import LibraryAPIObjects.getBook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resources.Base;

public class TestLibrary extends Base {
    public addBook add = new addBook();
    public deleteBook del = new deleteBook();
    public getBook get = new getBook();

    @BeforeTest
    public void beforeTest() {
        initializeTest();
    }

    @Test(dataProvider = "bookData")
    public void addBookAndGetId(String name, String id1, String id2, String author) {
        add.addNewBook(name, id1, id2, author);
        System.out.println("ID: " + add.getResponse());
    }

    @Test(dataProvider = "bookData")
    public void deleteBook(String name, String id1, String id2, String author) {
        String id = id1 + id2;
        del.deleteBook(id);
        get.getBook(id);//to verify if data is deleted or not.
    }

    @AfterTest
    public void printConsole() {
        System.out.println("Test Bitti");
    }

    @DataProvider(name = "bookData")
    public Object[][] getData() {
        return new String[][]{{"Kayı II", "Code", "0008", "Ahmet Bey"}, {"Kayı II", "Code", "0009", "Ahmet Bey"}, {"Kayı II", "Code", "0010", "Ahmet Bey"}};

    }


}

