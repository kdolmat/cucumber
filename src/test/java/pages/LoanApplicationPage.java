package pages;

import com.fasterxml.jackson.core.JsonParser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.Collection;

public class LoanApplicationPage<Details> {



    public LoanApplicationPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath ="(//h4[@class='card-title'])[2]")
    public WebElement ApplicationList;

    @FindBy(xpath="//a[@class='btn btn-info']")
    public WebElement ViewDetails;

    @FindBy(xpath="(//h4[@class='card-title'])[1]")
    public WebElement MortgageApplication;
}
