package Tests;

import CourseAPIObjects.getMockData;
import MapAPIObjects.addPlace;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.Base;

public class TestCourse extends Base {

    public getMockData gd = new getMockData();

    @Test(priority = 0)
    public void printNumOfCourses() {
        System.out.println("Course Count: " + gd.courseCount());
    }

    @Test(priority = 1)
    public void printPurchaseAmount() {
        System.out.println("Purchase Amount: " + gd.purchaseAmount());
    }

    @Test(priority = 2)
    public void printTitleOfFirstCourse() {
        // 0: represents first title of course
        System.out.println("Title: " + gd.titleOfCourse(0));
    }

    @Test(priority = 3)
    public void printAllCourseTitlesWithTheirPrices() {
        gd.printTitleAndPrices();
    }

    @Test(priority = 4)
    public void printCourseCopies() {
        gd.copiesOfCourse("RPA");
    }

    @Test(priority = 4)
    public void verifyTotalCoursePricesAndPurchaseAmountIsEqual() {
        gd.verifyAmount();

    }

    @AfterTest
    public void printConsole() {
        System.out.println("Test Bitti");
    }

}
