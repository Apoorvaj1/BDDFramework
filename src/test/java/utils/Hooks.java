package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import static utils.BrowserFactory.getDriver;

public class Hooks {
    @Before
    public void BeforeScenario(){
        System.out.println("This will run before the scenario");
    }
    @After(order = 1)
    public void screenCapture(Scenario sc){
        System.out.println("This will run after the scenario");
        if(sc.isFailed()){
            TakesScreenshot ts = (TakesScreenshot)getDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            sc.attach(screenshot,"image/png","Failed screenshot attached");
        }
        /*else{
            TakesScreenshot ts = (TakesScreenshot)getDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            sc.attach(screenshot,"image/png","Passed screenshot");
        }*/
    }
}
