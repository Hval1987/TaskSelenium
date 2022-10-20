package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageSearchResult {
    WebDriver driver;

    public PageSearchResult(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    @FindBy(xpath="//span[@data-loc='SteamOS + Linux']")
    private WebElement checkboxOS;

    @FindBy(xpath="//*[@data-collapse-name='category3']//span[@data-loc='Кооператив (LAN)']")
    private WebElement checkboxAmountOfPlayer;

    @FindBy(xpath="//div[@data-collapse-name='tags']//span[@data-loc='Экшен'][1]")
    private WebElement checkboxTags;

    @FindBy(xpath="//input[@id='TagSuggest']")
    private WebElement inputTagSuggest;



    public void selectCheckboxOS(){
        ActionOnPage.selectItem(checkboxOS);
    }

    public void selectHideCheckBoxPlayerAmount(){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('#additional_search_options > div:nth-child(6) > div.block_content.block_content_inner')" +
                ".setAttribute('style','display: block;')");

        ActionOnPage.selectItem(checkboxAmountOfPlayer);
    }

    public void inputSuggestionTag(){

        System.out.println("element -  "+inputTagSuggest.isDisplayed());

        ActionOnPage.inputForm(inputTagSuggest,"Экшен");
    }

    public void selectCheckboxTags(){
        ActionOnPage.selectItem(checkboxTags);

    }

}
