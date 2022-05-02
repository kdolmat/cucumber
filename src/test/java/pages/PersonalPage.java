package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PersonalPage {

    public PersonalPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }



    @FindBy(xpath = "(//label[.='Yes'])[3]")
    public WebElement clickYes1;

    @FindBy(xpath = "//input[@id='b_firstName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@id='b_middleName']")
    public WebElement middleName;

    @FindBy(xpath = "//input[@id='b_lastName']")
    public WebElement lastName;


    @FindBy(xpath = "//span[@id='select2-b_suffix-container']")
    public WebElement clicksuffix;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement suffix;

    @FindBy(xpath = " //input[@id='b_email']")
    public WebElement email1;
    @FindBy(xpath = "//input[@placeholder='Select Date'])[1]")
    public WebElement dateOfBirth1;

    @FindBy(xpath = "//input[@id='b_ssn']")
    public WebElement SSN1;


    @FindBy(xpath = "//input[@id='b_cell']")
    public WebElement phoneNumber;

    @FindBy(xpath = "//span[@id='select2-b_marital-container']")
    public WebElement Select2click;


    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement Select2;

    @FindBy(xpath = "//input[@id='b_home']")
    public WebElement homeNumber;

    @FindBy(xpath = "(//label[.='Yes'])[3]")
    public WebElement clickYes;

    @FindBy(xpath = "//input[@name='c_firstName']")
    public WebElement name2;

    @FindBy(xpath = "//input[@id='c_middleName']")
    public WebElement middleName2;

    @FindBy(xpath = "//input[@id='c_lastName']")
    public WebElement lastName2;


    @FindBy(xpath = " //span[@id='select2-c_suffix-container']")
    public WebElement clickSuffix;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement choose;

    @FindBy(xpath = " //input[@id='c_email']")
    public WebElement email2;

    @FindBy(xpath = "//input[@id='c_ssn']")
    public WebElement birthDate;


    @FindBy(xpath = "//span[@id='select2-c_marital-container']")
    public WebElement Select3;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    public WebElement SelectClick;


    @FindBy(xpath = "//input[@id='c_cell']")
    public WebElement phone2;

    @FindBy(xpath = "//input[@id='c_home']")
    public WebElement homePhone2;

    @FindBy(xpath = "//a[.='Next']")
    public WebElement nextButton;


    @FindBy(xpath = "//input[@id='c_dob']")
    public WebElement BOD;









}
