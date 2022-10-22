package page.extendPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.RegExParser;

public class PageAbout {
    WebDriver driver;

    public PageAbout(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"about_greeting\"]/div[3]/div[1]")
    WebElement amountOfPlayersTotal;

    @FindBy(xpath = "//*[@id=\"about_greeting\"]/div[3]/div[2]")
    private WebElement amountOfPlayersOnline;

    @FindBy(xpath = "/html/body/div[1]/div[4]/div/div[2]/a")
    private WebElement buttonHome;

    public Long getAmountOfPlayers() {

        String str = amountOfPlayersTotal.getText();
        RegExParser regEx = new RegExParser();
        Long findedValue = Long.parseLong(regEx.getTegTextValue(str));
        System.out.println("long value -->" + findedValue);
        return findedValue;
    }

    public Long getAmountOfPlayersOnline() {

        String str = amountOfPlayersOnline.getText();
        RegExParser regEx = new RegExParser();
        Long findedValue = Long.parseLong(regEx.getTegTextValue(str));
        System.out.println("long value -->" + findedValue);
        return findedValue;
    }


    public void goHome() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf(buttonHome));
        Actions actions = new Actions(driver);

        actions.contextClick(buttonHome).release().build().perform();
//        buttonHome.click();

    }


}
