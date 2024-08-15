package Practice;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;

public class Demo7 {

    public static void main(String[] args) throws InterruptedException {

        EdgeOptions option = new EdgeOptions();
        option.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        WebDriver driver = new EdgeDriver(option);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://nswpe-valnet-dt2.pega.net/prweb/app/default/ReGFix5ybgw87fgjiRuDbOLS_73_FCC9AjIgKkjAEb8*/!STANDARD");
        driver.findElement(By.id("txtUserID")).sendKeys("apoorv.jain+730@coforge.com");
        driver.findElement(By.id("txtPassword")).sendKeys("Rules@123");
        driver.findElement(By.id("sub")).click();
        Thread.sleep(2000);
        driver.switchTo().frame("PegaGadget0Ifr");
        driver.findElement(By.xpath("//a[normalize-space()='GENQ-30012']")).click();
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        driver.switchTo().frame("PegaGadget1Ifr");
        driver.findElement(By.xpath("(//div[@class=\"header-left\"])[1]")).click();
        driver.findElement(By.xpath("//input[@role=\"combobox\"][@placeholder=\"Please select a resolution reason\"]")).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).build().perform();
        Thread.sleep(4000);
        List<WebElement> resolutionReason_Options = driver.findElements(By.xpath("//ul[@role=\"listbox\"]/li/span"));
        for (WebElement options : resolutionReason_Options) {
            String option123 = options.getText();
            Thread.sleep(2000);
            if(option123.equals("Matter finalised") || option123.equals("Matter finalised - customer no longer required assistance")){
                options.click();
            }
        }
        action.sendKeys(Keys.ESCAPE).build().perform();
        Thread.sleep(2000);
        WebElement finish_Button = driver.findElement(By.xpath("//button[normalize-space()=\"Finish\"]"));

       JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("window.scrollBy(0,1200)");
        js.executeScript("arguments[0].scrollIntoView(true);",finish_Button);
        finish_Button.click();
    }

}
