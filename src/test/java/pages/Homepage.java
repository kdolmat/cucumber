package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
// privet
public class Homepage {

    
    public Homepage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//input[@type = 'email']")
    public WebElement email;

    @FindBy (xpath = "//input[@type = 'password']")
    public WebElement password;





//    public void clickOnAProduct(String name){
//        String xpath = "(//a[@title='"+name+"'])[2]";
//        Driver.getDriver().findElement(By.xpath(xpath)).click();
//    }

//    public void clickOnPlusButton(int times){
//
//        for (int i = 0; i < times; i++) {
//            plusButton.click();
//        }
//    }







}