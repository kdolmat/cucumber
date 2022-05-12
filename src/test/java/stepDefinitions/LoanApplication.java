package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoanApplicationPage;
import utilities.Driver;
import utilities.PropertyReader;

import java.io.IOException;

public class LoanApplication {


    @When("I am clicking View Detail it should open the new page")
    public void i_am_clicking_view_detail_it_should_open_the_new_page() {
        LoanApplicationPage loanApplicationPage = new LoanApplicationPage();
         System.out.println(loanApplicationPage.ViewDetails.getText());
         Assert.assertEquals("View Details", loanApplicationPage.ViewDetails.getText());
        }

    @Then("I should be able to land on Mortgage Application and verify info")
    public void i_should_be_able_to_land_on_mortgage_application_and_verify_info() {
        LoanApplicationPage loanApplicationPage = new LoanApplicationPage();
        System.out.println(loanApplicationPage.MortgageApplication.getText());
        Assert.assertTrue(loanApplicationPage.MortgageApplication.getText().contains("Mortagage Application"));
    }

}
