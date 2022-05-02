package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.EconsentPage;
import pages.SummaryPage;
import utilities.Driver;
import utilities.PropertyReader;

public class EconsetStepdefs {

    @Given("I am on the eConsent page")
    public void i_am_on_the_e_consent_page() {
        Driver.getDriver().get(PropertyReader.getProperty("http://qa-duobank.us-east-2.elasticbeanstalk.com/mortagage.php"));
        }

        @When("I am filling First Name")
        public void i_am_filling_first_name() {
            EconsentPage econsentPage = new EconsentPage();
            Assert.assertTrue(econsentPage.firstName.getText().contains("First Name"));
        }
        @Then("I am filling Last Name")
        public void i_am_filling_last_name() {
            EconsentPage econsentPage = new EconsentPage();
            Assert.assertTrue(econsentPage.lastName.getText().contains("Last Name"));
        }

        @Then("I am filling Email")
        public void i_am_filling_email() {
            EconsentPage econsentPage = new EconsentPage();
            Assert.assertTrue(econsentPage.email.getText().contains("Email"));
        }

        @Then("I am clicking Agree on the eConsent agreement")
        public void i_am_clicking_agree_with_the_e_consent_agreement() {
            EconsentPage econsentPage = new EconsentPage();
            econsentPage.agree.sendKeys("check", Keys.ENTER);

        }

//        @Then("I push Next")
//        public void i_push_next() {
//        }

        @Then("I should be in Summary page")
        public void i_should_be_in_summary_page() {
        SummaryPage summaryPage = new SummaryPage();
        Assert.assertTrue( summaryPage .econsent.getPageSource().contains("eConsent"));

            Driver.quitDriver();

        }

        @Then("I am clicking Agree with the eConsent agreement")
        public void iAmClickingAgreeWithTheEConsentAgreement() {
            EconsentPage econsentPage = new EconsentPage();
            econsentPage.agree.sendKeys("check", Keys.ENTER);

        }
}
