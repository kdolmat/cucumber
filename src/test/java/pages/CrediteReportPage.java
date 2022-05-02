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
    @FindBy(xpath ="//*[@id=\"steps-uid-0-p-4\"]/div/div/div/ul/li[1]/fieldset/div/label")
    public WebElement OrderCrediteReportCheck;
}
