package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SummaryPage {

    public SummaryPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath ="(//a[@role='menuitem'])[3]")
    public WebElement econsent;
    }

