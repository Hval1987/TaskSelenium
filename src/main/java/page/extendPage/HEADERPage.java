package page.extendPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.BasicPage;

public class HEADERPage extends BasicPage {

    public HEADERPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//a[contains(text(),'МАГАЗИН')]")
    private WebElement btnStore;

    public void redirectStorePage(){



    }


}
