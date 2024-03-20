package StepDefinition;

import Pages.RelatedActions;
import Pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SearchPageDefinitionOfSteps {
    WebDriver driver = null;
    Properties prop;
    String configPath = "configuration.properties";
    RelatedActions relatedActions = new RelatedActions();
    SearchPage searchPage = new SearchPage();
    @Given("user open browser")
    public void open() throws IOException {
        prop = new Properties();
        InputStream input = new FileInputStream(configPath);
        prop.load(input);

        switch (prop.getProperty("browser")){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }
        driver.manage().window().maximize();
    }

    @And("user navigates to Bing search engine")
    public void navigate_to_url() throws Exception {
        driver.navigate().to(relatedActions.readFile(0, 0));
    }

    @Then("enters keyword Vodafone in search input")
    public void enter_search_input() throws Exception {
        searchPage.SearchText(driver, relatedActions.readFile(1, 0));
    }

    @And("click search icon")
    public void click_search_icon(){
        searchPage.clickSearchIcon(driver);
    }
}
