package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PageStart {

    public WebDriver driver;

    public PageStart(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver=driver;

    }

    @FindBy(xpath="//input[contains(@class,'search3__input')]")
    private WebElement inputField;

    public void inputAndFind(String input){
        inputField.sendKeys(input, Keys.ENTER);
    }






}