package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import page.PageBasic;


public class PageStart extends PageBasic {
    
    public PageStart(WebDriver driver) {
        super(driver);
    }

    public WebDriver initWebDriver() {
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


    @FindBy(xpath="//*[@id='global_header']/div/div[2]/a[3]")
    private WebElement buttonAbout;

    public void clickButtonABOUT(){
//        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='global_header']/div/div[2]/a[3]")));
        buttonAbout.click();
    }






}