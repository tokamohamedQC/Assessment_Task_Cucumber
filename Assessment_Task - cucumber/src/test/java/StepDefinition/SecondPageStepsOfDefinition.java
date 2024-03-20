package StepDefinition;

import Pages.RelatedActions;
import Pages.SecondPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecondPageStepsOfDefinition {
    WebDriver driver = null;
    RelatedActions relatedActions = new RelatedActions();
    SecondPage secondPage = new SecondPage();
    WebDriverWait wait = new WebDriverWait(driver,10);

    @And("Assert that age 2 is selected")
    public void assert_second_page(){
        Assert.assertEquals(relatedActions.pageNumber(driver,2).getCssValue("border-color"), "rgb(23, 74, 228)");
    }
    @And("Assert that results in page 2 is 10")
    public void assert_results(){
        relatedActions.action(relatedActions.pageNumber(driver,2));
        Assert.assertEquals(secondPage.PageTwoResults(driver), 10);

    }

    @Then("user scroll down to pagination and select 3 in pagination")
    public void select_third_page(){
        try {
            wait.until(ExpectedConditions.visibilityOf(relatedActions.pageNumber(driver, 3)));
        }catch (StaleElementReferenceException e){}
        relatedActions.action(relatedActions.pageNumber(driver,3));

    }

}
