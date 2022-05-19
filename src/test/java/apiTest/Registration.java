package apiTest;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Driver;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class Registration {

    static{
        baseURI = "http://qa-duobank.us-east-2.elasticbeanstalk.com/api";
    }

    @Test
    public void testMultiLayerAPItoUI(){

        String email = new Faker().internet().emailAddress();
        String password = new Faker().internet().password();
         given().
                body("{\n" +
                        "\"first_name\" : \"John\",\n" +
                        "\"last_name\" : \"Travolta\",\n" +
                        "\"email\": \"" + email + "\",\n" +
                        "\"password\" : \"" + password + "\"\n" +
                        "}").
                when().log().all().
                post("/register.php").
                then().log().all().
                assertThat().
                statusCode(200).
                body("status", equalTo(201)).
                body("message", equalTo("You have successfully registered.")).
                 time(lessThan(3000L));

                 Driver.getDriver().get("http://qa-duobank.us-east-2.elasticbeanstalk.com/index.php");
                 Driver.getDriver().findElement(By.id("exampleInputEmail1")).sendKeys(email, Keys.TAB, password, Keys.ENTER);
                 Assert.assertTrue(Driver.getDriver().getTitle().contains("Loan Application"));

                 Driver.getDriver().quit();



    }


    }
