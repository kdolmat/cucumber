package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Homepage {

    public Homepage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy (id = "search_query_top")
    public WebElement searchBar;

    public void clickOnAProduct(String name){
        String xpath = "(//a[@title='"+name+"'])[2]";
        Driver.getDriver().findElement(By.xpath(xpath)).click();
    }







}