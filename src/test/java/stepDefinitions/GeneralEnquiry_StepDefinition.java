package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
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
        Assert.assertEquals("NSW Valnet Portal",title);
    }
    @When("User enter {string} as email id")
    public void user_enter_as_email_id(String string) {
        GeneralEnquiry_Page gep = new GeneralEnquiry_Page(getDriver());
        gep.enterEmail(string);
    }
    @When("Enter password as {string}")
    public void enter_password_as(String string) {
        GeneralEnquiry_Page gep = new GeneralEnquiry_Page(getDriver());
        gep.enterPassword(string);
    }

    @When("Click on Submit")
    public void click_on_submit() throws InterruptedException {
        GeneralEnquiry_Page gpp = new GeneralEnquiry_Page(getDriver());
        gpp.clickLoginBtn();

    }
    @Then("User able to navigation to the home page")
    public void user_able_to_navigation_to_the_home_page() {
            String actual_title = getDriver().getTitle();
            System.out.println("Home Page Title is "+actual_title);
        }

    @When("User enter {string} and {string}")
    public void user_enter_and(String string, String string2) throws InterruptedException {
        GeneralEnquiry_Page gep = new GeneralEnquiry_Page(getDriver());
        gep.enterUserPass(string,string2);

    }

    @When("User clicks on Submit a service request or enquiry option")
    public void user_clicks_on_submit_a_service_request_or_enquiry_option() throws InterruptedException {
        GeneralEnquiry_Page gep = new GeneralEnquiry_Page(getDriver());
        gep.click_Submit_a_SR_and_Enquiry();
    }
    @When("Click on GeneralEnquiry button")
    public void click_on_general_enquiry_button() throws InterruptedException {
        GeneralEnquiry_Page gep = new GeneralEnquiry_Page(getDriver());
        gep.click_GeneralEnquiry();
    }
    @Then("GeneralEnquiry case will initiate")
    public void general_enquiry_case_will_initiate() {
        GeneralEnquiry_Page gep = new GeneralEnquiry_Page(getDriver());
        gep.generalEnquiry_CaseID();

    }
    @When("User enters selects No")
    public void user_enters_selects_no() throws InterruptedException {
        GeneralEnquiry_Page gep = new GeneralEnquiry_Page(getDriver());
        gep.click_No();
    }
    @When("Enter all the details")
    public void enter_all_the_details() throws InterruptedException {
        GeneralEnquiry_Page gep = new GeneralEnquiry_Page(getDriver());
        gep.enter_EnquiryDetails();
    }
    @Then("Confirmation text will display")
    public void confirmation_text_will_display() throws InterruptedException {
        GeneralEnquiry_Page gep = new GeneralEnquiry_Page(getDriver());
        gep.get_GEConfirmationText();
    }


}
