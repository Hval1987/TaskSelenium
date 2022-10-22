package testCase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.extendPage.PageAbout;
import page.extendPage.PageHeader;
import page.extendPage.PageSearchResult;
import page.extendPage.PageStart;
import util.RegExParser;

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

   // @Test(groups = {"Test1"})
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
        try {
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
            Thread.sleep(3000);
            WebElement element1 = driver.findElement(By.xpath("//div[@data-loc='Экшен']"));
            String criteria = element.getDomAttribute("class");
            String searchResultCount=driver.findElement(By.xpath("//div[@class='search_results_count']")).getText();
            System.out.println(searchResultCount);

            Long count=Long.parseLong(RegExParser.getTegTextValue(searchResultCount));
            System.out.println(count);


            Assert.assertEquals(criteria, "tab_filter_control tab_filter_control_include  checked");


            //step6
            Actions action=new Actions(driver);
            action.sendKeys(Keys.PAGE_UP).perform();
            Thread.sleep(3000);

            String tittle = driver.findElement(By.xpath("//a[@class='search_result_row ds_collapse_flag  app_impression_tracked'][1]//span[@class='title']")).getText().trim();
            System.out.println(tittle);

            String releaseDate=driver.findElement(By.xpath("//a[@class='search_result_row ds_collapse_flag  app_impression_tracked'][1]//div[@class='col search_released responsive_secondrow']"))
                    .getText().trim();
            System.out.println(releaseDate);
//            String totalPrice=driver.findElement(By.xpath("//a[@class='search_result_row ds_collapse_flag  app_impression_tracked'][1]//div[contains(@class,'price discounted')]/text()[2]")).getAttribute("data");
//            System.out.println(totalPrice);

            //step7
            List<WebElement> list = pageSearchResult.getListFindedGames();
                Thread.sleep(2000);

            list.get(0).click();
            Thread.sleep(2000);
            String tittle2=driver.findElement(By.xpath("//div[@id='appHubAppName']")).getText().trim();

            Assert.assertEquals(tittle,tittle2);


        }catch (Exception ex){
        ex.printStackTrace();
        }
    }

}
