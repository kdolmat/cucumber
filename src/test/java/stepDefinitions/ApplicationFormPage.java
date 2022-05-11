package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.PersonalPage;
import pages.Preapproval;
import utilities.Driver;
import utilities.SeleniumUtils;
import java.util.List;


public class ApplicationFormPage {



    @When("I go on applications list page")
    public void iGoOnApplicationsListPage() {
        Preapproval preapproval = new Preapproval();

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


    @Then("I click on the first application and verify that the data matches with what I put in")
    public void iClickOnTheFirstApplicationAndVerifyThatTheDataMatchesWithWhatIPutIn() {
        Preapproval preapproval = new Preapproval();
        String viewDet = "//td[text()='"+firstName+"  "+lastName+"  "+"']//following-sibling::td//a";
        Driver.getDriver().findElement(By.xpath(viewDet)).click();
        Assert.assertTrue(firstName.contains(preapproval.nameInApplication.getText()));


    }



}
