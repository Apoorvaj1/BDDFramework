package pageObjects;

import CommonToAllPage.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GeneralEnquiry_Page extends BaseClass {

    WebDriver driver;

    public GeneralEnquiry_Page(WebDriver ldriver){
        this.driver = ldriver;
    }

    @FindBy(id="txtUserID")
    WebElement email;

    @FindBy(id="txtPassword")
    WebElement password;

    @FindBy(id="sub")
    WebElement LoginBtn;

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

    public void enterUserPass(String usern, String passw){
        enterText(email,usern);
        enterText(password,passw);
    }


}
