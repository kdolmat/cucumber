package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SignupPage;
import utilities.Driver;
import utilities.PropertyReader;


public class SignupStepDefs {

@Given("I am on the homepage")
public void i_am_on_the_homepage() {
    Driver.getDriver().get(PropertyReader.getProperty("url"));
}

@When("I press the button Sign up")
public void i_press_the_button_sign_up() {

    SignupPage signupPage = new SignupPage();
    signupPage.SignupWindow.click();
}

@Then("I create application adding user information")
public void i_create_application_adding_user_information() {
    SignupPage signupPage = new SignupPage();

        signupPage.firstName.sendKeys("Bobby");
        signupPage.lastName.sendKeys("Brown");
        signupPage.email.sendKeys("58555@yahoo.com");
        signupPage.password.sendKeys("1234");
        signupPage.button.click();


}

}











