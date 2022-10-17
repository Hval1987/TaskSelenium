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

    @FindBy(xpath="//*[@id='global_header']/div/div[2]/a[3]")
    private WebElement buttonAbout;

    public void clickButtonABOUT(){
        buttonAbout.click();
    }






}