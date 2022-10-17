package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.event.MouseEvent;
import java.time.Duration;

public class PageAbout {
    WebDriver driver;

    public PageAbout(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@class='online_stat_label gamers_online']")
    WebElement amountOfPlayersOnline;

    @FindBy(xpath = "/html/body/div[1]/div[4]/div/div[2]/a")

    private WebElement buttonHome;

    public int getAmountOfPlayers(WebElement element) {

        String str = element.getText();
        System.out.println(str);
        //парсим в инт

        return 0;
    }

    public void goHome() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf(buttonHome));
        Actions actions=new Actions(driver);

        actions.contextClick(buttonHome).release().build().perform();
//        buttonHome.click();

    }


}
