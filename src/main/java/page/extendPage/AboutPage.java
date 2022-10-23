package page.extendPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import page.BasicPage;
import util.RegExParser;

public class AboutPage extends BasicPage {
    public AboutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='about_greeting']/div[3]/div[1]")
    WebElement amountOfPlayersTotal;

    @FindBy(xpath = "//*[@id='about_greeting']/div[3]/div[2]")
    private WebElement amountOfPlayersOnline;

    @FindBy(xpath = "/html/body/div[1]/div[4]/div/div[2]/a")
    private WebElement btnHome;

    public void clickButtonHOME(){

        waitElementVisibility(btnHome).click();
    }

    public AboutPage checkAmountOfPlayers(){
        Long onlineCount=Long.parseLong(parser.getTegTextValue(amountOfPlayersOnline
                .getText()
                .trim()));
        Long totalCount=Long.parseLong(parser.getTegTextValue(amountOfPlayersTotal
                .getText()
                .trim()));

        Assert.assertTrue(onlineCount<totalCount);

      return this;
    }


}
