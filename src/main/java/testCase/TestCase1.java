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
import page.PageHeader;
import page.PageStart;

import java.time.Duration;

public class TestCase1 {
    WebDriver driver;
    private PageStart pageStart;
    private PageAbout pageAbout;
    private PageHeader pageHeader;

    @BeforeTest
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-private");
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        pageStart = new PageStart(driver);
        pageAbout = new PageAbout(driver);
        pageHeader=new PageHeader(driver);

    }

    @AfterTest
    public void tearsDown() {

       // driver.quit();
    }


    public void Test1() {

//step1
        driver.get("https://store.steampowered.com ");
//step2
        pageStart.clickButtonABOUT();
        System.out.println("test run");
        String actualTittle = pageStart.driver.getTitle();
        Assert.assertEquals(actualTittle, "Steam — превосходная игровая Интернет-платформа");
//step3
        Long totalAmount = pageAbout.getAmountOfPlayers();
        Long onlineAmount = pageAbout.getAmountOfPlayersOnline();
        Assert.assertTrue(totalAmount > onlineAmount);
//step4
        pageHeader.goMainPage();
        String actualTittle2 = pageStart.driver.getTitle();
        Assert.assertEquals(actualTittle2, "Добро пожаловать в Steam");


    }
    @Test
    public void Test2(){
 //step1
        driver.get("https://store.steampowered.com ");
        pageHeader.hoverCursorToNew();

    }

}
