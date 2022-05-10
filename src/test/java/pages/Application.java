package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Application {


    public Application(){
        PageFactory.initElements(Driver.getDriver(), this);

    }


    @FindBy(xpath ="//span[.='Application List']")
    public WebElement applicationList;
    @FindBy(xpath =" //input[@class='form-control form-control-sm']")
    public WebElement searchButton;

    @FindBy(xpath ="//td[contains(text(),'Shelby')]")
    public WebElement match;

    }




