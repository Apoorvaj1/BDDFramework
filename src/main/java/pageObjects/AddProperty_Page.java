package pageObjects;

import CommonToAllPage.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AddProperty_Page extends BaseClass {

    public AddProperty_Page(WebDriver driver){
            super(driver);
    }

    @FindBy(xpath = "//span[@class=\"menu-item-title\"][contains(text(),\"My properties\")]")
    WebElement option_MyProperties;

    @FindBy(xpath = "//button[normalize-space()=\"Submit\"]")
    WebElement submit_GEButton;

    @FindBy(xpath = "(//h3[normalize-space()=\"Owned properties\"])[2]")
    WebElement display_OwnedProperties;

    @FindBy(xpath = "//h3[normalize-space()=\"Managed properties\"]")
    WebElement display_ManagedProperties;
    public void click_MyProperties() throws InterruptedException {
        Actions action = new Actions(driver);
        action.moveToElement(option_MyProperties).build().perform();
        clickOnButton(option_MyProperties);
        Thread.sleep(2000);
        action.moveToElement(display_ManagedProperties).build().perform();
        Thread.sleep(2000);
    }

    public void click_GeneralEnquiryButton(){
        clickOnButton(submit_GEButton);
    }

    public void isOwnedPropertyDisplayed(){
        boolean is_available = display_OwnedProperties.isDisplayed();
        if(is_available){
            System.out.println("Yes button is available");
        }
        else{
            System.out.println("No it's not available");
        }
    }
}
