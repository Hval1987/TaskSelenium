package page.ActionOnPage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import page.PageBasic;

public class ActionOnPage extends PageBasic {

    public static WebDriver initWebDriver() {
        WebDriver driver = null;
        if(true){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("-private");
        }

        switch ("chrome") {
            case "chrome":
                driver = new ChromeDriver();
                System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }
        if(true){
            driver.manage().window().maximize();
        }
        return driver;
    }


    public static void selectItem(WebElement element) {
        element.click();
    }

    public static void inputForm(WebElement element, String suggestion) {
        element.clear();
        element.sendKeys(suggestion, Keys.ENTER);

    }


}
