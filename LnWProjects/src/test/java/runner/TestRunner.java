package runner;

import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import utils.CustomPageFactory;
import utils.WebDriverFactory;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps"}
        //dryRun = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

    private TestNGCucumberRunner testNGCucumberRunner;


    @BeforeClass
    public void setUp()  {
        WebDriver driver = WebDriverFactory.getDriver();
        CustomPageFactory pageFactory = new CustomPageFactory(driver);
        driver.get("https://www.amazon.com/");
    }

    @AfterClass
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }

}