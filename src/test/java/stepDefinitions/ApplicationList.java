package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.*;
import utilities.Driver;
import utilities.PropertyReader;
import utilities.SeleniumUtils;

public class ApplicationList {

    @Given("I want to fill in all Mortage Application")
    public void i_want_to_fill_in_all_mortage_application() {
//comment
        Driver.getDriver().get(PropertyReader.getProperty("url"));

        LoginPage loginPage = new LoginPage();
        loginPage.emailAddress.sendKeys(PropertyReader.getProperty("email"));
        loginPage.password.sendKeys(PropertyReader.getProperty("pass"));
        SignupPage signupPage = new SignupPage();
        signupPage.login.click();
        Preapproval preapproval = new Preapproval();
        preapproval.MortgageButton.click();
        preapproval.realtorName.sendKeys("John Doe");


        preapproval.estPurchPrice.sendKeys("450000");
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

    @Then("click Application list")
    public void click_application_list_to_find_borrower_name() {

        Application application = new Application();
        application.applicationList.click();
        SeleniumUtils.waitFor(4);


    }

    @Given("I want to login and click to Application list")
    public void i_want_to_login_and_click_to_application_list() {
        Driver.getDriver().get(PropertyReader.getProperty("url"));
        LoginPage loginPage = new LoginPage();
        loginPage.emailAddress.sendKeys(PropertyReader.getProperty("email"));
        loginPage.password.sendKeys(PropertyReader.getProperty("pass"));
        SignupPage signupPage = new SignupPage();
        signupPage.login.click();
        Application application = new Application();
        application.applicationList.click();
        SeleniumUtils.waitFor(3);

    }

    @Then("I can find in search button Borrower name")
    public void i_can_find_in_search_button_borrower_name() {


        Application application = new Application();
        application.searchButton.sendKeys("Shelby");
         Assert.assertEquals("Shelby Mrs. Ena Beier Schulist McCullough",application.match.getText());








        SeleniumUtils.waitFor(3);
    }
}
