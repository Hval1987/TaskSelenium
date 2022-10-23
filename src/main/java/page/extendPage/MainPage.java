package page.extendPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasicPage;

public class MainPage extends BasicPage {
    public MainPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath="//*[@id='global_header']/div/div[2]/a[3]")
    private WebElement buttonAbout;

    public void clickBtnABOUT(){
        waitElementVisibility(buttonAbout).click();

    }

}
