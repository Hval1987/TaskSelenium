package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    final DriverFactory driverFactory=getInstanse();

    public DriverFactory getInstanse() {
        return new DriverFactory();
    }

    private DriverFactory() {
    }

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


}
