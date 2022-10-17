package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageAbout {
    WebDriver driver;

    public PageAbout(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    @FindBy(xpath ="//div[@class='online_stat_label gamers_online']")
    WebElement amountOfPlayersOnline;

    public int getAmountOfPlayers(WebElement element){

        String str=element.getText();
        System.out.println(str);
        //парсим в инт

        return 0;
    }




}
