package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Preapproval;

public class ApplicationFormPage {
    @When("I go on applications list page")
    public void iGoOnApplicationsListPage() {
        Preapproval preapproval = new Preapproval();
        preapproval.applicationListBttn.click();
    }

    @Then("I click on the first application and verify that the data matches with what I put in")
    public void iClickOnTheFirstApplicationAndVerifyThatTheDataMatchesWithWhatIPutIn() {
Preapproval preapproval = new Preapproval();
preapproval.viewDetails.click();
        Assert.assertEquals(preapproval.loanExp,preapproval.loan.getText());
    }
}
