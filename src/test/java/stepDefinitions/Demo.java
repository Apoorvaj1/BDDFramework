package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()=\"GENQ-24030\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[contains(text(),\"Go\")]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[id$=\"Yes\"]")).click();
        driver.findElement(By.xpath("//button[normalize-space()=\"Next\"]")).click();
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
        /*WebElement click_Submit = driver.findElement(By.xpath("//button[contains(text(),\"Submit\")]"));
        js.executeScript("arguments[0].scrollIntoView(true);",click_Submit);*/


        /*
        WebElement frame1 = driver.findElement(By.xpath("//div[@id=\"cke_1_contents\"]/iframe"));
        driver.switchTo().frame(frame1);
        driver.findElement(By.cssSelector("body p")).sendKeys("APOORV");
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        WebElement click_Submit = driver.findElement(By.xpath("//button[contains(text(),\"Submit\")]"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",click_Submit);
        click_Submit.click();*/

    }
}
