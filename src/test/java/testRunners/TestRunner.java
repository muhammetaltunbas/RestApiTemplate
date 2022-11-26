package testRunners;

import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features",plugin ="json:target/jsonReports/cucumber-report.json",glue = {"stepDefinations"})
public class TestRunner extends AbstractTestNGCucumberTests {
//tags= "@DeletePet" : Eğer sadece bu tag'e sahip senaryoyu çalıştırmak istersen bu komutu @CucumberOptions'a ilave et.
}