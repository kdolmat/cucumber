package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
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
import utilities.DBUtility;
import utilities.Driver;
import utilities.PropertyReader;
import utilities.SeleniumUtils;

import java.util.List;
import java.util.Map;


public class PersonalInformation {

    String b_firstName;
    String b_middleName;
    String b_lastName;



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


    List<List<String>> borrow;
    @Then("I click no and fill in firs name,middle name,last name and select suffix")
    public void i_click_no_and_fill_in_firs_name_middle_name_last_name_and_select_suffix(List<List<String>> borrower) {

        borrow = borrower;
//        String firstName = new Faker().name().firstName();
//        String middleName = new Faker().name().nameWithMiddle();
//        String lastName = new Faker().name().lastName();
        PersonalPage personalPage =new PersonalPage();
        personalPage.firstName.clear();
        personalPage.middleName.clear();
        personalPage.lastName.clear();

       // Faker faker = new Faker();

        personalPage.firstName.sendKeys(borrower.get(1).get(0));
        SeleniumUtils.waitFor(3);
        personalPage.middleName.sendKeys(borrower.get(1).get(1));
        personalPage.lastName.sendKeys(borrower.get(1).get(2));
        personalPage.clicksuffix.click();

        b_firstName = borrower.get(1).get(0);
        b_middleName = borrower.get(1).get(1);
        b_lastName = borrower.get(1).get(2);

//
//        personalPage.suffix.sendKeys("Jr." + Keys.ENTER);
//
//        String query = "Select * from tbl_mortagage where b_firstName = '"+b_firstName+"'";
//        System.out.println(query);
//
//        List<Map<String, Object>> listOfmaps = DBUtility.getQueryResultListOfMaps(query);
//
//        Map<String, Object> map = listOfmaps.get(0);
//
//       // Assert.assertEquals(b_firstName, map.get(firstName));
//        Assert.assertEquals(expectedMiddle, map.get(b_middleName));
//        Assert.assertEquals(expectedLast, map.get(b_lastName));






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

    @And("I verify Borrower name from DB")
    public void iVerifyBorrowerNameFromDB() {

        String query = "select b_firstName, b_middleName, b_lastName from tbl_mortagage \n" +
                "where b_firstName = 'Alex' \n" +
                "and b_middleName ='Jason' and b_lastName = 'Davidson'";
        List<List<Object>> actual = DBUtility.getQueryResultAsListOfLists(query);

        Assert.assertEquals(borrow.get(1), actual.get(0));

    }
}
