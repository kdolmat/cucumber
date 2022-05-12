package pages;

import com.fasterxml.jackson.core.JsonParser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.Collection;

public class LoanApplicationPage<Details> {


<<<<<<< HEAD
=======
    public JsonParser ViewDetails;
>>>>>>> 712a0cb0da238a243f137e1e3f0e4edd1fb0cd04

    public LoanApplicationPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

<<<<<<< HEAD
    @FindBy(xpath ="(//h4[@class='card-title'])[2]")
    public WebElement ApplicationList;

    @FindBy(xpath="//a[@class='btn btn-info']")
    public WebElement ViewDetails;
=======
    public Collection<Object> getTitle() {
        return null;
    }



    @FindBy(xpath ="(//h4[@class='card-title'])[2]")
    public WebElement ApplicationList;

    @FindBy(xpath="//*[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[4]/a")
    public WebElement ViewDetail;
>>>>>>> 712a0cb0da238a243f137e1e3f0e4edd1fb0cd04

    @FindBy(xpath="(//h4[@class='card-title'])[1]")
    public WebElement MortgageApplication;
}
<<<<<<< HEAD
=======

>>>>>>> 712a0cb0da238a243f137e1e3f0e4edd1fb0cd04
