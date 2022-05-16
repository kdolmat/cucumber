package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Driver;
import utilities.PropertyReader;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Zuhra_Duobank_StepDef {


    String email;
    String password;
    RequestSpecification requestSpecification;
    Response response;







    @Given("I am on the homepage to login to the request")
    public void i_am_on_the_homepage_to_login_to_the_request() {

         Driver.getDriver().get(PropertyReader.getProperty("url2"));

    }

    @Given("The valid body is added to the request")
    public void POST() {


   email=  new Faker().internet().emailAddress();
   password = new Faker().internet().password();

        requestSpecification = given().
                                  body("{\n" +
                                         "\"first_name\" : \"Joe\",\n" +
                                         "\"last_name\" : \"Doe\",\n" +
                                         "\"email\" : \"" + email + "\",\n" +
                                         "\"password\" : \"" + password + "\"\n" +
                                          "\n" +
                                         "}");


    }
    @When("I send a POST request to endpoint {string}")
    public void EndPoint(String endpoint) {


        response = requestSpecification.when().log().all().
                post(endpoint);


    }
    @Then("The status code should be {int} and response payload should contain a message {string}")
    public void PayloadMessage(Integer status, String message) {
        response.then(). log().all().
                assertThat().
                statusCode(status).
                body("message", equalTo(message));



    }



    @When("I enter the same credentials sent by API request")
    public void i_enter_the_same_credentials_sent_by_api_request() {
        Driver.getDriver().findElement(By.id("exampleInputEmail1")).sendKeys(email, Keys.TAB, password, Keys.ENTER);


    }
    @Then("I should be able to login")
    public void i_should_be_able_to_login() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Loan Application"));

        Driver.getDriver().quit();
    }







}
