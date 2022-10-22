package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
<<<<<<< HEAD
import page.extendPage.PageAbout;
import page.extendPage.PageHeader;
import page.extendPage.PageSearchResult;
import page.extendPage.PageStart;
import util.RegExParser;
=======
import page.PageAbout;
import page.PageHeader;
import page.PageSearchResult;
import page.PageStart;
>>>>>>> parent of 81b987a (some changes)

import java.time.Duration;
import java.util.List;

public class TestCase1 {
    WebDriver driver;
    private PageStart pageStart;
    private PageAbout pageAbout;
    private PageHeader pageHeader;
    private PageSearchResult pageSearchResult;

    @BeforeTest
    public void setUp() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("-private");
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        pageStart = new PageStart(driver);
        pageAbout = new PageAbout(driver);
        pageHeader = new PageHeader(driver);
        pageSearchResult = new PageSearchResult(driver);


    }

    @AfterTest
    public void tearsDown() {

        // driver.quit();
    }

    //  @Test(groups = {"Test1"})
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

    @Test(groups = {"Test2"})
    public void Test2() {
        //step1
        driver.get("https://store.steampowered.com ");
        pageHeader.hoverCursorToNew();

        //step2
        pageHeader.selectTopSellers();

        //step3
        pageSearchResult.selectCheckboxOS();
        WebElement element = driver.findElement(By.xpath("//span[@data-loc='SteamOS + Linux']"));
        String criteriaOfCheck = element.getAttribute("className");

        Assert.assertEquals(criteriaOfCheck, "tab_filter_control tab_filter_control_include  checked");
 //step4
        pageSearchResult.selectHideCheckBoxPlayerAmount();

        //step5
        pageSearchResult.inputSuggestionTag();


        pageSearchResult.selectCheckboxTags();

        //step6
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //step7
        List<WebElement> list=pageSearchResult.getListFindedGames();
        System.out.println(list.size());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list.get(0).click();


    }

}
