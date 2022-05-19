package stepDefinitions.duobank;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class LoginStepDefs {

    Response response;
    RequestSpecification requestSpecification;


    @When("I insert valid email and password")
    public void i_insert_valid_email_and_password() {

        requestSpecification = given().header("Accept", "application/json").
                body("\"email\" : \"jtravolta2022@gmail.com\",\n" +
                        "    \"password\" : \"jt2022\"");


    }
    @Then("I should be able to login to Mortgage Application")
    public void i_should_be_able_to_login_to_mortgage_application() {

        response = requestSpecification.when().log().all().
                post("/login.php");
                response.then().log().all().
                assertThat().
                statusCode(200).
                time(lessThan(3000L));
    }




}
