package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinitions.ApplicationFormPage;
import utilities.Driver;

import java.time.Duration;

public class Preapproval {
    public Preapproval(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//span[text()='PreApproval Details']")
    public WebElement ApprovalForm;

    @FindBy(xpath = "//span[@class='menu-item']")
    public WebElement MortgageButton;

    @FindBy(xpath = "//label[@for='loanofficer2']")
    public WebElement loanOfficerButton;

    @FindBy(xpath = "//label[@for='realtor2']")
    public WebElement realtorButton;

    @FindBy(xpath = "//label[@for='loanofficer1']")
    public WebElement loanOfficerButtonY;

    @FindBy(xpath = "//label[@for='realtor1']")
    public WebElement realtorButtonY;

    @FindBy(xpath = "//input[@id='realtorinfo']")
    public WebElement realtorName;

    @FindBy (xpath = "//input[@name='est_purchase_price']")
    public WebElement estPurchPrice;

    @FindBy (xpath = "//input[@name='down_payment']")
    public WebElement downPaymnt;

    @FindBy (xpath = "//input[@name='down_payment_percent']")
    public WebElement downPaymntPercent;

    @FindBy (xpath = "//select[@name='src_down_payment']")
    public WebElement optionsFinances;

    @FindBy(xpath = "//a[text()='Next']")
    public  WebElement nextButton;

    @FindBy(xpath = "//h6[text()='Personal Information']")
    public WebElement pI;




    @FindBy(xpath = "(//a[@aria-controls='DataTables_Table_0'])[3]")
    public WebElement nextApplicationPage;

    @FindBy(xpath = "//span[text()='Application List']")
    public WebElement applicationListBttn;

    @FindBy()
    public WebElement loan;

    public String loanExp="260175";


    public static boolean isClickable()
    {

        Preapproval preapproval = new Preapproval();
        try{
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(1));
            wait.until(ExpectedConditions.elementToBeClickable(preapproval.nextApplicationPage));
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

}
