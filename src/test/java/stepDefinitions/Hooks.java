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
        //

    }

//    @Before(@db)
    public void setupDB(){}

//    @After(@db)
    public void tearDownDB(){
        DBUtility.close();
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


//    @After("@application")
//    public void voidLoopTeardown(){
//    Preapproval preapproval = new Preapproval();
//
//   if(preapproval.isClickable()){
//       Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//       Driver.getDriver().manage().window().maximize();
//
//}
//}

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
