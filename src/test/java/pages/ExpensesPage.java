package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ExpensesPage {

    public ExpensesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id=\"expense1\"]")
    public WebElement RentClick;

    @FindBy(xpath ="//input[@id='monthlyrentalpayment']")
    public WebElement MonthlyRentalPayment;

    @FindBy(xpath = "//a[text()='Next']")
    public WebElement next;

//    @FindBy(xpath = "//*[@id=\"steps-uid-0\"]/div[3]/ul/li[2]/a")
//    public WebElement next;

    }