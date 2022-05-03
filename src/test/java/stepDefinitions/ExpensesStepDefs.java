package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.EmploymentAndIncomePage;
import pages.ExpensesPage;
import utilities.Driver;
import utilities.PropertyReader;
import utilities.SeleniumUtils;

public class ExpensesStepDefs {

    @Given("I am on the Expenses page")
    public void i_am_on_the_expenses_page() {
        Driver.getDriver().get(PropertyReader.getProperty("url"));
    }

    @When("I am click in Rent")
    public void i_am_cklick_in_rent_or_own() {
        ExpensesPage expensesPage = new ExpensesPage();
        System.out.println(expensesPage.RentClick.getText());
        Assert.assertTrue(expensesPage.RentClick.isSelected());
    }

    @Then("I am filling Monthly Rental Payment or First Mortagage")
    public void i_am_filling_monthly_rental_payment_or_first_mortagage() {
        ExpensesPage expensesPage = new ExpensesPage();
        expensesPage.MonthlyRentalPayment.sendKeys("1000");

        expensesPage.next.click();
    }

    @Then("I should see the next page Employment and Income")
    public void i_should_see_the_next_page_employment_and_income() {
//        EmploymentAndIncomePage employmentAndIncomePage = new EmploymentAndIncomePage();
//        Assert.assertTrue(employmentAndIncomePage.EmplymentAndIncome.getTitle().contains("EmplymentAndIncome"));


    }
}
