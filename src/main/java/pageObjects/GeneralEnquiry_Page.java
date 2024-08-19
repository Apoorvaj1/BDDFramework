package pageObjects;

import CommonToAllPage.BaseClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.ConfigReader;

import java.util.List;

public class GeneralEnquiry_Page extends BaseClass {


    public GeneralEnquiry_Page(WebDriver driver){
        super(driver);
    }

    public static String ID;

    @FindBy(id="txtUserID")
    private WebElement email;

    @FindBy(id="txtPassword")
    private WebElement password;

    @FindBy(id="sub")
    private WebElement LoginBtn;

    @FindBy(xpath = "//span[@class=\"menu-item-title\"][normalize-space()=\"Submit a service request or enquiry\"]")
    WebElement option_Submit_a_SRandE;

    @FindBy(xpath = "//button[@class=\"Widget_button pzhc pzbutton\"][normalize-space()=\"General enquiry\"]")
    WebElement GeneralEnquiry_Button;

    By GeneralEnquiry_ID = By.xpath("//span[@class=\"case_title\"]");

    @FindBy(css = "input[id$=\"No\"]")
    WebElement No_radiobutton;

    @FindBy(css = "input[id$=\"Yes\"]")
    WebElement Yes_radiobutton;

    @FindBy(xpath = "//button[normalize-space()=\"Next\"]")
    WebElement Next_button;

    @FindBy(xpath = "//div[@id=\"cke_1_contents\"]/iframe")
    WebElement EnquiryDetail_TextField;

    @FindBy(xpath = "//button[normalize-space()=\"Submit\"]")
    WebElement Submit_Button;

    @FindBy(xpath = "//h2[normalize-space()=\"My workbaskets\"]")
    WebElement button_Myworkbaskets;

    @FindBy(xpath = "(//div[@class=\"header-left\"])[1]")
    WebElement collapse_Title;

    @FindBy(xpath="(//div[@class=\"header-left\"])[4]")
    WebElement collapse_RelatedCases;

    @FindBy(xpath = "//label[normalize-space()=\"Fulfill the request\"]")
    WebElement button_FullfillTheRequest;

    @FindBy(xpath = "//button[contains(text(),\"Proceed\")]")
    WebElement Proceed_button;

    @FindBy(xpath = "//input[@role=\"combobox\"][@placeholder=\"Please select a resolution reason\"]")
    WebElement multiselect_ResolutionReason;

    public void enterEmail(String email1){
        enterText(email,email1);
    }

    public void enterPassword(String pass){
        enterText(password,pass);
    }

    public void clickLoginBtn() throws InterruptedException {
        clickOnButton(LoginBtn);
        Thread.sleep(2000);
    }

    public void enterUserPass(String usern, String passw) throws InterruptedException {
        enterText(email,usern);
        enterText(password,passw);
        clickOnButton(LoginBtn);
        Thread.sleep(2000);
    }

    public void click_Submit_a_SR_and_Enquiry() throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(option_Submit_a_SRandE).build().perform();
        clickOnButton(option_Submit_a_SRandE);
        Thread.sleep(2000);
        action.moveToElement(GeneralEnquiry_Button).build().perform();
        Thread.sleep(2000);
    }

    public void click_GeneralEnquiry() throws InterruptedException {
        clickOnButton(GeneralEnquiry_Button);
        Thread.sleep(2000);
    }

    public void generalEnquiry_CaseID(){
        visibilityOfElement(GeneralEnquiry_ID);
        ID=driver.findElement(GeneralEnquiry_ID).getText();
        System.out.println("General Enquiry Case Id is "+ID);
    }

    public void click_No_Yes() throws InterruptedException {
        Thread.sleep(2000);
        if(ConfigReader.readKey("option").equals("No")){
            clickOnButton(No_radiobutton);
            clickOnButton(Next_button);
            Thread.sleep(2000);
        }
        if(ConfigReader.readKey("option").equals("Yes")){
            clickOnButton(Yes_radiobutton);
            clickOnButton(Next_button);
            Thread.sleep(2000);

        }
    }

    public void enter_EnquiryDetails() throws InterruptedException {
        if(ConfigReader.readKey("option").equals("No")){
            Thread.sleep(2000);
            driver.switchTo().frame(EnquiryDetail_TextField);
            driver.findElement(By.cssSelector("body p")).sendKeys("HEY");
            Thread.sleep(2000);
            driver.switchTo().defaultContent();
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].scrollIntoView(true);",Submit_Button);
            clickOnButton(Submit_Button);
        }
        if(ConfigReader.readKey("option").equals("Yes")){
            Thread.sleep(2000);
            driver.findElement(By.xpath("(//input[@class=\"checkbox chkBxCtl\"])[1]")).click();
            WebElement next_Button = driver.findElement(By.xpath("//button[contains(text(),\"Next\")]"));
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].scrollIntoView(true);",next_Button);
            next_Button.click();
            Thread.sleep(2000);
            js.executeScript("window.scrollBy(0,-1200)");
            Thread.sleep(2000);

            WebElement frame1 = driver.findElement(By.xpath("//div[@id=\"cke_1_contents\"]/iframe"));
            driver.switchTo().frame(frame1);
            driver.findElement(By.cssSelector("body p")).sendKeys(ConfigReader.readKey("comment_from_externalUser"));
            Thread.sleep(2000);
            driver.switchTo().defaultContent();
            clickOnButton(Submit_Button);

        }
    }

    public void get_GEConfirmationText() throws InterruptedException {
        Thread.sleep(7000);
        WebElement GE_CT = driver.findElement(By.cssSelector("div.content-item.content-label.item-1.remove-bottom-spacing.remove-top-spacing.remove-left-spacing.flex.flex-row.dataLabelRead"));
        String confirmation_Message = GE_CT.getText();
        System.out.println(confirmation_Message);
        if(confirmation_Message.contains("GENQ")){
            System.out.println("Yes Apoorv ID is present");
        }
        else{
            System.out.println("No Apoorv It's not present");
        }
    }

    public void click_MyWorkbaskets(){
        driver.switchTo().frame("PegaGadget0Ifr");
        clickOnButton(button_Myworkbaskets);

    }

    public void which_Workbasket() throws InterruptedException {
        Thread.sleep(2000);
        Select select = new Select(driver.findElement(By.xpath("//select[@title=\"ViewQueueFor\"]")));
        List<WebElement> list = select.getOptions();
        for(WebElement list1: list){
            System.out.println(list1.getText());
            if(list1.getText().equals(ConfigReader.readKey("worklist_option"))){
                list1.click();
                break;
            }
        }
    }

    public void verify_CaseIdAvailable() throws InterruptedException {
        String name = ID;
        Thread.sleep(5000);
        List<WebElement> case_ID = driver.findElements(By.xpath("//a[contains(text(),\"GENQ-\")]"));
        for(WebElement case_ID1:case_ID){
            if(case_ID1.getText().equals(name)){
                System.out.println("Case ID is available");
                System.out.println("CASE "+name);
                case_ID1.click();
                break;
            }
        }
        driver.switchTo().defaultContent();
    }

    public void enterAllDetails_GE() throws InterruptedException {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id=\"PegaGadget1Ifr\"]")));
        Thread.sleep(5000);
        clickOnButton(collapse_Title);
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1000)");
        clickOnButton(button_FullfillTheRequest);
        clickOnButton(Proceed_button);
        Thread.sleep(3000);
        clickOnButton(collapse_RelatedCases);
        clickOnTextField(multiselect_ResolutionReason);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).build().perform();
        Thread.sleep(2000);
        List<WebElement> resolutionReason_Options = driver.findElements(By.xpath("//ul[@role=\"listbox\"]/li/span"));
        for(WebElement options:resolutionReason_Options){
            String option = options.getText();
            Thread.sleep(2000);
            if(option.equals("Matter finalised") || option.equals("Matter finalised - customer no longer required assistance")){
                options.click();
            }
        }
        action.sendKeys(Keys.ESCAPE).build().perform();
        Thread.sleep(2000);
        WebElement finish_Button = driver.findElement(By.xpath("//button[normalize-space()=\"Finish\"]"));
        js.executeScript("arguments[0].scrollIntoView(true);",finish_Button);
        finish_Button.click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[normalize-space()=\"Yes\"]")).click();
        Thread.sleep(4000);
    }

}
