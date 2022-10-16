package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageResultOfSearch {
    WebDriver driver;

    public PageResultOfSearch(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }
    


}
