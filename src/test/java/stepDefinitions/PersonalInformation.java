package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.LoginPage;
import pages.PersonalPage;
import pages.Preapproval;
import pages.SignupPage;
import utilities.Driver;
import utilities.PropertyReader;
import utilities.SeleniumUtils;


public class PersonalInformation {


    @Given("I login duobank using email and password")
    public void i_login_duobank_using_email_and_password() {
        Driver.getDriver().get(PropertyReader.getProperty("url"));

        LoginPage loginPage = new LoginPage();
        loginPage.emailAddress.sendKeys(PropertyReader.getProperty("email"));
        loginPage.password.sendKeys(PropertyReader.getProperty("pass"));
        SignupPage signupPage = new SignupPage();
        signupPage.login.click();
        Driver.getDriver().findElement(By.xpath("//input[@id='employername2']")).sendKeys("AAAA");

    }

    @When("I Click on Mortgage Application and fill in preapproval details")
    public void i_click_on_mortgage_application_and_fill_in_preapproval_details() {

        Preapproval preapproval = new Preapproval();
        preapproval.MortgageButton.click();
        preapproval.realtorName.sendKeys("John Doe");
        preapproval.estPurchPrice.sendKeys("650000");
        preapproval.downPaymntPercent.sendKeys("10");
        preapproval.nextButton.click();


    }

    @Then("I verify with title I'm in Personal Information page")
    public void i_verify_with_title_i_m_in_personal_information_page() {

        Assert.assertTrue(Driver.getDriver().getTitle().contains("Loan Application"));
    }

    @Then("I click no and fill in firs name,middle name,last name and select suffix")
    public void i_click_no_and_fill_in_firs_name_middle_name_last_name_and_select_suffix() {

        String firstName = new Faker().name().firstName();
        String middleName = new Faker().name().nameWithMiddle();
        String lastName = new Faker().name().lastName();


        PersonalPage personalPage = new PersonalPage();


        personalPage.firstName.sendKeys(firstName);
        SeleniumUtils.waitFor(3);
        personalPage.middleName.sendKeys(middleName);
        personalPage.lastName.sendKeys(lastName);
        personalPage.clicksuffix.click();


        personalPage.suffix.sendKeys("Jr." + Keys.ENTER);





    }

    @Then("I fill in all browser information")
    public void i_fill_in_all_browser_information() {

        String email = new Faker().internet().emailAddress();


        PersonalPage personalPage = new PersonalPage();
        personalPage.email1.sendKeys(email);
        SeleniumUtils.waitFor(2);
        // personalPage.dateOfBirth1.sendKeys("04.05.1993");
        Driver.getDriver().findElement(By.xpath("(//input[@placeholder='Select Date'])[1]")).sendKeys("03.05.1993");

        personalPage.SSN1.sendKeys("123-44-2222");
        personalPage.Select2click.click();
        personalPage.Select2.sendKeys("Married" + Keys.ENTER);
        personalPage.phoneNumber.sendKeys("3224320757");
        personalPage.homeNumber.sendKeys("4224320759");


    }

    @Then("I click yes and fill in personal information and co-browser information")
    public void i_click_yes_and_fill_in_personal_information_and_co_browser_information() {


        PersonalPage personalPage =new PersonalPage();

        SeleniumUtils.scroll(0,-150);
        personalPage.clickYes.click();
        String firstName = new Faker().name().firstName();
        String middleName = new Faker().name().nameWithMiddle();
        String lastName = new Faker().name().lastName();
        String email = new Faker().internet().emailAddress();

        personalPage.firstName.sendKeys(firstName);
        SeleniumUtils.waitFor(1);
        personalPage.middleName.sendKeys(middleName);
        personalPage.lastName.sendKeys(lastName);
        personalPage.clicksuffix.click();


        personalPage.suffix.sendKeys("Jr." + Keys.ENTER);
        personalPage.email1.sendKeys(email);
        Driver.getDriver().findElement(By.xpath("(//input[@placeholder='Select Date'])[1]")).sendKeys("03.05.1993");

        personalPage.SSN1.sendKeys("123-44-2222");
        personalPage.Select2click.click();
        personalPage.Select2.sendKeys("Married" + Keys.ENTER);
        personalPage.phoneNumber.sendKeys("3224320757");
        personalPage.homeNumber.sendKeys("4224320759");



        SeleniumUtils.scroll(0,250);
        String name2 = new Faker().name().firstName();
        String middleName2 = new Faker().name().nameWithMiddle();
        String lastName2 = new Faker().name().lastName();
        String email2 = new Faker().internet().emailAddress();
        personalPage.name2.sendKeys(name2);
      personalPage.middleName2.sendKeys(middleName2);
      personalPage.lastName2.sendKeys(lastName2);
      personalPage.clickSuffix.click();
       personalPage.choose.sendKeys("Jr"+Keys.ENTER);
       personalPage.email2.sendKeys(email2);
       personalPage.BOD.sendKeys("15.05.2000");

       personalPage.Select3.click();
       personalPage.SelectClick.sendKeys("Married"+Keys.ENTER);

       personalPage.phone2.sendKeys("4333555478");
       personalPage.homePhone2.sendKeys("2337779999");

    }


    @Then("I click next and make sure Im in expenses page")
    public void i_click_next_and_make_sure_im_in_expenses_page() {


        PersonalPage personalPage =new PersonalPage();
        personalPage.nextButton.click();
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Loan Application"));


    }

}
