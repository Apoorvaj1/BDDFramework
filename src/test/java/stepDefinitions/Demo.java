package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://nswpe-valnet-dt2.pega.net/prweb/app/default/ReGFix5ybgw87fgjiRuDbOLS_73_FCC9AjIgKkjAEb8*/!STANDARD");
        driver.findElement(By.id("txtUserID")).sendKeys("apoorv.jain+3500@coforge.com");
        driver.findElement(By.id("txtPassword")).sendKeys("Rules@123");
        driver.findElement(By.id("sub")).click();
        Thread.sleep(4000);
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//span[@class=\"menu-item-title\"][contains(text(),\"My properties\")]"))).build().perform();
        driver.findElement(By.xpath("//span[@class=\"menu-item-title\"][contains(text(),\"My properties\")]")).click();
        Thread.sleep(2000);
        List<WebElement> total_tab = driver.findElements(By.xpath("//h3[@class=\"layout-group-item-title\"]"));
        for(WebElement tabs:total_tab){
            System.out.println(tabs.getText());
        }
        driver.quit();
    }
}
