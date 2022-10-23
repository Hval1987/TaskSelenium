package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.RegExParser;

import java.time.Duration;

public class BasicPage {

    protected  WebDriver driver;
    protected RegExParser parser=new RegExParser();

    public BasicPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public WebElement waitElementVisibility(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(element));
        return element;

    }

    public void clickBtn(WebElement btn){
        waitElementVisibility(btn).click();

    }





}
