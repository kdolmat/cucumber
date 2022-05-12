package stepDefinitions.duobank;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.*;
import utilities.DBUtility;
import utilities.Driver;
import utilities.PropertyReader;
import utilities.SeleniumUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class LoanAmount {

    @Given("I want to login")
    public void i_want_to_login() {

        Driver.getDriver().get(PropertyReader.getProperty("url"));

        LoginPage loginPage = new LoginPage();
        loginPage.emailAddress.sendKeys(PropertyReader.getProperty("email"));
        loginPage.password.sendKeys(PropertyReader.getProperty("pass"));
        SignupPage signupPage = new SignupPage();
        signupPage.login.click();
        Preapproval preapproval = new Preapproval();



    }
    @When("I fill in loan application")
    public void i_fill_in_loan_application() {


        Preapproval preapproval = new Preapproval();
        preapproval.MortgageButton.click();
        preapproval.realtorName.sendKeys("John Doe");


        preapproval.estPurchPrice.sendKeys("850000");
        preapproval.downPaymntPercent.sendKeys("5");
        preapproval.nextButton.click();
        String firstName = new Faker().name().firstName();
        String middleName = new Faker().name().nameWithMiddle();
        String lastName = new Faker().name().lastName();


        PersonalPage personalPage = new PersonalPage();


        personalPage.firstName.sendKeys(firstName);

        personalPage.middleName.sendKeys(middleName);
        personalPage.lastName.sendKeys(lastName);
        personalPage.clicksuffix.click();


        personalPage.suffix.sendKeys("Jr." + Keys.ENTER);

        String email = new Faker().internet().emailAddress();
        personalPage.email1.sendKeys(email);
        Driver.getDriver().findElement(By.xpath("(//input[@placeholder='Select Date'])[1]")).sendKeys("03.05.1993");

        personalPage.SSN1.sendKeys("123-44-2222");
        personalPage.Select2click.click();
        personalPage.Select2.sendKeys("Married" + Keys.ENTER);
        personalPage.phoneNumber.sendKeys("3224320757");
        personalPage.homeNumber.sendKeys("4224320759");
        personalPage.nextButton.click();
        ExpensesPage expensesPage = new ExpensesPage();
        expensesPage.MonthlyRentalPayment.sendKeys("3000");

        expensesPage.next.click();

        EmplAndIncPage emplAndIncPage = new EmplAndIncPage();
        emplAndIncPage.DuoBankPage.isDisplayed();


        Faker faker = new Faker();

        emplAndIncPage.employerName.sendKeys(faker.name().firstName());


        emplAndIncPage.position.sendKeys(faker.job().position());


        emplAndIncPage.city.sendKeys(faker.address().city());


        emplAndIncPage.state.sendKeys(Keys.ARROW_DOWN, Keys.END);

        emplAndIncPage.startDate.sendKeys("03.05.2010");


        SeleniumUtils.scroll(0, 900);

        emplAndIncPage.grossIncome.sendKeys("4000");


        emplAndIncPage.nextp.click();

        CrediteReportPage crediteReportPage = new CrediteReportPage();
        crediteReportPage.next.click();
        EconsentPage econsentPage = new EconsentPage();
        // econsentPage.agree.click();
        // SeleniumUtils.jsClick(econsentPage.agree);


        econsentPage.firstName.sendKeys(faker.name().firstName());
        econsentPage.lastName.sendKeys(faker.name().lastName());
        econsentPage.email.sendKeys(faker.internet().emailAddress());
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(econsentPage.agree).doubleClick().perform();
        new CrediteReportPage().next.click();
        SummaryPage summaryPage = new SummaryPage();
        SeleniumUtils.waitFor(4);
        summaryPage.econsent.click();



    }
    @Then("I should be to on Application list")
    public void i_should_be_to_on_application_list() {



        Application application = new Application();
        application.applicationList.click();
        SeleniumUtils.waitFor(4);

    }
    @Then("I should to be able to verify the loan amount details in the datable")
    public void i_should_to_be_able_to_verify_the_loan_amount_details_in_the_datable() {



       String query= "Select *from tbl_mortagage where total_loan_amount='807500'";

        System.out.println(query);
        List<Map<String, Object>> listofmaps = DBUtility.getQueryResultListOfMaps(query);

        System.out.println(listofmaps);


    }

    @Then("I can delete loan amount")
    public void i_can_delete_loan_amount() throws SQLException {

        String query = "delete from tbl_mortagage where total_loan_amount='12222';";

        DBUtility.updateQuery(query);


    }

}
