package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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



    public void selectCheckboxOS(){
        ActionOnPage.selectItem(checkboxOS);
    }

    public void selectCheckBoxPlayerAmount(){
        ActionOnPage.selectItem(checkboxAmountOfPlayer);
    }

    public void selecCheckboxTags(){
        ActionOnPage.selectItem(checkboxTags);
    }
}
