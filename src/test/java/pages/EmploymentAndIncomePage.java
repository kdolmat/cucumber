package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EmploymentAndIncomePage {

    public EmploymentAndIncomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
        @FindBy(xpath = "//*[@id=\"steps-uid-0-p-3\"]/h6[1]")
         public static WebDriver EmplymentAndIncome;
    }

