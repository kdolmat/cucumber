package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.EmplAndIncPage;
import utilities.Driver;
import utilities.PropertyReader;
import utilities.SeleniumUtils;

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
       // emplAndIncPage.mortgageApp.click();

        // steps of others - Preapproval details, Personal Info, Expenses

        Faker faker = new Faker();

        emplAndIncPage.employerName.sendKeys(faker.name().firstName());

        emplAndIncPage.position.sendKeys(faker.job().position());

        emplAndIncPage.city.sendKeys(faker.address().city());

        emplAndIncPage.state.sendKeys(Keys.ARROW_DOWN, Keys.END);

        emplAndIncPage.startDate.sendKeys("03.05.2010");

        SeleniumUtils.scroll(0,900);

        emplAndIncPage.employer2Name.sendKeys("John Doe");





    }

    @When("I add gross monthly income {int}")
    public void i_add_gross_monthly_income(Integer gross) {
        EmplAndIncPage emplAndIncPage = new EmplAndIncPage();
        String s = gross.toString();

        emplAndIncPage.grossIncome.sendKeys(s);


        System.out.println(emplAndIncPage.grossIncome.getAttribute("id"));
//        System.out.println(emplAndIncPage.grossIncome.getAttribute("1000"));
//       Assert.assertEquals(String.valueOf(gross), emplAndIncPage.grossIncome.getAttribute("5000"));


    }

    @Then("I can go on the next application page")
    public void i_can_go_on_the_next_application_page() {
        EmplAndIncPage emplAndIncPage = new EmplAndIncPage();


        emplAndIncPage.nextp.click();

    }

    @Then("I can add Another Employer")
    public void i_can_add_another_employer() {
        EmplAndIncPage emplAndIncPage = new EmplAndIncPage();
        emplAndIncPage.addButton.click();

    }



    @When("add monthly overtime {int} and monthly bonuses {int}")
    public void add_monthly_overtime_and_monthly_bonuses(Integer monthlyOvertime, Integer monthlyBonus) {
        EmplAndIncPage emplAndIncPage = new EmplAndIncPage();
        Assert.assertEquals(String.valueOf(monthlyOvertime), emplAndIncPage.overtime.getText());
        Assert.assertEquals(String.valueOf(monthlyBonus), emplAndIncPage.bonuses.getText());

        System.out.println("Monthly overtime " + monthlyOvertime);
        System.out.println("Monthly bonuses " + monthlyBonus);

    }

    @Then("Borrower Total Monthly Income increase from {int} to {int}")
    public void borrower_total_monthly_income_increase_from_to(Integer gross, Integer totalGross) {
        EmplAndIncPage emplAndIncPage = new EmplAndIncPage();
        Assert.assertEquals(String.valueOf(gross), emplAndIncPage.grossIncome.getText());
        Assert.assertEquals(String.valueOf(totalGross), emplAndIncPage.totalIncome.getText());


    }


    }













