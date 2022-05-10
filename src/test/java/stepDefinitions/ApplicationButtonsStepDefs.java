package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import org.openqa.selenium.support.ui.Select;
import pages.ApplicationList;
import pages.SummaryPage;
import utilities.SeleniumUtils;


public class ApplicationButtonsStepDefs {
//comment
    @Given("On the Summary page I save my application")
    public void on_the_summary_page_i_save_my_application() {

        SummaryPage summaryPage = new SummaryPage();

        summaryPage.buttonSave.click();



    }

    @When("I go to Application list")
    public void i_go_to_application_list() {

        SeleniumUtils.waitFor(2);
        ApplicationList applicationList = new ApplicationList();
        applicationList.buttonApplicationList.click();

    }

    @Then("I should be able to check all buttons")
    public void i_should_be_able_to_check_all_buttons() {
        ApplicationList applicationList = new ApplicationList();

        applicationList.buttonOne.click();
        applicationList.text1.getText();
        String expected = "Showing 1 to 10";
        Assert.assertTrue(applicationList.text1.getText().contains(expected));


        applicationList.buttonTwo.click();
        applicationList.text1.getText();
        String expected1 = "Showing 11 to 20";
        Assert.assertTrue(applicationList.text1.getText().contains(expected1));


        applicationList.buttonNext.click();
        applicationList.text1.getText();
        Assert.assertTrue(applicationList.isClickable());



        applicationList.buttonShowEntries.click();


        applicationList.buttonInfo.click();
        String expected4 = "Application Details";
        Assert.assertEquals(applicationList.textAppDetails.getText(), expected4);









    }


}


