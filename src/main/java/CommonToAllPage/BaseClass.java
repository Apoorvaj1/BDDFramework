package CommonToAllPage;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseClass {

    public WebDriver driver;

    public void clickOnButton(WebElement e){
        e.click();
    }

    public void enterText(WebElement e,String str){
        e.sendKeys(str);
    }

}
