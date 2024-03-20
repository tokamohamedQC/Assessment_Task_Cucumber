package StepDefinition;

import Pages.RelatedActions;
import Pages.SearchPage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

public class FirstPageStepsOfDefinition {
    WebDriver driver = null;
    RelatedActions relatedActions = new RelatedActions();
    @Then("user scrolls down to pagination and select 2 in pagination")
    public void select_page(){
        relatedActions.action(relatedActions.pageNumber(driver,2));
    }

}
