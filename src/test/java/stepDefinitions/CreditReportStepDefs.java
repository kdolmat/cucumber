package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.CrediteReportPage;
import pages.EconsentPage;
import utilities.Driver;
import utilities.PropertyReader;

public class CreditReportStepDefs {



    @Given("I am on the PreApproval page")
    public void i_am_on_the_pre_approval_page() {
        Driver.getDriver().get(PropertyReader.getProperty("http://qa-duobank.us-east-2.elasticbeanstalk.com/mortagage.php"));
    }
    @When("I am clicking Yes")
    public void i_am_clicking_yes() {
        CrediteReportPage crediteReportPage = new CrediteReportPage();
        Assert.assertTrue(crediteReportPage.OrderCrediteReportCheck.isSelected());
    }
    @Then("I should be able to move to the other page")
    public void i_should_be_able_to_move_to_the_other_page() {
        EconsentPage econsentPage = new EconsentPage();
        CrediteReportPage crediteReportPage = new CrediteReportPage();
        crediteReportPage.next.click();

//        Assert.assertTrue( econsentPage.eConsent.getText().contains("eConsent"));

    }
}
