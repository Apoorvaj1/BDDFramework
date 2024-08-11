package utils;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.Objects;

public class BrowserFactory {

    public static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static synchronized WebDriver getDriver(){
        return dr.get();
    }

    public static void setDriver(WebDriver driverRef){
        dr.set(driverRef);
    }

    public static void unload(){
        dr.remove();
    }
    public static void init(String browserName) {
        if(Objects.isNull(BrowserFactory.getDriver())){
            if (browserName.equals("edge")) {
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--guest");
                edgeOptions.addArguments("--incognito");
                edgeOptions.setAcceptInsecureCerts(true);
                edgeOptions.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
                WebDriver driver = new EdgeDriver(edgeOptions);
                setDriver(driver);
            }
            else if((browserName.equals("chrome"))) {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--guest");
                chromeOptions.addArguments("--incognito");
                chromeOptions.setAcceptInsecureCerts(true);
                chromeOptions.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
                WebDriver driver = new ChromeDriver(chromeOptions);
                setDriver(driver);
            }
        }
    }
    @After (order = 0)
    public static void down() {
        if(Objects.nonNull(BrowserFactory.getDriver())){
            getDriver().quit();
            unload();
        }
    }




}
