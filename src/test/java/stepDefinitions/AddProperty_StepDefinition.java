package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageObjects.AddProperty_Page;
import pageObjects.GeneralEnquiry_Page;

import java.util.List;

import static utils.BrowserFactory.getDriver;

public class AddProperty_StepDefinition {



    @When("User clicks on My properties from left navigation pane")
    public void user_clicks_on_my_properties_from_left_navigation_pane() throws InterruptedException {
        AddProperty_Page app = new AddProperty_Page(getDriver());
        app.click_MyProperties();
    }
    @Then("User able to see Owned properties section")
    public void user_able_to_see_owned_properties_section() {
        AddProperty_Page app = new AddProperty_Page(getDriver());
        app.isOwnedPropertyDisplayed();

    }
    @When("User click on Add property button")
    public void user_click_on_add_property_button() throws InterruptedException {
       AddProperty_Page app = new AddProperty_Page(getDriver());
       app.click_AddPropertyButton();
    }
    @Then("Case will initiate")
    public void case_will_initiate() {
        System.out.println("Case will initiate");

    }
    @When("User enters the details from given sheetname {string} and rownumber {int}")
    public void user_enters_the_details_from_given_sheetname_and_rownumber(String string, Integer int1) {
        System.out.println(string);
        System.out.println(int1);
    }

    @When("Click on Submit_GeneralEnquiry")
    public void click_on_submit_general_enquiry() {
        System.out.println("Hello");
    }

    @Then("User able to see confirmation message")
    public void user_able_to_see_confirmation_message() {
        System.out.println("Hello");
    }
}
