package testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.PageAbout;
import page.PageStart;

import java.time.Duration;

public class TestCase1 {
    WebDriver driver;
    private PageStart pageStart;
    private PageAbout pageAbout;

    @BeforeTest
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-private");
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://store.steampowered.com ");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        pageStart = new PageStart(driver);
        pageAbout = new PageAbout(driver);

    }

    @AfterTest
    public void tearsDown() {
        driver.quit();
    }

    @Test
    public void Test1() {

        pageStart.clickButtonABOUT();
        System.out.println("test run");
        String actualTittle = pageStart.driver.getTitle();
        Assert.assertEquals(actualTittle, "Steam — превосходная игровая Интернет-платформа");
        Long totalAmount = pageAbout.getAmountOfPlayers();
        Long onlineAmount = pageAbout.getAmountOfPlayersOnline();
        Assert.assertTrue(totalAmount > onlineAmount);


    }
}
