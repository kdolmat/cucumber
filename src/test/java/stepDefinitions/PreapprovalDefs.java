package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;
import pages.Preapproval;
import utilities.SeleniumUtils;

import java.util.List;
import java.util.Map;

public class PreapprovalDefs {
    String estPurchP;
    String nameG;
    String down;
    String prcnt;

    @When("I Click on Mortgage Application")
    public void i_click_on_mortgage_application() {
        Preapproval preapproval = new Preapproval();
        preapproval.MortgageButton.click();
        SeleniumUtils.waitFor(1);
    }
    @Then("I should see the {string}")
    public void i_should_see_the_preapproval_form(String form) {
        Preapproval preapproval = new Preapproval();
        String exp = preapproval.ApprovalForm.getText();
        Assert.assertTrue(form.equalsIgnoreCase(exp));
    }

    @Then("I want to check all boxes No")
    public void i_want_to_check_all_boxes_no(){
        Preapproval preapproval = new Preapproval();
        SeleniumUtils.waitFor(2);
        if(!preapproval.loanOfficerButton.isSelected()){
            preapproval.loanOfficerButton.click();
        }
        if(!preapproval.realtorButton.isSelected()){
            preapproval.realtorButton.click();
        }
    }

    @Then("I want to check all boxes Yes")
    public void i_want_to_check_all_boxes_yes(){
        Preapproval preapproval = new Preapproval();
        preapproval.loanOfficerButtonY.click();
        preapproval.realtorButtonY.click();
    }

    @Then("I want to provide the {string} name")
    public void i_want_to_provide_the_officers_name(String name){
        nameG=name;
        Preapproval preapproval = new Preapproval();
        Faker faker = new Faker();
        preapproval.realtorName.sendKeys(faker.name().firstName()+" "+faker.name().lastName());

    }


    @Then("I want to fill the {string},{string},{string}")
    public void iWantToFillThe(String arg0, String arg1, String arg2) {
        Preapproval preapproval = new Preapproval();
        estPurchP = arg0;
        down = arg1;
        prcnt = arg2;
        SeleniumUtils.scroll(1,500);
        preapproval.estPurchPrice.sendKeys("200000");

        preapproval.downPaymntPercent.clear();
        preapproval.downPaymntPercent.sendKeys("20");

        preapproval.downPaymnt.clear();
        preapproval.downPaymnt.sendKeys("40000");
    }



    @And("The following should be")
    public void theFollowingShouldBe(List<Map<String,String>> values) {
        //Map<String,String> map = values.get(0);
        Preapproval preapproval = new Preapproval();
        SeleniumUtils.scroll(1,500);
//        nameG = map.get("Loan Officer");
//        estPurchP = map.get("ESTIMATED PURCHASE PRICE");
//        down = map.get("DOWN PAYMENT AMOUNT");
//        prcnt = map.get("DOWN PAYMENT PERCENTAGE");


//        preapproval.realtorName.sendKeys(nameG);
//        SeleniumUtils.waitFor(2);
//        preapproval.estPurchPrice.sendKeys(estPurchP);
//        SeleniumUtils.waitFor(2);
//        preapproval.downPaymnt.sendKeys(down);
//        SeleniumUtils.waitFor(2);
//        preapproval.downPaymntPercent.sendKeys(prcnt);
//        SeleniumUtils.waitFor(2);

        for (Map<String,String> map:values){
            nameG = map.get("Loan Officer");
            estPurchP = map.get("ESTIMATED PURCHASE PRICE");
            down = map.get("DOWN PAYMENT AMOUNT");
            prcnt = map.get("DOWN PAYMENT PERCENTAGE");
        }

        preapproval.realtorName.sendKeys(nameG);
        SeleniumUtils.waitFor(2);
        preapproval.estPurchPrice.sendKeys(estPurchP);
        SeleniumUtils.waitFor(2);
        preapproval.downPaymnt.sendKeys(down);
        SeleniumUtils.waitFor(2);
        preapproval.downPaymntPercent.sendKeys(prcnt);
        SeleniumUtils.waitFor(2);

//        preapproval.realtorName.sendKeys(map.get("Loan Officer"));
//        SeleniumUtils.waitFor(2);
//        preapproval.estPurchPrice.sendKeys(map.get("ESTIMATED PURCHASE PRICE"));
//        SeleniumUtils.waitFor(2);
//        preapproval.downPaymnt.sendKeys(map.get("DOWN PAYMENT AMOUNT"));
//        SeleniumUtils.waitFor(2);
//        preapproval.downPaymntPercent.sendKeys(map.get("DOWN PAYMENT PERCENTAGE"));
//        SeleniumUtils.waitFor(2);
    }

    @And("I want to pick {string} and verify")
    public void iWantToPick(String arg0) {
        Preapproval preapproval = new Preapproval();
//        Select select = new Select(preapproval.optionsFinances);
//       // preapproval.optionsFinances.click();
//        SeleniumUtils.jsClick(preapproval.optionsFinances);
//        select.selectByValue(arg0);
//        System.out.println(arg0+" "+select);
//        Assert.assertEquals(select,arg0);

    }


    @And("click {string} and verify that next page contains {string}")
    public void click(String arg0,String personalInfo) {
        Preapproval preapproval = new Preapproval();
        preapproval.nextButton.click();
        SeleniumUtils.waitFor(2);
        Assert.assertEquals(personalInfo,preapproval.pI.getText());
    }
}
