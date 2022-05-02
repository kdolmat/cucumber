package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ExpensesPage {

    public ExpensesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"steps-uid-0-p-2\"]/div/div[1]/div/ul/li[1]/fieldset/div/label\n")
    public WebElement RentClick;

    @FindBy(xpath ="//*[@id=\"monthlyrentalpayment\"]")
    public WebElement MonthlyRentalPayment;

//    @FindBy(xpath = "//*[@id=\"steps-uid-0\"]/div[3]/ul/li[2]/a")
//    public WebElement next;

    }