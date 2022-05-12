package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.PersonalPage;
import pages.Preapproval;
import utilities.DBUtility;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.sql.SQLException;
import java.util.List;


public class ApplicationFormPage {



    @When("I go on applications list page")
    public void iGoOnApplicationsListPage() {
        Preapproval preapproval = new Preapproval();
<<<<<<< HEAD
        SeleniumUtils.waitFor(2);
        preapproval.applicationListBttn.click();
    }
=======
>>>>>>> 712a0cb0da238a243f137e1e3f0e4edd1fb0cd04

        SeleniumUtils.waitForClickablility(preapproval.applicationListBttn,5);
        preapproval.applicationListBttn.click();
    }

    public String firstName;
    public String lastName;
    @And("I want to set the name")
    public void theFollowingShouldBe(List<String>list) {

        PersonalPage personalPage =new PersonalPage();
        Preapproval preapproval = new Preapproval();
        Faker faker = new Faker();
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();

        personalPage.firstName.clear();
        personalPage.middleName.clear();
        personalPage.lastName.clear();
        personalPage.clicksuffix.click();
        personalPage.suffix.sendKeys("Select One" + Keys.ENTER);

        personalPage.firstName.sendKeys(firstName);
        personalPage.lastName.sendKeys(lastName);


        List<String>l=SeleniumUtils.getElementsText(preapproval.allBlankInfo);
        while(l.size()!=13){l.remove(l.size()-1);}
        Assert.assertTrue(l.equals(list));



    }

    public String email;
    @And("I set the email to desired")
    public void I_set_the_email_to_desired(){
        PersonalPage personalPage =new PersonalPage();
        Faker faker = new Faker();
        email = faker.internet().emailAddress();
        personalPage.email1.clear();
        personalPage.email1.sendKeys(email);
    }



    @Then("I click on the first application and verify that the data matches with what I put in")
    public void iClickOnTheFirstApplicationAndVerifyThatTheDataMatchesWithWhatIPutIn() {
        Preapproval preapproval = new Preapproval();
        String viewDet = "//td[text()='"+firstName+"  "+lastName+"  "+"']//following-sibling::td//a";
        Driver.getDriver().findElement(By.xpath(viewDet)).click();
        Assert.assertTrue(firstName.contains(preapproval.nameInApplication.getText()));


    }
    String emailV;
    WebElement e;
    @Then("I click on the first application and verify that the email matches the email I have")
    public void iClickOnTheFirstApplicationAndVerify() {
        String viewDet = "//td[text()='"+firstName+"  "+lastName+"  "+"']//following-sibling::td//a";
        Driver.getDriver().findElement(By.xpath(viewDet)).click();
        emailV = "//td[text()='"+email+"']";
        e = Driver.getDriver().findElement(By.xpath(emailV));
        Assert.assertTrue(email.contains(e.getText()));


    }

    String updated;
    @Then("I change the email in the database using given data, print it and verify if it was changed")
    public void iChangeTheEmailInTheDatabaseUsingGivenData(List<List<Object>>emailTable) throws SQLException {

        updated = (String) emailTable.get(0).get(1);
        Preapproval preapproval = new Preapproval();
        String realtorName = preapproval.realtorNameDynamic.getText();

        String query = "UPDATE tbl_mortagage SET b_email='"+updated+"' WHERE realtor_info = '"+realtorName+"';";

        DBUtility.updateQuery(query);
        String pullR = "select * from tbl_mortagage where b_email='"+updated+"';";
        emailTable = DBUtility.getQueryResultAsListOfLists(pullR);
        System.out.println(emailTable);
        Assert.assertTrue(emailTable.get(0).contains(updated));
        Driver.getDriver().navigate().refresh();

    }

    @Then("I refresh the page and verify the changed data")
    public void iRefreshThePageAndVerifyTheChangedData() {

        Driver.getDriver().navigate().refresh();


        Preapproval preapproval = new Preapproval();
        Assert.assertEquals(updated,preapproval.updEmail.getText());

    }
}
