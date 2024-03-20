package StepDefinition;

import Pages.RelatedActions;
import Pages.SecondPage;
import Pages.ThirdPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ThirdPageStepsOfDefinition {
    WebDriver driver = null;
    RelatedActions relatedActions = new RelatedActions();
    ThirdPage thirdPage = new ThirdPage();
    SecondPage secondPage = new SecondPage();
    Properties prop;
    String configPath = "configuration.properties";

    @And("Assert that age 3 is selected")
    public void assert_third_page(){
        Assert.assertEquals(relatedActions.pageNumber(driver,3).getCssValue("border-color"), "rgb(23, 74, 228)");
    }
    @And("Assert that results in page 3 is 10")
    public void assert_results(){
        relatedActions.action(relatedActions.pageNumber(driver,3));
        Assert.assertEquals(thirdPage.PageThreeResults(driver), 10);

    }

    @Then("Assert that second page results equals to third page results")
    public void assert_between_pages(){
        Assert.assertEquals(secondPage.PageTwoResults(driver), thirdPage.PageThreeResults(driver));
    }

    @And("close browser")
    public void close() throws IOException {
        prop = new Properties();
        InputStream input = new FileInputStream(configPath);
        prop.load(input);
        relatedActions.screenShots(driver, prop.getProperty("browser"));
        driver.close();
    }

}
