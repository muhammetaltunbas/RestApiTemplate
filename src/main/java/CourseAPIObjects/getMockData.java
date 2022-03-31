package CourseAPIObjects;

import org.testng.Assert;
import resources.Base;
import resources.data;

public class getMockData extends Base {


    public int courseCount() {
        return rawToJson(data.mockData()).getInt("courses.size()");
    }

    public int purchaseAmount() {
        return rawToJson(data.mockData()).getInt("dashboard.purchaseAmount");
    }

    public String titleOfCourse(int i) {
        return rawToJson(data.mockData()).get("courses.title[" + i + "]");
    }

    public int priceOfCourse(int i) {
        return rawToJson(data.mockData()).get("courses.price[" + i + "]");
    }

    public int copiesOfCourse(int i) {
        return rawToJson(data.mockData()).get("courses.copies[" + i + "]");
    }


    public void printTitleAndPrices() {
        for (int i = 0; i < courseCount(); i++) {
            System.out.println(i + ": Title: " + titleOfCourse(i) + "- Price: " + priceOfCourse(i));
        }
    }

    public void copiesOfCourse(String course) {

        for (int i = 0; i < courseCount(); i++) {
            if (titleOfCourse(i).equalsIgnoreCase(course)) {
                System.out.println(course + ": Copies: " + copiesOfCourse(i));
                break;
            }
            if (i == courseCount() - 1)
                System.out.println("There is no such a course");
        }
    }

    public void verifyAmount() {
        int sum = 0;
        for (int i = 0; i < courseCount(); i++) {
            sum += priceOfCourse(i) * copiesOfCourse(i);
        }
        Assert.assertEquals(sum, purchaseAmount());
        System.out.println("Total Price Of Course (Price*Copies): "+sum+" Purchase Amount: "+purchaseAmount());

    }


}

