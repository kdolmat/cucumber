package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PersonalPage;
import pages.Preapproval;
import utilities.Driver;
import utilities.SeleniumUtils;

import java.util.List;
import java.util.Map;

public class ApplicationFormPage {

    public String firstName;
    public String lastName;
    public String fn = firstName+" "+lastName;

    @When("I go on applications list page")
    public void iGoOnApplicationsListPage() {
        Preapproval preapproval = new Preapproval();
        preapproval.applicationListBttn.click();
    }

    @Then("I click on the first application and verify that the data matches with what I put in")
    public void iClickOnTheFirstApplicationAndVerifyThatTheDataMatchesWithWhatIPutIn() {
        Preapproval preapproval = new Preapproval();
       // Assert.assertEquals(preapproval.loanExp,preapproval.loan.getText());
        String viewDet = "//td[text()='"+fn+"']//following-sibling::td//a";
        Driver.getDriver().findElement(By.xpath(viewDet)).click();
        String name = "//td[text()='"+fn+"']";
    }


    @And("I want to set the name")
    public void theFollowingShouldBe(List<List<String>> values) {
        PersonalPage personalPage =new PersonalPage();
        Faker faker = new Faker();
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();

        personalPage.firstName.clear();
        personalPage.middleName.clear();
        personalPage.lastName.clear();

        personalPage.firstName.sendKeys(firstName);
        personalPage.lastName.sendKeys(lastName);


        List<String> name = values.get(0);
        name.add(firstName);

        System.out.println(firstName);
        System.out.println(name);
        System.out.println(name.get(0));
        System.out.println(values.get(0));
        System.out.println(values);




    }
}
