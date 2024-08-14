package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.Arrays;
import java.util.List;

public class Demo2 {

    public static void main(String[] args) throws InterruptedException {

        EdgeOptions option = new EdgeOptions();
        option.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
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
        /*List<WebElement> list = driver.findElements(By.xpath("//div[@class=\"header\"]/h2"));
        for(WebElement list1:list){
            System.out.println(list1.getText());
        }*/

        driver.findElement(By.xpath("//h2[normalize-space()='My workbaskets']")).click();
        Thread.sleep(2000);
        option.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        Select select = new Select(driver.findElement(By.xpath("//select[@title=\"ViewQueueFor\"]")));
        List<WebElement> list = select.getOptions();
        for(WebElement list1: list){
            if(list1.getText().equals("Customer Experience")){
                list1.click();
                break;
            }
        }
        WebElement list3 = driver.findElement(By.xpath("(//table[@class=\"gridTable \"])[2]"));
    }

}
