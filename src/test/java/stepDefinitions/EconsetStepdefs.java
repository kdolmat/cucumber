package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.CrediteReportPage;
import pages.EconsentPage;
import pages.SummaryPage;
import utilities.Driver;
import utilities.PropertyReader;
import utilities.SeleniumUtils;

import javax.swing.*;

public class EconsetStepdefs {

    @Given("I am on the eConsent page")
    public void i_am_on_the_e_consent_page() {
        Driver.getDriver().get(PropertyReader.getProperty("http://qa-duobank.us-east-2.elasticbeanstalk.com/mortagage.php"));
        }

        @When("I am filling First Name")
        public void i_am_filling_first_name() {
            EconsentPage econsentPage = new EconsentPage();
            Faker faker = new Faker();
            econsentPage.firstName.sendKeys(faker.name().firstName());
        }
        @Then("I am filling Last Name")
        public void i_am_filling_last_name() {
            EconsentPage econsentPage = new EconsentPage();
            Faker faker = new Faker();
           econsentPage.lastName.sendKeys(faker.name().lastName());
        }

        @Then("I am filling Email")
        public void i_am_filling_email() {
            EconsentPage econsentPage = new EconsentPage();
            Faker faker = new Faker();
            econsentPage.email.sendKeys(faker.internet().emailAddress());
        }

        @Then("I am clicking Agree on the eConsent agreement")
        public void i_am_clicking_agree_with_the_e_consent_agreement() {
            EconsentPage econsentPage = new EconsentPage();
           // econsentPage.agree.click();
           // SeleniumUtils.jsClick(econsentPage.agree);
            SeleniumUtils.waitFor(2);
            Actions action = new Actions(Driver.getDriver());
            action.moveToElement(econsentPage.agree).doubleClick().perform();

        }


        @Then("I should be in Summary page")
        public void i_should_be_in_summary_page() {
        SummaryPage summaryPage = new SummaryPage();
        EconsentPage econsentPage = new EconsentPage();
        new CrediteReportPage().next.click();
            Select select = new Select(econsentPage.iam);
            System.out.println(select.getFirstSelectedOption());
            select.selectByValue("Borrower");

            new CrediteReportPage().next.click();


        }

        @And("I click save")
    public void save(){
        SummaryPage summaryPage = new SummaryPage();
        summaryPage.econsent.click();
        SeleniumUtils.waitFor(2);
        }

}
