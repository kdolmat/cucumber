package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Homepage;
import pages.ProductPage;
import utilities.Driver;

public class ProductDetailsStepDefs {

    @When("I click on a product {string}")
    public void i_click_on_a_product(String productName) {
        Homepage homepage = new Homepage();
        homepage.clickOnAProduct(productName);
    }
    @When("I land on a product details page with title containing {string}")
    public void i_land_on_a_product_details_page_with_title_containing(String productName) {
        Assert.assertTrue(Driver.getDriver().getTitle().contains(productName));
    }
    @Then("The title of the product should be {string}")
    public void the_title_of_the_product_should_be(String productName) {
        ProductPage productPage = new ProductPage();
        Assert.assertEquals(productName, productPage.productTitle.getText());
    }

    @Then("The price of the product should be {double}")
    public void the_price_of_the_product_should_be(Double price) {
        ProductPage productPage = new ProductPage();
        Assert.assertEquals(price, Double.valueOf(productPage.productPrice.getText().replace("$", "")));
    }

    @Then("The default quantity should be {int}")
    public void the_default_quantity_should_be(Integer defQuantity) {

        ProductPage productPage = new ProductPage();
        Assert.assertEquals(defQuantity, Integer.valueOf(productPage.quantity.getAttribute("value")));
    }
    Integer sharedTimes;
    @When("I click on a plus button {int} times")
    public void i_click_on_a_plus_button_times(Integer times) {
        sharedTimes = times;
        ProductPage productPage = new ProductPage();
        productPage.clickOnPlusButton(times);

    }
    @Then("The quantity should be correct")
    public void the_quantity_should_be() {
        Integer actualQuantity = Integer.valueOf(new ProductPage().quantity.getAttribute("value"));
        Integer expectedQuantity = sharedTimes + 1;

        Assert.assertEquals(expectedQuantity, actualQuantity);
    }




}