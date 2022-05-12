package pages;

import com.fasterxml.jackson.core.JsonParser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.Collection;

public class LoanApplicationPage{




    public LoanApplicationPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath="//a[@class='btn btn-info']")
    public WebElement ViewDetails;


    @FindBy(xpath ="(//h4[@class='card-title'])[2]")
    public WebElement ApplicationList1;

   // @FindBy(xpath="//*[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[4]/a")
    public WebElement ViewDetail;

    @FindBy(xpath="(//h4[@class='card-title'])[1]")
    public WebElement MortgageApplication;
}
