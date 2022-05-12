package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.Preapproval;
import utilities.DBUtility;
import utilities.Driver;
import utilities.SeleniumUtils;


import java.time.Duration;

public class Hooks {



    @Before
    public void setup(){

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Driver.getDriver().manage().window().maximize();
//        Driver.getDriver().manage().deleteAllCookies();



    }


    @Before ("@db")
    public void setupDB(){

        DBUtility.createConnection();

    }


//    @Before ("@module2")   // the before logic that runs before all scenarios tagged with @module2
//    public void setup2(){
//
//        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        Driver.getDriver().manage().window().maximize();
////        Driver.getDriver().manage().deleteAllCookies();
//
//
//
//    }

    @After ("@db")
    public void tearDownDb(){
        DBUtility.close();
    }

    @Before
    public void setupDB(){
        DBUtility.createConnection();
    }

    @After
    public void tearDownDB(){

        DBUtility.close();
    }



    @After
    public void tearDown(Scenario scenario){

        if(scenario.isFailed()){
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshotAs, "image/png", "failed");
        }

        Driver.quitDriver();
    }


}
