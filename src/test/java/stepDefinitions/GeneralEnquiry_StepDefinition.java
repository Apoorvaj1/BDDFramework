package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import pageObjects.GeneralEnquiry_Page;
import utils.BrowserFactory;
import utils.ConfigReader;
import static utils.BrowserFactory.getDriver;

public class GeneralEnquiry_StepDefinition {

    @Given("User reaches to login page of NSW")
    public void user_reaches_to_login_page_of_nsw() {
        BrowserFactory.init(ConfigReader.readKey("browser").toLowerCase());
        getDriver().navigate().to(ConfigReader.readKey("NSW_URL"));
        String title = getDriver().getTitle();
        System.out.println("Title is "+title);
    }
    @When("User enter {string} as email id")
    public void user_enter_as_email_id(String string) {
        GeneralEnquiry_Page gep = PageFactory.initElements(getDriver(),GeneralEnquiry_Page.class);
        gep.enterEmail(string);
    }
    @When("Enter password as {string}")
    public void enter_password_as(String string) {
        GeneralEnquiry_Page gep = PageFactory.initElements(getDriver(),GeneralEnquiry_Page.class);
        gep.enterPassword(string);
    }
    @Then("User able to navigation to the home page")
    public void user_able_to_navigation_to_the_home_page() throws InterruptedException {
        GeneralEnquiry_Page gep = PageFactory.initElements(getDriver(),GeneralEnquiry_Page.class);
        gep.clickLoginBtn();
    }

    @When("User enter {string} and {string}")
    public void user_enter_and(String string, String string2) {
        GeneralEnquiry_Page gep = PageFactory.initElements(getDriver(),GeneralEnquiry_Page.class);
        gep.enterUserPass(string,string2);

    }

}
