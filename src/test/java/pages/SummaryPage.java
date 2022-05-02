package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SummaryPage {

    public SummaryPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath ="//*[@id=\"steps-uid-0-p-6\"]/div[3]/div/h6")
    public WebDriver econsent;
    }

