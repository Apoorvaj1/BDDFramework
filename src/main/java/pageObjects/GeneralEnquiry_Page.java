package pageObjects;

import CommonToAllPage.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utils.ConfigReader;

public class GeneralEnquiry_Page extends BaseClass {


    public GeneralEnquiry_Page(WebDriver driver){
        super(driver);
    }

    public String ID;

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
        ID = driver.findElement(GeneralEnquiry_ID).getText();
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
            driver.findElement(By.cssSelector("body p")).sendKeys("APOORV");
            Thread.sleep(2000);
            driver.switchTo().defaultContent();
            clickOnButton(Submit_Button);

        }
    }

    public void get_GEConfirmationText() throws InterruptedException {
        Thread.sleep(2000);
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

}
