package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CrediteReportPage {

    public CrediteReportPage(){
    PageFactory.initElements(Driver.getDriver(), this);
    }
    private Object uid;

    @FindBy(xpath ="//input[@id=\"creditreport1\"]")
    public WebElement OrderCrediteReportCheck;

    @FindBy(xpath = "//a[text()='Next']")
    public WebElement next;
}
