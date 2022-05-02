package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EconsentPage {

    public EconsentPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath ="//*[@id=\"steps-uid-0-p-5\"]/h4")
    public WebElement eConsent;

    @FindBy(xpath="//*[@id=\"eConsentdeclarerFirstName\"]")
    public WebElement firstName;

    @FindBy(xpath="//*[@id=\"eConsentdeclarerLastName\"]")
    public WebElement lastName;

    @FindBy(xpath = "//*[@id=\"eConsentdeclarerEmail\"]")
    public WebElement email;

    @FindBy(xpath="//*[@id=\"steps-uid-0-p-5\"]/ul/li[1]/fieldset/div/label")
    public WebElement agree;

//    @FindBy(xpath="//*[@id=\"steps-uid-0\"]/div[3]/ul/li[2]/a")
//    public WebElement next;



}
