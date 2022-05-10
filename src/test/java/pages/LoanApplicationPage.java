package pages;

import com.fasterxml.jackson.core.JsonParser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.Collection;

public class LoanApplicationPage<Details> {


    public JsonParser ViewDetails;

    public LoanApplicationPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public Collection<Object> getTitle() {
        return null;
    }



    @FindBy(xpath ="(//h4[@class='card-title'])[2]")
    public WebElement ApplicationList;

    @FindBy(xpath="//*[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[4]/a")
    public WebElement ViewDetail;

    @FindBy(xpath="(//h4[@class='card-title'])[1]")
    public WebElement MortgageApplication;
}

