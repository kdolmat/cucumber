package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EconsentPage {

    public EconsentPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath ="(//h4[text()])[2]")
    public WebElement eConsent;

    @FindBy(xpath="//*[@id=\"eConsentdeclarerFirstName\"]")
    public WebElement firstName;

    @FindBy(xpath="//*[@id=\"eConsentdeclarerLastName\"]")
    public WebElement lastName;

    @FindBy(xpath = "//*[@id=\"eConsentdeclarerEmail\"]")
    public WebElement email;

    @FindBy(xpath="//input[@id=\"agree\"]")
    public WebElement agree;

    @FindBy(xpath = "//select[@name='eConsent_declarer']")
    public WebElement iam;

//    @FindBy(xpath="//*[@id=\"steps-uid-0\"]/div[3]/ul/li[2]/a")
//    public WebElement next;

    @FindBy (xpath = "//label[@for=\"agree\"]")
    public WebElement agreeButton;



}
