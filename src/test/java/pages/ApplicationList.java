package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ApplicationList {

    public ApplicationList(){
        PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy (xpath = "//span[text()='Application List'] ")
    public WebElement buttonApplicationList;

    @FindBy (xpath = "//div[@id=\"DataTables_Table_0_info\"]")
    public WebElement text1;

    @FindBy (xpath = "//option[@value=\"25\"]")
    public WebElement value25;

    @FindBy (xpath = "//a[@data-dt-idx=\"3\"]")
    public WebElement buttonNext;

    @FindBy (xpath = "//a[@data-dt-idx=\"1\"]")
     public WebElement buttonOne;

    @FindBy (xpath = "//a[@data-dt-idx=\"2\"]")
    public WebElement buttonTwo;

    @FindBy (xpath = "//select[@aria-controls=\"DataTables_Table_0\"]")
    public WebElement buttonShowEntries;

    @FindBy (xpath = "//a[@class=\"btn btn-info\"]")
    public WebElement buttonInfo;

    @FindBy (xpath = "//*[.='Application Details']")
    public WebElement textAppDetails;



}
