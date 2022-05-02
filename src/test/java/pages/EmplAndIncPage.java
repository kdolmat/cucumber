package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EmplAndIncPage {

    public EmplAndIncPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy (xpath = "//div[@class=\"app-content content\"]")
    public  WebElement DuoBankPage;

    // @FindBy (partialLinkText = "Mortgage Application")
    @FindBy (xpath = "(//span[@class=\"menu-item\"])[1]")
    public WebElement mortgageApp;

    @FindBy (xpath = "//h4[@class=\"card-title\"]")
    public WebElement appWizard;

    @FindBy (id = "employername1")
    public WebElement employerName;

    @FindBy (id = "position1")
    public  WebElement position;

    @FindBy (id = "city")
    public WebElement city;

    @FindBy (id = "state1")
    public  WebElement state;

    @FindBy (id = "start_date1")
    public WebElement startDate;

    @FindBy (id = "addemployer")
    public WebElement addButton;

    @FindBy (id = "grossmonthlyincome")
    public WebElement grossIncome;

    @FindBy (id = "monthlyovertime")
    public  WebElement overtime;

    @FindBy (id = "monthlybonuses")
    public WebElement bonuses;

    @FindBy (xpath = "//div[@class=\"borrowertotalmonthlyincome\"]")
    public  WebElement totalIncome;

    @FindBy (xpath = "//a[@href=\"#next\"]")
    public WebElement nextPageButton;


}
