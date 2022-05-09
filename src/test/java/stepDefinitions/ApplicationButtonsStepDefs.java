package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import pages.ApplicationList;
import pages.SummaryPage;



public class ApplicationButtonsStepDefs {

    @Given("On the Summary page I save my application")
    public void on_the_summary_page_i_save_my_application() {

        SummaryPage summaryPage = new SummaryPage();
        summaryPage.buttonSave.click();

    }

    @When("I go to Application list")
    public void i_go_to_application_list() {
        ApplicationList applicationList = new ApplicationList();
        applicationList.buttonApplicationList.click();

    }

    @Then("I should be able to check all buttons")
    public void i_should_be_able_to_check_all_buttons() {
        ApplicationList applicationList = new ApplicationList();

        applicationList.buttonOne.click();
        applicationList.text1.getText();
        String expected = "Showing 1 to 10 of 17 entries";
        Assert.assertEquals(applicationList.text1.getText(), expected);


        applicationList.buttonTwo.click();
        applicationList.text1.getText();
        String expected1 = "Showing 11 to 17 of 17 entries";
        Assert.assertEquals(applicationList.text1.getText(), expected1);


        applicationList.buttonNext.click();
        applicationList.text1.getText();
        String expected2 = "Showing 11 to 17 of 17 entries";
        Assert.assertEquals(applicationList.text1.getText(), expected2);

        applicationList.buttonShowEntries.click();
        applicationList.value25.isSelected();
        String expected3 = "Showing 1 to 17 of 17 entries";
        Assert.assertEquals(applicationList.text1.getText(), expected3);

        applicationList.buttonInfo.click();
        String expected4 = "Application Details";
        Assert.assertEquals(applicationList.textAppDetails.getText(), expected4);









    }


}


