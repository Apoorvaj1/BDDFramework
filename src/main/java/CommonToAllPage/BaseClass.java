package CommonToAllPage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BaseClass {

    WebDriver driver;

    public BaseClass(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void clickOnButton(WebElement e){
        e.click();
    }

    public void enterText(WebElement e,String str){
        e.sendKeys(str);
    }

}
