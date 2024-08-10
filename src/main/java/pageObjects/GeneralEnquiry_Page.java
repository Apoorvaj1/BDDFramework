package pageObjects;

import CommonToAllPage.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GeneralEnquiry_Page extends BaseClass {


    public GeneralEnquiry_Page(WebDriver driver){
        super(driver);
    }

    @FindBy(id="txtUserID")
    private WebElement email;

    @FindBy(id="txtPassword")
    private WebElement password;

    @FindBy(id="sub")
    private WebElement LoginBtn;

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

}
