package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.EmplAndIncPage;
import utilities.Driver;
import utilities.PropertyReader;

import java.util.Collections;
import java.util.List;

public class EmplAndIncStepDefs {

    @Given("I am on login page")
    public void i_am_on_login_page() {

        Driver.getDriver().get(PropertyReader.getProperty("url"));
    }
        @When("I press on Mortgage Application")
        public void i_press_on_mortgage_application() {
           EmplAndIncPage emplAndIncPage = new EmplAndIncPage();
            emplAndIncPage.mortgageApp.click();

        }
        @Then("I should see Application Page")
        public void i_should_see_application_page() {

            EmplAndIncPage emplAndIncPage = new EmplAndIncPage();
            Assert.assertTrue(emplAndIncPage.appWizard.getText().contains("Application Wizard"));

        }

    @When("I insert my employer information")
    public void i_insert_my_employer_information() {
        EmplAndIncPage emplAndIncPage = new EmplAndIncPage();
        emplAndIncPage.DuoBankPage.isDisplayed();
        emplAndIncPage.mortgageApp.click();

        // steps of others - Preapproval details, Personal Info, Expenses



        emplAndIncPage.employerName.sendKeys();
        emplAndIncPage.position.sendKeys();
        emplAndIncPage.city.sendKeys();
        emplAndIncPage.city.sendKeys(Keys.ARROW_DOWN, Keys.END);
        emplAndIncPage.startDate.sendKeys();



    }
    @Then("I can add Another Employer")
    public void i_can_add_another_employer() {
        EmplAndIncPage emplAndIncPage = new EmplAndIncPage();
        emplAndIncPage.addButton.click();

    }

    @When("I add gross monthly income")
    public void i_add_gross_monthly_income() {
        EmplAndIncPage emplAndIncPage = new EmplAndIncPage();
        emplAndIncPage.grossIncome.sendKeys("5000");


    }

    @Then("I can go on the next application page")
    public void i_can_go_on_the_next_application_page() {
        EmplAndIncPage emplAndIncPage = new EmplAndIncPage();
        emplAndIncPage.nextPageButton.click();

    }

    @When("add monthly overtime {int} and monthly bonuses {int}")
    public void add_monthly_overtime_and_monthly_bonuses(Integer int1, Integer int2) {


        EmplAndIncPage emplAndIncPage = new EmplAndIncPage();
        emplAndIncPage.grossIncome.sendKeys("5000");
        emplAndIncPage.overtime.sendKeys("100");
        emplAndIncPage.bonuses.sendKeys("200");


    }

    @Then("Borrower Total Monthly Income increase")
    public void borrower_total_monthly_income_increase(List<String> datatable) {

        List <String> str = Collections.singletonList(datatable.get(0));
        EmplAndIncPage emplAndIncPage = new EmplAndIncPage();

        Assert.assertEquals(str.get(Integer.parseInt("GROSS MONTHLY INCOME*")), emplAndIncPage.grossIncome.getText());
        Assert.assertEquals(str.get(Integer.parseInt("MONTHLY OVERTIME")), emplAndIncPage.overtime.getText());
        Assert.assertEquals(str.get(Integer.parseInt("MONTHLY BONUSES")), emplAndIncPage.bonuses.getText());








    }





    }

