package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class ActionOnPage {

    public static void selectItem(WebElement element) {
        element.click();
    }

    public static void inputForm(WebElement element, String suggestion) {
        element.clear();
        element.sendKeys(suggestion, Keys.ENTER);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
